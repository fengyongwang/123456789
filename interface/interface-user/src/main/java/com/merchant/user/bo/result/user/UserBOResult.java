package com.merchant.user.bo.result.user;

import com.merchant.bo.CommonBOResult;
import lombok.Data;

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
