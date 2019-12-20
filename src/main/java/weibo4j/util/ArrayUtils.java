package weibo4j.util;

import java.util.Iterator;
import java.util.Map;

import weibo4j.model.PostParameter;

/**
 * <p>ArrayUtils class.</p>
 *
 * @author user1
 * @version $Id: $Id
 */
public class ArrayUtils {

	/**
	 * <p>mapToArray.</p>
	 *
	 * @param map a {@link java.util.Map} object.
	 * @return an array of {@link weibo4j.model.PostParameter} objects.
	 */
	public static PostParameter[] mapToArray(Map<String, String> map) {
		PostParameter[] parList = new PostParameter[map.size()];
		Iterator<String> iter = map.keySet().iterator();
		int i = 0;
		while (iter.hasNext()) {
			String key = iter.next();
			String value = map.get(key);
			parList[i++] = new PostParameter(key, value);
		}
		return parList;
	}
	
}
