package com.homefun.wpj.damain;

import java.util.List;

/**
 * Name：JqGridResult
 * Time：2016/9/2 10:07
 * author：WPJ587
 * description：JqGrid 前端插件的响应结果
 **/

public class JqGridResult<T> extends BaseDamain {
    private static final long serialVersionUID = 4384948086998510887L;
    /**
     * 查询出的记录数
     */
    private long records;
    /**
     * 当前页
     */
    private int page;
    /**
     * 总页数

     */
    private  int total;
    /**
     *
     */
    private List<T> rows;

    public JqGridResult(long records, int page, int total, List<T> rows) {
        this.records = records;
        this.page = page;
        this.total = total;
        this.rows = rows;
    }

    public JqGridResult() {
    }



    public long getRecords() {
        return records;
    }

    public void setRecords(long records) {
        this.records = records;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
