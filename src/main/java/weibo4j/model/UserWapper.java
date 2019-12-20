/*
 * UserObjectWapper.java created on 2010-7-28 上午08:48:35 by bwl (Liu Daoru)
 */

package weibo4j.model;

import java.io.Serializable;
import java.util.List;

/**
 * 对User对象列表进行的包装，以支持cursor相关信息传递
 *
 * @author sinaWeibo
 * @version $Id: $Id
 */
public class UserWapper implements Serializable {

	private static final long serialVersionUID = -3119107701303920284L;

	/**
	 * 用户对象列表
	 */
	private List<User> users;

	/**
	 * 向前翻页的cursor
	 */
	private long previousCursor;

	/**
	 * 向后翻页的cursor
	 */
	private long nextCursor;
	
	private long totalNumber;
	
	private String hasvisible;

	/**
	 * <p>Constructor for UserWapper.</p>
	 *
	 * @param users a {@link java.util.List} object.
	 * @param previousCursor a long.
	 * @param nextCursor a long.
	 * @param totalNumber a long.
	 * @param hasvisible a {@link java.lang.String} object.
	 */
	public UserWapper(List<User> users, long previousCursor, long nextCursor, long totalNumber,String hasvisible) {
		this.users = users;
		this.previousCursor = previousCursor;
		this.nextCursor = nextCursor;
		this.totalNumber=totalNumber;
		this.hasvisible = hasvisible;
	}

	/**
	 * <p>Getter for the field <code>users</code>.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * <p>Setter for the field <code>users</code>.</p>
	 *
	 * @param users a {@link java.util.List} object.
	 */
	public void setUsers(List<User> users) {
		this.users = users;
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
		String str="";
		str += "UserWapper [users=[";
		for(User u : users) {
			str += u.toString() + " ";
		}
		str += "], ";
		str += "previousCursor=" + previousCursor + ", ";
		str += "nextCursor=" + nextCursor + ", ";
		str += "totalNumber=" + totalNumber + ", ";
		str += "hasvisible=" + hasvisible + "]";
		return str;
	}
}
