package weibo4j.http;

import java.io.Serializable;

import weibo4j.model.WeiboException;
import weibo4j.model.WeiboResponse;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;


/**
 * <p>AccessToken class.</p>
 *
 * @author user1
 * @version $Id: $Id
 */
public class AccessToken extends WeiboResponse implements Serializable {

	private static final long serialVersionUID = 6986530164134648944L;
	private String accessToken;
	private String expireIn;
	private String refreshToken;
	private String uid;
	/**
	 * <p>Constructor for AccessToken.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public AccessToken(Response res) throws WeiboException{
		super(res);
		JSONObject json =res.asJSONObject();
		try{
			accessToken = json.getString("access_token");
			expireIn = json.getString("expires_in");
			refreshToken = json.getString("refresh_token");
			uid = json.getString("uid");
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(), je);
		}
	}
	AccessToken(String res) throws WeiboException,JSONException{
		super();
		JSONObject json =new JSONObject(res);
		accessToken = json.getString("access_token");
		expireIn = json.getString("expires_in");
		refreshToken = json.getString("refresh_token");
		uid = json.getString("uid");
	}
	/**
	 * <p>Getter for the field <code>accessToken</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getAccessToken() {
		return accessToken;
	}
	/**
	 * <p>Getter for the field <code>expireIn</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getExpireIn() {
		return expireIn;
	}
	/**
	 * <p>Getter for the field <code>refreshToken</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getRefreshToken() {
		return refreshToken;
	}
	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
		+ ((accessToken == null) ? 0 : accessToken.hashCode());
		result = prime * result
		+ ((expireIn == null) ? 0 : expireIn.hashCode());
		result = prime * result
		+ ((refreshToken == null) ? 0 : refreshToken.hashCode());
		return result;
	}
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccessToken other = (AccessToken) obj;
		if (accessToken == null) {
			if (other.accessToken != null)
				return false;
		} else if (!accessToken.equals(other.accessToken))
			return false;
		if (expireIn == null) {
			if (other.expireIn != null)
				return false;
		} else if (!expireIn.equals(other.expireIn))
			return false;
		if (refreshToken == null) {
			if (other.refreshToken != null)
				return false;
		} else if (!refreshToken.equals(other.refreshToken))
			return false;
		return true;
	}
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "AccessToken [" +
		"accessToken=" + accessToken + 
		", expireIn=" + expireIn + 
		", refreshToken=" + refreshToken +
		",uid="+uid+
		"]";
	}








}
