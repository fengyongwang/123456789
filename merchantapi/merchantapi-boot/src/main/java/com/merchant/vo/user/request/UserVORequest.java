package com.merchant.vo.user.request;

import com.merchant.data.vo.request.CommonRequestVO;
import com.merchant.group.Login;
import com.merchant.group.Registered;
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
    @NotBlank(groups = {Registered.class})
    private String phone;

    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    @NotBlank(groups = {Registered.class,Login.class})
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty(value="密码")
    @NotBlank(groups = {Registered.class, Login.class})
    private String passWord;

    /**
     * 重复密码
     */
    @ApiModelProperty(value="重复密码")
    @NotBlank(groups = {Registered.class})
    private String repeatPassWord;

    /**
     * 验证码
     */
    @ApiModelProperty(value="验证码")
    @NotBlank(groups = {Registered.class})
    private String code;

}
