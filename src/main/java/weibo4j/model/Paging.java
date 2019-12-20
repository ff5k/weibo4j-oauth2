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

/**
 * Controlls pagination
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @version $Id: $Id
 */
public class Paging implements java.io.Serializable {
	private static final long serialVersionUID = -3285857427993796670L;
   
	private int page = -1;              //页码。注意：最多返回200条分页内容。
    private int count = -1;             //指定每页返回的记录条数。
    private long sinceId = -1;          //若指定此参数，则只返回ID比since_id大（即比since_id发表时间晚的）的微博消息。
    private long maxId = -1;            //若指定此参数，则返回ID小于或等于max_id的微博消息

    /**
     * <p>Constructor for Paging.</p>
     */
    public Paging() {
    }

    /**
     * <p>Constructor for Paging.</p>
     *
     * @param page a int.
     */
    public Paging(int page) {
        setPage(page);
    }

    /**
     * <p>Constructor for Paging.</p>
     *
     * @param sinceId a long.
     */
    public Paging(long sinceId) {
        setSinceId(sinceId);
    }

    /**
     * <p>Constructor for Paging.</p>
     *
     * @param page a int.
     * @param count a int.
     */
    public Paging(int page, int count) {
        this(page);
        setCount(count);
    }
    /**
     * <p>Constructor for Paging.</p>
     *
     * @param page a int.
     * @param sinceId a long.
     */
    public Paging(int page, long sinceId) {
        this(page);
        setSinceId(sinceId);
    }

    /**
     * <p>Constructor for Paging.</p>
     *
     * @param page a int.
     * @param count a int.
     * @param sinceId a long.
     */
    public Paging(int page, int count, long sinceId) {
        this(page, count);
        setSinceId(sinceId);
    }

    /**
     * <p>Constructor for Paging.</p>
     *
     * @param page a int.
     * @param count a int.
     * @param sinceId a long.
     * @param maxId a long.
     */
    public Paging(int page, int count, long sinceId, long maxId) {
        this(page, count, sinceId);
        setMaxId(maxId);
    }

    /**
     * <p>Getter for the field <code>page</code>.</p>
     *
     * @return a int.
     */
    public int getPage() {
        return page;
    }

    /**
     * <p>Setter for the field <code>page</code>.</p>
     *
     * @param page a int.
     */
    public void setPage(int page) {
        if (page < 1) {
            throw new IllegalArgumentException("page should be positive integer. passed:" + page);
        }
        this.page = page;
    }

    /**
     * <p>Getter for the field <code>count</code>.</p>
     *
     * @return a int.
     */
    public int getCount() {
        return count;
    }

    /**
     * <p>Setter for the field <code>count</code>.</p>
     *
     * @param count a int.
     */
    public void setCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("count should be positive integer. passed:" + count);
        }
        this.count = count;
    }

    /**
     * <p>count.</p>
     *
     * @param count a int.
     * @return a {@link weibo4j.model.Paging} object.
     */
    public Paging count(int count) {
        setCount(count);
        return this;
    }

    /**
     * <p>Getter for the field <code>sinceId</code>.</p>
     *
     * @return a long.
     */
    public long getSinceId() {
        return sinceId;
    }

    /**
     * <p>Setter for the field <code>sinceId</code>.</p>
     *
     * @param sinceId a int.
     */
    public void setSinceId(int sinceId) {
        if (sinceId < 1) {
            throw new IllegalArgumentException("since_id should be positive integer. passed:" + sinceId);
        }
        this.sinceId = sinceId;
    }

    /**
     * <p>sinceId.</p>
     *
     * @param sinceId a int.
     * @return a {@link weibo4j.model.Paging} object.
     */
    public Paging sinceId(int sinceId) {
        setSinceId(sinceId);
        return this;
    }

    /**
     * <p>Setter for the field <code>sinceId</code>.</p>
     *
     * @param sinceId a long.
     */
    public void setSinceId(long sinceId) {
        if (sinceId < 1) {
            throw new IllegalArgumentException("since_id should be positive integer. passed:" + sinceId);
        }
        this.sinceId = sinceId;
    }

    /**
     * <p>sinceId.</p>
     *
     * @param sinceId a long.
     * @return a {@link weibo4j.model.Paging} object.
     */
    public Paging sinceId(long sinceId) {
        setSinceId(sinceId);
        return this;
    }

    /**
     * <p>Getter for the field <code>maxId</code>.</p>
     *
     * @return a long.
     */
    public long getMaxId() {
        return maxId;
    }

    /**
     * <p>Setter for the field <code>maxId</code>.</p>
     *
     * @param maxId a long.
     */
    public void setMaxId(long maxId) {
        if (maxId < 1) {
            throw new IllegalArgumentException("max_id should be positive integer. passed:" + maxId);
        }
        this.maxId = maxId;
    }

    /**
     * <p>maxId.</p>
     *
     * @param maxId a long.
     * @return a {@link weibo4j.model.Paging} object.
     */
    public Paging maxId(long maxId) {
        setMaxId(maxId);
        return this;
    }
}
