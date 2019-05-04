package com.merchant.data.po.request;


/**
 * Description: po 查询条件基类
 *
 * @author wangyf
 * @date 2019/4/27
 */

public class CommonRequestPO {

    /**
     * 表示查询的页码,页码从0开始计算
     */
    private int page = 0;

    /**
     * 表示每页的个数。
     */
    private int pageSize = 10;

    /**
     * 表示开始查询的索引号
     */
    private int start = -1;

    /**
     * 表示查询是否分页。
     * 如果值为true，表示结果分页；
     * 如果结果不为true，则结果不分页，取所有结果。
     */
    private boolean paging = true;


    /**
     * 如果需要分页，可以通过该方法获得该页的第一个数据的行数
     *
     * 判断的条件是 >= getStart
     *
     */
    public int getStart() {
        if( start < 0 ){
            return page * pageSize;
        }else{
            return start;
        }
    }

    /**
     * 设置查询的开始索引
     * @param start
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * 如果需要分页，可以通过该方法获得该页的最后一个数据的下一行的行数
     *
     * 判断条件是 < getEnd
     *
     * @return
     */
    public int getEnd() {
        return (page + 1) * pageSize;
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isPaging() {
        return paging;
    }

    public boolean getIsPaging() {
        return paging;
    }

    public void setPaging(boolean paging) {
        this.paging = paging;
    }



}
