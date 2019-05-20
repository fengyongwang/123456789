package com.merchant.user.manage.impl;

import com.merchant.user.bo.ResultConstant;
import com.merchant.user.bo.token.request.TokenBORequest;
import com.merchant.user.bo.token.result.TokenBOResult;
import com.merchant.user.dao.UserDao;
import com.merchant.user.manage.JwtTokenManage;
import com.merchant.user.po.request.UserRequest;
import com.merchant.user.po.result.UserResult;
import com.merchant.user.util.ResultUserServiceCodeUtil;
import com.merchant.user.util.JwtToken;
import com.merchant.user.util.JwtTokenConstant;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/10
 */
@Component
@Log4j
public class JwtTokenManageImpl implements JwtTokenManage {


    @Resource
    private UserDao userDao;


    @Override
    public TokenBOResult verifyToken(TokenBORequest tokenBORequest) {
        TokenBOResult tokenBOResult = new TokenBOResult();
        if (tokenBORequest == null || StringUtils.isBlank(tokenBORequest.getToken())) {
            log.warn("miss param token in JwtTokenManage ...");
            tokenBOResult.setMessage(ResultConstant.MESSAGE.DEFAULT_MISS_PARAM_MESSAGE);
            return tokenBOResult;
        }

        return this.tokenChangeResult(tokenBORequest.getToken(),tokenBOResult);
    }

    private TokenBOResult tokenChangeResult(String token, TokenBOResult tokenBOResult) {
        Map<String, String> claims = JwtToken.verifyToken(token);
        /**
         * 获取token中得id和phone
         */
        String phone = claims.get(JwtTokenConstant.TOKEN_PHONE_KEY);
        Integer id;
        if (StringUtils.isBlank(phone)) {
            log.warn("phone is null or empty in JwtTokenManage ...");
            return tokenBOResult;
        }

        try {
            id = Integer.valueOf(claims.get(JwtTokenConstant.TOKEN_ID_KEY));
        } catch (Exception e) {
            log.warn("id of token may null ...");
            return tokenBOResult;
        }
        /**
         * 去查询满足Token中得id和phone  是否正常
         */

        if(this.queryByIdAndPhone(id,phone)){
            tokenBOResult.setPhone(phone);
            tokenBOResult.setId(id);
            ResultUserServiceCodeUtil.resultSuccess(tokenBOResult);
        }
        return tokenBOResult;
    }

    /**
     * 根据id和phone去查询数据库数据是否正确
     * @param id
     * @param phone
     * @return
     */
    private boolean queryByIdAndPhone(Integer id, String phone) {
        boolean flag = false;
        UserRequest userRequest = new UserRequest();
        userRequest.setId(id);
        userRequest.setPhone(phone);

        UserResult userResult = userDao.simpleQueryByRequest(userRequest);
        if (userResult.isSuccess() && userResult.getCount() > 0) {
            log.info("id and phone true ...");
            flag = true;
        }
        return flag;
    }


}
