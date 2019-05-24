package com.merchant.shop.manage.shopuser.impl;

import com.merchant.user.bo.CommonBOResult;
import com.merchant.convert.ConvertManager;
import com.merchant.shop.dao.ShopUserDao;
import com.merchant.data.StatusEnum;
import com.merchant.shop.po.data.ShopUser;
import com.merchant.shop.po.request.ShopUserRequest;
import com.merchant.shop.po.result.ShopUserResult;
import com.merchant.shop.bo.shopuser.data.ShopUserBO;
import com.merchant.shop.bo.shopuser.request.ShopUserBORequest;
import com.merchant.shop.bo.shopuser.result.ShopUserBOResult;
import com.merchant.shop.constant.ShopUserConfig;
import com.merchant.shop.manage.shopuser.ShopUserManager;
import com.merchant.user.util.ResultShopServiceCodeUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Random;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/9
 */
@Component
@Log4j
public class ShopUserManagerImpl implements ShopUserManager {

    @Resource
    private ShopUserDao shopUserDao;

    @Resource
    private ConvertManager convertManager;

    @Override
    public ShopUserBOResult insertShop(ShopUserBORequest shopUserBORequest) {
        ShopUserBOResult shopUserBOResult = new ShopUserBOResult();
        /**
         * 生成商铺编码
         */
        String shopCode = this.createShopCode(ShopUserConfig.shopCodeLength);
        if (shopCode == null) {
            log.error("create shopCode error ...");
            return shopUserBOResult;
        }
        shopUserBORequest.setShopCode(shopCode);
        ShopUser shopUser = convertManager.tran(shopUserBORequest, ShopUser.class);
        shopUser.setStatus(StatusEnum.EFFECTIVE.getValue());
        ShopUserResult shopUserResult = shopUserDao.insertUser(shopUser);

        if (!shopUserResult.isSuccess()) {
            log.error("insert shopUser error in shopUserManager ...");
            return shopUserBOResult;
        }
        shopUserBOResult.setShopUserList(convertManager.convertList(shopUserResult.getValues(), ShopUserBO.class));
        ResultShopServiceCodeUtil.resultSuccess(shopUserBOResult);
        return shopUserBOResult;
    }

    @Override
    public ShopUserBOResult queryShopUserByRequest(ShopUserBORequest shopUserBORequest) {
        ShopUserBOResult shopUserBOResult = new ShopUserBOResult();

        ShopUserResult shopUserResult = shopUserDao.queryShopUserByRequest(convertManager.tran(shopUserBORequest, ShopUserRequest.class));
        if (!shopUserResult.isSuccess()) {
            log.error("query shopUser by request error in queryShopUserByRequest ...");
            return shopUserBOResult;
        }

        shopUserBOResult.setShopUserList(convertManager.convertList(shopUserResult.getValues(), ShopUserBO.class));
        ResultShopServiceCodeUtil.resultSuccess(shopUserBOResult);
        return shopUserBOResult;
    }

    @Override
    public CommonBOResult updateShopByRequest(ShopUserBORequest shopUserBORequest) {
        CommonBOResult commonBOResult = new CommonBOResult();
        ShopUser shopUser=convertManager.tran(shopUserBORequest, ShopUser.class);
        shopUser.setId(shopUserBORequest.getShopId());
        ShopUserResult shopUserResult = shopUserDao.updateShopUserById(shopUser);
        if (!shopUserResult.isSuccess()) {
            log.error("update shop by request in ShopUserManagerImpl error ...");
            return commonBOResult;
        }

        if (shopUserResult.getCount() == 0) {
            log.warn("sorry, do not query this shop ...");
            return commonBOResult;
        }
        ResultShopServiceCodeUtil.resultSuccess(commonBOResult);

        return commonBOResult;
    }

    /**
     * 随机生成商铺编码
     *
     * @param n
     * @return
     */
    private String createShopCode(int n) {

        String val = "";
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            String str = random.nextInt(2) % 2 == 0 ? "num" : "char";
            if ("char".equalsIgnoreCase(str)) {
                /**
                 * 产生字母
                 */
                int nextInt = random.nextInt(2) % 2 == 0 ? 65 : 97;
                // System.out.println(nextInt + "!!!!"); 1,0,1,1,1,0,0
                val += (char) (nextInt + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(str)) {
                /**
                 * 产生数字
                 */
                val += String.valueOf(random.nextInt(10));
            }
        }
        log.info("create ShopCode is :" + val);
        ShopUserRequest shopUserRequest = new ShopUserRequest();
        shopUserRequest.setShopCode(val);
        ShopUserResult shopUserResult = shopUserDao.queryShopUserByRequest(shopUserRequest);
        if (!shopUserResult.isSuccess()) {
            log.error("shopUserDao query is error in shopUserManager ...");
            return null;
        }

        if (shopUserResult.getCount() > 0) {
            log.info("sorry ,this shopCode is exist ,please create again ...");
            return createShopCode(ShopUserConfig.shopCodeLength);
        }

        return val;

    }
}
