package com.merchant.vo.user.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/1
 */
@Data
@ApiModel
public class UserVO {

    /**
     * 主键id
     */
    @ApiModelProperty(value="主键id")
    private Integer id;
    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private String phone;

    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty(value="密码")
    private String passWord;

    /**
     * 类型 客户100or商家200
     */
    @ApiModelProperty(value="类型 客户100or商家200")
    private Integer type;

}
