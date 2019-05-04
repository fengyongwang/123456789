package com.merchant.user.po.request;

import com.merchant.data.po.request.CommonRequestPO;
import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/29
 */
@Data
public class UserRequest extends CommonRequestPO {

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
     * 密码
     */
    private String passWord;

    /**
     * 类型 客户or商家
     */
    private Integer type;

}
