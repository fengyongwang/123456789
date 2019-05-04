package com.merchant.vo.shop.data;

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
public class ShopCommodityVO {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;
    /**
     * 商铺id
     */
    @ApiModelProperty(value = "商铺id")
    private Integer shopId;

    /**
     * 总的商品分类id
     */
    @ApiModelProperty(value = "总的商品分类id")
    private Integer totalCommodityId;
    /**
     * 这个商品的名称
     */
    @ApiModelProperty(value = "这个商品的名称")
    private String commodityName;
    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    private Double unitPrice;

    /**
     * 库存
     */
    @ApiModelProperty(value = "库存")
    private Integer stock;
    /**
     * 每月销售数量
     */
    @ApiModelProperty(value = "每月销售数量")
    private Integer monthSaleNumber;

    /**
     * 每月销售金额
     */
    @ApiModelProperty(value = "每月销售金额")
    private Double monthSalePrice;
    /**
     * 销售总量
     */
    @ApiModelProperty(value = "销售总量")
    private Integer totalSaleNumber;
    /**
     * 销售总金额
     */
    @ApiModelProperty(value = "销售总金额")
    private Double totalSalePrice;
    /**
     * 门店图片
     */
    @ApiModelProperty(value = "门店图片")
    private String imageUrl;
    /**
     * 门店描述
     */
    @ApiModelProperty(value = "门店描述")
    private String commodityDescription;


}
