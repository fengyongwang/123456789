package com.wyf.user.util;

import com.wyf.user.po.result.UserResult;
import com.wyf.util.JwtToken;
import com.wyf.util.JwtTokenConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/30
 */
public class TokenUtil {

    /**
     * 生成token
     * @return
     */
    public static String createToken(UserResult userResult){
        Map<String,String> hashMap=new HashMap<>();
        String token=null;
        if(userResult.getValue().getPhone()!=null||userResult.getValue().getId()!=null) {
            hashMap.put(JwtTokenConstant.TOKEN_ID_KEY, String.valueOf(userResult.getValue().getId()));
            hashMap.put(JwtTokenConstant.TOKEN_IDENTITY_KEY, String.valueOf(userResult.getValue().getPhone()));

            token = JwtToken.getToken(hashMap);
        }
        return token;
    }

}
