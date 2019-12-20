package weibo4j.model;

import java.util.ArrayList;
import java.util.List;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * 搜学校搜索建议
 *
 * @author xiaoV
 * @version $Id: $Id
 */
public class SchoolSearch extends WeiboResponse {

	private static final long serialVersionUID = 4059782919675941016L;

	private String schoolName;
	private String location;
	private long id;
	private long type;

	/**
	 * <p>Constructor for SchoolSearch.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public SchoolSearch(Response res) throws WeiboException {
		super(res);
		JSONObject json = res.asJSONObject();
		try {
			id = json.getInt("id");
			location = json.getString("location");
			type = json.getLong("type");
			schoolName = json.getString("school_name");
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(),
					je);
		}
	}

	/**
	 * <p>Constructor for SchoolSearch.</p>
	 *
	 * @param json a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public SchoolSearch(JSONObject json) throws WeiboException {
		try {
			id = json.getInt("id");
			location = json.getString("location");
			type = json.getLong("type");
			schoolName = json.getString("school_name");
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(),
					je);
		}
	}

	/**
	 * <p>constructSchoolSearch.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @return a {@link java.util.List} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public static List<SchoolSearch> constructSchoolSearch(Response res)
			throws WeiboException {
		try {
			JSONArray list = res.asJSONArray();
			int size = list.length();
			List<SchoolSearch> schools = new ArrayList<SchoolSearch>(size);
			for (int i = 0; i < size; i++) {
				schools.add(new SchoolSearch(list.getJSONObject(i)));
			}
			return schools;
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		} catch (WeiboException te) {
			throw te;
		}
	}

	/**
	 * <p>Getter for the field <code>schoolName</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * <p>Setter for the field <code>schoolName</code>.</p>
	 *
	 * @param schoolName a {@link java.lang.String} object.
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * <p>Getter for the field <code>location</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <p>Setter for the field <code>location</code>.</p>
	 *
	 * @param location a {@link java.lang.String} object.
	 */
	public void setLocation(String location) {
		this.location = location;
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
	 * <p>Getter for the field <code>type</code>.</p>
	 *
	 * @return a long.
	 */
	public long getType() {
		return type;
	}

	/**
	 * <p>Setter for the field <code>type</code>.</p>
	 *
	 * @param type a long.
	 */
	public void setType(long type) {
		this.type = type;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "SchoolSearch [id=" + id
				+ ",school_name=" + schoolName
				+ ",location" + location
				+ ", type=" + type + "]";
	}
}
