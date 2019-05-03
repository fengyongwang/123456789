package com.wyf.vo.shop.request;

import com.wyf.data.vo.request.CommonRequestVO;
import com.wyf.group.Delete;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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


    @ApiModelProperty(value = "商铺id 关门必填，查询不填")
    @NotNull(groups = {Delete.class})
    private Integer shopId;

    /**
     * 商铺名称
     */
    @ApiModelProperty(value = "商铺名称 查询选填")
    private String shopName;

    /**
     * 商铺地址
     */
    @ApiModelProperty(value = "商铺地址 查询选填")
    private String shopAddress;
    /**
     * 商铺联系人
     */
    @ApiModelProperty(value = "商铺联系人 查询选填")
    private String shopContact;
    /**
     * 商铺电话
     */
    @ApiModelProperty(value = "商铺电话 查询选填")
    private String shopPhone;

}
