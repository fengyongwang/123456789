package com.merchant.vo.shop.request;

import com.merchant.data.vo.request.CommonRequestVO;
import com.merchant.group.Delete;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/4
 */
@Data
@ApiModel
public class ShopCommodityVORequest extends CommonRequestVO {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id，下架时必传")
    @NotNull(groups = {Delete.class})
    private Integer id;
    /**
     * 最大单价
     */
    @ApiModelProperty(value = "最大单价")
    private Double maxUnitPrice;
    /**
     * 最小单价
     */
    @ApiModelProperty(value = "最小单价")
    private Double minUnitPrice;
    /**
     * 最大库存
     */
    @ApiModelProperty(value = "最大库存")
    private Integer maxStock;
    /**
     * 最小库存
     */
    @ApiModelProperty(value = "最小库存")
    private Integer minStock;
    /**
     * 最大月销量
     */
    @ApiModelProperty(value = "最大月销量")
    private Integer maxMonthSaleNumber;
    /**
     * 最小月销量
     */
    @ApiModelProperty(value = "最小月销量")
    private Integer minMonthSaleNumber;
    /**
     * 最大总销量
     */
    @ApiModelProperty(value = "最大总销量")
    private Integer maxTotalSaleNumber;
    /**
     * 最小总销量
     */
    @ApiModelProperty(value = "最小总销量")
    private Integer minTotalSaleNumber;
}
