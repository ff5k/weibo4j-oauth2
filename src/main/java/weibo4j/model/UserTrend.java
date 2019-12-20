package weibo4j.model;

import java.util.ArrayList;
import java.util.List;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * 话题
 *
 * @author SinaWeibo
 * @since weibo4j-V2 1.0.0
 * @version $Id: $Id
 */
public class UserTrend extends WeiboResponse{
    private String num;               
    private String hotword = null;
    private String trendId = null;
    private static final long serialVersionUID = 1925956704460743946L;
 
	/**
	 * <p>Constructor for UserTrend.</p>
	 */
	public UserTrend() {
		super();
	}
	/**
	 * <p>Constructor for UserTrend.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public UserTrend(Response res) throws WeiboException {
		super(res);
		JSONObject json = res.asJSONObject();
		try {
			num = json.getString("num");
			hotword = json.getString("hotword");
			trendId = json.getString("trend_id");
			if( json.getString("topicid")!=null)
				trendId = json.getString("topicid");
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(),
					je);
		}
	}
	/**
	 * <p>Constructor for UserTrend.</p>
	 *
	 * @param json a {@link weibo4j.org.json.JSONObject} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public UserTrend(JSONObject json) throws WeiboException {
		try {
			num = json.getString("num");
			hotword = json.getString("hotword");
			trendId = json.getString("trend_id");
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(),
					je);
		}
	}
	
	/**
	 * <p>constructTrendList.</p>
	 *
	 * @param res a {@link weibo4j.http.Response} object.
	 * @return a {@link java.util.List} object.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public static List<UserTrend> constructTrendList(Response res) throws WeiboException {
	   	 try {
	            JSONArray list = res.asJSONArray();
	            int size = list.length();
	            List<UserTrend> trends = new ArrayList<UserTrend>(size);
	            for (int i = 0; i < size; i++) {
	            	trends.add(new UserTrend(list.getJSONObject(i)));
	            }
	            return trends;
	        } catch (JSONException jsone) {
	            throw new WeiboException(jsone);
	        } catch (WeiboException te) {
	            throw te;
	        }

	   }
	/**
	 * <p>Getter for the field <code>num</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getNum() {
		return num;
	}
	/**
	 * <p>Setter for the field <code>num</code>.</p>
	 *
	 * @param num a {@link java.lang.String} object.
	 */
	public void setNum(String num) {
		this.num = num;
	}
	/**
	 * <p>Getter for the field <code>hotword</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getHotword() {
		return hotword;
	}
	/**
	 * <p>Setter for the field <code>hotword</code>.</p>
	 *
	 * @param hotword a {@link java.lang.String} object.
	 */
	public void setHotword(String hotword) {
		this.hotword = hotword;
	}
	/**
	 * <p>Getter for the field <code>trendId</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String gettrendId() {
		return trendId;
	}
	/**
	 * <p>Setter for the field <code>trendId</code>.</p>
	 *
	 * @param trendId a {@link java.lang.String} object.
	 */
	public void settrendId(String trendId) {
		this.trendId = trendId;
	}
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Trend [num=" + num + ", hotword=" + hotword + ", trendId="
				+ trendId + "]";
	}
    
    
}
