package com.wyf.vo.request.user;

import com.wyf.data.vo.request.CommonRequestVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/29
 */
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel
public class LoginVORequest extends CommonRequestVO {


    /**
     * 系统后台服务管理者
     * 用户名
     */
    @ApiModelProperty(value="系统后台服务管理者 用户名")
    private String userName;

    /**
     * 系统后台服务管理者
     * 用户密码
     */
    @ApiModelProperty(value="系统后台服务管理者 用户密码")
    private String passWord;

    /**
     * 手机号
     * 商家：获取手机验证码  必填
     *       手机号码登录   必填
     *      登出        不填
     *
     *
     * 客户：获取手机验证码  必填
     *       手机号码登录   必填
     *       登出        不填
     */
    @ApiModelProperty(value="手机号")
    private String phone;




    /**
     * 验证码
     * 商家：获取手机验证码  不填
     *       手机号码登录   必填
     *      登出        不填
     *
     *
     * 客户：获取手机验证码  不填
     *       手机号码登录   必填
     *       登出        不填
     */
    @ApiModelProperty(value="验证码")
    private String code;

    /**
     * 身份  枚举值  商家1，客户0
     */
    @ApiModelProperty(value="身份 枚举值 商家1，客户0")
    private Integer identity;

    /**
     * 登录类型  枚举值 网页登录1，APP登录0
     */
    @ApiModelProperty(value="登录类型 枚举值 网页登录1，APP登录0")
    private Integer loginType;


}
