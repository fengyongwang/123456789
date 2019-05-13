package com.merchant.controller.shop;

import com.alibaba.dubbo.config.annotation.Reference;
import com.merchant.controller.BaseController;
import com.merchant.convert.ConvertManager;
import com.merchant.data.vo.result.CommonResultVO;
import com.merchant.group.Create;
import com.merchant.group.Delete;
import com.merchant.group.Update;
import com.merchant.shop.bo.shopuser.request.ShopUserBORequest;
import com.merchant.shop.bo.shopuser.request.TotalCommodityBORequest;
import com.merchant.shop.bo.shopuser.result.ShopUserBOResult;
import com.merchant.shop.bo.shopuser.result.TotalCommodityBOResult;
import com.merchant.shop.service.ShopUserService;
import com.merchant.shop.service.TotalCommodityService;
import com.merchant.util.ResultCodeUtil;
import com.merchant.vo.shop.param.ShopUserParam;
import com.merchant.vo.shop.request.ShopUserVORequest;
import com.merchant.vo.shop.result.ShopUserVOResult;
import com.merchant.vo.shop.result.TotalCommodityVOResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/2
 */
@Log4j
@RestController
@RequestMapping(value = "/merchant/shop", method = RequestMethod.POST)
@Api(tags = "商家店铺相关操作")
public class ShopUserController extends BaseController {

    @Resource
    private ConvertManager convertManager;

    @Reference
    private ShopUserService shopUserService;


    @Reference
    private TotalCommodityService totalCommodityService;

    @ApiOperation(value = "to-create-shop", notes = "去开店")
    @RequestMapping("/to-create-shop")
    public TotalCommodityVOResult toCreateShop(HttpServletRequest request, HttpServletResponse response) {
        TotalCommodityVOResult totalCommodityVOResult = new TotalCommodityVOResult();
        log.info("query all commodity type start in toCreateShop ...");
        TotalCommodityBORequest totalCommodityBORequest = new TotalCommodityBORequest();
        TotalCommodityBOResult totalCommodityBOResult = totalCommodityService.queryTotalCommodity(totalCommodityBORequest);
        if (totalCommodityBOResult.isFailed()) {
            log.error("query all commodity type error in toCreateShop ...");
            return totalCommodityVOResult;
        }
        totalCommodityVOResult= convertManager.tran(totalCommodityBOResult,TotalCommodityVOResult.class);
        ResultCodeUtil.resultSuccess(totalCommodityVOResult);
        return totalCommodityVOResult;
    }


    @ApiOperation(value = "create-shop", notes = "开店")
    @RequestMapping("/create-shop")
    public ShopUserVOResult createShop(HttpServletRequest request, HttpServletResponse response, @RequestBody @Validated({Create.class}) ShopUserParam shopUserVORequest) {

        ShopUserVOResult shopUserVOResult = new ShopUserVOResult();
        Integer userId = super.getUserId(request);
        if (userId == null) {
            log.error("sorry ,you do not login in createShop ...");
            return shopUserVOResult;
        }
        ShopUserBORequest shopUserBORequest = convertManager.tran(shopUserVORequest, ShopUserBORequest.class);
        shopUserBORequest.setUserId(userId);
        ShopUserBOResult shopUserBOResult = shopUserService.insertShop(shopUserBORequest);
        if (shopUserBOResult.isSuccess()) {
            shopUserVOResult = convertManager.tran(shopUserBOResult, ShopUserVOResult.class);
            ResultCodeUtil.resultSuccess(shopUserVOResult);
            log.info("Congratulations! create shop success ...");
        }
        return shopUserVOResult;
    }

    @ApiOperation(value = "query-shop", notes = "查询我的商铺")
    @RequestMapping("/query-shop")
    public ShopUserVOResult queryMyShopByRequest(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false) ShopUserVORequest shopUserVORequest) {
        ShopUserVOResult shopUserVOResult = new ShopUserVOResult();
        Integer userId = this.getUserId(request);
        if (userId == null) {
            log.error("sorry ,you do not login in queryShop ...");
            return shopUserVOResult;
        }

        ShopUserBORequest shopUserBORequest = convertManager.tran(shopUserVORequest, ShopUserBORequest.class);
        shopUserBORequest.setUserId(userId);
        ShopUserBOResult shopUserBOResult = shopUserService.queryShopUserByRequest(shopUserBORequest);
        if (shopUserBOResult.isSuccess()) {
            shopUserVOResult = convertManager.tran(shopUserBOResult, ShopUserVOResult.class);
            ResultCodeUtil.resultSuccess(shopUserVOResult);
        }
        return shopUserVOResult;
    }

    @ApiOperation(value = "update-shop", notes = "修改我的商铺")
    @RequestMapping("/update-shop")
    public CommonResultVO updateMyShopByRequest(HttpServletRequest request, HttpServletResponse response, @RequestBody @Validated({Update.class}) ShopUserParam shopUserVORequest) {
        CommonResultVO commonResultVO = new CommonResultVO();

        return commonResultVO;
    }

    @ApiOperation(value = "delete-shop", notes = "关门倒闭")
    @RequestMapping("delete-shop")
    public CommonResultVO deleteMyShop(HttpServletRequest request, HttpServletResponse response, @RequestBody @Validated({Delete.class}) ShopUserVORequest shopUserVORequest) {
        CommonResultVO commonResultVO = new CommonResultVO();

        return commonResultVO;
    }


}
