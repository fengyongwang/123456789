package com.merchant.shop.bo.shopuser.request;

import com.merchant.bo.CommonBORequest;
import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/3
 */
@Data
public class ShopUserBORequest extends CommonBORequest {


    /**
     * 商家id
     */
    private Integer userId;

    /**
     * 商铺名称
     */
    private String shopName;

    /**
     * 商铺编码
     */
    private String shopCode;


    /**
     * 商铺地址
     */
    private String shopAddress;
    /**
     * 商铺联系人
     */
    private String shopContact;
    /**
     * 商铺电话
     */
    private String shopPhone;


    /**
     * 状态
     */
    private Integer status;
}
