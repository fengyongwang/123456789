package com.merchant.controller.shop;

import com.alibaba.dubbo.config.annotation.Reference;
import com.merchant.user.bo.CommonBOResult;
import com.merchant.controller.BaseController;
import com.merchant.convert.ConvertManager;
import com.merchant.data.StatusEnum;
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
@Api(tags = "v1.0.0商家店铺相关操作")
public class ShopUserController extends BaseController {

    @Resource
    private ConvertManager convertManager;

    @Reference
    private ShopUserService shopUserService;


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
        shopUserVOResult = convertManager.tran(shopUserBOResult, ShopUserVOResult.class);
        if (shopUserBOResult.isSuccess()) {

            ResultCodeUtil.resultSuccess(shopUserVOResult);
            log.info("Congratulations! create shop success ...");
        }
        return shopUserVOResult;
    }

    @ApiOperation(value = "query-shop", notes = "查询我的商铺的基本信息")
    @RequestMapping("/query-shop")
    public ShopUserVOResult queryMyShopByRequest(HttpServletRequest request, HttpServletResponse response) {
        ShopUserVOResult shopUserVOResult = new ShopUserVOResult();
        String phone = this.getPhone(request);
        if (phone == null) {
            log.error("sorry ,you do not login in queryShop ...");
            return shopUserVOResult;
        }

        ShopUserBORequest shopUserBORequest = new ShopUserBORequest();
        shopUserBORequest.setShopPhone(phone);
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
        Integer userId = super.getUserId(request);
        if (userId == null) {
            log.error("sorry ,you do not login in updateShop ...");
            return commonResultVO;
        }
        ShopUserBORequest shopUserBORequest = convertManager.tran(shopUserVORequest, ShopUserBORequest.class);
        shopUserBORequest.setUserId(userId);
        CommonBOResult commonBOResult = shopUserService.updateShopByRequest(shopUserBORequest);
        if (commonBOResult.isFailed()) {
            log.error("update my shop by request in controller error ...");
            return commonResultVO;
        }
        ResultCodeUtil.resultSuccess(commonResultVO);
        return commonResultVO;
    }

    @ApiOperation(value = "delete-shop", notes = "关门倒闭")
    @RequestMapping("delete-shop")
    public CommonResultVO deleteMyShop(HttpServletRequest request, HttpServletResponse response, @RequestBody @Validated({Delete.class}) ShopUserVORequest shopUserVORequest) {
        CommonResultVO commonResultVO = new CommonResultVO();

        ShopUserBORequest shopUserBORequest = convertManager.tran(shopUserVORequest, ShopUserBORequest.class);
        shopUserBORequest.setStatus(StatusEnum.INVALID.getValue());

        CommonBOResult commonBOResult = shopUserService.updateShopByRequest(shopUserBORequest);
        if (commonBOResult.isFailed()) {
            log.error("delete my shop error ...");
        }
        ResultCodeUtil.resultSuccess(commonResultVO);
        return commonResultVO;
    }


}
