package weibo4j;

import weibo4j.model.Paging;
import weibo4j.model.PostParameter;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONObject;
import weibo4j.util.WeiboConfig;

/**
 * <p>Suggestion class.</p>
 *
 * @author user1
 * @version $Id: $Id
 */
public class Suggestion extends Weibo {

	private static final long serialVersionUID = 1861364044145921824L;

	/**
	 * <p>Constructor for Suggestion.</p>
	 *
	 * @param access_token a {@link java.lang.String} object.
	 */
	public Suggestion(String access_token) {
		this.access_token = access_token;
	}

	// ---------------------------------推荐接口---------------------------------------------------
	/**
	 * 返回系统推荐的热门用户列表
	 *
	 * @return list of the users
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/suggestions/users/hot
	 * @since JDK 1.5
	 */
	public JSONArray suggestionsUsersHot() throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "suggestions/users/hot.json",
				access_token).asJSONArray();
	}

	/**
	 * <p>suggestionsUsersHot.</p>
	 *
	 * @param category a {@link java.lang.String} object.
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public JSONArray suggestionsUsersHot(String category) throws WeiboException {
		return client
				.get(WeiboConfig.getValue("baseURL")
						+ "suggestions/users/hot.json",
						new PostParameter[] { new PostParameter("category",
								category) }, access_token).asJSONArray();
	}

	/**
	 * 获取用户可能感兴趣的人
	 *
	 * @return list of the user's id
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/suggestions/users/may_interested
	 * @since JDK 1.5
	 */
	public JSONArray suggestionsUsersMayInterested() throws WeiboException {
		return client
				.get(WeiboConfig.getValue("baseURL")
						+ "suggestions/users/may_interested.json", access_token)
				.asJSONArray();
	}

	/**
	 * <p>suggestionsUsersMayInterested.</p>
	 *
	 * @param count a int.
	 * @param page a int.
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public JSONArray suggestionsUsersMayInterested(int count, int page)
			throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL")
						+ "suggestions/users/may_interested.json",
				new PostParameter[] { new PostParameter("count", count),
						new PostParameter("page", page) }, access_token)
				.asJSONArray();
	}

	/**
	 * 根据一段微博正文推荐相关微博用户
	 *
	 * @return list of the users
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/suggestions/users/by_status
	 * @since JDK 1.5
	 * @param content a {@link java.lang.String} object.
	 */
	public UserWapper suggestionsUsersByStatus(String content)
			throws WeiboException {
		return User.constructWapperUsers(client.get(
				WeiboConfig.getValue("baseURL")
						+ "suggestions/users/by_status.json",
				new PostParameter[] { new PostParameter("content", content) },
				access_token));
	}

	/**
	 * <p>suggestionsUsersByStatus.</p>
	 *
	 * @param content a {@link java.lang.String} object.
	 * @param num a int.
	 * @return a {@link weibo4j.model.UserWapper} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public UserWapper suggestionsUsersByStatus(String content, int num)
			throws WeiboException {
		return User.constructWapperUsers(client.get(
				WeiboConfig.getValue("baseURL")
						+ "suggestions/users/by_status.json",
				new PostParameter[] { new PostParameter("content", content),
						new PostParameter("num", num) }, access_token));
	}

	/**
	 * 当前登录用户的friends_timeline微博按兴趣推荐排序
	 *
	 * @param section
	 *            排序时间段，距现在n秒内的微博参加排序，最长支持24小时
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/suggestions/statuses/reorder
	 * @since JDK 1.5
	 * @return a {@link weibo4j.model.StatusWapper} object.
	 */
	public StatusWapper suggestionsStatusesReorder(int section)
			throws WeiboException {
		return Status.constructWapperStatus(client.get(
				WeiboConfig.getValue("baseURL")
						+ "suggestions/statuses/reorder.json",
				new PostParameter[] { new PostParameter("section", section) },
				access_token));
	}

	/**
	 * <p>suggestionsStatusesReorder.</p>
	 *
	 * @param section a int.
	 * @param count a int.
	 * @param page a {@link weibo4j.model.Paging} object.
	 * @return a {@link weibo4j.model.StatusWapper} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public StatusWapper suggestionsStatusesReorder(int section, int count,
			Paging page) throws WeiboException {
		return Status
				.constructWapperStatus(client.get(
						WeiboConfig.getValue("baseURL")
								+ "suggestions/statuses/reorder.json",
						new PostParameter[] {
								new PostParameter("section", section),
								new PostParameter("count", count) }, page,
						access_token));
	}

	/**
	 * 当前登录用户的friends_timeline微博按兴趣推荐排序的微博ID
	 *
	 * @param section
	 *            排序时间段，距现在n秒内的微博参加排序，最长支持24小时
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/suggestions/statuses/reorder/ids
	 * @since JDK 1.5
	 * @return a {@link weibo4j.org.json.JSONObject} object.
	 */
	public JSONObject suggestionStatusesReorderIds(int section)
			throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL")
						+ "suggestions/statuses/reorder/ids.json",
				new PostParameter[] { new PostParameter("section", section) },
				access_token).asJSONObject();
	}

	/**
	 * <p>suggestionStatusesReorderIds.</p>
	 *
	 * @param section a int.
	 * @param count a int.
	 * @param page a {@link weibo4j.model.Paging} object.
	 * @return a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public JSONObject suggestionStatusesReorderIds(int section, int count,
			Paging page) throws WeiboException {
		return client
				.get(WeiboConfig.getValue("baseURL")
						+ "suggestions/statuses/reorder/ids.json",
						new PostParameter[] {
								new PostParameter("section", section),
								new PostParameter("count", count) }, page,
						access_token).asJSONObject();
	}

	/**
	 * 返回系统推荐的热门收藏
	 *
	 * @return list of the status
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/suggestions/favorites/hot
	 * @since JDK 1.5
	 */
	public JSONArray suggestionsFavoritesHot() throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL")
						+ "suggestions/favorites/hot.json", access_token)
				.asJSONArray();
	}

	/**
	 * <p>suggestionsFavoritesHot.</p>
	 *
	 * @param page a int.
	 * @param count a int.
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public JSONArray suggestionsFavoritesHot(int page, int count)
			throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL")
						+ "suggestions/favorites/hot.json",
				new PostParameter[] { new PostParameter("page", page),
						new PostParameter("count", count) }, access_token)
				.asJSONArray();
	}

	/**
	 * 把某人标识为不感兴趣的人
	 *
	 * @return user
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/suggestions/users/not_interested
	 * @since JDK 1.5
	 * @param uid a {@link java.lang.String} object.
	 */
	public User suggestionsUsersNotInterested(String uid)
			throws WeiboException {
		return new User(client.post(
				WeiboConfig.getValue("baseURL")
						+ "suggestions/users/not_interested.json",
				new PostParameter[] { new PostParameter("uid", uid) },
				access_token).asJSONObject());
	}
}
