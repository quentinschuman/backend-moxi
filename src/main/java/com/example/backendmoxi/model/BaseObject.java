package com.example.backendmoxi.model;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: backend-moxi
 * User: quent
 * Date: 2018/6/18
 * Time: 17:05
 */
public class BaseObject {

    private int start;
    private int end;
    private int pageCurrent;
    private int pageSize;
    private int pageCount;
    private String orderBy;

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setPageCurrent(int pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getPageCurrent() {
        return pageCurrent;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getOrderBy() {
        return orderBy;
    }
}
