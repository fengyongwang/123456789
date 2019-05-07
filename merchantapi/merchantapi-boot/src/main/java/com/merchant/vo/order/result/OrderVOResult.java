package com.merchant.vo.order.result;

import com.merchant.data.vo.result.CommonResultVO;
import com.merchant.vo.order.data.OrderVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/7
 */
@Data
@ApiModel
public class OrderVOResult extends CommonResultVO {

    /**
     * 订单列表
     */
    @ApiModelProperty(value = "订单列表")
    private List<OrderVO> orderList;

}
