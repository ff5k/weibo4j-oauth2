package weibo4j.model;

import java.util.ArrayList;
import java.util.List;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * <p>School class.</p>
 *
 * @author user1
 * @version $Id: $Id
 */
public class School extends WeiboResponse {

	private static final long serialVersionUID = -5991828656755790609L;
	private int id; // 学校id
	private String name; // 学校名称

	/**
	 * <p>Constructor for School.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public School(Response res) throws WeiboException {
		super(res);
		JSONObject json = res.asJSONObject();
		try {
			id = json.getInt("id");
			name = json.getString("name");
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(),
					je);
		}
	}

	/**
	 * <p>Constructor for School.</p>
	 *
	 * @param json a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public School(JSONObject json) throws WeiboException {
		try {
			id = json.getInt("id");
			name = json.getString("name");
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(),
					je);
		}
	}

	/**
	 * <p>constructSchool.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @return a {@link java.util.List} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public static List<School> constructSchool(Response res) throws WeiboException {
		try {
			JSONArray list = res.asJSONArray();
			int size = list.length();
			List<School> schools = new ArrayList<School>(size);
			for (int i = 0; i < size; i++) {
				schools.add(new School(list.getJSONObject(i)));
			}
			return schools;
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		} catch (WeiboException te) {
			throw te;
		}

	}

	/**
	 * <p>Getter for the field <code>id</code>.</p>
	 *
	 * @return a int.
	 */
	public int getId() {
		return id;
	}

	/**
	 * <p>Getter for the field <code>name</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getName() {
		return name;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		School other = (School) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + "]";
	}

}
