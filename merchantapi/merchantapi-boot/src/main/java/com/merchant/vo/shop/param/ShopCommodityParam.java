package com.merchant.vo.shop.param;

import com.merchant.group.Create;
import com.merchant.group.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/3
 */
@Data
@ApiModel
public class ShopCommodityParam  {

    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id 修改必填，增加不填")
    @NotNull(groups = {Update.class})
    private Integer id;


    /**
     * 总的商品分类id
     */
    @ApiModelProperty(value = "总的商品分类id 增必填,改是查询后后台传过来原样传回去")
    @NotNull(groups = {Create.class, Update.class})
    private Integer totalCommodityId;
    /**
     * 这个商品的名称
     */
    @ApiModelProperty(value = "这个商品的名称 增必填,改是查询后后台传过来原样传回去")
    @NotBlank(groups = {Create.class, Update.class})
    private String commodityName;
    /**
     * 单价
     */
    @ApiModelProperty(value = "单价 必填")
    @NotBlank(groups = {Create.class,Update.class})
    private Double unitPrice;

    /**
     * 库存
     */
    @ApiModelProperty(value = "库存 必填")
    @NotBlank(groups = {Create.class,Update.class})
    private Integer stock;

    /**
     * 门店图片
     */
    @ApiModelProperty(value = "门店图片 必填")
    @NotBlank(groups = {Create.class,Update.class})
    private String imageUrl;
    /**
     * 门店描述
     */
    @ApiModelProperty(value = "门店描述 必填")
    @NotBlank(groups = {Create.class,Update.class})
    private String commodityDescription;

}
