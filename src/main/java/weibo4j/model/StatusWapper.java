package weibo4j.model;

import java.util.List;

/**
 * <p>StatusWapper class.</p>
 *
 * @author user1
 * @version $Id: $Id
 */
public class StatusWapper {

	private List<Status> statuses;

	private long previousCursor;

	private long nextCursor;

	private long totalNumber;
	
	private String hasvisible;

	/**
	 * <p>Constructor for StatusWapper.</p>
	 *
	 * @param statuses a {@link java.util.List} object.
	 * @param previousCursor a long.
	 * @param nextCursor a long.
	 * @param totalNumber a long.
	 * @param hasvisible a {@link java.lang.String} object.
	 */
	public StatusWapper(List<Status> statuses, long previousCursor,
			long nextCursor, long totalNumber,String hasvisible) {
		this.statuses = statuses;
		this.previousCursor = previousCursor;
		this.nextCursor = nextCursor;
		this.totalNumber = totalNumber;
		this.hasvisible = hasvisible;
	}

	/**
	 * <p>Getter for the field <code>statuses</code>.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<Status> getStatuses() {
		return statuses;
	}

	/**
	 * <p>Setter for the field <code>statuses</code>.</p>
	 *
	 * @param statuses a {@link java.util.List} object.
	 */
	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
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
		str += "StatusWapper [statuses=[";
		for (Status s : statuses) {
			str += s.toString() + " ";
		}
		str += "], ";
		str += "previousCursor=" + previousCursor + ", ";
		str += "nextCursor=" + nextCursor + ", ";
		str += "totalNumber=" + totalNumber + ", ";
		str += "hasvisible=" + hasvisible + "]";
		return str;
	}

}
