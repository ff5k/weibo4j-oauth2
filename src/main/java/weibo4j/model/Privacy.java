package weibo4j.model;

import weibo4j.http.Response;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * 获取隐私设置信息
 *
 * @author xiaoV
 * @version $Id: $Id
 */
public class Privacy extends WeiboResponse {

	private static final long serialVersionUID = 8055620370528957274L;
	private long badge; // 勋章是否可见，0：不可见、1：可见
	private long comment; // 是否可以评论我的微博，0：所有人、1：关注的人、2：可信用户
	private long geo; // 是否开启地理信息，0：不开启、1：开启
	private long message; // 是否可以给我发私信，0：所有人、1：我关注的人、2：可信用户
	private long mobile; // 是否可以通过手机号码搜索到我，0：不可以、1：可以
	private long realname; // 是否可以通过真名搜索到我，0：不可以、1：可以
	private long profileUrlType;
	private long webim; // 是否开启webim， 0：不开启、1：开启

	/**
	 * <p>Constructor for Privacy.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public Privacy(Response res) throws WeiboException {
		super(res);
		JSONObject json = res.asJSONObject();
		try {
			badge = json.getLong("badge");
			comment = json.getLong("comment");
			geo = json.getLong("geo");
			message = json.getLong("message");
			mobile = json.getLong("mobile");
			realname = json.getLong("realname");
			profileUrlType = json.getLong("profileUrlType");
			webim = json.getLong("webim");
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(),
					je);
		}
	}

	/**
	 * <p>Constructor for Privacy.</p>
	 *
	 * @param json a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public Privacy(JSONObject json) throws WeiboException {
		try {
			badge = json.getLong("badge");
			comment = json.getLong("comment");
			geo = json.getLong("geo");
			message = json.getLong("message");
			mobile = json.getLong("mobile");
			realname = json.getLong("realname");
			profileUrlType = json.getLong("profileUrlType");
			webim = json.getLong("webim");
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(),
					je);
		}
	}

	/**
	 * <p>Getter for the field <code>badge</code>.</p>
	 *
	 * @return a long.
	 */
	public long getBadge() {
		return badge;
	}

	/**
	 * <p>Setter for the field <code>badge</code>.</p>
	 *
	 * @param badge a long.
	 */
	public void setBadge(long badge) {
		this.badge = badge;
	}

	/**
	 * <p>Getter for the field <code>comment</code>.</p>
	 *
	 * @return a long.
	 */
	public long getComment() {
		return comment;
	}

	/**
	 * <p>Setter for the field <code>comment</code>.</p>
	 *
	 * @param comment a long.
	 */
	public void setComment(long comment) {
		this.comment = comment;
	}

	/**
	 * <p>Getter for the field <code>geo</code>.</p>
	 *
	 * @return a long.
	 */
	public long getGeo() {
		return geo;
	}

	/**
	 * <p>Setter for the field <code>geo</code>.</p>
	 *
	 * @param geo a long.
	 */
	public void setGeo(long geo) {
		this.geo = geo;
	}

	/**
	 * <p>Getter for the field <code>message</code>.</p>
	 *
	 * @return a long.
	 */
	public long getMessage() {
		return message;
	}

	/**
	 * <p>Setter for the field <code>message</code>.</p>
	 *
	 * @param message a long.
	 */
	public void setMessage(long message) {
		this.message = message;
	}

	/**
	 * <p>Getter for the field <code>mobile</code>.</p>
	 *
	 * @return a long.
	 */
	public long getMobile() {
		return mobile;
	}

	/**
	 * <p>Setter for the field <code>mobile</code>.</p>
	 *
	 * @param mobile a long.
	 */
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	/**
	 * <p>Getter for the field <code>realname</code>.</p>
	 *
	 * @return a long.
	 */
	public long getRealname() {
		return realname;
	}

	/**
	 * <p>Setter for the field <code>realname</code>.</p>
	 *
	 * @param realname a long.
	 */
	public void setRealname(long realname) {
		this.realname = realname;
	}

	/**
	 * <p>Getter for the field <code>profileUrlType</code>.</p>
	 *
	 * @return a long.
	 */
	public long getProfileUrlType() {
		return profileUrlType;
	}

	/**
	 * <p>Setter for the field <code>profileUrlType</code>.</p>
	 *
	 * @param profileUrlType a long.
	 */
	public void setProfileUrlType(long profileUrlType) {
		this.profileUrlType = profileUrlType;
	}

	/**
	 * <p>Getter for the field <code>webim</code>.</p>
	 *
	 * @return a long.
	 */
	public long getWebim() {
		return webim;
	}

	/**
	 * <p>Setter for the field <code>webim</code>.</p>
	 *
	 * @param webim a long.
	 */
	public void setWebim(long webim) {
		this.webim = webim;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Privacy [badge=" + badge
				+ ", comment=" + comment
				+ ", geo=" + geo
				+ ", message=" + message
				+ ", mobile=" + mobile
				+ ", profileUrlType=" + profileUrlType
				+ ", webim=" + webim
				+ ", realname=" + realname + "]";
	}
}
