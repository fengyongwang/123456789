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
     * token 信息
     */
    @ApiModelProperty(value = "token信息")
    private String token;

    /**
     * 用户信息集合
     */
    @ApiModelProperty(value = "用户信息集合")
    private List<UserVO> userList;
}
