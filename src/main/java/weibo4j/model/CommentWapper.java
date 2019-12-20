package weibo4j.model;

import java.util.List;

/**
 * <p>CommentWapper class.</p>
 *
 * @author user1
 * @version $Id: $Id
 */
public class CommentWapper {
	
	private List<Comment> comments;

	private long previousCursor;

	private long nextCursor;
	
	private long totalNumber;
	
	private String hasvisible;
	
	/**
	 * <p>Constructor for CommentWapper.</p>
	 *
	 * @param comments a {@link java.util.List} object.
	 * @param previousCursor a long.
	 * @param nextCursor a long.
	 * @param totalNumber a long.
	 * @param hasvisible a {@link java.lang.String} object.
	 */
	public CommentWapper(List<Comment> comments, long previousCursor,
			long nextCursor, long totalNumber,String hasvisible) {
		this.comments = comments;
		this.previousCursor = previousCursor;
		this.nextCursor = nextCursor;
		this.totalNumber = totalNumber;
		this.hasvisible = hasvisible;
	}

	/**
	 * <p>Getter for the field <code>comments</code>.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * <p>Setter for the field <code>comments</code>.</p>
	 *
	 * @param comments a {@link java.util.List} object.
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	/**
	 * <p>Getter for the field <code>previousCursor</code>.</p>
	 *
	 * @return a long.
	 */
	public long getPreviousCursor() {
		return previousCursor;
	}

	/**
	 * <p>Setter for the field <code>previousCursor</code>.</p>
	 *
	 * @param previousCursor a long.
	 */
	public void setPreviousCursor(long previousCursor) {
		this.previousCursor = previousCursor;
	}

	/**
	 * <p>Getter for the field <code>nextCursor</code>.</p>
	 *
	 * @return a long.
	 */
	public long getNextCursor() {
		return nextCursor;
	}

	/**
	 * <p>Setter for the field <code>nextCursor</code>.</p>
	 *
	 * @param nextCursor a long.
	 */
	public void setNextCursor(long nextCursor) {
		this.nextCursor = nextCursor;
	}

	/**
	 * <p>Getter for the field <code>totalNumber</code>.</p>
	 *
	 * @return a long.
	 */
	public long getTotalNumber() {
		return totalNumber;
	}

	/**
	 * <p>Setter for the field <code>totalNumber</code>.</p>
	 *
	 * @param totalNumber a long.
	 */
	public void setTotalNumber(long totalNumber) {
		this.totalNumber = totalNumber;
	}

	/**
	 * <p>Getter for the field <code>hasvisible</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getHasvisible() {
		return hasvisible;
	}

	/**
	 * <p>Setter for the field <code>hasvisible</code>.</p>
	 *
	 * @param hasvisible a {@link java.lang.String} object.
	 */
	public void setHasvisible(String hasvisible) {
		this.hasvisible = hasvisible;
	}
		
	/** {@inheritDoc} */
	@Override
	public String toString() {
		String str = "";
		str += "CommentWapper [comments=[";
		for (Comment c : comments) {
			str += c.toString() + " ";
		}
		str += "], ";
		str += "previousCursor=" + previousCursor + ", ";
		str += "nextCursor=" + nextCursor + ", ";
		str += "totalNumber=" + totalNumber + ", ";
		str += "hasvisible=" + hasvisible + "]";
		return str;
	}
}
