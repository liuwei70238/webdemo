package com.lov.entity;

/**
 * Created by liuw on 2017/1/18.
 */
public class Pager {
    private int totalRecords;//总条数
    private int pageSize; //每页条数
    private int pageNo;//第几页
    private int nextPage;//下一页
    private int bottomPageNo;//尾页
    private int previousPageNo;//前一页

    //总页数
    public int getTotalPages() {
        return (totalRecords + pageSize - 1) / pageSize;
    }


    /**
     * @return 上一页
     */
    public void setPreviousPageNo() {
        if (pageNo <= 1) {
            this.previousPageNo = 1;
        }
        this.previousPageNo = pageNo - 1;
    }

    public int getPreviousPageNo() {
        return previousPageNo;
    }

    /**
     * @return 下一页
     */
    public int getNextPageNo() {
        if (pageNo >= getBottomPageNo()) {
            return getBottomPageNo();
        }
        return pageNo + 1;
    }

    /**
     * 计算当前页开始记录
     *
     * @param pageSize    每页记录数
     * @param currentPage 当前第几页
     * @return 当前页开始记录号
     */
    public int countOffset(int currentPage, int pageSize) {
        int offset = pageSize * (currentPage - 1);
        return offset;
    }

    /**
     * @return 首页
     */
    public int getTopPageNo() {
        return 1;
    }

    public void setBottomPageNo(int bottomPageNo) {
        this.bottomPageNo = bottomPageNo;
    }
    /**
     * @return 尾页
     */
    public int getBottomPageNo() {
        return getTotalPages();
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    @Override
    public String toString() {
        return "Pager{" +
                "totalRecords=" + totalRecords +
                ", pageSize=" + pageSize +
                ", pageNo=" + pageNo +
                ", nextPage=" + nextPage +
                ", bottomPageNo=" + bottomPageNo +
                ", previousPageNo=" + previousPageNo +
                '}';
    }
}
