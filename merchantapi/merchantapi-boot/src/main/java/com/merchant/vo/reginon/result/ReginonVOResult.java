package com.merchant.vo.reginon.result;

import com.merchant.data.vo.result.CommonResultVO;
import com.merchant.vo.reginon.data.ReginonVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/4
 */
@Data
@ApiModel
public class ReginonVOResult extends CommonResultVO {

    /**
     * 省市区信息集合
     */
    @ApiModelProperty(value = "省市区信息集合")
    private List<ReginonVO> reginonList;

}
