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
import com.merchant.shop.bo.shopcommodity.param.ShopCommodityParamBO;
import com.merchant.shop.bo.shopcommodity.request.ShopCommodityBORequest;
import com.merchant.shop.bo.shopcommodity.result.ShopCommodityBOResult;
import com.merchant.shop.bo.shopuser.request.TotalCommodityBORequest;
import com.merchant.shop.bo.shopuser.result.TotalCommodityBOResult;
import com.merchant.shop.service.ShopCommodityService;
import com.merchant.shop.service.TotalCommodityService;
import com.merchant.util.ResultCodeUtil;
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

import javax.annotation.Resource;
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
@Api(tags = "v1.0.0商家商品相关操作")
public class ShopCommodityController extends BaseController {

    @Reference
    private TotalCommodityService totalCommodityService;


    @Reference
    private ShopCommodityService shopCommodityService;

    @Resource
    private ConvertManager convertManager;

    /**
     * 查询所有得商品类型
     *
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "query-all-commodity", notes = "查询所有得商品类型")
    @RequestMapping("query-all-commodity")
    public CommodityVOResult queryAllCommodity(HttpServletRequest request, HttpServletResponse response) {
        CommodityVOResult commodityVOResult = new CommodityVOResult();
        TotalCommodityBORequest totalCommodityBORequest = new TotalCommodityBORequest();
        TotalCommodityBOResult totalCommodityBOResult = totalCommodityService.queryTotalCommodity(totalCommodityBORequest);
        if (totalCommodityBOResult.isFailed()) {
            log.error("query All commodity error in controller ...");
            return commodityVOResult;
        }
        commodityVOResult = convertManager.tran(totalCommodityBOResult, CommodityVOResult.class);
        ResultCodeUtil.resultSuccess(commodityVOResult);
        return commodityVOResult;
    }

    /**
     * 往自家商铺中添加商品
     *
     * @param request
     * @param response
     * @param shopCommodityVORequest
     * @return
     */
    @ApiOperation(value = "add-commodity-to-shop", notes = "往自家商铺中添加商品")
    @RequestMapping("add-commodity-to-shop")
    public ShopCommodityVOResult insertCommodityToShop(HttpServletRequest request, HttpServletResponse response, @RequestBody @Validated(Create.class) ShopCommodityParam shopCommodityVORequest) {
        ShopCommodityVOResult shopCommodityVOResult = new ShopCommodityVOResult();

        Integer userId = this.getUserId(request);
        if (userId == null) {
            log.error("userId is null in insertCommodityToShop ...");
            return shopCommodityVOResult;
        }

        ShopCommodityParamBO shopCommodityBORequest = convertManager.tran(shopCommodityVORequest, ShopCommodityParamBO.class);

        ShopCommodityBOResult shopCommodityBOResult = shopCommodityService.insertShopCommodity(shopCommodityBORequest);
        if (shopCommodityBOResult.isFailed()) {
            log.error("insert commodity error in controller ...");
            return shopCommodityVOResult;
        }

        shopCommodityVOResult = convertManager.tran(shopCommodityBOResult, ShopCommodityVOResult.class);
        ResultCodeUtil.resultSuccess(shopCommodityVOResult);
        return shopCommodityVOResult;
    }


    /**
     * 修改商品的信息
     *
     * @param request
     * @param response
     * @param shopCommodityVORequest
     * @return
     */
    @ApiOperation(value = "update-commodity", notes = "修改商品的信息")
    @RequestMapping("update-commodity")
    public CommonResultVO updateCommodityByRequest(HttpServletRequest request, HttpServletResponse response, @RequestBody @Validated(Update.class) ShopCommodityParam shopCommodityVORequest) {
        CommonResultVO commonResultVO = new CommonResultVO();
        ShopCommodityParamBO shopCommodityBORequest = convertManager.tran(shopCommodityVORequest, ShopCommodityParamBO.class);
        CommonBOResult commonBOResult = shopCommodityService.updateShopCommodityByRequest(shopCommodityBORequest);
        if (commonBOResult.isSuccess()) {
            ResultCodeUtil.resultSuccess(commonResultVO);
        }
        return commonResultVO;
    }

    /**
     * 查询商品的信息
     *
     * @param request
     * @param response
     * @param shopCommodityVORequest
     * @return
     */
    @ApiOperation(value = "query-commodity", notes = "查询我的商铺的商品信息")
    @RequestMapping("query-commodity")
    public ShopCommodityVOResult queryCommodityByRequest(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false) ShopCommodityVORequest shopCommodityVORequest) {
        ShopCommodityVOResult shopCommodityVOResult = new ShopCommodityVOResult();

        Integer userId=super.getUserId(request);
        if(userId==null){
            log.error("no login ...");
            return shopCommodityVOResult;
        }

        ShopCommodityBORequest shopCommodityBORequest=convertManager.tran(shopCommodityVORequest, ShopCommodityBORequest.class);
        shopCommodityBORequest.setUserId(userId);
        ShopCommodityBOResult shopCommodityBOResult = shopCommodityService.queryShopCommodityByRequest(shopCommodityBORequest);
        if (shopCommodityBOResult.isFailed()) {
            log.error("query commodity of shop error in controller ...");
            return shopCommodityVOResult;
        }

        shopCommodityVOResult= convertManager.tran(shopCommodityBOResult,ShopCommodityVOResult.class);
        ResultCodeUtil.resultSuccess(shopCommodityVOResult);
        return shopCommodityVOResult;
    }

    /**
     * 商品下架
     *
     * @param request
     * @param response
     * @param shopCommodityVORequest
     * @return
     */
    @ApiOperation(value = "delete-commodity", notes = "商品下架")
    @RequestMapping("delete-commodity")
    public CommonResultVO deleteCommodity(HttpServletRequest request, HttpServletResponse response, @RequestBody @Validated(Delete.class) ShopCommodityVORequest shopCommodityVORequest) {
        CommonResultVO commonResultVO = new CommonResultVO();
        ShopCommodityParamBO shopCommodityParam=new ShopCommodityParamBO();
        shopCommodityParam.setId(shopCommodityVORequest.getId());
        shopCommodityParam.setStatus(StatusEnum.INVALID.getValue());
        CommonBOResult commonBOResult = shopCommodityService.updateShopCommodityByRequest(shopCommodityParam);
        if (commonBOResult.isSuccess()) {
            ResultCodeUtil.resultSuccess(commonResultVO);
        }
        return commonResultVO;

    }


}
