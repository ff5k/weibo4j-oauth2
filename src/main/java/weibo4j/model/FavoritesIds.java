package weibo4j.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * 获取当前用户的收藏列表的ID
 *
 * @author xiaoV
 * @version $Id: $Id
 */
public class FavoritesIds extends WeiboResponse {

	private static final long serialVersionUID = -2969906105821204489L;
	private Date favoritedTime; // 添加收藏的时间
	private String statusId; // 收藏的statusId
	private List<FavoritesTag> tags; // 收藏的tags
	private static long totalNumber; // 收藏总数

	/**
	 * <p>Constructor for FavoritesIds.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public FavoritesIds(Response res) throws WeiboException {
		super(res);
		JSONObject json = null;
		try {
			json = res.asJSONObject();
			favoritedTime = parseDate(json.getString("favorited_time"),
					"EEE MMM dd HH:mm:ss z yyyy");
			statusId = json.getString("status");
			if (!json.isNull("tags")) {
				JSONArray list = json.getJSONArray("tags");
				int size = list.length();
				List<FavoritesTag> tag = new ArrayList<FavoritesTag>(size);
				for (int i = 0; i < size; i++) {
					tag.add(new FavoritesTag(list.getJSONObject(i)));
				}
			}
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(),
					je);
		}
	}

	FavoritesIds(JSONObject json) throws WeiboException, JSONException {
		favoritedTime = parseDate(json.getString("favorited_time"),
				"EEE MMM dd HH:mm:ss z yyyy");
		if (!json.isNull("status")) {
			statusId = json.getString("status");
		}
		if (!json.isNull("tags")) {
			JSONArray list = json.getJSONArray("tags");
			int size = list.length();
			tags = new ArrayList<FavoritesTag>(size);
			for (int i = 0; i < size; i++) {
				tags.add(new FavoritesTag(list.getJSONObject(i)));
			}
		}

	}

	/**
	 * <p>constructFavoritesIds.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @return a {@link java.util.List} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public static List<FavoritesIds> constructFavoritesIds(Response res)
			throws WeiboException {
		try {
			JSONArray list = res.asJSONObject().getJSONArray("favorites");
			int size = list.length();
			List<FavoritesIds> favoritesIds = new ArrayList<FavoritesIds>(size);
			for (int i = 0; i < size; i++) {
				favoritesIds.add(new FavoritesIds(list.getJSONObject(i)));
			}
			totalNumber = res.asJSONObject().getLong("total_number");
			return favoritesIds;
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}
	}

	/**
	 * <p>Getter for the field <code>favoritedTime</code>.</p>
	 *
	 * @return a {@link java.util.Date} object.
	 */
	public Date getFavoritedTime() {
		return favoritedTime;
	}

	/**
	 * <p>Setter for the field <code>favoritedTime</code>.</p>
	 *
	 * @param favoritedTime a {@link java.util.Date} object.
	 */
	public void setFavoritedTime(Date favoritedTime) {
		this.favoritedTime = favoritedTime;
	}

	/**
	 * <p>Getter for the field <code>statusId</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getStatusId() {
		return statusId;
	}

	/**
	 * <p>Setter for the field <code>statusId</code>.</p>
	 *
	 * @param statusId a {@link java.lang.String} object.
	 */
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	/**
	 * <p>Getter for the field <code>totalNumber</code>.</p>
	 *
	 * @return a long.
	 */
	public static long getTotalNumber() {
		return totalNumber;
	}

	/**
	 * <p>Setter for the field <code>totalNumber</code>.</p>
	 *
	 * @param totalNumber a long.
	 */
	public static void setTotalNumber(long totalNumber) {
		FavoritesIds.totalNumber = totalNumber;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Favorites [" + "favorited_time=" + favoritedTime
				+ ", statusId=" + statusId + ", FavoritesTag="
				+ ((tags == null) ? "null" : tags.toString())
				+ ", total_number = " + totalNumber + "]";
	}
}
