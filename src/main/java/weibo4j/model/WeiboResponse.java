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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import weibo4j.http.HTMLEntity;
import weibo4j.http.Response;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/**
 * Super class of Weibo Response objects.
 *
 * @see weibo4j.DirectMessage
 * @see weibo4j.model.Status
 * @see weibo4j.model.User
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @version $Id: $Id
 */
public class WeiboResponse implements java.io.Serializable {
    private static Map<String,SimpleDateFormat> formatMap = new HashMap<String,SimpleDateFormat>();
    private static final long serialVersionUID = 3519962197957449562L;
    private transient int rateLimitLimit = -1;
    private transient int rateLimitRemaining = -1;
    private transient long rateLimitReset = -1;
    private static final boolean IS_DALVIK = Configuration.isDalvik();

    /**
     * <p>Constructor for WeiboResponse.</p>
     */
    public WeiboResponse() {
    }

    /**
     * <p>Constructor for WeiboResponse.</p>
     *
     * @param res a {@link weibo4j.http.Response} object.
     */
    public WeiboResponse(Response res) {
        String limit = res.getResponseHeader("X-RateLimit-Limit");
        if(null != limit){
            rateLimitLimit = Integer.parseInt(limit);
        }
        String remaining = res.getResponseHeader("X-RateLimit-Remaining");
        if(null != remaining){
            rateLimitRemaining = Integer.parseInt(remaining);
        }
        String reset = res.getResponseHeader("X-RateLimit-Reset");
        if(null != reset){
            rateLimitReset = Long.parseLong(reset);
        }
    }

    /**
     * <p>ensureRootNodeNameIs.</p>
     *
     * @param rootName a {@link java.lang.String} object.
     * @param elem a {@link org.w3c.dom.Element} object.
     * @throws weibo4j.model.WeiboException if any.
     */
    protected static void ensureRootNodeNameIs(String rootName, Element elem) throws WeiboException {
        if (!rootName.equals(elem.getNodeName())) {
            throw new WeiboException("Unexpected root node name:" + elem.getNodeName() + ". Expected:" + rootName + ". Check the availability of the Weibo API at http://open.t.sina.com.cn/.");
        }
    }

    /**
     * <p>ensureRootNodeNameIs.</p>
     *
     * @param rootNames an array of {@link java.lang.String} objects.
     * @param elem a {@link org.w3c.dom.Element} object.
     * @throws weibo4j.model.WeiboException if any.
     */
    protected static void ensureRootNodeNameIs(String[] rootNames, Element elem) throws WeiboException {
        String actualRootName = elem.getNodeName();
        for (String rootName : rootNames) {
            if (rootName.equals(actualRootName)) {
                return;
            }
        }
        String expected = "";
        for (int i = 0; i < rootNames.length; i++) {
            if (i != 0) {
                expected += " or ";
            }
            expected += rootNames[i];
        }
        throw new WeiboException("Unexpected root node name:" + elem.getNodeName() + ". Expected:" + expected + ". Check the availability of the Weibo API at http://open.t.sina.com.cn/.");
    }

    /**
     * <p>ensureRootNodeNameIs.</p>
     *
     * @param rootName a {@link java.lang.String} object.
     * @param doc a {@link org.w3c.dom.Document} object.
     * @throws weibo4j.model.WeiboException if any.
     */
    protected static void ensureRootNodeNameIs(String rootName, Document doc) throws WeiboException {
        Element elem = doc.getDocumentElement();
        if (!rootName.equals(elem.getNodeName())) {
            throw new WeiboException("Unexpected root node name:" + elem.getNodeName() + ". Expected:" + rootName + ". Check the availability of the Weibo API at http://open.t.sina.com.cn/");
        }
    }

    /**
     * <p>isRootNodeNilClasses.</p>
     *
     * @param doc a {@link org.w3c.dom.Document} object.
     * @return a boolean.
     */
    protected static boolean isRootNodeNilClasses(Document doc) {
        String root = doc.getDocumentElement().getNodeName();
        return "nil-classes".equals(root) || "nilclasses".equals(root);
    }

    /**
     * <p>getChildText.</p>
     *
     * @param str a {@link java.lang.String} object.
     * @param elem a {@link org.w3c.dom.Element} object.
     * @return a {@link java.lang.String} object.
     */
    protected static String getChildText( String str, Element elem ) {
        return HTMLEntity.unescape(getTextContent(str,elem));
    }

    /**
     * <p>getTextContent.</p>
     *
     * @param str a {@link java.lang.String} object.
     * @param elem a {@link org.w3c.dom.Element} object.
     * @return a {@link java.lang.String} object.
     */
    protected static String getTextContent(String str, Element elem){
        NodeList nodelist = elem.getElementsByTagName(str);
        if (nodelist.getLength() > 0) {
            Node node = nodelist.item(0).getFirstChild();
            if (null != node) {
                String nodeValue = node.getNodeValue();
                return null != nodeValue ? nodeValue : "";
            }
        }
        return "";
     }

    /*modify by sycheng  add "".equals(str) */
    /**
     * <p>getChildInt.</p>
     *
     * @param str a {@link java.lang.String} object.
     * @param elem a {@link org.w3c.dom.Element} object.
     * @return a int.
     */
    protected static int getChildInt(String str, Element elem) {
        String str2 = getTextContent(str, elem);
        if (null == str2 || "".equals(str2)||"null".equals(str)) {
            return -1;
        } else {
            return Integer.valueOf(str2);
        }
    }

    /**
     * <p>getChildLong.</p>
     *
     * @param str a {@link java.lang.String} object.
     * @param elem a {@link org.w3c.dom.Element} object.
     * @return a long.
     */
    protected static long getChildLong(String str, Element elem) {
        String str2 = getTextContent(str, elem);
        if (null == str2 || "".equals(str2)||"null".equals(str)) {
            return -1;
        } else {
            return Long.valueOf(str2);
        }
    }

    /**
     * <p>getString.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param json a {@link weibo4j.org.json.JSONObject} object.
     * @param decode a boolean.
     * @return a {@link java.lang.String} object.
     */
    protected static String getString(String name, JSONObject json, boolean decode) {
        String returnValue = null;
            try {
                returnValue = json.getString(name);
                if (decode) {
                    try {
                        returnValue = URLDecoder.decode(returnValue, "UTF-8");
                    } catch (UnsupportedEncodingException ignore) {
                    }
                }
            } catch (JSONException ignore) {
                // refresh_url could be missing
            }
        return returnValue;
    }

    /**
     * <p>getChildBoolean.</p>
     *
     * @param str a {@link java.lang.String} object.
     * @param elem a {@link org.w3c.dom.Element} object.
     * @return a boolean.
     */
    protected static boolean getChildBoolean(String str, Element elem) {
        String value = getTextContent(str, elem);
        return Boolean.valueOf(value);
    }
    /**
     * <p>getChildDate.</p>
     *
     * @param str a {@link java.lang.String} object.
     * @param elem a {@link org.w3c.dom.Element} object.
     * @return a {@link java.util.Date} object.
     * @throws weibo4j.model.WeiboException if any.
     */
    protected static Date getChildDate(String str, Element elem) throws WeiboException {
        return getChildDate(str, elem, "EEE MMM d HH:mm:ss z yyyy");
    }

    /**
     * <p>getChildDate.</p>
     *
     * @param str a {@link java.lang.String} object.
     * @param elem a {@link org.w3c.dom.Element} object.
     * @param format a {@link java.lang.String} object.
     * @return a {@link java.util.Date} object.
     * @throws weibo4j.model.WeiboException if any.
     */
    protected static Date getChildDate(String str, Element elem, String format) throws WeiboException {
        return parseDate(getChildText(str, elem),format);
    }
    /**
     * <p>parseDate.</p>
     *
     * @param str a {@link java.lang.String} object.
     * @param format a {@link java.lang.String} object.
     * @return a {@link java.util.Date} object.
     * @throws weibo4j.model.WeiboException if any.
     */
    protected static Date parseDate(String str, String format) throws WeiboException{
        if(str==null||"".equals(str)){
        	return null;
        }
    	SimpleDateFormat sdf = formatMap.get(format);
        if (null == sdf) {
            sdf = new SimpleDateFormat(format, Locale.ENGLISH);
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            formatMap.put(format, sdf);
        }
        try {
            synchronized(sdf){
                // SimpleDateFormat is not thread safe
                return sdf.parse(str);
            }
        } catch (ParseException pe) {
            throw new WeiboException("Unexpected format(" + str + ") returned from sina.com.cn");
        }
    }

    /**
     * <p>getInt.</p>
     *
     * @param key a {@link java.lang.String} object.
     * @param json a {@link weibo4j.org.json.JSONObject} object.
     * @return a int.
     * @throws weibo4j.org.json.JSONException if any.
     */
    protected static int getInt(String key, JSONObject json) throws JSONException {
        String str = json.getString(key);
        if(null == str || "".equals(str)||"null".equals(str)){
            return -1;
        }
        return Integer.parseInt(str);
    }

    /**
     * <p>getLong.</p>
     *
     * @param key a {@link java.lang.String} object.
     * @param json a {@link weibo4j.org.json.JSONObject} object.
     * @return a long.
     * @throws weibo4j.org.json.JSONException if any.
     */
    protected static long getLong(String key, JSONObject json) throws JSONException {
        String str = json.getString(key);
        if(null == str || "".equals(str)||"null".equals(str)){
            return -1;
        }
        return Long.parseLong(str);
    }
    /**
     * <p>getBoolean.</p>
     *
     * @param key a {@link java.lang.String} object.
     * @param json a {@link weibo4j.org.json.JSONObject} object.
     * @return a boolean.
     * @throws weibo4j.org.json.JSONException if any.
     */
    protected static boolean getBoolean(String key, JSONObject json) throws JSONException {
        String str = json.getString(key);
        if(null == str || "".equals(str)||"null".equals(str)){
            return false;
        }
        return Boolean.valueOf(str);
    }

    /**
     * <p>Getter for the field <code>rateLimitLimit</code>.</p>
     *
     * @return a int.
     */
    public int getRateLimitLimit() {
        return rateLimitLimit;
    }

    /**
     * <p>Getter for the field <code>rateLimitRemaining</code>.</p>
     *
     * @return a int.
     */
    public int getRateLimitRemaining() {
        return rateLimitRemaining;
    }

    /**
     * <p>Getter for the field <code>rateLimitReset</code>.</p>
     *
     * @return a long.
     */
    public long getRateLimitReset() {
        return rateLimitReset;
    }
}
