package com.wyf.user.service.user;

import com.wyf.bo.CommonBOResult;
import com.wyf.convert.ConvertManager;
import com.wyf.data.StatusEnum;
import com.wyf.user.bo.request.user.UserBORequest;
import com.wyf.user.bo.result.user.UserBOResult;
import com.wyf.user.dao.UserDao;
import com.wyf.user.manager.user.UserManager;
import com.wyf.user.po.data.User;
import com.wyf.user.po.request.UserRequest;
import com.wyf.user.po.result.UserResult;
import com.wyf.user.util.ResultUserServiceCodeUtil;
import com.wyf.user.util.TokenUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/29
 */
@Log4j
@Service
@com.alibaba.dubbo.config.annotation.Service
public class UserServiceImpl implements UserService {

    @Resource
    private ConvertManager convertManager;

    @Resource
    private UserDao userDao;

    @Resource
    private UserManager userManager;


    @Override
    public CommonBOResult registeredUser(UserBORequest request) {
        CommonBOResult commonBOResult = new CommonBOResult();

        /**
         * TODO 验证验证码是否正确
         */
        log.info("registeredUser in UserService,user is: " + request.toString());
        User user = convertManager.tran(request, User.class);
        user.setStatus(StatusEnum.EFFECTIVE.getValue());
        UserResult userResult = userDao.insertUser(user);
        if (userResult.isSuccess()) {
            log.info("welcome! registeredUser success ..." );
            ResultUserServiceCodeUtil.resultSuccess(commonBOResult);
        }

        return commonBOResult;
    }

    @Override
    public UserBOResult simpleQueryByRequest(UserBORequest request) {
        UserBOResult userBOResult = new UserBOResult();
        log.info("welcome ,simpleQueryByRequest at UserService , user is: " + request.toString());
        UserRequest userRequest = convertManager.tran(request, UserRequest.class);
        UserResult userResult = userDao.simpleQueryByRequest(userRequest);
        if(!userResult.isSuccess()){
            log.error("simpleQueryByRequest at UserService error... ");
            ResultUserServiceCodeUtil.resultError(userBOResult);
            return userBOResult;
        }

        if(userResult.getValues().size()==0){
            log.warn("simpleQueryByRequest at UserService error... ");
            ResultUserServiceCodeUtil.resultError(userBOResult);
            return userBOResult;
        }

        /**
         * 生成token
         */
        String token =null;
        try {
            token= TokenUtil.createToken(userResult);
        }catch (Exception e){
            log.error("create token error :",e);
        }

        if(token!=null){
            userBOResult.setToken(token);
        }
        userBOResult.setType(request.getType());
        ResultUserServiceCodeUtil.resultSuccess(userBOResult);

        return userBOResult;
    }


}
