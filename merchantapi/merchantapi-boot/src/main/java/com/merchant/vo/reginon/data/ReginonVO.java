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
    private String regionName;


    /**
     * 行政地区编号
     */
    @ApiModelProperty(value = "行政地区编号")
    private String regionCode;

}
