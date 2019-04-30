package com.wyf.user.bo.result;

import com.wyf.bo.CommonBOResult;
import lombok.Data;
import lombok.ToString;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/30
 */
@Data
@ToString
public class LoginBOResult extends CommonBOResult {


    /**
     * token信息
     */
    private String token;

}
