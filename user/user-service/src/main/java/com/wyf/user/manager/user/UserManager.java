package com.wyf.user.manager.user;

import com.wyf.bo.CommonBOResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/29
 */
public interface UserManager {


    /**
     * 生成图片验证码存入redis
     * @param userName
     * @return
     */
    CommonBOResult createImageCode(String userName);

}
