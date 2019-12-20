package weibo4j.model;

import java.util.ArrayList;
import java.util.List;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * 获取用户发布的微博的ID
 *
 * @author xiaoV
 * @version $Id: $Id
 */
public class UserTimelineIds extends WeiboResponse {

	private static final long serialVersionUID = -5541221820178631421L;

	private long nextCursor;
	private long previousCursor;
	private long totalNumber;
	private String marks;
	private List<String> statusesIds; // ID列表
	private boolean hasvisible;

	/**
	 * <p>Constructor for UserTimelineIds.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public UserTimelineIds(Response res) throws WeiboException {
		super(res);
		JSONObject json = res.asJSONObject();
		try {
			nextCursor = json.getLong("next_cursor");
			previousCursor = json.getLong("previous_cursor");
			totalNumber = json.getLong("total_number");
			hasvisible = json.getBoolean("hasvisible");
			marks = json.getString("marks");
			JSONArray list = json.getJSONArray("statuses");
			int size = list.length();
			statusesIds = new ArrayList<String>(size);
			for (int i = 0; i < size; i++) {
				statusesIds.add(list.getString(i));
			}
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}

	}

	/**
	 * <p>Constructor for UserTimelineIds.</p>
	 *
	 * @param json a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public UserTimelineIds(JSONObject json) throws WeiboException {
		try {
			nextCursor = json.getLong("next_cursor");
			previousCursor = json.getLong("previous_cursor");
			totalNumber = json.getLong("total_number");
			hasvisible = json.getBoolean("hasvisible");
			marks = json.getString("marks");
			JSONArray list = json.getJSONArray("statuses");
			int size = list.length();
			statusesIds = new ArrayList<String>(size);
			for (int i = 0; i < size; i++) {
				statusesIds.add(list.getString(i));
			}
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}
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
	 * <p>Getter for the field <code>marks</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getMarks() {
		return marks;
	}

	/**
	 * <p>Setter for the field <code>marks</code>.</p>
	 *
	 * @param marks a {@link java.lang.String} object.
	 */
	public void setMarks(String marks) {
		this.marks = marks;
	}

	/**
	 * <p>Getter for the field <code>statusesIds</code>.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<String> getStatusesIds() {
		return statusesIds;
	}

	/**
	 * <p>Setter for the field <code>statusesIds</code>.</p>
	 *
	 * @param statusesIds a {@link java.util.List} object.
	 */
	public void setStatusesIds(List<String> statusesIds) {
		this.statusesIds = statusesIds;
	}

	/**
	 * <p>isHasvisible.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isHasvisible() {
		return hasvisible;
	}

	/**
	 * <p>Setter for the field <code>hasvisible</code>.</p>
	 *
	 * @param hasvisible a boolean.
	 */
	public void setHasvisible(boolean hasvisible) {
		this.hasvisible = hasvisible;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "UserTimelineIds [" + "next_cursor=" + nextCursor
				+ ", previous_cursor=" + previousCursor
				+ ", marks=" + marks
				+ ", hasvisible=" + hasvisible
				+ ", statusesIds=" + statusesIds
				+ ", total_number = " + totalNumber + "]";
	}
}
