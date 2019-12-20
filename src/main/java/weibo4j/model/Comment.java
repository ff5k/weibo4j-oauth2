package weibo4j.model;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Comment class.</p>
 *
 * @author user1
 * @version $Id: $Id
 */
public class Comment extends WeiboResponse {

	private static final long serialVersionUID = -6981150504900709672L;
	private Date createdAt;                    //评论时间
	private long id;                           //评论id
	private String mid;						   //评论id
	private String idstr;					   //评论id
	private String text;                       //评论内容
	private String source;                     //内容来源
	private Comment replycomment = null;       //回复的评论内容
	private User user = null;                  //User对象
	private Status status = null;              //Status对象

	/**
	 * <p>Constructor for Comment.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	/*package*/public Comment(Response res) throws WeiboException {
		super(res);
		JSONObject json =res.asJSONObject();
		try {
			id = json.getLong("id");
			mid = json.getString("mid");
			idstr = json.getString("idstr");
			text = json.getString("text");
			source = json.getString("source");
			createdAt = parseDate(json.getString("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
			if(!json.isNull("user"))
				user = new User(json.getJSONObject("user"));
			if(!json.isNull("status"))
				status = new Status(json.getJSONObject("status"));
			if(!json.isNull("reply_comment"))
				replycomment = (new Comment(json.getJSONObject("reply_comment")));
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(), je);
		}
	}

	/**
	 * <p>Constructor for Comment.</p>
	 *
	 * @param json a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.model.WeiboException if any.
	 * @throws weibo4j.org.json.JSONException if any.
	 */
	public Comment(JSONObject json)throws WeiboException, JSONException{
		id = json.getLong("id");
		mid = json.getString("mid");
		idstr = json.getString("idstr");
		text = json.getString("text");
		source = json.getString("source");
		createdAt = parseDate(json.getString("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
		if(!json.isNull("user"))
			user = new User(json.getJSONObject("user"));
		if(!json.isNull("status"))
			status = new Status(json.getJSONObject("status"));	
		if(!json.isNull("reply_comment"))
			replycomment = (new Comment(json.getJSONObject("reply_comment")));
	}

	/**
	 * <p>Constructor for Comment.</p>
	 *
	 * @param str a {@link java.lang.String} object.
	 * @throws weibo4j.model.WeiboException if any.
	 * @throws weibo4j.org.json.JSONException if any.
	 */
	public Comment(String str) throws WeiboException, JSONException {
		// StatusStream uses this constructor
		super();
		JSONObject json = new JSONObject(str);
		id = json.getLong("id");
		mid = json.getString("mid");
		idstr = json.getString("idstr");
		text = json.getString("text");
		source = json.getString("source");
		createdAt = parseDate(json.getString("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
		if(!json.isNull("user"))
			user = new User(json.getJSONObject("user"));
		if(!json.isNull("status"))
			status = new Status(json.getJSONObject("status"));	
		if(!json.isNull("reply_comment"))
			replycomment = (new Comment(json.getJSONObject("reply_comment")));
	}

	/**
	 * <p>constructWapperComments.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @return a {@link weibo4j.model.CommentWapper} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public static CommentWapper constructWapperComments(Response res) throws WeiboException {
		JSONObject json = res.asJSONObject(); //asJSONArray();
		try {
			JSONArray comments = json.getJSONArray("comments");
			int size = comments.length();
			List<Comment> comment = new ArrayList<Comment>(size);
			for (int i = 0; i < size; i++) {
				comment.add(new Comment(comments.getJSONObject(i)));
			}
			long previousCursor = json.getLong("previous_curosr");
			long nextCursor = json.getLong("next_cursor");
			long totalNumber = json.getLong("total_number");
			String hasvisible = json.getString("hasvisible");
			return new CommentWapper(comment, previousCursor, nextCursor,totalNumber,hasvisible);
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}
	}
	
	/**
	 * <p>constructComment.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @return a {@link java.util.List} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public static List<Comment> constructComment(Response res)
			throws WeiboException {

		try {
			JSONArray array = res.asJSONArray();
			int size = array.length();
			List<Comment> comment = new ArrayList<Comment>(size);
			for (int i = 0; i < size; i++) {
				comment.add(new Comment(array.getJSONObject(i)));
			}
			return comment;
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}
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
	 * <p>Getter for the field <code>id</code>.</p>
	 *
	 * @return a long.
	 */
	public long getId() {
		return id;
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
	 * <p>Getter for the field <code>source</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getSource() {
		return source;
	}

	/**
	 * <p>Getter for the field <code>replycomment</code>.</p>
	 *
	 * @return a {@link weibo4j.model.Comment} object.
	 */
	public Comment getReplycomment() {
		return replycomment;
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
	 * <p>Getter for the field <code>status</code>.</p>
	 *
	 * @return a {@link weibo4j.model.Status} object.
	 */
	public Status getStatus() {
		return status;
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
	 * <p>Getter for the field <code>idstr</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getIdstr() {
		return idstr;
	}

	/**
	 * <p>Setter for the field <code>idstr</code>.</p>
	 *
	 * @param idstr a {@link java.lang.String} object.
	 */
	public void setIdstr(String idstr) {
		this.idstr = idstr;
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
	 * <p>Setter for the field <code>id</code>.</p>
	 *
	 * @param id a long.
	 */
	public void setId(long id) {
		this.id = id;
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
	 * <p>Setter for the field <code>source</code>.</p>
	 *
	 * @param source a {@link java.lang.String} object.
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * <p>Setter for the field <code>replycomment</code>.</p>
	 *
	 * @param replycomment a {@link weibo4j.model.Comment} object.
	 */
	public void setReplycomment(Comment replycomment) {
		this.replycomment = replycomment;
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
	 * <p>Setter for the field <code>status</code>.</p>
	 *
	 * @param status a {@link weibo4j.model.Status} object.
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Comment other = (Comment) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Comment [createdAt=" + createdAt + ", id=" + id + ", mid="
				+ mid + ", idstr=" + idstr + ", text=" + text + ", source="
				+ source + ", replycomment=" + replycomment + ", user=" + user
				+ ", status=" + status +"]";
	}

}
