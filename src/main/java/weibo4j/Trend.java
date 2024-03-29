package weibo4j;

import java.util.List;

import weibo4j.model.Paging;
import weibo4j.model.PostParameter;
import weibo4j.model.Trends;
import weibo4j.model.UserTrend;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;
import weibo4j.util.WeiboConfig;

/**
 * <p>Trend class.</p>
 *
 * @author user1
 * @version $Id: $Id
 */
public class Trend extends Weibo {

	private static final long serialVersionUID = 903299515334415487L;

	/**
	 * <p>Constructor for Trend.</p>
	 *
	 * @param access_token a {@link java.lang.String} object.
	 */
	public Trend(String access_token) {
		this.access_token = access_token;
	}

	/*----------------------------话题接口----------------------------------------*/
	/**
	 * 获取某人的话题列表
	 *
	 * @param uid
	 *            需要获取话题的用户的UID
	 * @return list of the userTrend
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/trends
	 * @since JDK 1.5
	 */
	public List<UserTrend> getTrends(String uid) throws WeiboException {
		return UserTrend.constructTrendList(client.get(
				WeiboConfig.getValue("baseURL") + "trends.json",
				new PostParameter[] { new PostParameter("uid", uid) },
				access_token));
	}

	/**
	 * 获取某人的话题列表
	 *
	 * @param uid
	 *            需要获取话题的用户的UID
	 * @param page
	 *            返回结果的页码，默认为1
	 * @return list of the userTrend
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/trends
	 * @since JDK 1.5
	 */
	public List<UserTrend> getTrends(String uid, Paging page)
			throws WeiboException {
		return UserTrend.constructTrendList(client.get(
				WeiboConfig.getValue("baseURL") + "trends.json",
				new PostParameter[] { new PostParameter("uid", uid) }, page,
				access_token));
	}

	/**
	 * 判断当前用户是否关注某话题
	 *
	 * @param trend_name
	 *            话题关键字，必须做URLencode
	 * @return jsonobject
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/trends/is_follow
	 * @since JDK 1.5
	 */
	public JSONObject isFollow(String trend_name) throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "trends/is_follow.json",
				new PostParameter[] { new PostParameter("trend_name",
						trend_name) }, access_token).asJSONObject();
	}

	/**
	 * 返回最近一小时内的热门话题
	 *
	 * @return list of trends
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/trends/hourly
	 * @since JDK 1.5
	 */
	public List<Trends> getTrendsHourly() throws WeiboException {
		return Trends.constructTrendsList(client.get(
				WeiboConfig.getValue("baseURL") + "trends/hourly.json",
				access_token));
	}

	/**
	 * <p>getTrendsHourly.</p>
	 *
	 * @param base_app a {@link java.lang.Integer} object.
	 * @return a {@link java.util.List} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public List<Trends> getTrendsHourly(Integer base_app) throws WeiboException {
		return Trends.constructTrendsList(client.get(
				WeiboConfig.getValue("baseURL") + "trends/hourly.json",
				new PostParameter[] { new PostParameter("base_app", base_app
						.toString()) }, access_token));
	}

	/**
	 * 返回最近一天内的热门话题
	 *
	 * @return list of trends
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/trends/daily
	 * @since JDK 1.5
	 */
	public List<Trends> getTrendsDaily() throws WeiboException {
		return Trends.constructTrendsList(client.get(
				WeiboConfig.getValue("baseURL") + "trends/daily.json",
				access_token));
	}

	/**
	 * <p>getTrendsDaily.</p>
	 *
	 * @param base_app a {@link java.lang.Integer} object.
	 * @return a {@link java.util.List} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public List<Trends> getTrendsDaily(Integer base_app) throws WeiboException {
		return Trends.constructTrendsList(client.get(
				WeiboConfig.getValue("baseURL") + "trends/daily.json",
				new PostParameter[] { new PostParameter("base_app", base_app
						.toString()) }, access_token));
	}

	/**
	 * 返回最近一周内的热门话题
	 *
	 * @return list of trends
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/trends/weekly
	 * @since JDK 1.5
	 */
	public List<Trends> getTrendsWeekly() throws WeiboException {
		return Trends.constructTrendsList(client.get(
				WeiboConfig.getValue("baseURL") + "trends/weekly.json",
				access_token));
	}

	/**
	 * <p>getTrendsWeekly.</p>
	 *
	 * @param base_app a {@link java.lang.Integer} object.
	 * @return a {@link java.util.List} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public List<Trends> getTrendsWeekly(Integer base_app) throws WeiboException {
		return Trends.constructTrendsList(client.get(
				WeiboConfig.getValue("baseURL") + "trends/weekly.json",
				new PostParameter[] { new PostParameter("base_app", base_app
						.toString()) }, access_token));
	}

	/**
	 * 关注某话题
	 *
	 * @param trend_name
	 *            要关注的话题关键词。
	 * @return UserTrend
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/trends/follow
	 * @since JDK 1.5
	 */
	public UserTrend trendsFollow(String trend_name) throws WeiboException {
		return new UserTrend(client.post(WeiboConfig.getValue("baseURL")
				+ "trends/follow.json",
				new PostParameter[] { new PostParameter("trend_name",
						trend_name) }, access_token));
	}

	/**
	 * 取消对某话题的关注
	 *
	 * @param trend_id
	 *            要取消关注的话题ID
	 * @return jsonobject
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/trends/destroy
	 * @since JDK 1.5
	 */
	public JSONObject trendsDestroy(Integer trend_id) throws WeiboException {
		return client.post(
				WeiboConfig.getValue("baseURL") + "trends/destroy.json",
				new PostParameter[] { new PostParameter("trend_id", trend_id
						.toString()) }, access_token).asJSONObject();
	}

}
