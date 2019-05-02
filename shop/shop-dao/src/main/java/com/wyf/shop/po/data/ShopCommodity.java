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
@TableName(value = "t_yf_shop_commodity")
public class ShopCommodity {


    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 商家id
     */
    private Integer shopId;
    /**
     * 单价
     */
    private Double unitPrice;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 商品图片
     */
    private String imageUrl;
    /**
     * 商品描述
     */
    private String commodityDescription;
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
