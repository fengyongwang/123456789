package com.merchant.user.bo.request.user;

import com.merchant.bo.CommonBORequest;
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
     * 类型 客户100or商家200
     */
    private Integer type;

    /**
     * 验证码
     */
    private String code;


}
