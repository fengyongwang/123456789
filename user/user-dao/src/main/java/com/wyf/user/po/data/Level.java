package com.wyf.user.po.data;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Description:t_yf_level 等级表信息
 *
 * @author wangyf
 * @date 2019/4/29
 */
@Data
@ToString
@TableName(value = "t_yf_level")
public class Level {

    /**
     * 主键id
     */
    @TableId
    private Integer id;

    /**
     * 等级名称
     */
    private String levelName;
    /**
     * 等级备注
     */
    private String remarks;
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
