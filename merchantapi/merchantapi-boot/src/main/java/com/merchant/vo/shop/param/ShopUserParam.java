package com.merchant.vo.shop.param;

import com.merchant.group.Create;
import com.merchant.group.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/3
 */
@Data
@ApiModel
public class ShopUserParam  {

    /**
     * 商铺id
     */
    @ApiModelProperty(value = "商铺id,修改必填,增不填")
    @NotBlank(groups = {Update.class})
    private Integer shopId;

    /**
     * 商铺名称
     */
    @ApiModelProperty(value = "商铺名称 增改必填")
    @NotBlank(groups = {Create.class, Update.class})
    private String shopName;

    /**
     * 商铺地址
     */
    @ApiModelProperty(value = "商铺地址 增改必填")
    @NotBlank(groups = {Create.class, Update.class})
    private String shopAddress;
    /**
     * 商铺联系人
     */
    @ApiModelProperty(value = "商铺联系人 增改必填")
    @NotBlank(groups = {Create.class, Update.class})
    private String shopContact;
    /**
     * 商铺电话
     */
    @ApiModelProperty(value = "商铺电话 增改必填")
    @NotBlank(groups = {Create.class, Update.class})
    private String shopPhone;

}
