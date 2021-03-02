package com.codingfuture.coding_cloud_course.vo;

import java.util.List;

public class PageData {

    private List limit;
    private Long total;

    public List getRows() {
        return limit;
    }

    public void setRows(List limit) {
        this.limit = limit;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
