package com.customer.vo.order.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/27
 */
@Data
@ApiModel
public class OrderCheapDetailParamVO {


    /**
     * 优惠描述
     */
    @ApiModelProperty("优惠描述 用了优惠则必填")
    private String cheapDescription;

    /**
     *  优惠金额
     */
    @ApiModelProperty("优惠金额 用了优惠则必填")
    private String cheapMoney;
}
