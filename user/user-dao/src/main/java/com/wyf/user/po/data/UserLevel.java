package com.wyf.user.po.data;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Description:t_yf_user_level_r   用户和等级关联表
 *
 * @author wangyf
 * @date 2019/4/29
 */
@Data
@ToString
@TableName(value = "t_yf_user_level_r")
public class UserLevel {

    /**
     * 主键id
     */
    @TableId
    private Integer id;

    /**
     * userId   用户id
     */
    private Integer userId;
    /**
     * 等级id
     */
    private Integer levelId;
    /**
     * 保持会员等级的截止时间，生成订单时产生
     */
    private Date deadlineTime;
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
