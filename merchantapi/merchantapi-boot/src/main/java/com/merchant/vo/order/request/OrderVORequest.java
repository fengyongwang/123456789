package com.merchant.vo.order.request;

import com.merchant.data.vo.request.CommonRequestVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/7
 */
@Data
@ApiModel
public class OrderVORequest extends CommonRequestVO {

    /**
     * 商铺id
     */
    @ApiModelProperty(value = "商铺id 非手填，查必传，修改必传")
    private Integer shopId;

    /**
     * 订单状态
     */
    @ApiModelProperty(value = "订单状态 查不传，修改必填且只能从已付款修改成已发货")
    private String orderStatus;
}
