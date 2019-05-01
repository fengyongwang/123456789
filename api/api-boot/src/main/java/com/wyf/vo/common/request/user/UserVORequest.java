package com.wyf.vo.common.request.user;

import com.wyf.data.vo.request.CommonRequestVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/1
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel
public class UserVORequest extends CommonRequestVO {

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private String phone;

    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    @NotBlank
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty(value="密码")
    @NotBlank
    private String passWord;

    /**
     * 类型 客户100or商家200
     */
    @ApiModelProperty(value="类型 客户100or商家200")
    @NotBlank
    private Integer type;

    /**
     * 验证码
     */
    @ApiModelProperty(value="验证码")
    @NotBlank
    private String code;

}
