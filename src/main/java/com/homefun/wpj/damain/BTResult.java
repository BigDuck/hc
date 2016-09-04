package com.homefun.wpj.damain;

import java.util.List;

/**
 * Name：JqGridResult
 * Time：2016/9/2 10:07
 * author：WPJ587
 * description：BTResult 前端插件的响应结果
 **/

public class BTResult<T> extends BaseDamain {
    private static final long serialVersionUID = 4384948086998510887L;

    /**
     * 当前页
     */
    private int page;
    /**
     * 总记录

     */
    private  long total;
    /**
     *
     */
    private List<T> rows;

    public BTResult(int page, int total, List<T> rows) {
        this.page = page;
        this.total = total;
        this.rows = rows;
    }

    public BTResult() {
    }





    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
