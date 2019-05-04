package com.merchant.controller.shop;

import com.merchant.controller.BaseController;
import com.merchant.data.vo.result.CommonResultVO;
import com.merchant.group.Create;
import com.merchant.group.Delete;
import com.merchant.group.Update;
import com.merchant.vo.shop.param.ShopCommodityParam;
import com.merchant.vo.shop.request.ShopCommodityVORequest;
import com.merchant.vo.shop.result.CommodityVOResult;
import com.merchant.vo.shop.result.ShopCommodityVOResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/3
 */
@Log4j
@RestController
@RequestMapping(value = "/merchant/commodity", method = RequestMethod.POST)
@Api(tags = "商家商品相关操作")
public class ShopCommodityController extends BaseController {


    @ApiOperation(value = "query-all-commodity", notes = "查询所有得商品类型")
    @RequestMapping("query-all-commodity")
    public CommodityVOResult queryAllCommodity(HttpServletRequest request, HttpServletResponse response) {
        CommodityVOResult commodityVOResult = new CommodityVOResult();
        return commodityVOResult;
    }

    @ApiOperation(value = "add-commodity-to-shop", notes = "往自家商铺中添加商品")
    @RequestMapping("add-commodity-to-shop")
    public ShopCommodityVOResult insertCommodityToShop(HttpServletRequest request, HttpServletResponse response, @RequestBody @Validated(Create.class) ShopCommodityParam shopCommodityVORequest) {
        ShopCommodityVOResult shopCommodityVOResult = new ShopCommodityVOResult();

        return shopCommodityVOResult;
    }

    @ApiOperation(value = "update-commodity", notes = "修改商品的信息")
    @RequestMapping("update-commodity")
    public CommonResultVO updateCommodityByRequest(HttpServletRequest request, HttpServletResponse response, @RequestBody @Validated(Update.class) ShopCommodityParam shopCommodityVORequest) {
        CommonResultVO commonResultVO = new CommonResultVO();
        return commonResultVO;
    }

    @ApiOperation(value = "query-commodity", notes = "查询商品的信息")
    @RequestMapping("query-commodity")
    public ShopCommodityVOResult queryCommodityByRequest(HttpServletRequest request, HttpServletResponse response, @RequestBody ShopCommodityVORequest shopCommodityVORequest) {
        ShopCommodityVOResult shopCommodityVOResult = new ShopCommodityVOResult();
        return shopCommodityVOResult;
    }

    @ApiOperation(value = "delete-commodity", notes = "商品下架")
    @RequestMapping("delete-commodity")
    public CommonResultVO deleteCommodity(HttpServletRequest request, HttpServletResponse response, @RequestBody @Validated(Delete.class) ShopCommodityVORequest shopCommodityVORequest) {
        CommonResultVO commonResultVO = new CommonResultVO();
        return commonResultVO;
    }


}
