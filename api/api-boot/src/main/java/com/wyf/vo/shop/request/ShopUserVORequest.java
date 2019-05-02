package com.wyf.vo.shop.request;

import com.wyf.data.vo.request.CommonRequestVO;
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
public class ShopUserVORequest extends CommonRequestVO {

    /**
     * 商铺名称
     */
    @ApiModelProperty(value = "商铺名称 必填")
    @NotBlank
    private String shopName;

    /**
     * 商铺地址
     */
    @ApiModelProperty(value = "商铺地址 必填")
    @NotBlank
    private String shopAddress;
    /**
     * 商铺联系人
     */
    @ApiModelProperty(value = "商铺联系人 必填")
    @NotBlank
    private String shopContact;
    /**
     * 商铺电话
     */
    @ApiModelProperty(value = "商铺电话 必填")
    @NotBlank
    private String shopPhone;

}
