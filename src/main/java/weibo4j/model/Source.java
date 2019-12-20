package weibo4j.model;

/**
 * <p>Source class.</p>
 *
 * @author user1
 * @version $Id: $Id
 */
public class Source implements java.io.Serializable{

	private static final long serialVersionUID = -8972443458374235866L;
    private String url;               //来源连接
    private String relationShip;      
    private String name;              //来源文案名称
	/**
	 * <p>Constructor for Source.</p>
	 *
	 * @param str a {@link java.lang.String} object.
	 */
	public Source(String str) {
		super();
		String[] source = str.split("\"",5);
        url = source[1];
        relationShip = source[3];
        name = source[4].replace(">", "").replace("</a", "");
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
	 * <p>Setter for the field <code>url</code>.</p>
	 *
	 * @param url a {@link java.lang.String} object.
	 */
	public void setUrl(String url) {
		this.url = url;
	}


	/**
	 * <p>getRelationship.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getRelationship() {
		return relationShip;
	}


	/**
	 * <p>setRelationship.</p>
	 *
	 * @param relationShip a {@link java.lang.String} object.
	 */
	public void setRelationship(String relationShip) {
		this.relationShip = relationShip;
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
	 * <p>Setter for the field <code>name</code>.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 */
	public void setName(String name) {
		this.name = name;
	}

    
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Source [url=" + url + ", relationShip=" + relationShip
				+ ", name=" + name + "]";
	}


}
