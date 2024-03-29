package weibo4j;

import java.util.List;
import java.util.Map;

import weibo4j.model.PostParameter;
import weibo4j.model.Privacy;
import weibo4j.model.RateLimitStatus;
import weibo4j.model.School;
import weibo4j.model.User;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;
import weibo4j.util.ArrayUtils;
import weibo4j.util.WeiboConfig;

/**
 * <p>Account class.</p>
 *
 * @author user1
 * @version $Id: $Id
 */
public class Account extends Weibo {

	private static final long serialVersionUID = 3816005087976772682L;

	/**
	 * <p>Constructor for Account.</p>
	 *
	 * @param access_token a {@link java.lang.String} object.
	 */
	public Account(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * OAuth授权之后，获取授权用户的UID
	 *
	 * @return uid
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/account/get_uid
	 * @since JDK 1.5
	 */
	public JSONObject getUid() throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "account/get_uid.json",
				access_token).asJSONObject();
	}

	/**
	 * 获取当前登录用户的隐私设置
	 *
	 * @return User's privacy
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/account/get_privacy
	 * @since JDK 1.5
	 */
	public Privacy getAccountPrivacy() throws WeiboException {
		return new Privacy(client.get(WeiboConfig.getValue("baseURL")
				+ "account/get_privacy.json", access_token));
	}

	/**
	 * 获取所有学校列表
	 *
	 * @return list of school
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/account/profile/school_list
	 * @since JDK 1.5
	 * @param keyword a {@link java.lang.String} object.
	 */
	public List<School> getAccountProfileSchoolList(String keyword)
			throws WeiboException {
		return School.constructSchool(client.get(
				WeiboConfig.getValue("baseURL")
						+ "account/profile/school_list.json",
				new PostParameter[] { new PostParameter("keyword", keyword) },
				access_token));
	}

	/**
	 * 获取所有的学校列表
	 *
	 * @param province
	 *            省份范围，省份ID
	 * @param capital
	 *            学校首字母
	 * @return list of school
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/account/profile/school_list
	 * @since JDK 1.5
	 */
	public List<School> getAccountProfileSchoolList(String province,
			String capital) throws WeiboException {
		return School.constructSchool(client.get(
				WeiboConfig.getValue("baseURL")
						+ "account/profile/school_list.json",
				new PostParameter[] { new PostParameter("province", province),
						new PostParameter("capital", capital) }, access_token));
	}

	/**
	 * 获取所有的学校列表
	 *
	 * @param map
	 *            参数列表
	 * @return list of school
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/account/profile/school_list
	 * @since JDK 1.5
	 */
	public List<School> getAccountProfileSchoolList(Map<String, String> map)
			throws WeiboException {
		PostParameter[] parList = ArrayUtils.mapToArray(map);
		return School
				.constructSchool(client.get(WeiboConfig.getValue("baseURL")
						+ "account/profile/school_list.json", parList, access_token));
	}

	/**
	 * 获取当前登录用户的API访问频率限制情况
	 *
	 * @return rate limit
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.1
	 * @see http://open.weibo.com/wiki/2/account/rate_limit_status
	 * @since JDK 1.5
	 */
	public RateLimitStatus getAccountRateLimitStatus() throws WeiboException {
		return new RateLimitStatus(client.get(WeiboConfig.getValue("baseURL")
				+ "account/rate_limit_status.json", access_token));
	}

	/**
	 * 退出登录
	 *
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/account/end_session
	 * @since JDK 1.5
	 * @return a {@link weibo4j.model.User} object.
	 */
	public User endSession() throws WeiboException {
		return new User(client.get(WeiboConfig.getValue("baseURL")
				+ "account/end_session.json", access_token));
	}
}
