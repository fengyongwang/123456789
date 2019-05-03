package com.wyf.vo.shop.result;

import com.wyf.data.vo.result.CommonResultVO;
import com.wyf.vo.shop.data.CommodityVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/3
 */
@Data
@ApiModel
public class CommodityVOResult extends CommonResultVO {

    /**
     *所有商品类型得集合
     */
    @ApiModelProperty(value = "所有商品类型得集合")
    private List<CommodityVO> commodityList;

}
