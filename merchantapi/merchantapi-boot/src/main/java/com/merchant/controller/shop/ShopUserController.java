package com.merchant.controller.shop;

import com.merchant.controller.BaseController;
import com.merchant.convert.ConvertManager;
import com.merchant.data.vo.result.CommonResultVO;
import com.merchant.group.Create;
import com.merchant.group.Delete;
import com.merchant.group.Update;
import com.merchant.shop.bo.shopuser.request.ShopUserBORequest;
import com.merchant.shop.bo.shopuser.result.ShopUserBOResult;
import com.merchant.shop.service.shopuser.ShopUserService;
import com.merchant.util.ResultCodeUtil;
import com.merchant.vo.shop.param.ShopUserParam;
import com.merchant.vo.shop.request.ShopUserVORequest;
import com.merchant.vo.shop.result.ShopUserVOResult;
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

    @Resource
    private ShopUserService shopUserService;

    @ApiOperation(value = "create-shop", notes = "我要开店")
    @RequestMapping("/create-shop")
    public ShopUserVOResult createShop(HttpServletRequest request, HttpServletResponse response, @RequestBody @Validated({Create.class}) ShopUserParam shopUserVORequest) {

        ShopUserVOResult shopUserVOResult = new ShopUserVOResult();

        ShopUserBORequest shopUserBORequest = convertManager.tran(shopUserVORequest, ShopUserBORequest.class);
        ShopUserBOResult shopUserBOResult = shopUserService.insertShop(shopUserBORequest);
        if (shopUserBOResult.isSuccess()) {
            shopUserVOResult = convertManager.tran(shopUserBOResult, ShopUserVOResult.class);
            ResultCodeUtil.resultSuccess(shopUserVOResult);
        }
        return shopUserVOResult;
    }

    @ApiOperation(value = "query-shop", notes = "查询我的商铺")
    @RequestMapping("/query-shop")
    public ShopUserVOResult queryMyShopByRequest(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false) ShopUserVORequest shopUserVORequest) {
        ShopUserVOResult shopUserVOResult = new ShopUserVOResult();
        /**
         * TODO 按照创建时间排序，最早开的店第一个
         */
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
