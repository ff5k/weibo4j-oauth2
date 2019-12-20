/*
Copyright (c) 2007-2009, Yusuke Yamamoto
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
 * Neither the name of the Yusuke Yamamoto nor the
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY Yusuke Yamamoto ``AS IS'' AND ANY
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL Yusuke Yamamoto BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package weibo4j.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * A data class representing Basic user information element
 *
 * @author user1
 * @version $Id: $Id
 */
public class User extends WeiboResponse {

	private static final long serialVersionUID = -332738032648843482L;
	private String id;                      //用户UID
	private String screenName;            //微博昵称
	private String name;                  //友好显示名称，如Bill Gates,名称中间的空格正常显示(此特性暂不支持)
	private int province;                 //省份编码（参考省份编码表）
	private int city;                     //城市编码（参考城市编码表）
	private String location;              //地址
	private String description;           //个人描述
	private String url;                   //用户博客地址
	private String profileImageUrl;       //自定义图像
	private String userDomain;            //用户个性化URL
	private String gender;                //性别,m--男，f--女,n--未知
	private int followersCount;           //粉丝数
	private int friendsCount;             //关注数
	private int statusesCount;            //微博数
	private int favouritesCount;          //收藏数
	private Date createdAt;               //创建时间
	private boolean following;            //保留字段,是否已关注(此特性暂不支持)
	private boolean verified;             //加V标示，是否微博认证用户
	private int verifiedType;             //认证类型
	private boolean allowAllActMsg;       //是否允许所有人给我发私信
	private boolean allowAllComment;      //是否允许所有人对我的微博进行评论
	private boolean followMe;             //此用户是否关注我
	private String avatarLarge;           //大头像地址
	private int onlineStatus;             //用户在线状态
	private Status status = null;         //用户最新一条微博
	private int biFollowersCount;         //互粉数
	private String remark;                //备注信息，在查询用户关系时提供此字段。
	private String lang;                  //用户语言版本
	private String verifiedReason;		  //认证原因
	private String weihao;				  //微號
	private String statusId;
	/**
	 * <p>getVerified_reason.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getVerified_reason() {
		return verifiedReason;
	}
	/**
	 * <p>setVerified_reason.</p>
	 *
	 * @param verifiedReason a {@link java.lang.String} object.
	 */
	public void setVerified_reason(String verifiedReason) {
		this.verifiedReason = verifiedReason;
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
	 * <p>Setter for the field <code>screenName</code>.</p>
	 *
	 * @param screenName a {@link java.lang.String} object.
	 */
	public void setScreenName(String screenName) {
		this.screenName = screenName;
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
	 * <p>Setter for the field <code>province</code>.</p>
	 *
	 * @param province a int.
	 */
	public void setProvince(int province) {
		this.province = province;
	}
	/**
	 * <p>Setter for the field <code>city</code>.</p>
	 *
	 * @param city a int.
	 */
	public void setCity(int city) {
		this.city = city;
	}
	/**
	 * <p>Setter for the field <code>location</code>.</p>
	 *
	 * @param location a {@link java.lang.String} object.
	 */
	public void setLocation(String location) {
		this.location = location;
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
	 * <p>Setter for the field <code>url</code>.</p>
	 *
	 * @param url a {@link java.lang.String} object.
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * <p>Setter for the field <code>profileImageUrl</code>.</p>
	 *
	 * @param profileImageUrl a {@link java.lang.String} object.
	 */
	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
	/**
	 * <p>Setter for the field <code>userDomain</code>.</p>
	 *
	 * @param userDomain a {@link java.lang.String} object.
	 */
	public void setUserDomain(String userDomain) {
		this.userDomain = userDomain;
	}
	/**
	 * <p>Setter for the field <code>gender</code>.</p>
	 *
	 * @param gender a {@link java.lang.String} object.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * <p>Setter for the field <code>followersCount</code>.</p>
	 *
	 * @param followersCount a int.
	 */
	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}
	/**
	 * <p>Setter for the field <code>friendsCount</code>.</p>
	 *
	 * @param friendsCount a int.
	 */
	public void setFriendsCount(int friendsCount) {
		this.friendsCount = friendsCount;
	}
	/**
	 * <p>Setter for the field <code>statusesCount</code>.</p>
	 *
	 * @param statusesCount a int.
	 */
	public void setStatusesCount(int statusesCount) {
		this.statusesCount = statusesCount;
	}
	/**
	 * <p>Setter for the field <code>favouritesCount</code>.</p>
	 *
	 * @param favouritesCount a int.
	 */
	public void setFavouritesCount(int favouritesCount) {
		this.favouritesCount = favouritesCount;
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
	 * <p>Setter for the field <code>following</code>.</p>
	 *
	 * @param following a boolean.
	 */
	public void setFollowing(boolean following) {
		this.following = following;
	}
	/**
	 * <p>Setter for the field <code>verified</code>.</p>
	 *
	 * @param verified a boolean.
	 */
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	/**
	 * <p>Setter for the field <code>verifiedType</code>.</p>
	 *
	 * @param verifiedType a int.
	 */
	public void setVerifiedType(int verifiedType) {
		this.verifiedType = verifiedType;
	}
	/**
	 * <p>Setter for the field <code>allowAllActMsg</code>.</p>
	 *
	 * @param allowAllActMsg a boolean.
	 */
	public void setAllowAllActMsg(boolean allowAllActMsg) {
		this.allowAllActMsg = allowAllActMsg;
	}
	/**
	 * <p>Setter for the field <code>allowAllComment</code>.</p>
	 *
	 * @param allowAllComment a boolean.
	 */
	public void setAllowAllComment(boolean allowAllComment) {
		this.allowAllComment = allowAllComment;
	}
	/**
	 * <p>Setter for the field <code>followMe</code>.</p>
	 *
	 * @param followMe a boolean.
	 */
	public void setFollowMe(boolean followMe) {
		this.followMe = followMe;
	}
	/**
	 * <p>Setter for the field <code>avatarLarge</code>.</p>
	 *
	 * @param avatarLarge a {@link java.lang.String} object.
	 */
	public void setAvatarLarge(String avatarLarge) {
		this.avatarLarge = avatarLarge;
	}
	/**
	 * <p>Setter for the field <code>onlineStatus</code>.</p>
	 *
	 * @param onlineStatus a int.
	 */
	public void setOnlineStatus(int onlineStatus) {
		this.onlineStatus = onlineStatus;
	}
	/**
	 * <p>Setter for the field <code>status</code>.</p>
	 *
	 * @param status a {@link weibo4j.model.Status} object.
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * <p>Setter for the field <code>biFollowersCount</code>.</p>
	 *
	 * @param biFollowersCount a int.
	 */
	public void setBiFollowersCount(int biFollowersCount) {
		this.biFollowersCount = biFollowersCount;
	}
	/**
	 * <p>Setter for the field <code>remark</code>.</p>
	 *
	 * @param remark a {@link java.lang.String} object.
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * <p>Setter for the field <code>lang</code>.</p>
	 *
	 * @param lang a {@link java.lang.String} object.
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	/**
	 * <p>Getter for the field <code>weihao</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getWeihao() {
		return weihao;
	}
	/**
	 * <p>Setter for the field <code>weihao</code>.</p>
	 *
	 * @param weihao a {@link java.lang.String} object.
	 */
	public void setWeihao(String weihao) {
		this.weihao = weihao;
	}

	/**
	 * <p>Getter for the field <code>verifiedReason</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getVerifiedReason() {
		return verifiedReason;
	}
	/**
	 * <p>Setter for the field <code>verifiedReason</code>.</p>
	 *
	 * @param verifiedReason a {@link java.lang.String} object.
	 */
	public void setVerifiedReason(String verifiedReason) {
		this.verifiedReason = verifiedReason;
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
	 * <p>Getter for the field <code>url</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * <p>Getter for the field <code>profileImageUrl</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getProfileImageUrl() {
		return profileImageUrl;
	}
	/**
	 * <p>Getter for the field <code>verifiedType</code>.</p>
	 *
	 * @return a int.
	 */
	public int getVerifiedType() {
		return verifiedType;
	}
	/**
	 * <p>isAllowAllActMsg.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isAllowAllActMsg() {
		return allowAllActMsg;
	}
	/**
	 * <p>isAllowAllComment.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isAllowAllComment() {
		return allowAllComment;
	}
	/**
	 * <p>isFollowMe.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isFollowMe() {
		return followMe;
	}
	/**
	 * <p>Getter for the field <code>avatarLarge</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getAvatarLarge() {
		return avatarLarge;
	}
	/**
	 * <p>Getter for the field <code>onlineStatus</code>.</p>
	 *
	 * @return a int.
	 */
	public int getOnlineStatus() {
		return onlineStatus;
	}
	/**
	 * <p>Getter for the field <code>biFollowersCount</code>.</p>
	 *
	 * @return a int.
	 */
	public int getBiFollowersCount() {
		return biFollowersCount;
	}
	/**
	 * <p>Constructor for User.</p>
	 *
	 * @param json a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	/*package*/public User(JSONObject json) throws WeiboException {
		super();
		init(json);
	}
	
	/**
	 * <p>Constructor for User.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public User(Response res ) throws WeiboException {
		super(res);
		init(res.asJSONObject());
	}

	private void init(JSONObject json) throws WeiboException {
		if(json!=null){
			try {
				id = json.getString("id");
				screenName = json.getString("screen_name");
				name = json.getString("name");
				province = json.getInt("province");
				city = json.getInt("city");
				location = json.getString("location");
				description = json.getString("description");
				url = json.getString("url");
				profileImageUrl = json.getString("profile_image_url");
				userDomain = json.getString("domain");
				gender = json.getString("gender");
				followersCount = json.getInt("followers_count");
				friendsCount = json.getInt("friends_count");
				favouritesCount = json.getInt("favourites_count");
				statusesCount = json.getInt("statuses_count");
				createdAt = parseDate(json.getString("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
				following = getBoolean("following", json);
				verified = getBoolean("verified", json);
				verifiedType = json.getInt("verified_type"); 
				verifiedReason = json.getString("verified_reason");
				allowAllActMsg = json.getBoolean("allow_all_act_msg");
				allowAllComment = json.getBoolean("allow_all_comment");
				followMe = json.getBoolean("follow_me");
				avatarLarge = json.getString("avatar_large");
				onlineStatus = json.getInt("online_status");
				statusId = json.getString("status_id");
				biFollowersCount = json.getInt("bi_followers_count");
				if(!json.getString("remark").isEmpty()){					
					remark = json.getString("remark");
				}
				lang = json.getString("lang");
				weihao = json.getString("weihao");
				if (!json.isNull("status")) {
					status = new Status(json.getJSONObject("status"));
				}
			} catch (JSONException jsone) {
				throw new WeiboException(jsone.getMessage() + ":" + json.toString(), jsone);
			}
		}
	}
	
	/**
	 * <p>constructIds.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @return an array of {@link java.lang.String} objects.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public static String[] constructIds(Response res) throws WeiboException {
	try {
		JSONArray list = res.asJSONObject().getJSONArray("ids");
		String temp = list.toString().substring(1,list.toString().length()-1);
		String[] ids = temp.split(",");
		return ids;
	} catch (JSONException jsone) {
		throw new WeiboException(jsone.getMessage() + ":" + jsone.toString(), jsone);
	} 
}
	/**
	 * <p>constructWapperUsers.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @throws weibo4j.model.WeiboException
	 * @return a {@link weibo4j.model.UserWapper} object.
	 */
	public static UserWapper constructWapperUsers(Response res) throws WeiboException {
		JSONObject jsonUsers = res.asJSONObject(); //asJSONArray();
		try {
			JSONArray user = jsonUsers.getJSONArray("users");
			int size = user.length();
			List<User> users = new ArrayList<User>(size);
			for (int i = 0; i < size; i++) {
				users.add(new User(user.getJSONObject(i)));
			}
			long previousCursor = jsonUsers.getLong("previous_curosr");
			long nextCursor = jsonUsers.getLong("next_cursor");
			long totalNumber = jsonUsers.getLong("total_number");
			String hasvisible = jsonUsers.getString("hasvisible");
			return new UserWapper(users, previousCursor, nextCursor,totalNumber,hasvisible);
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}
	}

	/**
	 * @param res 
	 * @return 
	 * @throws WeiboException
	 */
	static List<User> constructResult(Response res) throws WeiboException {
		JSONArray list = res.asJSONArray();
		try {
			int size = list.length();
			List<User> users = new ArrayList<User>(size);
			for (int i = 0; i < size; i++) {
				users.add(new User(list.getJSONObject(i)));
			}
			return users;
		} catch (JSONException e) {
		}
		return null;
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
	 * <p>Getter for the field <code>screenName</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getScreenName() {
		return screenName;
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
	 * <p>Getter for the field <code>province</code>.</p>
	 *
	 * @return a int.
	 */
	public int getProvince() {
		return province;
	}

	/**
	 * <p>Getter for the field <code>city</code>.</p>
	 *
	 * @return a int.
	 */
	public int getCity() {
		return city;
	}

	/**
	 * <p>Getter for the field <code>location</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getLocation() {
		return location;
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
	 * <p>getProfileImageURL.</p>
	 *
	 * @return a {@link java.net.URL} object.
	 */
	public URL getProfileImageURL() {
		try {
			return new URL(profileImageUrl);
		} catch (MalformedURLException ex) {
			return null;
		}
	}

	/**
	 * <p>getURL.</p>
	 *
	 * @return a {@link java.net.URL} object.
	 */
	public URL getURL() {
		try {
			return new URL(url);
		} catch (MalformedURLException ex) {
			return null;
		}
	}

	/**
	 * <p>Getter for the field <code>userDomain</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getUserDomain() {
		return userDomain;
	}

	/**
	 * <p>Getter for the field <code>gender</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * <p>Getter for the field <code>followersCount</code>.</p>
	 *
	 * @return a int.
	 */
	public int getFollowersCount() {
		return followersCount;
	}

	/**
	 * <p>Getter for the field <code>friendsCount</code>.</p>
	 *
	 * @return a int.
	 */
	public int getFriendsCount() {
		return friendsCount;
	}

	/**
	 * <p>Getter for the field <code>statusesCount</code>.</p>
	 *
	 * @return a int.
	 */
	public int getStatusesCount() {
		return statusesCount;
	}

	/**
	 * <p>Getter for the field <code>favouritesCount</code>.</p>
	 *
	 * @return a int.
	 */
	public int getFavouritesCount() {
		return favouritesCount;
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
	 * <p>isFollowing.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isFollowing() {
		return following;
	}

	/**
	 * <p>isVerified.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isVerified() {
		return verified;
	}

	/**
	 * <p>Getter for the field <code>verifiedType</code>.</p>
	 *
	 * @return a int.
	 */
	public int getverifiedType() {
		return verifiedType;
	}

	/**
	 * <p>isallowAllActMsg.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isallowAllActMsg() {
		return allowAllActMsg;
	}

	/**
	 * <p>isallowAllComment.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isallowAllComment() {
		return allowAllComment;
	}

	/**
	 * <p>isfollowMe.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isfollowMe() {
		return followMe;
	}

	/**
	 * <p>Getter for the field <code>avatarLarge</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getavatarLarge() {
		return avatarLarge;
	}

	/**
	 * <p>Getter for the field <code>onlineStatus</code>.</p>
	 *
	 * @return a int.
	 */
	public int getonlineStatus() {
		return onlineStatus;
	}

	/**
	 * <p>Getter for the field <code>status</code>.</p>
	 *
	 * @return a {@link weibo4j.model.Status} object.
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * <p>Getter for the field <code>biFollowersCount</code>.</p>
	 *
	 * @return a int.
	 */
	public int getbiFollowersCount() {
		return biFollowersCount;
	}

	/**
	 * <p>Getter for the field <code>remark</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * <p>Getter for the field <code>lang</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getLang() {
		return lang;
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
		User other = (User) obj;
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
		return "User [" +
		"id=" + id +
		", screenName=" + screenName + 
		", name="+ name +
		", province=" + province + 
		", city=" + city +
		", location=" + location + 
		", description=" + description + 
		", url=" + url + 
		", profileImageUrl=" + profileImageUrl + 
		", userDomain=" + userDomain + 
		", gender=" + gender + 
		", followersCount=" + followersCount + 
		", friendsCount=" + friendsCount + 
		", statusesCount=" + statusesCount + 
		", favouritesCount=" + favouritesCount + 
		", createdAt=" + createdAt + 
		", following=" + following + 
		", verified=" + verified + 
		", verifiedType=" + verifiedType + 
		", allowAllActMsg=" + allowAllActMsg + 
		", allowAllComment=" + allowAllComment + 
		", followMe=" + followMe + 
		", avatarLarge=" + avatarLarge + 
		", onlineStatus=" + onlineStatus + 
		", status=" + status + 
		", biFollowersCount=" + biFollowersCount + 
		", remark=" + remark + 
		", lang=" + lang +
		", verifiedReason="  + verifiedReason +
		", weihao=" + weihao +
		", statusId=" + statusId +
		"]";
	}


}
