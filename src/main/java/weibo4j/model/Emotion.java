package weibo4j.model;

import java.util.ArrayList;
import java.util.List;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * <p>Emotion class.</p>
 *
 * @author SinaWeibo
 * @version $Id: $Id
 */
public class Emotion extends WeiboResponse {
	private static final long serialVersionUID = -4096813631691846494L;
	private String phrase; // 表情使用的替代文字
	private String type; // 表情类型，image为普通图片表情，magic为魔法表情
	private String url; // 表情图片存放的位置
	private boolean hot; // 是否为热门表情
	private boolean common; // 是否是常用表情
	private String value;
	private String category; // 表情分类
	private String picid;
	private String icon;

	/**
	 * <p>Constructor for Emotion.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public Emotion(Response res) throws WeiboException {
		super(res);
		JSONObject json = res.asJSONObject();
		try {
			phrase = json.getString("phrase");
			type = json.getString("type");
			url = json.getString("url");
			hot = json.getBoolean("hot");
			category = json.getString("category");
			common = json.getBoolean("common");
			value = json.getString("value");
			picid = json.getString("picid");
			icon = json.getString("icon");
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(),
					je);
		}
	}

	/**
	 * <p>Constructor for Emotion.</p>
	 *
	 * @param json a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public Emotion(JSONObject json) throws WeiboException {
		try {
			phrase = json.getString("phrase");
			type = json.getString("type");
			url = json.getString("url");
			hot = json.getBoolean("hot");
			category = json.getString("category");
			common = json.getBoolean("common");
			value = json.getString("value");
			picid = json.getString("picid");
			icon = json.getString("icon");
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(),
					je);
		}
	}

	/**
	 * <p>constructEmotions.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @return a {@link java.util.List} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public static List<Emotion> constructEmotions(Response res)
			throws WeiboException {
		try {
			JSONArray list = res.asJSONArray();
			int size = list.length();
			List<Emotion> emotions = new ArrayList<Emotion>(size);
			for (int i = 0; i < size; i++) {
				emotions.add(new Emotion(list.getJSONObject(i)));
			}
			return emotions;
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		} catch (WeiboException te) {
			throw te;
		}

	}

	/**
	 * <p>Constructor for Emotion.</p>
	 */
	public Emotion() {
		super();
	}

	/**
	 * <p>Getter for the field <code>phrase</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getPhrase() {
		return phrase;
	}

	/**
	 * <p>Setter for the field <code>phrase</code>.</p>
	 *
	 * @param phrase a {@link java.lang.String} object.
	 */
	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

	/**
	 * <p>Getter for the field <code>type</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getType() {
		return type;
	}

	/**
	 * <p>Setter for the field <code>type</code>.</p>
	 *
	 * @param type a {@link java.lang.String} object.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * <p>Getter for the field <code>url</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * <p>Setter for the field <code>url</code>.</p>
	 *
	 * @param url a {@link java.lang.String} object.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * <p>Getter for the field <code>category</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * <p>Setter for the field <code>category</code>.</p>
	 *
	 * @param category a {@link java.lang.String} object.
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * <p>isHot.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isHot() {
		return hot;
	}

	/**
	 * <p>Setter for the field <code>hot</code>.</p>
	 *
	 * @param hot a boolean.
	 */
	public void setHot(boolean hot) {
		this.hot = hot;
	}

	/**
	 * <p>isCommon.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isCommon() {
		return common;
	}

	/**
	 * <p>Setter for the field <code>common</code>.</p>
	 *
	 * @param common a boolean.
	 */
	public void setCommon(boolean common) {
		this.common = common;
	}

	/**
	 * <p>Getter for the field <code>value</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <p>Setter for the field <code>value</code>.</p>
	 *
	 * @param value a {@link java.lang.String} object.
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * <p>Getter for the field <code>picid</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getPicid() {
		return picid;
	}

	/**
	 * <p>Setter for the field <code>picid</code>.</p>
	 *
	 * @param picid a {@link java.lang.String} object.
	 */
	public void setPicid(String picid) {
		this.picid = picid;
	}

	/**
	 * <p>Getter for the field <code>icon</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * <p>Setter for the field <code>icon</code>.</p>
	 *
	 * @param icon a {@link java.lang.String} object.
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Emotion [phrase=" + phrase + ", type=" + type + ", url=" + url
				+ ", hot=" + hot + ", common=" + common + ", value=" + value
				+ ", category=" + category + ", picid=" + picid + ", icon="
				+ icon + "]";
	}

}
