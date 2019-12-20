package weibo4j;

import java.util.Map;

import weibo4j.model.PostParameter;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;
import weibo4j.util.ArrayUtils;
import weibo4j.util.WeiboConfig;

/**
 * <p>Reminds class.</p>
 *
 * @author user1
 * @version $Id: $Id
 */
public class Reminds extends Weibo {

	private static final long serialVersionUID = 5042162449339969435L;

	/**
	 * <p>Constructor for Reminds.</p>
	 *
	 * @param access_token a {@link java.lang.String} object.
	 */
	public Reminds(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * 获取某个用户的各种消息未读数
	 *
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/remind/unread_count
	 * @since JDK 1.5
	 * @return a {@link weibo4j.org.json.JSONObject} object.
	 */
	public JSONObject getUnreadCountOfRemind() throws WeiboException {
		return client.get(
				WeiboConfig.getValue("baseURL") + "remind/unread_count.json",
				access_token).asJSONObject();
	}

	/**
	 * <p>getUnreadCountOfRemind.</p>
	 *
	 * @param callback a {@link java.lang.String} object.
	 * @return a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public JSONObject getUnreadCountOfRemind(String callback)
			throws WeiboException {
		return client
				.get(WeiboConfig.getValue("baseURL")
						+ "remind/unread_count.json",
						new PostParameter[] { new PostParameter("callback",
								callback) }, access_token).asJSONObject();
	}

	/**
	 * <p>getUnreadCountOfRemind.</p>
	 *
	 * @param map a {@link java.util.Map} object.
	 * @return a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public JSONObject getUnreadCountOfRemind(Map<String, String> map)
			throws WeiboException {
		PostParameter[] parList = ArrayUtils.mapToArray(map);
		return client.get(
				WeiboConfig.getValue("baseURL") + "remind/unread_count.json",
				parList, access_token).asJSONObject();
	}

}
