package com.merchant.shop.service.shopuser;

import com.merchant.convert.ConvertManager;
import com.merchant.shop.bo.shopuser.data.ShopUserBO;
import com.merchant.shop.bo.shopuser.request.ShopUserBORequest;
import com.merchant.shop.bo.shopuser.result.ShopUserBOResult;
import com.merchant.shop.dao.ShopUserDao;
import com.merchant.shop.po.data.ShopUser;
import com.merchant.shop.po.result.ShopUserResult;
import com.merchant.shop.util.ResultShopServiceCodeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/3
 */
@Service
@com.alibaba.dubbo.config.annotation.Service
public class ShopUserServiceImpl implements ShopUserService{

    @Resource
    private ShopUserDao shopUserDao;

    @Resource
    private ConvertManager convertManager;

    @Override
    public ShopUserBOResult insertShop(ShopUserBORequest shopUserBORequest) {
        ShopUserBOResult shopUserBOResult=new ShopUserBOResult();
        ShopUser shopUser=convertManager.tran(shopUserBORequest,ShopUser.class);

        /**
         * 添加相关字段
         */
        ShopUserResult shopUserResult=shopUserDao.insertUser(shopUser);

        if(shopUserResult.isSuccess()){
            List<ShopUserBO> list=new ArrayList<>();
            shopUserResult.getValues().forEach((ShopUser shop)->{
                list.add(convertManager.tran(shop, ShopUserBO.class));
            });
            shopUserBOResult.setShopUserList(list);
            ResultShopServiceCodeUtil.resultSuccess(shopUserBOResult);
        }

        return shopUserBOResult;
    }
}
