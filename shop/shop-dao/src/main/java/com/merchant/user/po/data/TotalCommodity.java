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
 * @date 2019/5/4
 */
@Data
@ToString
@TableName(value = "t_yf_total_commodity")
public class TotalCommodity {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     *商品分类名称
     */
    private String commodityTypeName;

    /**
     * 更新时间
     */
    private Date lastModifyTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 修改者
     */
    private String modifyBy;
    /**
     * 创建者
     */
    private String createBy;

}
