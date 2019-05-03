package com.wyf.vo.shop.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/3
 */
@Data
@ApiModel
public class CommodityVO {

    /**
     * 商品类型主键id
     */
    @ApiModelProperty(value = "商品类型主键id")
    private Integer id;

    /**
     * 商品类型名称
     */
    @ApiModelProperty(value = "商品类型名称")
    private String commodityTypeName;
}
