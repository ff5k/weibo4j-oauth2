package weibo4j.model;

import java.util.ArrayList;
import java.util.List;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * 地理信息
 *
 * @author xiaoV
 * @version $Id: $Id
 */
public class Geos extends WeiboResponse {

	private static final long serialVersionUID = -3147781298339233908L;

	private String longitude; // 经度坐标
	private String latitude; // 维度坐标
	private String city; // 所在城市的城市代码
	private String province; // 所在省份的省份代码
	private String cityName; // 所在城市的城市名称
	private String provinceName;// 所在省份的省份名称
	private String address; // 所在的实际地址，可以为空
	private String pinyin; // 地址的汉语拼音，不是所有情况都会返回该字段
	private String more; // 更多信息，不是所有情况都会返回该字段

	/**
	 * <p>Constructor for Geos.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public Geos(Response res) throws WeiboException {
		super(res);
		JSONObject json = null;
		try {
			json = res.asJSONObject();
			longitude = json.getString("longitude");
			latitude = json.getString("latitude");
			city = json.getString("city");
			province = json.getString("province");
			cityName = json.getString("city_name");
			provinceName = json.getString("province_name");
			address = json.getString("address");
			pinyin = json.getString("pinyin");
			more = json.getString("more");
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(),
					je);
		}
	}

	/**
	 * <p>Constructor for Geos.</p>
	 *
	 * @param json a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public Geos(JSONObject json) throws WeiboException {
		try {
			longitude = json.getString("longitude");
			latitude = json.getString("latitude");
			city = json.getString("city");
			province = json.getString("province");
			cityName = json.getString("city_name");
			provinceName = json.getString("province_name");
			address = json.getString("address");
			pinyin = json.getString("pinyin");
			more = json.getString("more");
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(),
					je);
		}
	}

	/**
	 * <p>constructGeos.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @return a {@link java.util.List} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public static List<Geos> constructGeos(Response res) throws WeiboException {
		try {
			JSONArray list = res.asJSONObject().getJSONArray("geos");
			int size = list.length();
			List<Geos> geos = new ArrayList<Geos>(size);
			for (int i = 0; i < size; i++) {
				geos.add(new Geos(list.getJSONObject(i)));
			}
			return geos;
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}
	}

	/**
	 * <p>Getter for the field <code>longitude</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * <p>Setter for the field <code>longitude</code>.</p>
	 *
	 * @param longitude a {@link java.lang.String} object.
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * <p>Getter for the field <code>latitude</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * <p>Setter for the field <code>latitude</code>.</p>
	 *
	 * @param latitude a {@link java.lang.String} object.
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
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
	 * <p>Getter for the field <code>cityName</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * <p>Setter for the field <code>cityName</code>.</p>
	 *
	 * @param cityName a {@link java.lang.String} object.
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * <p>Getter for the field <code>provinceName</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getProvinceName() {
		return provinceName;
	}

	/**
	 * <p>Setter for the field <code>provinceName</code>.</p>
	 *
	 * @param provinceName a {@link java.lang.String} object.
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
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
	 * <p>Getter for the field <code>pinyin</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getPinyin() {
		return pinyin;
	}

	/**
	 * <p>Setter for the field <code>pinyin</code>.</p>
	 *
	 * @param pinyin a {@link java.lang.String} object.
	 */
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	/**
	 * <p>Getter for the field <code>more</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getMore() {
		return more;
	}

	/**
	 * <p>Setter for the field <code>more</code>.</p>
	 *
	 * @param more a {@link java.lang.String} object.
	 */
	public void setMore(String more) {
		this.more = more;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Geos [" + "longitude = " + longitude
				+ ", latitude = " + latitude
				+ ", city = " + city 
				+ ", province = " + province
				+ ", city_name = " + cityName
				+ ", province_name = " + provinceName
				+ ", address = " + address
				+ ", pinyin = " + pinyin
				+ ", more = " + more + "]";
	}

}
