package weibo4j.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * <p>WeiboConfig class.</p>
 *
 * @author user1
 * @version $Id: $Id
 */
public class WeiboConfig {
	/**
	 * <p>Constructor for WeiboConfig.</p>
	 */
	public WeiboConfig(){}
	private static Properties props = new Properties(); 
	static{
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * <p>getValue.</p>
	 *
	 * @param key a {@link java.lang.String} object.
	 * @return a {@link java.lang.String} object.
	 */
	public static String getValue(String key){
		return props.getProperty(key);
	}

    /**
     * <p>updateProperties.</p>
     *
     * @param key a {@link java.lang.String} object.
     * @param value a {@link java.lang.String} object.
     */
    public static void updateProperties(String key,String value) {    
            props.setProperty(key, value); 
    } 
}
