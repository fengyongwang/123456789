package com.merchant.vo.reginon.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/4
 */
@Data
@ApiModel
public class ReginonVO {

    /**
     * 地区名字
     */
    @ApiModelProperty(value = "地区名字")
    private String areaName;

    @ApiModelProperty(value = "地区id")
    private Integer areaId;
}
