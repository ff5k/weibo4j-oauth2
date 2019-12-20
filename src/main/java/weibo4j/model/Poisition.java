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
public class Poisition extends WeiboResponse {

	private static final long serialVersionUID = -6156515630521071392L;

	private String srcid;
	private String longitude;
	private String latitude;
	private String name;
	private String cityName;
	private String address;
	private String telephone;
	private String category;
	private String description;
	private String intro;
	private String tags;
	private String url;
	private String traffic;
	private String deal;
	private String pid;

	private static long totalNumber;
	private static String coordinates;

	/**
	 * <p>Constructor for Poisition.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public Poisition(Response res) throws WeiboException {
		super(res);
		JSONObject json = null;
		try {
			json = res.asJSONObject();
			srcid = json.getString("srcid");
			longitude = json.getString("longitude");
			latitude = json.getString("latitude");
			name = json.getString("name");
			cityName = json.getString("city_name");
			address = json.getString("address");
			telephone = json.getString("telephone");
			category = json.getString("category");
			description = json.getString("description");
			intro = json.getString("intro");
			tags = json.getString("tags");
			url = json.getString("url");
			traffic = json.getString("traffic");
			deal = json.getString("deal");
			pid = json.getString("pid");
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(),
					je);
		}
	}

	/**
	 * <p>Constructor for Poisition.</p>
	 *
	 * @param json a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public Poisition(JSONObject json) throws WeiboException {
		try {
			srcid = json.getString("srcid");
			longitude = json.getString("longitude");
			latitude = json.getString("latitude");
			name = json.getString("name");
			cityName = json.getString("city_name");
			address = json.getString("address");
			telephone = json.getString("telephone");
			category = json.getString("category");
			description = json.getString("description");
			intro = json.getString("intro");
			tags = json.getString("tags");
			url = json.getString("url");
			traffic = json.getString("traffic");
			deal = json.getString("deal");
			pid = json.getString("pid");
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(),
					je);
		}
	}
	
	/**
	 * <p>constructPois.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @return a {@link java.util.List} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public static List<Poisition> constructPois(Response res) throws WeiboException {
		try {
			JSONArray list = res.asJSONObject().getJSONArray("pois");
			int size = list.length();
			List<Poisition> pois = new ArrayList<Poisition>(size);
			for (int i = 0; i < size; i++) {
				pois.add(new Poisition(list.getJSONObject(i)));
			}
			totalNumber = res.asJSONObject().getLong("total_number");
			coordinates = res.asJSONObject().getString("coordinates");
			return pois;
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}
	}

	/**
	 * <p>Getter for the field <code>srcid</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getSrcid() {
		return srcid;
	}

	/**
	 * <p>Setter for the field <code>srcid</code>.</p>
	 *
	 * @param srcid a {@link java.lang.String} object.
	 */
	public void setSrcid(String srcid) {
		this.srcid = srcid;
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
	 * <p>Getter for the field <code>name</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getName() {
		return name;
	}

	/**
	 * <p>Setter for the field <code>name</code>.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 */
	public void setName(String name) {
		this.name = name;
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
	 * <p>Getter for the field <code>telephone</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * <p>Setter for the field <code>telephone</code>.</p>
	 *
	 * @param telephone a {@link java.lang.String} object.
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	 * <p>Getter for the field <code>description</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <p>Setter for the field <code>description</code>.</p>
	 *
	 * @param description a {@link java.lang.String} object.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * <p>Getter for the field <code>intro</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getIntro() {
		return intro;
	}

	/**
	 * <p>Setter for the field <code>intro</code>.</p>
	 *
	 * @param intro a {@link java.lang.String} object.
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}

	/**
	 * <p>Getter for the field <code>tags</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * <p>Setter for the field <code>tags</code>.</p>
	 *
	 * @param tags a {@link java.lang.String} object.
	 */
	public void setTags(String tags) {
		this.tags = tags;
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
	 * <p>Getter for the field <code>traffic</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getTraffic() {
		return traffic;
	}

	/**
	 * <p>Setter for the field <code>traffic</code>.</p>
	 *
	 * @param traffic a {@link java.lang.String} object.
	 */
	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}

	/**
	 * <p>Getter for the field <code>deal</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getDeal() {
		return deal;
	}

	/**
	 * <p>Setter for the field <code>deal</code>.</p>
	 *
	 * @param deal a {@link java.lang.String} object.
	 */
	public void setDeal(String deal) {
		this.deal = deal;
	}

	/**
	 * <p>Getter for the field <code>pid</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * <p>Setter for the field <code>pid</code>.</p>
	 *
	 * @param pid a {@link java.lang.String} object.
	 */
	public void setPid(String pid) {
		this.pid = pid;
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
		Poisition.totalNumber = totalNumber;
	}
	
	/**
	 * <p>Getter for the field <code>coordinates</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public static String getCoordinates() {
		return coordinates;
	}

	/**
	 * <p>Setter for the field <code>coordinates</code>.</p>
	 *
	 * @param coordinates a {@link java.lang.String} object.
	 */
	public static void setCoordinates(String coordinates) {
		Poisition.coordinates = coordinates;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Pois [" + "coordinates = " + coordinates
				+ ", srcid = " + srcid 
				+ ", longitude = " + longitude 
				+ ", latitude = " + latitude 
				+ ", name = " + name 
				+ ", city_name = " + cityName 
				+ ", address = " + address 
				+ ", telephone = " + telephone 
				+ ", category = " + category 
				+ ", description = " + description 
				+ ", intro = " + intro 
				+ ", tags = " + tags 
				+ ", url = " + url 
				+ ", traffic = " + traffic 
				+ ", deal = " + deal 
				+ ", pid = " + pid 
				+ ", totalNumber = " + totalNumber + "]";
	}
	
}
