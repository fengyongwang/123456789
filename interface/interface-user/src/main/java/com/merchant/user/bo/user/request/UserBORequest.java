package com.merchant.user.bo.user.request;

import com.merchant.user.bo.CommonBORequest;
import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/1
 */
@Data
public class UserBORequest extends CommonBORequest {

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
     * 重复密码
     */
    private String repeatPassWord;

    /**
     * 类型 客户or商家
     */
    private Integer type;

    /**
     * 验证码
     */
    private String code;


}
