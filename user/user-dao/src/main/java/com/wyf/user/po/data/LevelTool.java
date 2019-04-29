package com.wyf.user.po.data;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Description: t_yf_level_tool__r   等级与工具关联表信息
 *
 * @author wangyf
 * @date 2019/4/29
 */
@Data
@ToString
@TableName(value = "t_yf_level_tool__r")
public class LevelTool {
    /**
     * 主键id
     */
    @TableId
    private Integer id;

    /**
     * 等级id
     */
    private Integer levelId;
    /**
     * 工具id
     */
    private Integer toolId;
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
    private Integer modifyBy;
    /**
     * 创建者
     */
    private Integer createBy;


}
