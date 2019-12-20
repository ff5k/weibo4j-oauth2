package weibo4j.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * <p>Status class.</p>
 *
 * @author user1
 * @version $Id: $Id
 */
public class Status extends WeiboResponse {

	private static final long serialVersionUID = -8795691786466526420L;

	private User user = null;                            //作者信息
	private Date createdAt;                              //status创建时间
	private String id;                                   //status id
	private String mid;                                  //微博MID
	private long idstr;                                  //保留字段，请勿使用                     
	private String text;                                 //微博内容
	private Source source;                               //微博来源
	private boolean favorited;                           //是否已收藏
	private boolean truncated;
	private long inReplyToStatusId;                      //回复ID
	private long inReplyToUserId;                        //回复人ID
	private String inReplyToScreenName;                  //回复人昵称
	private String thumbnailPic;                         //微博内容中的图片的缩略地址
	private String bmiddlePic;                           //中型图片
	private String originalPic;                          //原始图片
	private Status retweetedStatus = null;               //转发的博文，内容为status，如果不是转发，则没有此字段
	private String geo;                                  //地理信息，保存经纬度，没有时不返回此字段
	private double latitude = -1;                        //纬度
	private double longitude = -1;                       //经度
	private int repostsCount;                            //转发数
	private int commentsCount;                           //评论数
	private String annotations;                          //元数据，没有时不返回此字段
	private int mlevel;
	private Visible visible;
	/**
	 * <p>Constructor for Status.</p>
	 */
	public Status()
	{

	}
	/**
	 * <p>Constructor for Status.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public Status(Response res)throws WeiboException{
		super(res);
		JSONObject json=res.asJSONObject();
		constructJson(json);
	}

	private void constructJson(JSONObject json) throws WeiboException {
		try {
			createdAt = parseDate(json.getString("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
			id = json.getString("id");
			mid=json.getString("mid");
			idstr = json.getLong("idstr");
			text = json.getString("text");
			if(!json.getString("source").isEmpty()){
				source = new Source(json.getString("source"));
			}
			inReplyToStatusId = getLong("in_reply_to_status_id", json);
			inReplyToUserId = getLong("in_reply_to_user_id", json);
			inReplyToScreenName=json.getString("in_reply_toS_screenName");
			favorited = getBoolean("favorited", json);
			truncated = getBoolean("truncated", json);
			thumbnailPic = json.getString("thumbnail_pic");
			bmiddlePic = json.getString("bmiddle_pic");
			originalPic = json.getString("original_pic");
			repostsCount = json.getInt("reposts_count");
			commentsCount = json.getInt("comments_count");
			annotations = json.getString("annotations");
			if(!json.isNull("user"))
				user = new User(json.getJSONObject("user"));
			if(!json.isNull("retweeted_status")){
				retweetedStatus= new Status(json.getJSONObject("retweeted_status"));
			}
			mlevel = json.getInt("mlevel");
			geo= json.getString("geo");
			if(geo!=null &&!"".equals(geo) &&!"null".equals(geo)){
				getGeoInfo(geo);
			}
			if(!json.isNull("visible")){
				visible= new Visible(json.getJSONObject("visible"));
			}
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(), je);
		}
	}

	private void getGeoInfo(String geo) {
		StringBuffer value= new StringBuffer();
		for(char c:geo.toCharArray()){
			if(c>45&&c<58){
				value.append(c);
			}
			if(c==44){
				if(value.length()>0){
					latitude=Double.parseDouble(value.toString());
					value.delete(0, value.length());
				}
			}
		}
		longitude=Double.parseDouble(value.toString());
	}


	/**
	 * <p>Constructor for Status.</p>
	 *
	 * @param json a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.model.WeiboException if any.
	 * @throws weibo4j.org.json.JSONException if any.
	 */
	public Status(JSONObject json)throws WeiboException, JSONException{
		constructJson(json);
	}
	/**
	 * <p>Constructor for Status.</p>
	 *
	 * @param str a {@link java.lang.String} object.
	 * @throws weibo4j.model.WeiboException if any.
	 * @throws weibo4j.org.json.JSONException if any.
	 */
	public Status(String str) throws WeiboException, JSONException {
		// StatusStream uses this constructor
		super();
		JSONObject json = new JSONObject(str);
		constructJson(json);
	}

	
	/**
	 * <p>Getter for the field <code>user</code>.</p>
	 *
	 * @return a {@link weibo4j.model.User} object.
	 */
	public User getUser() {
		return user;
	}
	/**
	 * <p>Setter for the field <code>user</code>.</p>
	 *
	 * @param user a {@link weibo4j.model.User} object.
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * <p>Getter for the field <code>idstr</code>.</p>
	 *
	 * @return a long.
	 */
	public long getIdstr() {
		return idstr;
	}
	/**
	 * <p>Setter for the field <code>idstr</code>.</p>
	 *
	 * @param idstr a long.
	 */
	public void setIdstr(long idstr) {
		this.idstr = idstr;
	}
	/**
	 * <p>Getter for the field <code>createdAt</code>.</p>
	 *
	 * @return a {@link java.util.Date} object.
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * <p>Setter for the field <code>createdAt</code>.</p>
	 *
	 * @param createdAt a {@link java.util.Date} object.
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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
	/**
	 * <p>Getter for the field <code>text</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getText() {
		return text;
	}
	/**
	 * <p>Setter for the field <code>text</code>.</p>
	 *
	 * @param text a {@link java.lang.String} object.
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * <p>Getter for the field <code>source</code>.</p>
	 *
	 * @return a {@link weibo4j.model.Source} object.
	 */
	public Source getSource() {
		return source;
	}
	/**
	 * <p>Setter for the field <code>source</code>.</p>
	 *
	 * @param source a {@link weibo4j.model.Source} object.
	 */
	public void setSource(Source source) {
		this.source = source;
	}
	/**
	 * <p>isFavorited.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isFavorited() {
		return favorited;
	}
	/**
	 * <p>Setter for the field <code>favorited</code>.</p>
	 *
	 * @param favorited a boolean.
	 */
	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}
	/**
	 * <p>Getter for the field <code>inReplyToStatusId</code>.</p>
	 *
	 * @return a long.
	 */
	public long getInReplyToStatusId() {
		return inReplyToStatusId;
	}
	/**
	 * <p>Setter for the field <code>inReplyToStatusId</code>.</p>
	 *
	 * @param inReplyToStatusId a long.
	 */
	public void setInReplyToStatusId(long inReplyToStatusId) {
		this.inReplyToStatusId = inReplyToStatusId;
	}
	/**
	 * <p>Getter for the field <code>inReplyToUserId</code>.</p>
	 *
	 * @return a long.
	 */
	public long getInReplyToUserId() {
		return inReplyToUserId;
	}
	/**
	 * <p>Setter for the field <code>inReplyToUserId</code>.</p>
	 *
	 * @param inReplyToUserId a long.
	 */
	public void setInReplyToUserId(long inReplyToUserId) {
		this.inReplyToUserId = inReplyToUserId;
	}
	/**
	 * <p>Getter for the field <code>inReplyToScreenName</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getInReplyToScreenName() {
		return inReplyToScreenName;
	}
	/**
	 * <p>Setter for the field <code>inReplyToScreenName</code>.</p>
	 *
	 * @param inReplyToScreenName a {@link java.lang.String} object.
	 */
	public void setInReplyToScreenName(String inReplyToScreenName) {
		this.inReplyToScreenName = inReplyToScreenName;
	}
	/**
	 * <p>Getter for the field <code>thumbnailPic</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getThumbnailPic() {
		return thumbnailPic;
	}
	/**
	 * <p>Setter for the field <code>thumbnailPic</code>.</p>
	 *
	 * @param thumbnailPic a {@link java.lang.String} object.
	 */
	public void setThumbnailPic(String thumbnailPic) {
		this.thumbnailPic = thumbnailPic;
	}
	/**
	 * <p>Getter for the field <code>bmiddlePic</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getBmiddlePic() {
		return bmiddlePic;
	}
	/**
	 * <p>Setter for the field <code>bmiddlePic</code>.</p>
	 *
	 * @param bmiddlePic a {@link java.lang.String} object.
	 */
	public void setBmiddlePic(String bmiddlePic) {
		this.bmiddlePic = bmiddlePic;
	}
	/**
	 * <p>Getter for the field <code>originalPic</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getOriginalPic() {
		return originalPic;
	}
	/**
	 * <p>Setter for the field <code>originalPic</code>.</p>
	 *
	 * @param originalPic a {@link java.lang.String} object.
	 */
	public void setOriginalPic(String originalPic) {
		this.originalPic = originalPic;
	}
	/**
	 * <p>Getter for the field <code>retweetedStatus</code>.</p>
	 *
	 * @return a {@link weibo4j.model.Status} object.
	 */
	public Status getRetweetedStatus() {
		return retweetedStatus;
	}
	/**
	 * <p>Setter for the field <code>retweetedStatus</code>.</p>
	 *
	 * @param retweetedStatus a {@link weibo4j.model.Status} object.
	 */
	public void setRetweetedStatus(Status retweetedStatus) {
		this.retweetedStatus = retweetedStatus;
	}
	/**
	 * <p>Getter for the field <code>geo</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getGeo() {
		return geo;
	}
	/**
	 * <p>Setter for the field <code>geo</code>.</p>
	 *
	 * @param geo a {@link java.lang.String} object.
	 */
	public void setGeo(String geo) {
		this.geo = geo;
	}
	/**
	 * <p>Getter for the field <code>latitude</code>.</p>
	 *
	 * @return a double.
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * <p>Setter for the field <code>latitude</code>.</p>
	 *
	 * @param latitude a double.
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/**
	 * <p>Getter for the field <code>longitude</code>.</p>
	 *
	 * @return a double.
	 */
	public double getLongitude() {
		return longitude;
	}
	/**
	 * <p>Setter for the field <code>longitude</code>.</p>
	 *
	 * @param longitude a double.
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	/**
	 * <p>Getter for the field <code>repostsCount</code>.</p>
	 *
	 * @return a int.
	 */
	public int getRepostsCount() {
		return repostsCount;
	}
	/**
	 * <p>Setter for the field <code>repostsCount</code>.</p>
	 *
	 * @param repostsCount a int.
	 */
	public void setRepostsCount(int repostsCount) {
		this.repostsCount = repostsCount;
	}
	/**
	 * <p>Getter for the field <code>commentsCount</code>.</p>
	 *
	 * @return a int.
	 */
	public int getCommentsCount() {
		return commentsCount;
	}
	/**
	 * <p>Setter for the field <code>commentsCount</code>.</p>
	 *
	 * @param commentsCount a int.
	 */
	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}
	/**
	 * <p>Getter for the field <code>mid</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getMid() {
		return mid;
	}
	/**
	 * <p>Setter for the field <code>mid</code>.</p>
	 *
	 * @param mid a {@link java.lang.String} object.
	 */
	public void setMid(String mid) {
		this.mid = mid;
	}
	/**
	 * <p>Getter for the field <code>annotations</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getAnnotations() {
		return annotations;
	}
	/**
	 * <p>Setter for the field <code>annotations</code>.</p>
	 *
	 * @param annotations a {@link java.lang.String} object.
	 */
	public void setAnnotations(String annotations) {
		this.annotations = annotations;
	}
	/**
	 * <p>Getter for the field <code>mlevel</code>.</p>
	 *
	 * @return a int.
	 */
	public int getMlevel() {
		return mlevel;
	}
	/**
	 * <p>Setter for the field <code>mlevel</code>.</p>
	 *
	 * @param mlevel a int.
	 */
	public void setMlevel(int mlevel) {
		this.mlevel = mlevel;
	}
	/**
	 * <p>Getter for the field <code>visible</code>.</p>
	 *
	 * @return a {@link weibo4j.model.Visible} object.
	 */
	public Visible getVisible() {
		return visible;
	}
	/**
	 * <p>Setter for the field <code>visible</code>.</p>
	 *
	 * @param visible a {@link weibo4j.model.Visible} object.
	 */
	public void setVisible(Visible visible) {
		this.visible = visible;
	}
	
	/**
	 * <p>isTruncated.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isTruncated() {
		return truncated;
	}
	/**
	 * <p>Setter for the field <code>truncated</code>.</p>
	 *
	 * @param truncated a boolean.
	 */
	public void setTruncated(boolean truncated) {
		this.truncated = truncated;
	}
	/**
	 * <p>constructWapperStatus.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @return a {@link weibo4j.model.StatusWapper} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public static StatusWapper constructWapperStatus(Response res) throws WeiboException {
		JSONObject jsonStatus = res.asJSONObject(); //asJSONArray();
		JSONArray statuses = null;
		try {
			if(!jsonStatus.isNull("statuses")){				
				statuses = jsonStatus.getJSONArray("statuses");
			}
			if(!jsonStatus.isNull("reposts")){
				statuses = jsonStatus.getJSONArray("reposts");
			}
			int size = statuses.length();
			List<Status> status = new ArrayList<Status>(size);
			for (int i = 0; i < size; i++) {
				status.add(new Status(statuses.getJSONObject(i)));
			}
			long previousCursor = jsonStatus.getLong("previous_curosr");
			long nextCursor = jsonStatus.getLong("next_cursor");
			long totalNumber = jsonStatus.getLong("total_number");
			String hasvisible = jsonStatus.getString("hasvisible");
			return new StatusWapper(status, previousCursor, nextCursor,totalNumber,hasvisible);
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}
	}
	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Status other = (Status) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Status [user=" + user + ", idstr=" + idstr + ", createdAt="
				+ createdAt + ", id=" + id + ", text=" + text + ", source="
				+ source + ", favorited=" + favorited + ", truncated="
				+ truncated + ", inReplyToStatusId=" + inReplyToStatusId
				+ ", inReplyToUserId=" + inReplyToUserId
				+ ", inReplyToScreenName=" + inReplyToScreenName
				+ ", thumbnailPic=" + thumbnailPic + ", bmiddlePic="
				+ bmiddlePic + ", originalPic=" + originalPic
				+ ", retweetedStatus=" + retweetedStatus + ", geo=" + geo
				+ ", latitude=" + latitude + ", longitude=" + longitude
				+ ", repostsCount=" + repostsCount + ", commentsCount="
				+ commentsCount + ", mid=" + mid + ", annotations="
				+ annotations + ", mlevel=" + mlevel
				+ ", visible=" + visible + "]";
	}

}
