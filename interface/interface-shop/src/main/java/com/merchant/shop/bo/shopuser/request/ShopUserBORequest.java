package com.merchant.shop.bo.shopuser.request;

import com.merchant.user.bo.CommonBORequest;
import lombok.Data;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/9
 */
@Data
public class ShopUserBORequest extends CommonBORequest {


    private static final long serialVersionUID = 2572846817170602954L;

    /**
     * 主键id
     */
    private Integer shopId;

    /**
     * 店家id
     */
    private Integer userId;

    /**
     * 商铺名称
     */
    private String shopName;

    /**
     * 主营商品分类id
     */
    private Integer totalCommodityId;
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
