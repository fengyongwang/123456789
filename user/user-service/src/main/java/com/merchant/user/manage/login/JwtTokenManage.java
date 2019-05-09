package com.merchant.user.manage.login;

import com.merchant.bo.CommonBOResult;
import com.merchant.bo.token.request.TokenBORequest;
import com.merchant.bo.token.result.TokenBOResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/10
 */
public interface JwtTokenManage {

    /**校验token信息
     * @param tokenBORequest
     * @return
     */
    TokenBOResult verifyToken(TokenBORequest tokenBORequest);
}
