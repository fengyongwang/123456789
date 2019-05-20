package com.merchant.user.bo.user.data;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/1
 */
@Data
public class UserBO implements Serializable {
    private static final long serialVersionUID = -7533170097142704887L;

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
     * 类型 客户100or商家200
     */
    private Integer type;

    /**
     * 状态
     */
    private Integer status;
    /**
     * 修改时间
     */
    private Date lastModifyTime;
    /**
     * 创建时间
     */
    private Date createTime;


    /**
     * token 信息
     */
    private String token;

}
