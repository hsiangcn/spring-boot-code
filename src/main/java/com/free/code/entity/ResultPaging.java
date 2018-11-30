package com.free.code.entity;

import java.util.List;

/**
 * @ClassName ResultPaging
 * @Description TODO
 * @Author hsiangcn@sina.com
 * @Date 2018/11/30 10:48
 * @Version 1.0
 */
public class ResultPaging<T> {
    /**
     * 当前页码
     */
    private int pageNo;

    /**
     * 每页条数
     */
    private int pageSize = 10;

    /**
     * 总记录数
     */
    private int totalCount;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 结果集
     */
    private List<T> pageData;


    public ResultPaging(int totalCount, int pageNo){
        this.pageNo = pageNo;
        this.totalCount = totalCount;
        if ((this.totalCount%pageSize) == 0) {
            this.totalPage = this.totalCount / pageSize;
        } else {
            this.totalPage = this.totalCount / pageSize + 1;
        }
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (this.totalCount > 0) {
            if ((this.totalCount%pageSize) == 0) {
                this.totalPage = this.totalCount / pageSize;
            } else {
                this.totalPage = this.totalCount / pageSize + 1;
            }
        }
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if ((this.totalCount%pageSize) == 0) {
            this.totalPage = this.totalCount / pageSize;
        } else {
            this.totalPage = this.totalCount / pageSize + 1;
        }
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }
}
