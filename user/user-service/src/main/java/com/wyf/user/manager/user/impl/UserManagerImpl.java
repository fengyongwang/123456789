package com.wyf.user.manager.user.impl;

import com.wyf.bo.CommonBOResult;
import com.wyf.user.dao.UserDao;
import com.wyf.user.manager.user.UserManager;
import lombok.extern.log4j.Log4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/29
 */
@Component
@Log4j
public class UserManagerImpl implements UserManager {


    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private UserDao userDao;



    @Override
    public CommonBOResult createImageCode(String userName) {



        return null;
    }

    /**
     * redis  中加入一条数据
     *
     * @param key      key
     * @param msg      消息
     * @param time     时间数量
     * @param timeUnit 时间单位
     * @return
     */
    private boolean insertRedis(String key, String msg, int time, TimeUnit timeUnit) {

        boolean flag = false;
        try {
            redisTemplate.boundValueOps(key).set(msg, time, timeUnit);
            flag = true;
            log.info("insert redis  success");
        } catch (Exception e) {
            log.error("insert redis error", e);
        }
        return flag;
    }

}
