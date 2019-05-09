package com.merchant.shop.service;

import com.merchant.shop.bo.reginon.request.ReginonBORequest;
import com.merchant.shop.bo.reginon.result.ReginonBOResult;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/8
 */
public interface ReginonService {


    /**
     * 根据父地区得code查询所有得子地区
     * @param reginonBORequest
     * @return
     */
   ReginonBOResult queryReginonByRequest(ReginonBORequest reginonBORequest);



}
