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
 * @date 2019/5/3
 */
@Data
@ApiModel
public class ShopUserVORequest extends CommonRequestVO {


    @ApiModelProperty(value = "商铺id 关门必填，查询不填")
    @NotNull(groups = {Delete.class})
    private Integer shopId;



}
