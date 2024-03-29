package weibo4j;

import java.util.List;
import java.util.Map;

import weibo4j.model.PostParameter;
import weibo4j.model.SchoolSearch;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONArray;
import weibo4j.util.ArrayUtils;
import weibo4j.util.WeiboConfig;

/**
 * <p>Search class.</p>
 *
 * @author user1
 * @version $Id: $Id
 */
public class Search extends Weibo {

	private static final long serialVersionUID = 1060145395982699914L;

	/**
	 * <p>Constructor for Search.</p>
	 *
	 * @param access_token a {@link java.lang.String} object.
	 */
	public Search(String access_token) {
		this.access_token = access_token;
	}

	// ---------------------------------搜索接口-----------------------------------------------

	/**
	 * 搜索用户时的联想搜索建议
	 *
	 * @param q
	 *            搜索的关键字，必须做URLencoding
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/search/suggestions/users
	 * @since JDK 1.5
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 */
	public JSONArray searchSuggestionsUsers(String q) throws WeiboException {
		return client
				.get(WeiboConfig.getValue("baseURL")
						+ "search/suggestions/users.json",
						new PostParameter[] { new PostParameter("q", q) },
						access_token).asJSONArray();
	}

	/**
	 * 搜索用户时的联想搜索建议
	 *
	 * @param q
	 *            搜索的关键字，必须做URLencoding
	 * @param count
	 *            返回的记录条数，默认为10
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/search/suggestions/users
	 * @since JDK 1.5
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 */
	public JSONArray searchSuggestionsUsers(String q, int count)
			throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL")
						+ "search/suggestions/users.json",
				new PostParameter[] { new PostParameter("q", q),
						new PostParameter("count", count) }, access_token)
				.asJSONArray();
	}

	/**
	 * 搜索公司时的联想搜索建议
	 *
	 * @param q
	 *            搜索的关键字，必须做URLencoding
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/search/suggestions/companies
	 * @since JDK 1.5
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 */
	public JSONArray searchSuggestionsCompanies(String q) throws WeiboException {
		return client
				.get(WeiboConfig.getValue("baseURL")
						+ "search/suggestions/companies.json",
						new PostParameter[] { new PostParameter("q", q) },
						access_token).asJSONArray();
	}

	/**
	 * 搜索公司时的联想搜索建议
	 *
	 * @param q
	 *            搜索的关键字，必须做URLencoding
	 * @param count
	 *            返回的记录条数，默认为10
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/search/suggestions/companies
	 * @since JDK 1.5
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 */
	public JSONArray searchSuggestionsCompanies(String q, int count)
			throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL")
						+ "search/suggestions/companies.json",
				new PostParameter[] { new PostParameter("q", q),
						new PostParameter("count", count) }, access_token)
				.asJSONArray();
	}

	/**
	 * 搜索应用时的联想搜索建议
	 *
	 * @param q
	 *            搜索的关键字，必须做URLencoding
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/search/suggestions/apps
	 * @since JDK 1.5
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 */
	public JSONArray searchSuggestionsApps(String q) throws WeiboException {
		return client
				.get(WeiboConfig.getValue("baseURL")
						+ "search/suggestions/apps.json",
						new PostParameter[] { new PostParameter("q", q) },
						access_token).asJSONArray();
	}

	/**
	 * 搜索应用时的联想搜索建议
	 *
	 * @param q
	 *            搜索的关键字，必须做URLencoding
	 * @param count
	 *            返回的记录条数，默认为10
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/search/suggestions/apps
	 * @since JDK 1.5
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 */
	public JSONArray searchSuggestionsApps(String q, int count)
			throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL")
						+ "search/suggestions/apps.json",
				new PostParameter[] { new PostParameter("q", q),
						new PostParameter("count", count) }, access_token)
				.asJSONArray();
	}

	/**
	 * 搜索学校时的联想搜索建议
	 *
	 * @param q
	 *            搜索的关键字，必须做URLencoding
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/search/suggestions/schools
	 * @since JDK 1.5
	 * @return a {@link java.util.List} object.
	 */
	public List<SchoolSearch> searchSuggestionsSchools(String q)
			throws WeiboException {
		return SchoolSearch
				.constructSchoolSearch(client.get(
						WeiboConfig.getValue("baseURL")
								+ "search/suggestions/schools.json",
						new PostParameter[] { new PostParameter("q", q) },
						access_token));
	}

	/**
	 * 搜索学校时的联想搜索建议
	 *
	 * @param q
	 *            搜索的关键字，必须做URLencoding
	 * @param count
	 *            返回的记录条数，默认为10
	 * @param type
	 *            学校类型，0：全部、1：大学、2：高中、3：中专技校、4：初中、5：小学，默认为0
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/search/suggestions/schools
	 * @since JDK 1.5
	 * @return a {@link java.util.List} object.
	 */
	public List<SchoolSearch> searchSuggestionsSchools(String q, int count,
			int type) throws WeiboException {
		return SchoolSearch.constructSchoolSearch(client.get(
				WeiboConfig.getValue("baseURL")
						+ "search/suggestions/schools.json",
				new PostParameter[] { new PostParameter("q", q),
						new PostParameter("count", count),
						new PostParameter("type", type) }, access_token));
	}

	/**
	 * 搜索学校时的联想搜索建议
	 *
	 * @param map
	 *            参数列表
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/search/suggestions/schools
	 * @since JDK 1.5
	 * @return a {@link java.util.List} object.
	 */
	public List<SchoolSearch> searchSuggestionsSchools(Map<String, String> map)
			throws WeiboException {
		PostParameter[] parList = ArrayUtils.mapToArray(map);
		return SchoolSearch.constructSchoolSearch(client.get(
				WeiboConfig.getValue("baseURL")
						+ "search/suggestions/schools.json", parList, access_token));
	}

	/**
	 * <p>searchSuggestionsAtUsers.</p>
	 *
	 * @param q
	 *            搜索的关键字，必须做URLencoding
	 * @param type
	 *            联想类型，0：关注、1：粉丝
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/search/suggestions/at_users
	 * @since JDK 1.5
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 */
	public JSONArray searchSuggestionsAtUsers(String q, int type)
			throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL")
						+ "search/suggestions/at_users.json",
				new PostParameter[] { new PostParameter("q", q),
						new PostParameter("type", type) }, access_token)
				.asJSONArray();
	}

	/**
	 * <p>searchSuggestionsAtUsers.</p>
	 *
	 * @param q
	 *            搜索的关键字，必须做URLencoding
	 * @param count
	 *            返回的记录条数，默认为10，粉丝最多1000，关注最多2000
	 * @param type
	 *            联想类型，0：关注、1：粉丝
	 * @param range
	 *            联想范围，0：只联想关注人、1：只联想关注人的备注、2：全部，默认为2
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/search/suggestions/at_users
	 * @since JDK 1.5
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 */
	public JSONArray searchSuggestionsAtUsers(String q, int count, int type,
			int range) throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL")
						+ "search/suggestions/at_users.json",
				new PostParameter[] { new PostParameter("q", q),
						new PostParameter("count", count),
						new PostParameter("type", type),
						new PostParameter("range", range) }, access_token)
				.asJSONArray();
	}

	/**
	 * <p>searchSuggestionsAtUsers.</p>
	 *
	 * @param map
	 *            参数列表
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/search/suggestions/at_users
	 * @since JDK 1.5
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 */
	public JSONArray searchSuggestionsAtUsers(Map<String, String> map)
			throws WeiboException {
		PostParameter[] parList = ArrayUtils.mapToArray(map);
		return client.get(
				WeiboConfig.getValue("baseURL")
						+ "search/suggestions/at_users.json", parList, access_token)
				.asJSONArray();
	}
}
