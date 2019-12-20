package weibo4j.model;

import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * <p>Visible class.</p>
 *
 * @author user1
 * @version $Id: $Id
 */
public class Visible {
	private int type;
	private int list_id;
	
	/**
	 * <p>Constructor for Visible.</p>
	 *
	 * @param json a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.org.json.JSONException if any.
	 */
	public Visible(JSONObject json) throws JSONException {
			this.type = json.getInt("type");
			this.list_id = json.getInt("list_id");
	}
	/**
	 * <p>Getter for the field <code>type</code>.</p>
	 *
	 * @return a int.
	 */
	public int getType() {
		return type;
	}
	/**
	 * <p>Setter for the field <code>type</code>.</p>
	 *
	 * @param type a int.
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * <p>Getter for the field <code>list_id</code>.</p>
	 *
	 * @return a int.
	 */
	public int getList_id() {
		return list_id;
	}
	/**
	 * <p>Setter for the field <code>list_id</code>.</p>
	 *
	 * @param list_id a int.
	 */
	public void setList_id(int list_id) {
		this.list_id = list_id;
	}
	
	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + list_id;
		result = prime * result + type;
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
		Visible other = (Visible) obj;
		if (list_id != other.list_id)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Visible [type=" + type + ", list_id=" + list_id + "]";
	}
	
}
