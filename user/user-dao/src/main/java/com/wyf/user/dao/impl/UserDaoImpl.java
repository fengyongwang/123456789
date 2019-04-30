package com.wyf.user.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyf.user.dao.UserDao;
import com.wyf.user.mapper.UserMapper;
import com.wyf.user.po.data.User;
import com.wyf.user.po.request.UserRequest;
import com.wyf.user.po.result.UserResult;
import com.wyf.user.util.ResultUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/30
 */
@Component
@Log4j
public class UserDaoImpl implements UserDao {

    @Resource
    private UserMapper mapper;

    @Override
    public UserResult simpleQueryByRequest(UserRequest request) {
        UserResult res = new UserResult();
        try {
            LambdaQueryWrapper<User> wp = new LambdaQueryWrapper<>();
            if (request.getId() != null) {
                wp.eq(User::getId, request.getId());
            }
            if (request.getName() != null) {
                wp.eq(User::getName, request.getName());
            }
            if (request.getPhone() != null) {
                wp.eq(User::getPhone, request.getPhone());
            }
            if (request.getIdentity() != null) {
                wp.eq(User::getIdentity, request.getIdentity());
            }
            if (request.getUserName()!=null) {
                wp.eq(User::getUserName, request.getUserName());
            }

            if (request.isPaging()) {
                Page<User> page = new Page<>(request.getPage() + 1, request.getPageSize());
                IPage<User> zdAddressIPage = mapper.selectPage(page, wp);
                ResultUtil.resultValues(res, zdAddressIPage.getRecords());
                ResultUtil.resultCountWithPaging(res, (int) zdAddressIPage.getTotal(), request.getPage());
            } else {
                List<User> list = mapper.selectList(wp);
                ResultUtil.resultValues(res, list);
            }
            ResultUtil.resultSuccess(res);
        } catch (Exception e) {
            log.error("UserDao simpleQueryByRequest error..........", e);
        }
        return res;
    }

    @Override
    public UserResult insertUser(User user) {

        UserResult res = new UserResult();
        try {
            int status = mapper.insert(user);
            ResultUtil.dealUpsert(status, user, res);
        } catch (Exception e) {
            log.error("User dao insert error..........", e);
        }
        return res;
    }
}
