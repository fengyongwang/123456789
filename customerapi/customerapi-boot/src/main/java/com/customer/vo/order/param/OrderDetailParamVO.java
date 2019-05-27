package com.customer.vo.order.param;

import com.customer.init.Create;
import com.customer.init.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/24
 */
@Data
@ApiModel
public class OrderDetailParamVO {

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称 必填")
    @NotBlank(groups = {Create.class, Update.class})
    private String commodityName;

    /**
     * 商品单价
     */
    @ApiModelProperty("商品单价 必填")
    @NotBlank(groups = {Create.class,Update.class})
    private String commodityUnitPrice;

    /**
     * 商品数量
     */
    @ApiModelProperty("商品数量 必填")
    @NotBlank(groups = {Create.class,Update.class})
    private String commodityCount;

}
