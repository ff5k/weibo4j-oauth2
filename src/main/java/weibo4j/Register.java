package weibo4j;

import weibo4j.model.PostParameter;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;
import weibo4j.util.WeiboConfig;

/**
 * <p>Register class.</p>
 *
 * @author user1
 * @version $Id: $Id
 */
public class Register extends Weibo {

	private static final long serialVersionUID = -6809545704064413209L;

	/**
	 * <p>Constructor for Register.</p>
	 *
	 * @param access_token a {@link java.lang.String} object.
	 */
	public Register(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * 验证昵称是否可用，并给予建议昵称
	 *
	 * @param nickname
	 *            需要验证的昵称。4-20个字符，支持中英文、数字、"_"或减号。必须做URLEncode，采用UTF-8编码
	 * @throws weibo4j.model.WeiboException
	 *             when Weibo service or network is unavailable
	 * @version weibo4j-V2 1.0.2
	 * @see http://open.weibo.com/wiki/2/register/verify_nickname
	 * @since JDK 1.5
	 * @return a {@link weibo4j.org.json.JSONObject} object.
	 */
	public JSONObject verifyNickname(String nickname) throws WeiboException {
		return client
				.get(WeiboConfig.getValue("baseURL")
						+ "register/verify_nickname.json",
						new PostParameter[] { new PostParameter("nickname",
								nickname) }, access_token).asJSONObject();
	}
}
