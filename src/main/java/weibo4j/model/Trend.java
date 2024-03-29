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

import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * A data class representing Treand.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Weibo4J 1.2.1
 * @version $Id: $Id
 */
public class Trend implements java.io.Serializable{
    private String name;
    private String query = null;
    private long amount;
    private long delta;
    private static final long serialVersionUID = 1925956704460743946L;

    /**
     * <p>Constructor for Trend.</p>
     *
     * @param json a {@link weibo4j.org.json.JSONObject} object.
     * @throws weibo4j.org.json.JSONException if any.
     */
    public Trend(JSONObject json) throws JSONException {
        this.name = json.getString("name");
        if (!json.isNull("query")) {
            this.query = json.getString("query");
        }
        this.amount =json.getLong("amount");
        this.delta = json.getLong("delta");
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
     * <p>Getter for the field <code>query</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getQuery() {
        return query;
    }

    /**
     * <p>Getter for the field <code>amount</code>.</p>
     *
     * @return a long.
     */
    public long getAmount() {
		return amount;
	}

	/**
	 * <p>Setter for the field <code>amount</code>.</p>
	 *
	 * @param amount a long.
	 */
	public void setAmount(long amount) {
		this.amount = amount;
	}

	/**
	 * <p>Getter for the field <code>delta</code>.</p>
	 *
	 * @return a long.
	 */
	public long getDelta() {
		return delta;
	}

	/**
	 * <p>Setter for the field <code>delta</code>.</p>
	 *
	 * @param delta a long.
	 */
	public void setDelta(long delta) {
		this.delta = delta;
	}

	/**
	 * <p>Setter for the field <code>name</code>.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <p>Setter for the field <code>query</code>.</p>
	 *
	 * @param query a {@link java.lang.String} object.
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/** {@inheritDoc} */
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trend)) return false;

        Trend trend = (Trend) o;

        if (!name.equals(trend.name)) return false;
        if (query != null ? !query.equals(trend.query) : trend.query != null)
            return false;

        return true;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (query != null ? query.hashCode() : 0);
        return result;
    }

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Trend [name=" + name + ", query=" + query + ", amount="
				+ amount + ", delta=" + delta + "]";
	}
    
}
