package com.merchant.vo.reginon.request;

import com.merchant.data.vo.request.CommonRequestVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/4
 */
@Data
@ApiModel
public class ReginonVORequest extends CommonRequestVO {

    /**
     * 地区父code
     */
    @ApiModelProperty(value = "地区父code 如果查省父id为-1 必填")
    @NotBlank
    private String regionParentId;




}
