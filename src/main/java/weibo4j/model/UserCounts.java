package weibo4j.model;

import java.util.ArrayList;
import java.util.List;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * 获取用户的粉丝数、关注数、微博数、悄悄关注数
 *
 * @author xiaoV
 * @version $Id: $Id
 */
public class UserCounts extends WeiboResponse {

	private static final long serialVersionUID = -2841255612083504764L;

	private long id;
	private long followersCount;// 粉丝数
	private long friendsCount;// 关注数
	private long statusesCount;// 微博数
	private long privateFriendsCount;// 悄悄关注数

	/**
	 * <p>Constructor for UserCounts.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public UserCounts(Response res) throws WeiboException {
		super(res);
		JSONObject json = res.asJSONObject();
		try {
			id = json.getLong("id");
			followersCount = json.getLong("followers_count");
			friendsCount = json.getLong("friends_count");
			statusesCount = json.getLong("statuses_count");
			privateFriendsCount = json.getLong("private_friends_count");
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}
	}

	/**
	 * <p>Constructor for UserCounts.</p>
	 *
	 * @param json a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public UserCounts(JSONObject json) throws WeiboException {
		try {
			id = json.getLong("id");
			followersCount = json.getLong("followers_count");
			friendsCount = json.getLong("friends_count");
			statusesCount = json.getLong("statuses_count");
			privateFriendsCount = json.getLong("private_friends_count");
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}
	}

	/**
	 * <p>constructUserCount.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @return a {@link java.util.List} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public static List<UserCounts> constructUserCount(Response res)
			throws WeiboException {
		try {
			JSONArray json = res.asJSONArray();
			int size = json.length();
			List<UserCounts> list = new ArrayList<UserCounts>(size);
			for (int i = 0; i < size; i++) {
				list.add(new UserCounts(json.getJSONObject(i)));
			}
			return list;
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}
	}

	/**
	 * <p>Getter for the field <code>id</code>.</p>
	 *
	 * @return a long.
	 */
	public long getId() {
		return id;
	}

	/**
	 * <p>Setter for the field <code>id</code>.</p>
	 *
	 * @param id a long.
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * <p>Getter for the field <code>followersCount</code>.</p>
	 *
	 * @return a long.
	 */
	public long getFollowersCount() {
		return followersCount;
	}

	/**
	 * <p>Setter for the field <code>followersCount</code>.</p>
	 *
	 * @param followersCount a long.
	 */
	public void setFollowersCount(long followersCount) {
		this.followersCount = followersCount;
	}

	/**
	 * <p>Getter for the field <code>friendsCount</code>.</p>
	 *
	 * @return a long.
	 */
	public long getFriendsCount() {
		return friendsCount;
	}

	/**
	 * <p>Setter for the field <code>friendsCount</code>.</p>
	 *
	 * @param friendsCount a long.
	 */
	public void setFriendsCount(long friendsCount) {
		this.friendsCount = friendsCount;
	}

	/**
	 * <p>Getter for the field <code>statusesCount</code>.</p>
	 *
	 * @return a long.
	 */
	public long getStatusesCount() {
		return statusesCount;
	}

	/**
	 * <p>Setter for the field <code>statusesCount</code>.</p>
	 *
	 * @param statusesCount a long.
	 */
	public void setStatusesCount(long statusesCount) {
		this.statusesCount = statusesCount;
	}

	/**
	 * <p>Getter for the field <code>privateFriendsCount</code>.</p>
	 *
	 * @return a long.
	 */
	public long getPrivateFriendsCount() {
		return privateFriendsCount;
	}

	/**
	 * <p>Setter for the field <code>privateFriendsCount</code>.</p>
	 *
	 * @param privateFriendsCount a long.
	 */
	public void setPrivateFriendsCount(long privateFriendsCount) {
		this.privateFriendsCount = privateFriendsCount;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "UserCount [" + "id=" + id
				+ ", friends_count=" + friendsCount
				+ ", followers_count=" + followersCount
				+ ", statuses_count=" + statusesCount
				+ ", private_friends_count=" + privateFriendsCount + "]";
	}

}
