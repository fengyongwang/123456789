package com.wyf.user.po.data;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;


/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/27
 */
@Data
@ToString
@TableName(value = "t_yf_user")
public class User {
    /**
     *主键id
     */
    @TableId
    private Integer id;

    /**
     * 名称  如果是客户就是客户名称，手机号登录默认手机号，微信授权登录为微信昵称
     *       如果是商家默认为null
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 类型   客户为1，商家为0
     */
    private Integer type;
    /**
     * 用户名  系统的后台服务用户名
     */
    private String userName;
    /**
     * 密码  系统的后台服务用户密码
     */
    private String passWord;
    /**
     *头像url  手机号码登录  默认头像
     *          微信授权登录  微信头像
     */
    private String avatarUrl;
    /**
     * 商户邀请码
     */
    private String referralCode;
    /**
     * 商户的唯一编码
     */
    private String otherReferralCode;
    /**
     * 商户的唯一编码是否修改
     */
    private Integer modifyNumber;
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
     * 修改者
     */
    private String modifyBy;
    /**
     * 创建者
     */
    private String createBy;

}
