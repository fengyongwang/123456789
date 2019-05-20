package com.merchant.user.service;

import com.merchant.user.bo.token.request.TokenBORequest;
import com.merchant.user.bo.token.result.TokenBOResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/29
 */
public interface JwtTokenService {


    /**校验token信息
     * @param tokenBORequest
     * @return
     */
    TokenBOResult verifyToken(TokenBORequest tokenBORequest);


}
