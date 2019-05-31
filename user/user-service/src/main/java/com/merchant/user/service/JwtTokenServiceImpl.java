package com.merchant.user.service;

import com.merchant.user.bo.token.request.TokenBORequest;
import com.merchant.user.bo.token.result.TokenBOResult;
import com.merchant.user.manage.JwtTokenManage;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/10
 */
@Service
@com.alibaba.dubbo.config.annotation.Service
@Log4j
public class JwtTokenServiceImpl  implements JwtTokenService{

    @Resource
    private JwtTokenManage jwtTokenManage;

    @Override
    public TokenBOResult verifyToken(TokenBORequest tokenBORequest) {
        return this.jwtTokenManage.verifyToken(tokenBORequest);
    }
}
