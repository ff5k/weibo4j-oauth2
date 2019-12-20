package weibo4j.model;

import java.util.ArrayList;
import java.util.List;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * <p>FavoritesTag class.</p>
 *
 * @author sinaWeibo
 * @version $Id: $Id
 */
public class FavoritesTag extends WeiboResponse {

	private static final long serialVersionUID = 2177657076940291492L;

	private String id;           //标签id

	private String tag;          //标签

	private int count;           //该标签下收藏的微博数

	/**
	 * <p>Constructor for FavoritesTag.</p>
	 *
	 * @param json a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.model.WeiboException if any.
	 * @throws weibo4j.org.json.JSONException if any.
	 */
	public FavoritesTag(JSONObject json) throws WeiboException,JSONException {
		id = json.getString("id");
		tag = json.getString("tag");
		if(!json.isNull("count"))
		{
			count = json.getInt("count");
		}

	}


	/**
	 * <p>constructTags.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @return a {@link java.util.List} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public static List<FavoritesTag> constructTags(Response res) throws WeiboException {
		try {
			JSONArray list = res.asJSONArray();
			int size = list.length();
			List<FavoritesTag> tags = new ArrayList<FavoritesTag>(size);
			for (int i = 0; i < size; i++) {
				tags.add(new FavoritesTag(list.getJSONObject(i)));
			}
			return tags;
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		} catch (WeiboException te) {
			throw te;
		}
	}
	/**
	 * <p>constructTag.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @return a {@link java.util.List} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public static List<FavoritesTag> constructTag(Response res) throws WeiboException {
		try {
			JSONArray list = res.asJSONObject().getJSONArray("tags");
			int size = list.length();
			List<FavoritesTag> tags = new ArrayList<FavoritesTag>(size);
			for (int i = 0; i < size; i++) {
				tags.add(new FavoritesTag(list.getJSONObject(i)));
			}
			return tags;
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		} catch (WeiboException te) {
			throw te;
		}
	}



	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		FavoritesTag other = (FavoritesTag) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	/**
	 * <p>Getter for the field <code>id</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getId() {
		return id;
	}


	/**
	 * <p>Setter for the field <code>id</code>.</p>
	 *
	 * @param id a {@link java.lang.String} object.
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * <p>Getter for the field <code>tag</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getTag() {
		return tag;
	}


	/**
	 * <p>Setter for the field <code>tag</code>.</p>
	 *
	 * @param tag a {@link java.lang.String} object.
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}


	/**
	 * <p>Getter for the field <code>count</code>.</p>
	 *
	 * @return a int.
	 */
	public int getCount() {
		return count;
	}


	/**
	 * <p>Setter for the field <code>count</code>.</p>
	 *
	 * @param count a int.
	 */
	public void setCount(int count) {
		this.count = count;
	}


	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "FavoritesTag [id=" + id + ", tag=" + tag + ", count=" + count
		+ "]";
	}

}
