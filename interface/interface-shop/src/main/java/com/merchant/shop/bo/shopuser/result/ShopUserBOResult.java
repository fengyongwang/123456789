package com.merchant.shop.bo.shopuser.result;

import com.merchant.user.bo.CommonBOResult;
import com.merchant.shop.bo.shopuser.data.ShopUserBO;
import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/9
 */
@Data
public class ShopUserBOResult extends CommonBOResult {

    /**
     * 商家商铺得集合
     */
    private List<ShopUserBO> shopUserList;
}
