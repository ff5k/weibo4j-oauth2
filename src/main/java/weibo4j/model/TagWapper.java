package weibo4j.model;

import java.util.List;

/**
 * <p>TagWapper class.</p>
 *
 * @author user1
 * @version $Id: $Id
 */
public class TagWapper {
	private List<Tag> tags;
	private String id;
	
	/**
	 * <p>Constructor for TagWapper.</p>
	 *
	 * @param tags a {@link java.util.List} object.
	 * @param id a {@link java.lang.String} object.
	 */
	public TagWapper(List<Tag> tags, String id) {
		this.tags = tags;
		this.id = id;
	}
	/**
	 * <p>Getter for the field <code>tags</code>.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<Tag> getTags() {
		return tags;
	}
	/**
	 * <p>Setter for the field <code>tags</code>.</p>
	 *
	 * @param tags a {@link java.util.List} object.
	 */
	public void setTags(List<Tag> tags) {
		this.tags = tags;
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
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		String str = "";
		str += "TagWapper [tags=[";
		for (Tag t : tags) {
			str += t.toString() + " ";
		}
		str += "], ";
		str += "id=" + id + "]";
		return str;
	}
	
}
