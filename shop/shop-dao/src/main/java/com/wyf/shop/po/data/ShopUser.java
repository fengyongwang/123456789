package com.wyf.shop.po.data;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/2
 */
@Data
@ToString
@TableName(value = "t_yf_shop_user")
public class ShopUser {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 商家id
     */
    private Integer userId;
    /**
     * 门店编码
     */
    private Integer shopCode;
    /**
     * 门店地址
     */
    private String shopAddress;
    /**
     * 门店联系人
     */
    private String shopContact;
    /**
     * 门店电话
     */
    private String shopPhone;
    /**
     * 更新时间
     */
    private Date lastModifyTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 修改者
     */
    private String modifyBy;
    /**
     * 创建者
     */
    private String createBy;


}
