/*
Copyright (c) 2007-2009
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

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 搜索条件
 *
 * @author SinaWeibo
 * @version $Id: $Id
 */
public class Query {
    private String q; //搜索的关键字。
    private Boolean snick=null;//搜索范围是否包含昵称
    private int rpp=20;
    private Boolean sdomain=null;//搜索范围是否包含个性域名
    private Boolean sintro=null;//搜索范围是否包含简介
    private Integer province=null;//省份ID，参考省份城市编码表
    private Integer city	=null;//城市ID，参考省份城市编码表
    private Gender gender=null;//性别
    private String comorsch=null;
    private int sort=1;//排序方式，1为按更新时间，2为按粉丝数。
    private Integer page=null;
    private Integer count=null;//默认每页10条
    private boolean base_app=true;//是否不基于当前应用来获取数据
    private int filter_ori=0;//过滤器，是否为原创，0为全部，5为原创，4为转发。默认为0。
    private int filter_pic;//过滤器。是否包含图片。0为全部，1为包含，2为不包含。
    private long fuid;//微博作者的用户ID。
    private Date starttime;//开始时间，Unix时间戳
    private Date endtime;//结束时间，Unix时间戳
    private boolean needcount=false;//返回结果中是否包含返回记录数。true则返回搜索结果记录数。
    private String geocode=null;//返回指定经纬度附近的信息。经纬度参数格式是“纬度，经度，半径”，半径支持km（公里），m（米），mi（英里）。格式需要URL Encode编码
    
    /**
     * <p>Setter for the field <code>q</code>.</p>
     *
     * @param q a {@link java.lang.String} object.
     */
    public void setQ(String q) {
		this.q = q;
//		if(!URLEncodeUtils.isURLEncoded(q))
//		q=URLEncodeUtils.encodeURL(q);
	}
    
	/**
	 * <p>Getter for the field <code>q</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getQ() {
		return q;
	}
	
	/**
	 * <p>Getter for the field <code>snick</code>.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getSnick() {
		return snick;
	}
	
	/**
	 * <p>Setter for the field <code>snick</code>.</p>
	 *
	 * @param snick a {@link java.lang.Boolean} object.
	 */
	public void setSnick(Boolean snick) {
		this.snick = snick;
	}
	
	/**
	 * <p>Getter for the field <code>rpp</code>.</p>
	 *
	 * @return a int.
	 */
	public int getRpp() {
		return rpp;
	}
	
	/**
	 * <p>Setter for the field <code>rpp</code>.</p>
	 *
	 * @param rpp a int.
	 */
	public void setRpp(int rpp) {
		this.rpp = rpp;
	}
	
	/**
	 * <p>Getter for the field <code>sdomain</code>.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getSdomain() {
		return sdomain;
	}
	
	/**
	 * <p>Setter for the field <code>sdomain</code>.</p>
	 *
	 * @param sdomain a {@link java.lang.Boolean} object.
	 */
	public void setSdomain(Boolean sdomain) {
		this.sdomain = sdomain;
	}
	
	/**
	 * <p>Getter for the field <code>sintro</code>.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getSintro() {
		return sintro;
	}
	
	/**
	 * <p>Setter for the field <code>sintro</code>.</p>
	 *
	 * @param sintro a {@link java.lang.Boolean} object.
	 */
	public void setSintro(Boolean sintro) {
		this.sintro = sintro;
	}
	
	/**
	 * <p>Getter for the field <code>province</code>.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getProvince() {
		return province;
	}
	
	/**
	 * <p>Setter for the field <code>province</code>.</p>
	 *
	 * @param province a {@link java.lang.Integer} object.
	 */
	public void setProvince(Integer province) {
		this.province = province;
	}
	
	/**
	 * <p>Getter for the field <code>city</code>.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getCity() {
		return city;
	}
	
	/**
	 * <p>Setter for the field <code>city</code>.</p>
	 *
	 * @param city a {@link java.lang.Integer} object.
	 */
	public void setCity(Integer city) {
		this.city = city;
	}
	
	/**
	 * <p>Getter for the field <code>gender</code>.</p>
	 *
	 * @return a {@link weibo4j.model.Gender} object.
	 */
	public Gender getGender() {
		return gender;
	}
	
	/**
	 * <p>Setter for the field <code>gender</code>.</p>
	 *
	 * @param gender a {@link weibo4j.model.Gender} object.
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	/**
	 * <p>Getter for the field <code>comorsch</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getComorsch() {
		return comorsch;
	}
	
	/**
	 * <p>Setter for the field <code>comorsch</code>.</p>
	 *
	 * @param comorsch a {@link java.lang.String} object.
	 */
	public void setComorsch(String comorsch) {
		this.comorsch = comorsch;
	}
	
	/**
	 * <p>Getter for the field <code>sort</code>.</p>
	 *
	 * @return a int.
	 */
	public int getSort() {
		return sort;
	}
	
	/**
	 * <p>Setter for the field <code>sort</code>.</p>
	 *
	 * @param sort a int.
	 */
	public void setSort(int sort) {
		this.sort = sort;
	}
	
	/**
	 * <p>Getter for the field <code>page</code>.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getPage() {
		return page;
	}
	
	/**
	 * <p>Setter for the field <code>page</code>.</p>
	 *
	 * @param page a {@link java.lang.Integer} object.
	 */
	public void setPage(Integer page) {
		this.page = page;
	}
	
	/**
	 * <p>Getter for the field <code>count</code>.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getCount() {
		return count;
	}
	
	/**
	 * <p>Setter for the field <code>count</code>.</p>
	 *
	 * @param count a {@link java.lang.Integer} object.
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	
	/**
	 * <p>Getter for the field <code>base_app</code>.</p>
	 *
	 * @return a boolean.
	 */
	public boolean getBase_app() {
		return base_app;
	}
	
	/**
	 * <p>Setter for the field <code>base_app</code>.</p>
	 *
	 * @param baseApp a boolean.
	 */
	public void setBase_app(boolean baseApp) {
		base_app = baseApp;
	}
	
	/**
	 * <p>Getter for the field <code>filter_ori</code>.</p>
	 *
	 * @return a int.
	 */
	public int getFilter_ori() {
		return filter_ori;
	}
	
	/**
	 * <p>Setter for the field <code>filter_ori</code>.</p>
	 *
	 * @param filterOri a int.
	 */
	public void setFilter_ori(int filterOri) {
		filter_ori = filterOri;
	}
	
	/**
	 * <p>Getter for the field <code>filter_pic</code>.</p>
	 *
	 * @return a int.
	 */
	public int getFilter_pic() {
		return filter_pic;
	}
	
	/**
	 * <p>Setter for the field <code>filter_pic</code>.</p>
	 *
	 * @param filterPic a int.
	 */
	public void setFilter_pic(int filterPic) {
		filter_pic = filterPic;
	}
	
	/**
	 * <p>Getter for the field <code>fuid</code>.</p>
	 *
	 * @return a long.
	 */
	public long getFuid() {
		return fuid;
	}
	
	/**
	 * <p>Setter for the field <code>fuid</code>.</p>
	 *
	 * @param fuid a {@link java.lang.Integer} object.
	 */
	public void setFuid(Integer fuid) {
		this.fuid = fuid;
	}
	
	/**
	 * <p>Getter for the field <code>starttime</code>.</p>
	 *
	 * @return a {@link java.util.Date} object.
	 */
	public Date getStarttime() {
		return starttime;
	}
	
	/**
	 * <p>Setter for the field <code>starttime</code>.</p>
	 *
	 * @param starttime a {@link java.util.Date} object.
	 */
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	
	/**
	 * <p>Getter for the field <code>endtime</code>.</p>
	 *
	 * @return a {@link java.util.Date} object.
	 */
	public Date getEndtime() {
		return endtime;
	}
	
	/**
	 * <p>Setter for the field <code>endtime</code>.</p>
	 *
	 * @param endtime a {@link java.util.Date} object.
	 */
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	
	/**
	 * <p>Getter for the field <code>needcount</code>.</p>
	 *
	 * @return a boolean.
	 */
	public boolean getNeedcount() {
		return needcount;
	}
	
	/**
	 * <p>Setter for the field <code>needcount</code>.</p>
	 *
	 * @param needcount a boolean.
	 */
	public void setNeedcount(boolean needcount) {
		this.needcount = needcount;
	}
	
	/**
	 * <p>Getter for the field <code>geocode</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getGeocode() {
		return geocode;
	}
	/**
	 * <p>Setter for the field <code>geocode</code>.</p>
	 *
	 * @param geocode a {@link java.lang.String} object.
	 */
	public void setGeocode(String geocode) {
		this.geocode = geocode;
	}
	/**
	 * <p>getParameters.</p>
	 *
	 * @return an array of {@link weibo4j.model.PostParameter} objects.
	 * @throws weibo4j.model.WeiboException if any.
	 */
	public PostParameter[] getParameters() throws WeiboException{
		List<PostParameter> list= new ArrayList<PostParameter>();
		Class<Query> clz=Query.class;
		Field[] fields=clz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String fieldName=field.getName();
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getMethodName = "get" + firstLetter+ fieldName.substring(1); 
			Method getMethod;
			try {
				getMethod = clz.getMethod(getMethodName, new Class[] {});
				Object value = getMethod.invoke(this, new Object[] {}); 
				if(value!=null){
					list.add(getParameterValue(fieldName, value));
				}
			} catch (Exception e) {
				throw new WeiboException(e);
			}
		}
		return list.toArray(new PostParameter[list.size()]);
		
	}
	private PostParameter getParameterValue(String name,Object value){
		if(value instanceof Boolean){
			return new PostParameter(name, (Boolean)value?"0":"1");
		}else if(value instanceof String){
			return new PostParameter(name, value.toString());
		}else if(value instanceof Integer){
			return new PostParameter(name,Integer.toString((Integer)value));
		}else if(value instanceof Long){
			return new PostParameter(name,Long.toString((Long)value));
		}else if(value instanceof Gender) {
			return new PostParameter(name,Gender.valueOf((Gender)value));
		}
		return null;
	}
	
}


