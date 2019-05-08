package com.merchant.po.data;

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
 * @date 2019/5/5
 */
@Data
@ToString
@TableName(value = "t_yf_region")
public class Reginon {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 地区名称
     */
    private String regionName;
    /**
     * 地区名称简写
     */
    private String regionShortName;
    /**
     * 地区编码
     */
    private String regionCode;

    /**
     * 地区父code
     */
    private String regionParentId;
    /**
     * 地区级别 1：省级别，2：市级别，3：区级别
     */
    private Integer regionLevel;

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
