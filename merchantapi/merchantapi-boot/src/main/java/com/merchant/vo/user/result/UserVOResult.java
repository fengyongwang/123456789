package com.merchant.vo.user.result;

import com.merchant.data.vo.result.CommonResultVO;
import com.merchant.vo.user.data.UserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/1
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel
public class UserVOResult extends CommonResultVO {


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
     * 类型 客户100or商家200
     */
    @ApiModelProperty(value="类型 客户100or商家200")
    private Integer type;

    /**
     * token 信息
     */
    @ApiModelProperty(value = "token信息")
    private String token;

}
