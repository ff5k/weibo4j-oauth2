package weibo4j;

import weibo4j.model.PostParameter;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONObject;
import weibo4j.util.WeiboConfig;

/**
 * <p>PublicService class.</p>
 *
 * @author user1
 * @version $Id: $Id
 */
public class PublicService extends Weibo {

	private static final long serialVersionUID = -2783541874923814897L;

	/**
	 * <p>Constructor for PublicService.</p>
	 *
	 * @param access_token a {@link java.lang.String} object.
	 */
	public PublicService(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * 通过地址编码获取地址名称
	 *
	 * @param codes
	 *            需要查询的地址编码，多个之间用逗号分隔
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/common/code_to_location
	 * @since JDK 1.5
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 */
	public JSONArray getLocationByCode(String codes) throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL")
						+ "common/code_to_location.json",
				new PostParameter[] { new PostParameter("codes", codes) },
				access_token).asJSONArray();
	}

	/**
	 * 获取省份列表
	 *
	 * @param country
	 *            国家的国家代码
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/common/get_province
	 * @since JDK 1.5
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 */
	public JSONArray provinceList(String country) throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "common/get_province.json",
				new PostParameter[] { new PostParameter("country", country) },
				access_token).asJSONArray();
	}

	/**
	 * <p>provinceListOfCapital.</p>
	 *
	 * @param country a {@link java.lang.String} object.
	 * @param capital a {@link java.lang.String} object.
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public JSONArray provinceListOfCapital(String country, String capital)
			throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "common/get_province.json",
				new PostParameter[] { new PostParameter("country", country),
						new PostParameter("capital", capital) }, access_token)
				.asJSONArray();
	}

	/**
	 * <p>provinceList.</p>
	 *
	 * @param country a {@link java.lang.String} object.
	 * @param language a {@link java.lang.String} object.
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public JSONArray provinceList(String country, String language)
			throws WeiboException {
		return client
				.get(WeiboConfig.getValue("baseURL")
						+ "common/get_province.json",
						new PostParameter[] {
								new PostParameter("country", country),
								new PostParameter("language", language) },
						access_token).asJSONArray();
	}

	/**
	 * <p>provinceList.</p>
	 *
	 * @param country a {@link java.lang.String} object.
	 * @param capital a {@link java.lang.String} object.
	 * @param language a {@link java.lang.String} object.
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public JSONArray provinceList(String country, String capital,
			String language) throws WeiboException {
		return client
				.get(WeiboConfig.getValue("baseURL")
						+ "common/get_province.json",
						new PostParameter[] {
								new PostParameter("country", country),
								new PostParameter("capital", capital),
								new PostParameter("language", language) },
						access_token).asJSONArray();
	}

	/**
	 * 获取城市列表
	 *
	 * @param province
	 *            省份的省份代码
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/common/get_city
	 * @since JDK 1.5
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 */
	public JSONArray cityList(String province) throws WeiboException {
		return client
				.get(WeiboConfig.getValue("baseURL") + "common/get_city.json",
						new PostParameter[] { new PostParameter("province",
								province) }, access_token).asJSONArray();
	}

	/**
	 * <p>cityListOfCapital.</p>
	 *
	 * @param province a {@link java.lang.String} object.
	 * @param capital a {@link java.lang.String} object.
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public JSONArray cityListOfCapital(String province, String capital)
			throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "common/get_city.json",
				new PostParameter[] { new PostParameter("province", province),
						new PostParameter("capital", capital) }, access_token)
				.asJSONArray();
	}

	/**
	 * <p>cityList.</p>
	 *
	 * @param province a {@link java.lang.String} object.
	 * @param language a {@link java.lang.String} object.
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public JSONArray cityList(String province, String language)
			throws WeiboException {
		return client
				.get(WeiboConfig.getValue("baseURL") + "common/get_city.json",
						new PostParameter[] {
								new PostParameter("province", province),
								new PostParameter("language", language) },
						access_token).asJSONArray();
	}

	/**
	 * <p>cityList.</p>
	 *
	 * @param province a {@link java.lang.String} object.
	 * @param capital a {@link java.lang.String} object.
	 * @param language a {@link java.lang.String} object.
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public JSONArray cityList(String province, String capital, String language)
			throws WeiboException {
		return client
				.get(WeiboConfig.getValue("baseURL") + "common/get_city.json",
						new PostParameter[] {
								new PostParameter("province", province),
								new PostParameter("capital", capital),
								new PostParameter("language", language) },
						access_token).asJSONArray();
	}

	/**
	 * 获取国家列表
	 *
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/common/get_country
	 * @since JDK 1.5
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 */
	public JSONArray countryList() throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "common/get_country.json",
				access_token).asJSONArray();
	}

	/**
	 * <p>countryListOfCapital.</p>
	 *
	 * @param capital a {@link java.lang.String} object.
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public JSONArray countryListOfCapital(String capital) throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "common/get_country.json",
				new PostParameter[] { new PostParameter("capital", capital) },
				access_token).asJSONArray();
	}

	/**
	 * <p>countryList.</p>
	 *
	 * @param language a {@link java.lang.String} object.
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public JSONArray countryList(String language) throws WeiboException {
		return client
				.get(WeiboConfig.getValue("baseURL")
						+ "common/get_country.json",
						new PostParameter[] { new PostParameter("language",
								language) }, access_token).asJSONArray();
	}

	/**
	 * <p>countryList.</p>
	 *
	 * @param capital a {@link java.lang.String} object.
	 * @param language a {@link java.lang.String} object.
	 * @return a {@link weibo4j.org.json.JSONArray} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public JSONArray countryList(String capital, String language)
			throws WeiboException {
		return client
				.get(WeiboConfig.getValue("baseURL")
						+ "common/get_country.json",
						new PostParameter[] {
								new PostParameter("capital", capital),
								new PostParameter("language", language) },
						access_token).asJSONArray();
	}

	/**
	 * 获取时区配置表
	 *
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/common/get_timezone
	 * @since JDK 1.5
	 * @return a {@link weibo4j.org.json.JSONObject} object.
	 */
	public JSONObject getTomeZone() throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "common/get_timezone.json",
				access_token).asJSONObject();
	}

}
