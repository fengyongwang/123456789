package com.merchant.user.bo.user.result;

import com.merchant.user.bo.CommonBOResult;
import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/1
 */
@Data
public class UserBOResult extends CommonBOResult {


    /**
     * 主键id
     */
    private Integer id;
    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 类型 客户100or商家200
     */
    private Integer type;

    /**
     * token 信息
     */
    private String token;

}
