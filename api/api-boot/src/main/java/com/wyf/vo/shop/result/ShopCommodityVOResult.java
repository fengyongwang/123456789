package com.wyf.vo.shop.result;

import com.wyf.data.vo.result.CommonResultVO;
import com.wyf.vo.shop.data.ShopCommodityVO;
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
public class ShopCommodityVOResult extends CommonResultVO {

    /**
     * 商铺得商品
     */
    @ApiModelProperty("门店得商品")
    private List<ShopCommodityVO> shopCommodityList;

}
