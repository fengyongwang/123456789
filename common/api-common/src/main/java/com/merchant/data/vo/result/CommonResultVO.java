package com.merchant.data.vo.result;

import com.merchant.user.util.ResultConstant;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/27
 */
public class CommonResultVO {

    /**
     * 请求的返回代码，成功200，失败400
     */
    private int code;

    /**
     * 请求的返回信息
     */
    private String message;

    /**
     * 表示当前查询的数量
     */
    private int count;

    /**
     * 表示查询的总数
     */
    private long totalCount;

    /**
     * 返回页码数，在进行查询时，通过该参数可以让客户端知道该次的数据返回的是第几页的内容
     */
    private int page;


    public CommonResultVO() {
        this.code = ResultConstant.CODE.ERROR;
        this.message = ResultConstant.MESSAGE.DEFAULT_ERROR_MESSAGE;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }


}
