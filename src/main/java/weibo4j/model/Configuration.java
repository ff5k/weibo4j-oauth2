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
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.AccessControlException;
import java.util.Properties;

/**
 * <p>Configuration class.</p>
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @version $Id: $Id
 */
public class Configuration {
    private static Properties defaultProperty;

    static {
        init();
    }

    /*package*/ static void init() {
        defaultProperty = new Properties();
        defaultProperty.setProperty("weibo4j.debug", "true");
//        defaultProperty.setProperty("weibo4j.source", Weibo.CONSUMER_KEY);
        //defaultProperty.setProperty("weibo4j.clientVersion","");
        defaultProperty.setProperty("weibo4j.clientURL", "http://open.t.sina.com.cn/-{weibo4j.clientVersion}.xml");
        defaultProperty.setProperty("weibo4j.http.userAgent", "weibo4j http://open.t.sina.com.cn/ /{weibo4j.clientVersion}");
        //defaultProperty.setProperty("weibo4j.user","");
        //defaultProperty.setProperty("weibo4j.password","");
        defaultProperty.setProperty("weibo4j.http.useSSL", "false");
        //defaultProperty.setProperty("weibo4j.http.proxyHost","");
        defaultProperty.setProperty("weibo4j.http.proxyHost.fallback", "http.proxyHost");
        //defaultProperty.setProperty("weibo4j.http.proxyUser","");
        //defaultProperty.setProperty("weibo4j.http.proxyPassword","");
        //defaultProperty.setProperty("weibo4j.http.proxyPort","");
        defaultProperty.setProperty("weibo4j.http.proxyPort.fallback", "http.proxyPort");
        defaultProperty.setProperty("weibo4j.http.connectionTimeout", "20000");
        defaultProperty.setProperty("weibo4j.http.readTimeout", "120000");
        defaultProperty.setProperty("weibo4j.http.retryCount", "3");
        defaultProperty.setProperty("weibo4j.http.retryIntervalSecs", "10");
        //defaultProperty.setProperty("weibo4j.oauth.consumerKey","");
        //defaultProperty.setProperty("weibo4j.oauth.consumerSecret","");
        defaultProperty.setProperty("weibo4j.async.numThreads", "1");
        defaultProperty.setProperty("weibo4j.clientVersion", Version.getVersion());
        try {
            // Android platform should have dalvik.system.VMRuntime in the classpath.
            // @see http://developer.android.com/reference/dalvik/system/VMRuntime.html
            Class.forName("dalvik.system.VMRuntime");
            defaultProperty.setProperty("weibo4j.dalvik", "true");
        } catch (ClassNotFoundException cnfe) {
            defaultProperty.setProperty("weibo4j.dalvik", "false");
        }
        DALVIK = getBoolean("weibo4j.dalvik");
        String t4jProps = "weibo4j.properties";
        boolean loaded = loadProperties(defaultProperty, "." + File.separatorChar + t4jProps) ||
                loadProperties(defaultProperty, Configuration.class.getResourceAsStream("/WEB-INF/" + t4jProps)) ||
                loadProperties(defaultProperty, Configuration.class.getResourceAsStream("/" + t4jProps));
    }

    private static boolean loadProperties(Properties props, String path) {
        try {
            File file = new File(path);
            if(file.exists() && file.isFile()){
                props.load(new FileInputStream(file));
                return true;
            }
        } catch (Exception ignore) {
        }
        return false;
    }

    private static boolean loadProperties(Properties props, InputStream is) {
        try {
            props.load(is);
            return true;
        } catch (Exception ignore) {
        }
        return false;
    }

    private static boolean DALVIK;


    /**
     * <p>isDalvik.</p>
     *
     * @return a boolean.
     */
    public static boolean isDalvik() {
        return DALVIK;
    }

    /**
     * <p>useSSL.</p>
     *
     * @return a boolean.
     */
    public static boolean useSSL() {
        return getBoolean("weibo4j.http.useSSL");
    }
    /**
     * <p>getScheme.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public static String getScheme(){
        return useSSL() ? "https://" : "http://";
    }

    /**
     * <p>getCilentVersion.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public static String getCilentVersion() {
        return getProperty("weibo4j.clientVersion");
    }

    /**
     * <p>getCilentVersion.</p>
     *
     * @param clientVersion a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String getCilentVersion(String clientVersion) {
        return getProperty("weibo4j.clientVersion", clientVersion);
    }

    /**
     * <p>getSource.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public static String getSource() {
        return getProperty("weibo4j.source");
    }

    /**
     * <p>getSource.</p>
     *
     * @param source a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String getSource(String source) {
        return getProperty("weibo4j.source", source);
    }

    /**
     * <p>getProxyHost.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public static String getProxyHost() {
        return getProperty("weibo4j.http.proxyHost");
    }

    /**
     * <p>getProxyHost.</p>
     *
     * @param proxyHost a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String getProxyHost(String proxyHost) {
        return getProperty("weibo4j.http.proxyHost", proxyHost);
    }

    /**
     * <p>getProxyUser.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public static String getProxyUser() {
        return getProperty("weibo4j.http.proxyUser");
    }

    /**
     * <p>getProxyUser.</p>
     *
     * @param user a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String getProxyUser(String user) {
        return getProperty("weibo4j.http.proxyUser", user);
    }

    /**
     * <p>getClientURL.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public static String getClientURL() {
        return getProperty("weibo4j.clientURL");
    }

    /**
     * <p>getClientURL.</p>
     *
     * @param clientURL a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String getClientURL(String clientURL) {
        return getProperty("weibo4j.clientURL", clientURL);
    }

    /**
     * <p>getProxyPassword.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public static String getProxyPassword() {
        return getProperty("weibo4j.http.proxyPassword");
    }

    /**
     * <p>getProxyPassword.</p>
     *
     * @param password a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String getProxyPassword(String password) {
        return getProperty("weibo4j.http.proxyPassword", password);
    }

    /**
     * <p>getProxyPort.</p>
     *
     * @return a int.
     */
    public static int getProxyPort() {
        return getIntProperty("weibo4j.http.proxyPort");
    }

    /**
     * <p>getProxyPort.</p>
     *
     * @param port a int.
     * @return a int.
     */
    public static int getProxyPort(int port) {
        return getIntProperty("weibo4j.http.proxyPort", port);
    }

    /**
     * <p>getConnectionTimeout.</p>
     *
     * @return a int.
     */
    public static int getConnectionTimeout() {
        return getIntProperty("weibo4j.http.connectionTimeout");
    }

    /**
     * <p>getConnectionTimeout.</p>
     *
     * @param connectionTimeout a int.
     * @return a int.
     */
    public static int getConnectionTimeout(int connectionTimeout) {
        return getIntProperty("weibo4j.http.connectionTimeout", connectionTimeout);
    }

    /**
     * <p>getReadTimeout.</p>
     *
     * @return a int.
     */
    public static int getReadTimeout() {
        return getIntProperty("weibo4j.http.readTimeout");
    }

    /**
     * <p>getReadTimeout.</p>
     *
     * @param readTimeout a int.
     * @return a int.
     */
    public static int getReadTimeout(int readTimeout) {
        return getIntProperty("weibo4j.http.readTimeout", readTimeout);
    }

    /**
     * <p>getRetryCount.</p>
     *
     * @return a int.
     */
    public static int getRetryCount() {
        return getIntProperty("weibo4j.http.retryCount");
    }

    /**
     * <p>getRetryCount.</p>
     *
     * @param retryCount a int.
     * @return a int.
     */
    public static int getRetryCount(int retryCount) {
        return getIntProperty("weibo4j.http.retryCount", retryCount);
    }

    /**
     * <p>getRetryIntervalSecs.</p>
     *
     * @return a int.
     */
    public static int getRetryIntervalSecs() {
        return getIntProperty("weibo4j.http.retryIntervalSecs");
    }

    /**
     * <p>getRetryIntervalSecs.</p>
     *
     * @param retryIntervalSecs a int.
     * @return a int.
     */
    public static int getRetryIntervalSecs(int retryIntervalSecs) {
        return getIntProperty("weibo4j.http.retryIntervalSecs", retryIntervalSecs);
    }

    /**
     * <p>getUser.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public static String getUser() {
        return getProperty("weibo4j.user");
    }

    /**
     * <p>getUser.</p>
     *
     * @param userId a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String getUser(String userId) {
        return getProperty("weibo4j.user", userId);
    }

    /**
     * <p>getPassword.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public static String getPassword() {
        return getProperty("weibo4j.password");
    }

    /**
     * <p>getPassword.</p>
     *
     * @param password a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String getPassword(String password) {
        return getProperty("weibo4j.password", password);
    }

    /**
     * <p>getUserAgent.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public static String getUserAgent() {
        return getProperty("weibo4j.http.userAgent");
    }

    /**
     * <p>getUserAgent.</p>
     *
     * @param userAgent a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String getUserAgent(String userAgent) {
        return getProperty("weibo4j.http.userAgent", userAgent);
    }

    /**
     * <p>getOAuthConsumerKey.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public static String getOAuthConsumerKey() {
        return getProperty("weibo4j.oauth.consumerKey");
    }

    /**
     * <p>getOAuthConsumerKey.</p>
     *
     * @param consumerKey a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String getOAuthConsumerKey(String consumerKey) {
        return getProperty("weibo4j.oauth.consumerKey", consumerKey);
    }

    /**
     * <p>getOAuthConsumerSecret.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public static String getOAuthConsumerSecret() {
        return getProperty("weibo4j.oauth.consumerSecret");
    }

    /**
     * <p>getOAuthConsumerSecret.</p>
     *
     * @param consumerSecret a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String getOAuthConsumerSecret(String consumerSecret) {
        return getProperty("weibo4j.oauth.consumerSecret", consumerSecret);
    }

    /**
     * <p>getBoolean.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @return a boolean.
     */
    public static boolean getBoolean(String name) {
        String value = getProperty(name);
        return Boolean.valueOf(value);
    }

    /**
     * <p>getIntProperty.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @return a int.
     */
    public static int getIntProperty(String name) {
        String value = getProperty(name);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

    /**
     * <p>getIntProperty.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param fallbackValue a int.
     * @return a int.
     */
    public static int getIntProperty(String name, int fallbackValue) {
        String value = getProperty(name, String.valueOf(fallbackValue));
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

    /**
     * <p>getLongProperty.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @return a long.
     */
    public static long getLongProperty(String name) {
        String value = getProperty(name);
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

    /**
     * <p>getProperty.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String getProperty(String name) {
        return getProperty(name, null);
    }

    /**
     * <p>getProperty.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param fallbackValue a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String getProperty(String name, String fallbackValue) {
        String value;
        try {
            value = System.getProperty(name, fallbackValue);
            if (null == value) {
                value = defaultProperty.getProperty(name);
            }
            if (null == value) {
                String fallback = defaultProperty.getProperty(name + ".fallback");
                if (null != fallback) {
                    value = System.getProperty(fallback);
                }
            }
        } catch (AccessControlException ace) {
            // Unsigned applet cannot access System properties
            value = fallbackValue;
        }
        return replace(value);
    }

    private static String replace(String value) {
        if (null == value) {
            return value;
        }
        String newValue = value;
        int openBrace = 0;
        if (-1 != (openBrace = value.indexOf("{", openBrace))) {
            int closeBrace = value.indexOf("}", openBrace);
            if (closeBrace > (openBrace + 1)) {
                String name = value.substring(openBrace + 1, closeBrace);
                if (name.length() > 0) {
                    newValue = value.substring(0, openBrace) + getProperty(name)
                            + value.substring(closeBrace + 1);

                }
            }
        }
        if (newValue.equals(value)) {
            return value;
        } else {
            return replace(newValue);
        }
    }

    /**
     * <p>getNumberOfAsyncThreads.</p>
     *
     * @return a int.
     */
    public static int getNumberOfAsyncThreads() {
        return getIntProperty("weibo4j.async.numThreads");
    }

    /**
     * <p>getDebug.</p>
     *
     * @return a boolean.
     */
    public static boolean getDebug() {
        return getBoolean("weibo4j.debug");

    }
}
