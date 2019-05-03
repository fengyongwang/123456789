package com.wyf.shop.bo.data;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/3
 */
@Data
public class ShopUserBO implements Serializable {
    private static final long serialVersionUID = -3310134059528524832L;

    /**
     * 主键id
     */
    private Integer id;
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



}
