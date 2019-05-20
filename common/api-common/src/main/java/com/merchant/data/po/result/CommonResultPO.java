package com.merchant.data.po.result;

import com.merchant.user.util.ResultConstant;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:  po  查询结果基类
 *
 * @author wangyf
 * @date 2019/4/27
 */
public class CommonResultPO <T> {

    /**
     * 表示返回结果的状态（成功、延时等等）
     */
    private int status;

    /**
     * 表示当前操作的数量
     */
    private int count;

    /**
     * 表示操作的总数
     */
    private long totalCount;

    /**
     * 表示出现的异常
     */
    private Exception exception;

    /**
     * 异常信息
     */
    private String message;

    /**
     * 返回页码数，在进行查询时，通过该参数可以让客户端知道该次的数据返回的是第几页的内容。
     */
    private int page;

    /**
     * 实际持有的对象列表
     */
    private final List<T> values;

    /**
     * 构造一个新的Result实例,当前处于默认的未处理状态.
     */
    public CommonResultPO() {
        values = new LinkedList<>();
        this.message = ResultConstant.MESSAGE.DEFAULT_ERROR_MESSAGE;
        this.status = ResultConstant.CODE.ERROR;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    /**
     * 返回当前Result实例持有的所有元素.
     * 返回的为内部元素的只读视图.
     * <p>
     * @return 元素列表只读视图..
     */
    public List<T> getValues() {
        if (this.values != null) {
            List<T> result = new ArrayList<>();
            result.addAll(this.values);
            return result;
        }
        return this.values;
    }

    /**
     * 设置Result实例持有的所有元素。
     * <p>
     */
    public void setValues(List<T> values) {
        if (this.values.size() > 0) {
            this.values.clear();
        }
        this.values.addAll(values);
    }

    /**
     * 返回当前实例持有的首个对象.
     * <p>
     * @return 首个对象.如果没有持有元素,返回NULL.
     */
    public T getValue() {
        if (values.isEmpty()) {
            return null;
        } else {
            return values.get(0);
        }
    }

    /**
     * 将一个元素交给result实例.
     * <p>
     * @param newValue 新的元素.
     */
    public void addValue(T newValue) {
        values.add(newValue);
    }

    /**
     * 判断是否为正确响应.
     * @return true正确,false不正确.
     */
    public boolean isSuccess() {
        return getStatus() == ResultConstant.CODE.SUCCESS;
    }


}
