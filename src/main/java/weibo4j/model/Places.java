package weibo4j.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * 地点信息
 *
 * @author xiaoV
 * @version $Id: $Id
 */
public class Places extends WeiboResponse {

	private static final long serialVersionUID = -1423136187811594673L;

	private String poiid;// 地点ID
	private String title;// 地点名称
	private String address;// 地址及
	private double lon;// 经度
	private double lat;// 纬度
	private String category;
	private String city;
	private String province;
	private String country;
	private String url;
	private String phone;
	private String postcode;
	private long weiboId;
	private String categorys;
	private String categoryName;
	private String icon;
	private long checkinNum;
	private long checkinUserNum;
	private Date checkinTime;
	private long tipNum;
	private long photoNum;
	private long todoNum;
	private long distance;

	private static long totalNumber;

	/**
	 * <p>Constructor for Places.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public Places(Response res) throws WeiboException {
		super(res);
		JSONObject json = res.asJSONObject();
		try {
			poiid = json.getString("poiid");
			title = json.getString("title");
			address = json.getString("address");
			lon = json.getDouble("lon");
			lat = json.getDouble("lat");
			category = json.getString("category");
			city = json.getString("city");
			province = json.getString("privince");
			country = json.getString("country");
			url = json.getString("url");
			phone = json.getString("url");
			postcode = json.getString("postcode");
			weiboId = json.getLong("weibo_id");
			categorys = json.getString("categorys");
			categoryName = json.getString("category_name");
			icon = json.getString("icon");
			checkinUserNum = json.getLong("checkin_user_num");
			checkinTime = parseDate(json.getString("checkin_time"),
					"yyyy-MM-dd hh:mm:ss");
			checkinNum = json.getLong("checkin_num");
			tipNum = json.getLong("tip_num");
			photoNum = json.getLong("photo_num");
			todoNum = json.getLong("todo_num");
			distance = json.getLong("distance");
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}
	}

	/**
	 * <p>Constructor for Places.</p>
	 *
	 * @param json a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public Places(JSONObject json) throws WeiboException {
		try {
			poiid = json.getString("poiid");
			title = json.getString("title");
			address = json.getString("address");
			lon = json.getDouble("lon");
			lat = json.getDouble("lat");
			category = json.getString("category");
			city = json.getString("city");
			province = json.getString("privince");
			country = json.getString("country");
			url = json.getString("url");
			phone = json.getString("url");
			postcode = json.getString("postcode");
			weiboId = json.getLong("weibo_id");
			categorys = json.getString("categorys");
			categoryName = json.getString("category_name");
			icon = json.getString("icon");
			checkinUserNum = json.getLong("checkin_user_num");
			checkinTime = parseDate(json.getString("checkin_time"),
					"yyyy-MM-dd hh:mm:ss");
			checkinNum = json.getLong("checkin_num");
			tipNum = json.getLong("tip_num");
			photoNum = json.getLong("photo_num");
			todoNum = json.getLong("todo_num");
			distance = json.getLong("distance");
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}
	}

	/**
	 * <p>constructPlace.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @return a {@link java.util.List} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public static List<Places> constructPlace(Response res)
			throws WeiboException {
		try {
			JSONObject jsonObj = res.asJSONObject();
			totalNumber = jsonObj.getLong("total_number");
			JSONArray json = jsonObj.getJSONArray("pois");
			int size = json.length();
			List<Places> list = new ArrayList<Places>(size);
			for (int i = 0; i < size; i++) {
				list.add(new Places(json.getJSONObject(i)));
			}
			return list;
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}

	}

	/**
	 * <p>Getter for the field <code>poiid</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getPoiid() {
		return poiid;
	}

	/**
	 * <p>Setter for the field <code>poiid</code>.</p>
	 *
	 * @param poiid a {@link java.lang.String} object.
	 */
	public void setPoiid(String poiid) {
		this.poiid = poiid;
	}

	/**
	 * <p>Getter for the field <code>title</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <p>Setter for the field <code>title</code>.</p>
	 *
	 * @param title a {@link java.lang.String} object.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * <p>Getter for the field <code>address</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * <p>Setter for the field <code>address</code>.</p>
	 *
	 * @param address a {@link java.lang.String} object.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * <p>Getter for the field <code>lon</code>.</p>
	 *
	 * @return a double.
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * <p>Setter for the field <code>lon</code>.</p>
	 *
	 * @param lon a double.
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * <p>Getter for the field <code>lat</code>.</p>
	 *
	 * @return a double.
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * <p>Setter for the field <code>lat</code>.</p>
	 *
	 * @param lat a double.
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * <p>Getter for the field <code>category</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * <p>Setter for the field <code>category</code>.</p>
	 *
	 * @param category a {@link java.lang.String} object.
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * <p>Getter for the field <code>city</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * <p>Setter for the field <code>city</code>.</p>
	 *
	 * @param city a {@link java.lang.String} object.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * <p>Getter for the field <code>province</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * <p>Setter for the field <code>province</code>.</p>
	 *
	 * @param province a {@link java.lang.String} object.
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * <p>Getter for the field <code>country</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * <p>Setter for the field <code>country</code>.</p>
	 *
	 * @param country a {@link java.lang.String} object.
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * <p>Getter for the field <code>url</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * <p>Setter for the field <code>url</code>.</p>
	 *
	 * @param url a {@link java.lang.String} object.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * <p>Getter for the field <code>phone</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * <p>Setter for the field <code>phone</code>.</p>
	 *
	 * @param phone a {@link java.lang.String} object.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * <p>Getter for the field <code>postcode</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * <p>Setter for the field <code>postcode</code>.</p>
	 *
	 * @param postcode a {@link java.lang.String} object.
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * <p>Getter for the field <code>weiboId</code>.</p>
	 *
	 * @return a long.
	 */
	public long getWeiboId() {
		return weiboId;
	}

	/**
	 * <p>Setter for the field <code>weiboId</code>.</p>
	 *
	 * @param weiboId a long.
	 */
	public void setWeiboId(long weiboId) {
		this.weiboId = weiboId;
	}

	/**
	 * <p>Getter for the field <code>categorys</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getCategorys() {
		return categorys;
	}

	/**
	 * <p>Setter for the field <code>categorys</code>.</p>
	 *
	 * @param categorys a {@link java.lang.String} object.
	 */
	public void setCategorys(String categorys) {
		this.categorys = categorys;
	}

	/**
	 * <p>Getter for the field <code>categoryName</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * <p>Setter for the field <code>categoryName</code>.</p>
	 *
	 * @param categoryName a {@link java.lang.String} object.
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * <p>Getter for the field <code>icon</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * <p>Setter for the field <code>icon</code>.</p>
	 *
	 * @param icon a {@link java.lang.String} object.
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * <p>Getter for the field <code>checkinUserNum</code>.</p>
	 *
	 * @return a long.
	 */
	public long getCheckinUserNum() {
		return checkinUserNum;
	}

	/**
	 * <p>Setter for the field <code>checkinUserNum</code>.</p>
	 *
	 * @param checkinUserNum a long.
	 */
	public void setCheckinUserNum(long checkinUserNum) {
		this.checkinUserNum = checkinUserNum;
	}

	/**
	 * <p>Getter for the field <code>checkinTime</code>.</p>
	 *
	 * @return a {@link java.util.Date} object.
	 */
	public Date getCheckinTime() {
		return checkinTime;
	}

	/**
	 * <p>Setter for the field <code>checkinTime</code>.</p>
	 *
	 * @param checkinTime a {@link java.util.Date} object.
	 */
	public void setCheckinTime(Date checkinTime) {
		this.checkinTime = checkinTime;
	}

	/**
	 * <p>Getter for the field <code>checkinNum</code>.</p>
	 *
	 * @return a long.
	 */
	public long getCheckinNum() {
		return checkinNum;
	}

	/**
	 * <p>Setter for the field <code>checkinNum</code>.</p>
	 *
	 * @param checkinNum a long.
	 */
	public void setCheckinNum(long checkinNum) {
		this.checkinNum = checkinNum;
	}

	/**
	 * <p>Getter for the field <code>tipNum</code>.</p>
	 *
	 * @return a long.
	 */
	public long getTipNum() {
		return tipNum;
	}

	/**
	 * <p>Setter for the field <code>tipNum</code>.</p>
	 *
	 * @param tipNum a long.
	 */
	public void setTipNum(long tipNum) {
		this.tipNum = tipNum;
	}

	/**
	 * <p>Getter for the field <code>photoNum</code>.</p>
	 *
	 * @return a long.
	 */
	public long getPhotoNum() {
		return photoNum;
	}

	/**
	 * <p>Setter for the field <code>photoNum</code>.</p>
	 *
	 * @param photoNum a long.
	 */
	public void setPhotoNum(long photoNum) {
		this.photoNum = photoNum;
	}

	/**
	 * <p>Getter for the field <code>todoNum</code>.</p>
	 *
	 * @return a long.
	 */
	public long getTodoNum() {
		return todoNum;
	}

	/**
	 * <p>Setter for the field <code>todoNum</code>.</p>
	 *
	 * @param todoNum a long.
	 */
	public void setTodoNum(long todoNum) {
		this.todoNum = todoNum;
	}

	/**
	 * <p>Getter for the field <code>distance</code>.</p>
	 *
	 * @return a long.
	 */
	public long getDistance() {
		return distance;
	}

	/**
	 * <p>Setter for the field <code>distance</code>.</p>
	 *
	 * @param distance a long.
	 */
	public void setDistance(long distance) {
		this.distance = distance;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Place [" + "poiid=" + poiid
				+ ",title=" + title 
				+ ",address=" + address 
				+ ",lon=" + lon 
				+ ",lat=" + lat 
				+ ",category=" + category 
				+ ",city=" + city 
				+ ",province=" + province
				+ ",country=" + country
				+ ",url=" + url
				+ ",phone=" + phone
				+ ",postcode=" + postcode 
				+ ",weiboId=" + weiboId
				+ ",categorys=" + categorys 
				+ ",categoryName=" + categoryName
				+ ",icon=" + icon
				+ ",checkinUserNum=" + checkinUserNum
				+ ",checkinTime=" + checkinTime
				+ ",tip_num=" + tipNum
				+ ",photo_num=" + photoNum
				+ ",todo_num=" + todoNum
				+ ",distance=" + distance
				+ ",total_number=" + totalNumber + "]";
	}

}
