/*
Copyright (c) 2007-2009, Yusuke Yamamoto
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
 * Neither the name of the Yusuke Yamamoto nor the
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY Yusuke Yamamoto ``AS IS'' AND ANY
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL Yusuke Yamamoto BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package weibo4j.model;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;

/**
 * A data class representing Treands.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since weibo4j-V2 1.0.1
 * @version $Id: $Id
 */
public class Trends extends WeiboResponse implements Comparable<Trends> {
	private Date asOf; // asof
	private Date trendAt; // 话题时间
	private Trend[] trends; // 话题对象
	private static final long serialVersionUID = -7151479143843312309L;

	/**
	 * <p>compareTo.</p>
	 *
	 * @param that a {@link weibo4j.model.Trends} object.
	 * @return a int.
	 */
	public int compareTo(Trends that) {
		return this.trendAt.compareTo(that.trendAt);
	}

	/* package */Trends(Response res, Date asOf, Date trendAt, Trend[] trends)
			throws WeiboException {
		super(res);
		this.asOf = asOf;
		this.trendAt = trendAt;
		this.trends = trends;
	}

	/* package */
	/**
	 * <p>constructTrendsList.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @return a {@link java.util.List} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public static List<Trends> constructTrendsList(Response res)
			throws WeiboException {
		JSONObject json = res.asJSONObject();
		List<Trends> trends;
		try {
			Date asOf = parseDate(json.getString("as_of"));
			JSONObject trendsJson = json.getJSONObject("trends");
			trends = new ArrayList<Trends>(trendsJson.length());
			Iterator ite = trendsJson.keys();
			while (ite.hasNext()) {
				String key = (String) ite.next();
				JSONArray array = trendsJson.getJSONArray(key);
				Trend[] trendsArray = jsonArrayToTrendArray(array);
				if (key.length() == 19) {
					// current trends
					trends.add(new Trends(res, asOf, parseDate(key,
							"yyyy-MM-dd HH:mm:ss"), trendsArray));
				} else if (key.length() == 16) {
					// daily trends
					trends.add(new Trends(res, asOf, parseDate(key,
							"yyyy-MM-dd HH:mm"), trendsArray));
				} else if (key.length() == 10) {
					// weekly trends
					trends.add(new Trends(res, asOf, parseDate(key,
							"yyyy-MM-dd"), trendsArray));
				}
			}
			Collections.sort(trends);
			return trends;
		} catch (JSONException jsone) {
			throw new WeiboException(jsone.getMessage() + ":" + res.asString(),
					jsone);
		}
	}

	/* package */
	static Trends constructTrends(Response res) throws WeiboException {
		JSONObject json = res.asJSONObject();
		try {
			Date asOf = parseDate(json.getString("as_of"));
			JSONArray array = json.getJSONArray("trends");
			Trend[] trendsArray = jsonArrayToTrendArray(array);
			return new Trends(res, asOf, asOf, trendsArray);
		} catch (JSONException jsone) {
			throw new WeiboException(jsone.getMessage() + ":" + res.asString(),
					jsone);
		}
	}

	private static Date parseDate(String asOfStr) throws WeiboException {
		Date parsed;
		if (asOfStr.length() == 10) {
			parsed = new Date(Long.parseLong(asOfStr) * 1000);
		} else {
			parsed = WeiboResponse.parseDate(asOfStr,
					"EEE, d MMM yyyy HH:mm:ss z");
		}
		return parsed;
	}

	private static Trend[] jsonArrayToTrendArray(JSONArray array)
			throws JSONException {
		Trend[] trends = new Trend[array.length()];
		for (int i = 0; i < array.length(); i++) {
			JSONObject trend = array.getJSONObject(i);
			trends[i] = new Trend(trend);
		}
		return trends;
	}

	/**
	 * <p>Getter for the field <code>trends</code>.</p>
	 *
	 * @return an array of {@link weibo4j.model.Trend} objects.
	 */
	public Trend[] getTrends() {
		return this.trends;
	}

	/**
	 * <p>Getter for the field <code>asOf</code>.</p>
	 *
	 * @return a {@link java.util.Date} object.
	 */
	public Date getAsOf() {
		return asOf;
	}

	/**
	 * <p>Getter for the field <code>trendAt</code>.</p>
	 *
	 * @return a {@link java.util.Date} object.
	 */
	public Date getTrendAt() {
		return trendAt;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Trends))
			return false;

		Trends trends1 = (Trends) o;

		if (asOf != null ? !asOf.equals(trends1.asOf) : trends1.asOf != null)
			return false;
		if (trendAt != null ? !trendAt.equals(trends1.trendAt)
				: trends1.trendAt != null)
			return false;
		if (!Arrays.equals(trends, trends1.trends))
			return false;

		return true;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		int result = asOf != null ? asOf.hashCode() : 0;
		result = 31 * result + (trendAt != null ? trendAt.hashCode() : 0);
		result = 31 * result + (trends != null ? Arrays.hashCode(trends) : 0);
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Trends{" + "asOf=" + asOf + ", trendAt=" + trendAt
				+ ", trends=" + (trends == null ? null : Arrays.asList(trends))
				+ '}';
	}
}
