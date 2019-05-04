package com.merchant.shop.bo.shopuser.result;

import com.merchant.bo.CommonBOResult;
import com.merchant.shop.bo.shopuser.data.ShopUserBO;
import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/3
 */
@Data
public class ShopUserBOResult extends CommonBOResult {

    /**
     * 所有会员得商店
     */
    private List<ShopUserBO> shopUserList;
}
