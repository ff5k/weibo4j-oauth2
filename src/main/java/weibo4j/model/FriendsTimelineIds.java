package weibo4j.model;

import java.util.ArrayList;
import java.util.List;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * 获取当前登录用户及其所关注用户的最新微博的ID
 *
 * @author xiaoV
 * @version $Id: $Id
 */
public class FriendsTimelineIds extends WeiboResponse {

	private static final long serialVersionUID = 4785295274677627206L;

	private long nextCursor;
	private long previousCursor;
	private long totalNumber;
	private String ad;
	private String advertises;
	private List<String> statusesIds; // ID列表
	private boolean hasvisible;

	/**
	 * <p>Constructor for FriendsTimelineIds.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public FriendsTimelineIds(Response res) throws WeiboException {
		super(res);
		JSONObject json = res.asJSONObject();
		try {
			nextCursor = json.getLong("next_cursor");
			previousCursor = json.getLong("previous_cursor");
			totalNumber = json.getLong("total_number");
			ad = json.getString("ad");
			advertises = json.getString("advertises");
			hasvisible = json.getBoolean("hasvisible");
			JSONArray list = json.getJSONArray("statuses");
			int size = list.length();
			statusesIds = new ArrayList<String>(size);
			for (int i = 0; i < size; i++) {
				statusesIds.add(list.getString(i));
			}
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}

	}

	/**
	 * <p>Constructor for FriendsTimelineIds.</p>
	 *
	 * @param json a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public FriendsTimelineIds(JSONObject json) throws WeiboException {
		try {
			nextCursor = json.getLong("next_cursor");
			previousCursor = json.getLong("previous_cursor");
			totalNumber = json.getLong("total_number");
			ad = json.getString("ad");
			advertises = json.getString("advertises");
			hasvisible = json.getBoolean("hasvisible");
			JSONArray list = json.getJSONArray("statuses");
			int size = list.length();
			statusesIds = new ArrayList<String>(size);
			for (int i = 0; i < size; i++) {
				statusesIds.add(list.getString(i));
			}
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}
	}

	/**
	 * <p>Getter for the field <code>nextCursor</code>.</p>
	 *
	 * @return a long.
	 */
	public long getNextCursor() {
		return nextCursor;
	}

	/**
	 * <p>Setter for the field <code>nextCursor</code>.</p>
	 *
	 * @param nextCursor a long.
	 */
	public void setNextCursor(long nextCursor) {
		this.nextCursor = nextCursor;
	}

	/**
	 * <p>Getter for the field <code>previousCursor</code>.</p>
	 *
	 * @return a long.
	 */
	public long getPreviousCursor() {
		return previousCursor;
	}

	/**
	 * <p>Setter for the field <code>previousCursor</code>.</p>
	 *
	 * @param previousCursor a long.
	 */
	public void setPreviousCursor(long previousCursor) {
		this.previousCursor = previousCursor;
	}

	/**
	 * <p>Getter for the field <code>totalNumber</code>.</p>
	 *
	 * @return a long.
	 */
	public long getTotalNumber() {
		return totalNumber;
	}

	/**
	 * <p>Setter for the field <code>totalNumber</code>.</p>
	 *
	 * @param totalNumber a long.
	 */
	public void setTotalNumber(long totalNumber) {
		this.totalNumber = totalNumber;
	}

	/**
	 * <p>Getter for the field <code>ad</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getAd() {
		return ad;
	}

	/**
	 * <p>Setter for the field <code>ad</code>.</p>
	 *
	 * @param ad a {@link java.lang.String} object.
	 */
	public void setAd(String ad) {
		this.ad = ad;
	}

	/**
	 * <p>Getter for the field <code>advertises</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getAdvertises() {
		return advertises;
	}

	/**
	 * <p>Setter for the field <code>advertises</code>.</p>
	 *
	 * @param advertises a {@link java.lang.String} object.
	 */
	public void setAdvertises(String advertises) {
		this.advertises = advertises;
	}

	/**
	 * <p>Getter for the field <code>statusesIds</code>.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<String> getStatusesIds() {
		return statusesIds;
	}

	/**
	 * <p>Setter for the field <code>statusesIds</code>.</p>
	 *
	 * @param statusesIds a {@link java.util.List} object.
	 */
	public void setStatusesIds(List<String> statusesIds) {
		this.statusesIds = statusesIds;
	}

	/**
	 * <p>isHasvisible.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isHasvisible() {
		return hasvisible;
	}

	/**
	 * <p>Setter for the field <code>hasvisible</code>.</p>
	 *
	 * @param hasvisible a boolean.
	 */
	public void setHasvisible(boolean hasvisible) {
		this.hasvisible = hasvisible;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "FriendsTimelineIds [" + "next_cursor=" + nextCursor
				+ ", previous_cursor=" + previousCursor
				+ ", ad=" + ad
				+ ", advertises=" + advertises
				+ ", hasvisible=" + hasvisible
				+ ", statusesIds=" + statusesIds
				+ ", total_number = " + totalNumber + "]";
	}
}
