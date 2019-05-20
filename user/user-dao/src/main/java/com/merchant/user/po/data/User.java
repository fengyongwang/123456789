package com.merchant.user.po.data;

import com.baomidou.mybatisplus.annotation.IdType;
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
    @TableId(type = IdType.AUTO)
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
