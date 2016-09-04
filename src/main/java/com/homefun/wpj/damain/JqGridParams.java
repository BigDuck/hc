package com.homefun.wpj.damain;

/**
 * Name：JqGridParams
 * Time：2016/9/2 10:17
 * author：WPJ587
 * description：jqGrid请求参数
 **/

public class JqGridParams extends BaseDamain {
    private static final long serialVersionUID = 1394774679825116764L;
    /**
     * 查询的参数
     */
    private String qwery;
    /**
     * 是否是插叙
     */
    private boolean _search = false;
    /**
     * 每页行数 默认10条数据
     */
    private int rows=10;
    /**
     * 需要的页码 第一页
     */
    private int page=1;
    /**
     排序时的参数，那个参数要排序的意思
     */
    private String sidx;
    /**
     * 排序的方式
     */
    private String sord="asc";

    public String getQwery() {
        return qwery;
    }

    public void setQwery(String qwery) {
        this.qwery = qwery;
    }

    public boolean is_search() {
        return _search;
    }

    public void set_search(boolean _search) {
        this._search = _search;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }
}
