package com.wyf.controller.shop;

import com.wyf.convert.ConvertManager;
import com.wyf.vo.shop.request.ShopUserVORequest;
import com.wyf.vo.shop.result.ShopUserVOResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/2
 */
@Log4j
@RestController
@RequestMapping(value = "/app/shop", method = RequestMethod.POST)
@Api(tags = "后台人员门店相关操作")
public class ShopUserController {

    @Resource
    private ConvertManager convertManager;

//    @Resource
//    private ShopUserService shopUserService;

    @ApiOperation(value = "create-shop", notes = "我要开店")
    @RequestMapping("/create-shop")
    public ShopUserVOResult createShop(HttpServletRequest request, HttpServletResponse response,@RequestBody @Valid ShopUserVORequest shopUserVORequest) {

        ShopUserVOResult shopUserVOResult = new ShopUserVOResult();

        return shopUserVOResult;
    }
}
