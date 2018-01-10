package com.platform.admin.common.page;


import java.io.Serializable;

/**
 * Created by yankun on 2015/12/19 0019.
 */
public class PageBean implements Serializable {
    private Integer start;
    private Integer limit = 30;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
