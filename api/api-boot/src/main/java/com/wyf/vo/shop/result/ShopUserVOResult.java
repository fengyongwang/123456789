package com.wyf.vo.shop.result;

import com.wyf.data.vo.result.CommonResultVO;
import com.wyf.vo.shop.data.ShopUserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/2
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel
public class ShopUserVOResult extends CommonResultVO {

    /**
     * 所有商家得商铺
     */
    @ApiModelProperty(value = "所有商家得商铺")
    private List<ShopUserVO> shopUserList;

}
