package weibo4j.org.json;

/**
 * The JSONException is thrown by the JSON.org classes then things are amiss.
 *
 * @author JSON.org
 * @version 2008-09-18
 */
public class JSONException extends Exception {
    private Throwable cause;

    /**
     * Constructs a JSONException with an explanatory message.
     *
     * @param message Detail about the reason for the exception.
     */
    public JSONException(String message) {
        super(message);
    }

    /**
     * <p>Constructor for JSONException.</p>
     *
     * @param t a {@link java.lang.Throwable} object.
     */
    public JSONException(Throwable t) {
        super(t.getMessage());
        this.cause = t;
    }

    /**
     * <p>Getter for the field <code>cause</code>.</p>
     *
     * @return a {@link java.lang.Throwable} object.
     */
    public Throwable getCause() {
        return this.cause;
    }
}
