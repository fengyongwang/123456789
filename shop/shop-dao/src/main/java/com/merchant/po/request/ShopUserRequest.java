package com.merchant.po.request;

import com.merchant.data.po.request.CommonRequestPO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/2
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class ShopUserRequest extends CommonRequestPO {

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 门店ids
     */
    private List<Integer>ids;
    /**
     * 商家id
     */
    private Integer userId;

    /**
     * 商家ids
     */
    private List<Integer> userIds;
    /**
     * 门店编码
     */
    private Integer shopCode;

    /**
     * 门店联系人
     */
    private String shopContact;
    /**
     * 门店电话
     */
    private String shopPhone;
    /**
     * 门店名称
     */
    private String shopName;


}
