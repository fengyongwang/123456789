package com.merchant.vo.shop.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/13
 */
@Data
@ApiModel
public class TotalCommodityVO {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 商品分类得名称
     */
    @ApiModelProperty(value = "商品分类得名称")
    private String commodityTypeName;

}
