package com.merchant.user.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.merchant.data.StatusEnum;
import com.merchant.user.mapper.UserMapper;
import com.merchant.user.po.request.UserRequest;
import com.merchant.user.po.result.UserResult;
import com.merchant.user.dao.UserDao;
import com.merchant.user.po.data.User;
import com.merchant.user.util.ResultUserUtil;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
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
            if (request.getPhone() != null) {
                wp.eq(User::getPhone, request.getPhone());
            }
            if (request.getType() != null) {
                wp.eq(User::getType, request.getType());
            }
            if (request.getUserName() != null) {
                wp.eq(User::getUserName, request.getUserName());
            }
            if (request.getPassWord() != null) {
                wp.eq(User::getPassWord, request.getPassWord());
            }
            if (request.isPaging()) {
                Page<User> page = new Page<>(request.getPage() + 1, request.getPageSize());
                IPage<User> zdAddressIPage = mapper.selectPage(page, wp);
                ResultUserUtil.resultValues(res, zdAddressIPage.getRecords());
                ResultUserUtil.resultCountWithPaging(res, (int) zdAddressIPage.getTotal(), request.getPage());
            } else {
                List<User> list = mapper.selectList(wp);
                ResultUserUtil.resultValues(res, list);
            }
            ResultUserUtil.resultSuccess(res);
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
            ResultUserUtil.dealUpsert(status, user, res);
        } catch (Exception e) {
            log.error("User dao insert error..........", e);
        }
        return res;
    }

    @Override
    public UserResult queryUserByNameOrPhone(UserRequest request) {


        UserResult res = new UserResult();
        try {

            QueryWrapper<User> queryWrapper = new QueryWrapper<>();

            if (StringUtils.isNotBlank(request.getUserName())) {
                queryWrapper.lambda()
                        .or()
                        .eq(User::getUserName, request.getUserName());

            }
            if (StringUtils.isNotBlank(request.getPhone())) {
                queryWrapper.lambda()
                        .or()
                        .eq(User::getPhone, request.getPhone());
            }

            List<User> list = mapper.selectList(queryWrapper);


            ResultUserUtil.resultValues(res, list);

            ResultUserUtil.resultSuccess(res);
        } catch (Exception e) {
            log.error("UserDao simpleQueryByRequest error..........", e);
        }
        return res;
    }
}
