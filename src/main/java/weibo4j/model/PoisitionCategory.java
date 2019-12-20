package weibo4j.model;

import java.util.ArrayList;
import java.util.List;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * 获取地点分类
 *
 * @author xiaoV
 * @version $Id: $Id
 */
public class PoisitionCategory extends WeiboResponse {

	private static final long serialVersionUID = 6795534455304308918L;

	private long id;
	private String name;
	private long pid;

	/**
	 * <p>Constructor for PoisitionCategory.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public PoisitionCategory(Response res) throws WeiboException {
		super(res);
		JSONObject json = null;
		try {
			json = res.asJSONObject();
			id = json.getLong("id");
			pid = json.getLong("pid");
			name = json.getString("name");
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}
	}

	/**
	 * <p>Constructor for PoisitionCategory.</p>
	 *
	 * @param json a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public PoisitionCategory(JSONObject json) throws WeiboException {
		try {
			id = json.getLong("id");
			pid = json.getLong("pid");
			name = json.getString("name");
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}
	}

	/**
	 * <p>constructPoisCategory.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @return a {@link java.util.List} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public static List<PoisitionCategory> constructPoisCategory(Response res)
			throws WeiboException {
		try {
			JSONArray json = res.asJSONArray();
			int size = json.length();
			List<PoisitionCategory> list = new ArrayList<PoisitionCategory>(
					size);
			for (int i = 0; i < size; i++) {
				list.add(new PoisitionCategory(json.getJSONObject(i)));
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
	 * <p>Getter for the field <code>name</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getName() {
		return name;
	}

	/**
	 * <p>Setter for the field <code>name</code>.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <p>Getter for the field <code>pid</code>.</p>
	 *
	 * @return a long.
	 */
	public long getPid() {
		return pid;
	}

	/**
	 * <p>Setter for the field <code>pid</code>.</p>
	 *
	 * @param pid a long.
	 */
	public void setPid(long pid) {
		this.pid = pid;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "PoisitionCategory [" + "id=" + id
				+ ", name=" + name
				+ ", pid=" + pid + "]";
	}
}
