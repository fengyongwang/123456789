package com.merchant.shop.bo.reginon.data;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/8
 */
@Data
public class ReginonBO implements Serializable {

    /**
     * 主键id
     */
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

}
