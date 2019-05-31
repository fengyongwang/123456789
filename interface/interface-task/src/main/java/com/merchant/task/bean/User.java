package com.merchant.task.bean;

import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/30
 */
@Data
public class User {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;

    /**
     * 类型 客户or商家
     */
    private Integer type;

}
