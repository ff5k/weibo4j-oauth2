package weibo4j.model;

/**
 * <p>Gender class.</p>
 *
 * @author SinaWeibo
 * @version $Id: $Id
 */
public enum Gender {
	MALE, FEMALE;
	/**
	 * <p>valueOf.</p>
	 *
	 * @param gender a {@link weibo4j.model.Gender} object.
	 * @return a {@link java.lang.String} object.
	 */
	public static String valueOf(Gender gender) {
		int ordinal= gender.ordinal();
		if(ordinal==0)
			return "m";
		return "f";
	}
}
