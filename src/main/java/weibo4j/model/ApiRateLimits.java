package weibo4j.model;

import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * <p>ApiRateLimits class.</p>
 *
 * @author user1
 * @version $Id: $Id
 */
public class ApiRateLimits implements java.io.Serializable{

	private static final long serialVersionUID = 8550645887134692311L;
	private String api;                 //接口
	private int limit;                  //接口限制
	private String limitTimeUnit;       //限制单元
	private long remainingHits;         //剩余调用次数
    
	ApiRateLimits(JSONObject json) throws WeiboException {
		try {
			api = json.getString("api");
			limit = json.getInt("limit");
			limitTimeUnit = json.getString("limit_time_unit");
			remainingHits = json.getLong("remaining_hits");
		} catch (JSONException jsone) {
			throw new WeiboException(jsone.getMessage() + ":" + json.toString(), jsone);
		}
	}

	/**
	 * <p>Getter for the field <code>api</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getApi() {
		return api;
	}

	/**
	 * <p>Setter for the field <code>api</code>.</p>
	 *
	 * @param api a {@link java.lang.String} object.
	 */
	public void setApi(String api) {
		this.api = api;
	}

	/**
	 * <p>Getter for the field <code>limit</code>.</p>
	 *
	 * @return a int.
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * <p>Setter for the field <code>limit</code>.</p>
	 *
	 * @param limit a int.
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * <p>Getter for the field <code>limitTimeUnit</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getLimitTimeUnit() {
		return limitTimeUnit;
	}

	/**
	 * <p>Setter for the field <code>limitTimeUnit</code>.</p>
	 *
	 * @param limitTimeUnit a {@link java.lang.String} object.
	 */
	public void setLimitTimeUnit(String limitTimeUnit) {
		this.limitTimeUnit = limitTimeUnit;
	}

	/**
	 * <p>Getter for the field <code>remainingHits</code>.</p>
	 *
	 * @return a long.
	 */
	public long getRemainingHits() {
		return remainingHits;
	}

	/**
	 * <p>Setter for the field <code>remainingHits</code>.</p>
	 *
	 * @param remainingHits a long.
	 */
	public void setRemainingHits(long remainingHits) {
		this.remainingHits = remainingHits;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "api_rate_limits [api=" + api + ", limit=" + limit
				+ ", limitTimeUnit=" + limitTimeUnit + ", remainingHits="
				+ remainingHits + "]";
	}
	
	
}
