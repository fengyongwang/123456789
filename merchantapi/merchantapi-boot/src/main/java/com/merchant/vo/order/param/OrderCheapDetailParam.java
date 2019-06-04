package com.merchant.vo.order.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/6/3
 */
@Data
@ApiModel
public class OrderCheapDetailParam implements Serializable {

    private static final long serialVersionUID = 6117998324217605901L;
    /**
     * 优惠描述
     */
    @ApiModelProperty("优惠描述")
    private String cheapDescription;

    /**
     *  优惠金额
     */
    @ApiModelProperty("优惠金额")
    private String cheapMoney;

}
