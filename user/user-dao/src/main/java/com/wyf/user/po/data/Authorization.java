package com.wyf.user.po.data;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Description: t_yf_authorization 表信息
 *
 * @author wangyf
 * @date 2019/4/29
 */
@Data
@ToString
@TableName(value = "t_yf_authorization")
public class Authorization {

    /**
     * 主键id
     */
    @TableId
    private Integer id;
    /**
     * 授权来源类型
     */
    private String type;
    /**
     * 授权方提供的open_iD
     */
    private String openId;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像
     */
    private String avatarUrl;
    /**
     * userID
     */
    private Integer userId;
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
