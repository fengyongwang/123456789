package com.merchant.vo.shop.result;

import com.merchant.data.vo.result.CommonResultVO;
import com.merchant.vo.shop.data.TotalCommodityVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel
public class TotalCommodityVOResult extends CommonResultVO {
    /**
     * 所有得商品分类
     */
    @ApiModelProperty(value = "所有的商品分类")
    private List<TotalCommodityVO> totalCommodityList;

}
