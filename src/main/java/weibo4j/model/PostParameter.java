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

import java.io.File;
import java.net.URLEncoder;
import java.util.List;



/**
 * A data class representing HTTP Post parameter
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @version $Id: $Id
 */
public class PostParameter implements java.io.Serializable{
    String name;
    String value;
    private File file = null;
    
    private static final long serialVersionUID = -8708108746980739212L;

    /**
     * <p>Constructor for PostParameter.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param value a {@link java.lang.String} object.
     */
    public PostParameter(String name, String value) {
        this.name = name;
        this.value = value;
    }
    
    /**
     * <p>Constructor for PostParameter.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param value a long.
     */
    public PostParameter(String name, long value) {
        this.name = name;
        this.value = String.valueOf(value);
    }

    /**
     * <p>Constructor for PostParameter.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param value a double.
     */
    public PostParameter(String name, double value) {
        this.name = name;
        this.value = String.valueOf(value);
    }

    /**
     * <p>Constructor for PostParameter.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param value a int.
     */
    public PostParameter(String name, int value) {
        this.name = name;
        this.value = String.valueOf(value);
    }

    /**
     * <p>Constructor for PostParameter.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param file a {@link java.io.File} object.
     */
    public PostParameter(String name, File file) {
        this.name = name;
        this.file = file;
    }
    
    /**
     * <p>Getter for the field <code>name</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getName(){
        return name;
    }
    /**
     * <p>Getter for the field <code>value</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getValue(){
        return value;
    }

    /**
     * <p>Getter for the field <code>file</code>.</p>
     *
     * @return a {@link java.io.File} object.
     */
    public File getFile() {
        return file;
    }

    /**
     * <p>isFile.</p>
     *
     * @return a boolean.
     */
    public boolean isFile(){
        return null != file;
    }
    
    private static final String JPEG = "image/jpeg";
    private static final String GIF = "image/gif";
    private static final String PNG = "image/png";
    private static final String OCTET = "application/octet-stream";

    /**
     * <p>getContentType.</p>
     *
     * @return content-type
     */
    public String getContentType() {
        if (!isFile()) {
            throw new IllegalStateException("not a file");
        }
        String contentType;
        String extensions = file.getName();
        int index = extensions.lastIndexOf(".");
        if (-1 == index) {
            // no extension
            contentType = OCTET;
        } else {
            extensions = extensions.substring(extensions.lastIndexOf(".") + 1).toLowerCase();
            if (extensions.length() == 3) {
                if ("gif".equals(extensions)) {
                    contentType = GIF;
                } else if ("png".equals(extensions)) {
                    contentType = PNG;
                } else if ("jpg".equals(extensions)) {
                    contentType = JPEG;
                } else {
                    contentType = OCTET;
                }
            } else if (extensions.length() == 4) {
                if ("jpeg".equals(extensions)) {
                    contentType = JPEG;
                } else {
                    contentType = OCTET;
                }
            } else {
                contentType = OCTET;
            }
        }
        return contentType;
    }
    
    
    /**
     * <p>containsFile.</p>
     *
     * @param params an array of {@link weibo4j.model.PostParameter} objects.
     * @return a boolean.
     */
    public static boolean containsFile(PostParameter[] params) {
        boolean containsFile = false;
        if(null == params){
            return false;
        }
        for (PostParameter param : params) {
            if (param.isFile()) {
                containsFile = true;
                break;
            }
        }
        return containsFile;
    }
    /*package*/ static boolean containsFile(List<PostParameter> params) {
        boolean containsFile = false;
        for (PostParameter param : params) {
            if (param.isFile()) {
                containsFile = true;
                break;
            }
        }
        return containsFile;
    }

    /**
     * <p>getParameterArray.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param value a {@link java.lang.String} object.
     * @return an array of {@link weibo4j.model.PostParameter} objects.
     */
    public static PostParameter[] getParameterArray(String name, String value) {
        return new PostParameter[]{new PostParameter(name,value)};
    }
    /**
     * <p>getParameterArray.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param value a int.
     * @return an array of {@link weibo4j.model.PostParameter} objects.
     */
    public static PostParameter[] getParameterArray(String name, int value) {
        return getParameterArray(name,String.valueOf(value));
    }

    /**
     * <p>getParameterArray.</p>
     *
     * @param name1 a {@link java.lang.String} object.
     * @param value1 a {@link java.lang.String} object.
     * @param name2 a {@link java.lang.String} object.
     * @param value2 a {@link java.lang.String} object.
     * @return an array of {@link weibo4j.model.PostParameter} objects.
     */
    public static PostParameter[] getParameterArray(String name1, String value1
            , String name2, String value2) {
        return new PostParameter[]{new PostParameter(name1, value1)
                , new PostParameter(name2, value2)};
    }
    /**
     * <p>getParameterArray.</p>
     *
     * @param name1 a {@link java.lang.String} object.
     * @param value1 a int.
     * @param name2 a {@link java.lang.String} object.
     * @param value2 a int.
     * @return an array of {@link weibo4j.model.PostParameter} objects.
     */
    public static PostParameter[] getParameterArray(String name1, int value1
            , String name2, int value2) {
        return getParameterArray(name1,String.valueOf(value1),name2,String.valueOf(value2));
    }
    
    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + value.hashCode();
        result = 31 * result + (file != null ? file.hashCode() : 0);
        return result;
    }

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof PostParameter) {
            PostParameter that = (PostParameter) obj;
            
            if (file != null ? !file.equals(that.file) : that.file != null)
                return false;
            
            return this.name.equals(that.name) &&
                this.value.equals(that.value);
        }
        return false;
    }
   
    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "PostParameter{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", file=" + file +
                '}';
    }
    
    /**
     * <p>compareTo.</p>
     *
     * @param o a {@link java.lang.Object} object.
     * @return a int.
     */
    public int compareTo(Object o) {
        int compared;
        PostParameter that = (PostParameter) o;
        compared = name.compareTo(that.name);
        if (0 == compared) {
            compared = value.compareTo(that.value);
        }
        return compared;
    }
    
    /**
     * <p>encodeParameters.</p>
     *
     * @param httpParams an array of {@link weibo4j.model.PostParameter} objects.
     * @return a {@link java.lang.String} object.
     */
    public static String encodeParameters(PostParameter[] httpParams) {
        if (null == httpParams) {
            return "";
        }
        StringBuffer buf = new StringBuffer();
        for (int j = 0; j < httpParams.length; j++) {
            if (httpParams[j].isFile()) {
                throw new IllegalArgumentException("parameter [" + httpParams[j].name + "]should be text");
            }
            if (j != 0) {
                buf.append("&");
            }
            try {
                buf.append(URLEncoder.encode(httpParams[j].name, "UTF-8"))
                        .append("=").append(URLEncoder.encode(httpParams[j].value, "UTF-8"));
            } catch (java.io.UnsupportedEncodingException neverHappen) {
            }
        }
        return buf.toString();

    }
    
}
