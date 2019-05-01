package com.wyf.user.bo.result.user;

import com.wyf.bo.CommonBOResult;
import com.wyf.user.bo.data.user.UserBO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/1
 */
@Data
public class UserBOResult extends CommonBOResult {


    /**
     * token 信息
     */
    private String token;

    /**
     * 用户类型
     */
    private Integer type;

}
