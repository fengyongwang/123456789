package com.merchant.vo.shop.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/2
 */
@Data
@ApiModel
public class ShopUserVO {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;
    /**
     * 商家id
     */
    @ApiModelProperty(value = "商家id")
    private Integer userId;
    /**
     * 商铺名称
     */
    @ApiModelProperty(value = "商铺名称")
    private String shopName;
    /**
     * 商铺编码
     */
    @ApiModelProperty(value = "商铺编码")
    private String shopCode;
    /**
     * 商铺地址
     */
    @ApiModelProperty(value = "商铺地址")
    private String shopAddress;
    /**
     * 商铺联系人
     */
    @ApiModelProperty(value = "商铺联系人")
    private String shopContact;
    /**
     * 商铺电话
     */
    @ApiModelProperty(value = "商铺电话")
    private String shopPhone;


}
