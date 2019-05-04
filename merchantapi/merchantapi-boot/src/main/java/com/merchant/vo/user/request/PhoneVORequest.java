package com.merchant.vo.user.request;

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
public class PhoneVORequest extends CommonRequestVO {

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码必填")
    @NotBlank
    private String phone;

}
