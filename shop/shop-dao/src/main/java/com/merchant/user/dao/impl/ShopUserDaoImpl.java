package com.merchant.user.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.merchant.user.dao.ShopUserDao;
import com.merchant.user.mapper.ShopUserMapper;
import com.merchant.user.po.data.ShopUser;
import com.merchant.user.po.request.ShopUserRequest;
import com.merchant.user.po.result.ShopUserResult;
import com.merchant.user.util.ResultShopUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/2
 */
@Component
@Log4j
public class ShopUserDaoImpl implements ShopUserDao {

    @Resource
    private ShopUserMapper mapper;

    @Override
    public ShopUserResult insertUser(ShopUser shopUser) {
        ShopUserResult res = new ShopUserResult();
        try {
            int status = mapper.insert(shopUser);
            ResultShopUtil.dealUpsert(status, shopUser, res);
        } catch (Exception e) {
            log.error("ShopUserDao insert error..........", e);
        }
        return res;
    }

    @Override
    public ShopUserResult queryShopUserByRequest(ShopUserRequest request) {
        ShopUserResult res = new ShopUserResult();
        try {
            LambdaQueryWrapper<ShopUser> wp = new LambdaQueryWrapper<>();
            if (request.getId() != null) {
                wp.eq(ShopUser::getId, request.getId());
            }
            if (request.getShopCode() != null) {
                wp.eq(ShopUser::getShopCode, request.getShopCode());
            }
            if (request.getUserId() != null) {
                wp.eq(ShopUser::getUserId, request.getUserId());
            }
            if (!CollectionUtils.isEmpty(request.getIds())) {
                wp.in(ShopUser::getId, request.getIds());
            }
            if (!CollectionUtils.isEmpty(request.getUserIds())) {
                wp.in(ShopUser::getUserId, request.getUserIds());
            }
            if (!CollectionUtils.isEmpty(request.getTotalCommodityIds())) {
                wp.in(ShopUser::getTotalCommodityId, request.getTotalCommodityIds());
            }
            if (request.getTotalCommodityId() != null) {
                wp.eq(ShopUser::getTotalCommodityId, request.getTotalCommodityId());
            }
            /**
             * 按照创建时间升序排序
             */

            wp.orderByAsc(ShopUser::getCreateTime);

            if (request.isPaging()) {
                Page<ShopUser> page = new Page<>(request.getPage() + 1, request.getPageSize());
                IPage<ShopUser> shopUserIPage = mapper.selectPage(page, wp);
                ResultShopUtil.resultValues(res, shopUserIPage.getRecords());
                ResultShopUtil.resultCountWithPaging(res, (int) shopUserIPage.getTotal(), request.getPage());
            } else {
                List<ShopUser> list = mapper.selectList(wp);
                ResultShopUtil.resultValues(res, list);
            }
            ResultShopUtil.resultSuccess(res);
        } catch (Exception e) {
            log.error("ShopUserDao simpleQueryByRequest error..........", e);
        }
        return res;
    }

    @Override
    public ShopUserResult updateShopUserById(ShopUser shopUser) {
        ShopUserResult shopUserResult = new ShopUserResult();
        try {
            int status = mapper.updateById(shopUser);
            ResultShopUtil.dealUpsert(status,shopUser,shopUserResult);
        } catch (Exception e) {
            log.error("update shopUser by Id error ...", e);
        }
        return shopUserResult;
    }
}
