package com.merchant.shop.bo.result;

import com.merchant.bo.CommonBOResult;
import com.merchant.shop.bo.data.ReginonBO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/8
 */
@Data
public class ReginonBOResult extends CommonBOResult {


    /**
     * 地区信息列表
     */
    @ApiModelProperty(value = "地区信息列表")
    private List<ReginonBO> reginonList;

}
