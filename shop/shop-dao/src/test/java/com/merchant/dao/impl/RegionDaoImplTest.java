package com.merchant.dao.impl;


import com.merchant.base.BaseDaoTest;
import com.merchant.dao.RegionDao;
import com.merchant.po.data.Reginon;
import com.merchant.po.request.ReginonRequest;
import com.merchant.po.result.ReginonResult;
import lombok.extern.log4j.Log4j;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

@Log4j
public class RegionDaoImplTest extends BaseDaoTest {


    @Resource
    private RegionDao regionDao;

    @Test
    public void queryRegionByRequestTest(){

        ReginonRequest regionRequest=new ReginonRequest();

        ReginonResult regionResult= regionDao.queryRegionByRequest(regionRequest);
    }



    @Test
    public void insertRegionTest() {



        try {
            SAXReader reader = new SAXReader();
            File file = new File("D:\\test\\product\\area.xml");
            Document document = reader.read(file);
            Element root = document.getRootElement();
            Reginon region=null;
            Reginon cityRegion=null;
            Reginon areaRegion=null;

            String code22=null;
            String code33=null;

            System.out.println(root.getName());

            List<Element> childElements = root.elements();

            for (Element child : childElements) {

                /**
                 * 获取省provinceList
                 */
                System.out.println("provinceList:"+child.getName());
                if("provinceList".equals(child.getName())){
                    region=new Reginon();
                }
                //未知子元素名情况下
                List<Element> elementList = child.elements();
                for (Element ele : elementList) {
                    /**
                     * 获取provinceList 下子元素得code和name
                     */
                    System.out.println(ele.getName() + ": " + ele.getText());
                    if("code".equals(ele.getName())){
                        code22=ele.getText();
                        region.setRegionCode(code22);
                    }
                    if("name".equals(ele.getName())){
                        region.setRegionShortName(ele.getText());
                        region.setRegionName(ele.getText());

                        /**
                         * 拼接成其他数据add到数据库
                         */
                        region.setRegionParentId("-1");
                        region.setRegionLevel(1);
                        region.setStatus(1);

                        ReginonResult provinceResult= regionDao.insertRegion(region);


                    }

                    if("cityList".equals(ele.getName())){
                        cityRegion=new Reginon();
                    }

                    /**
                     * 获取provinceList下得cityList
                     */
                    List<Element> cityList = ele.elements();

                    /**
                     * 获取cityList 下得code和name
                     */
                    for (Element cityEle : cityList) {
                        System.out.println(cityEle.getName() + "    " + cityEle.getText());


                        if("code".equals(cityEle.getName())){
                            code33=cityEle.getText();
                            cityRegion.setRegionCode(code33);
                        }
                        if("name".equals(cityEle.getName())){
                            cityRegion.setRegionShortName(cityEle.getText());
                            cityRegion.setRegionName(cityEle.getText());

                        /**
                         * 拼接成其他数据add到数据库
                         */
                            cityRegion.setRegionParentId(code22);
                            cityRegion.setRegionLevel(2);
                            cityRegion.setStatus(1);

                        ReginonResult cityResult= regionDao.insertRegion(cityRegion);
                        }

                        if("areaList".equals(cityEle.getName())){
                            areaRegion=new Reginon();
                        }

                        /**
                         * 获取cityList 下得areaList
                         */
                        List<Element> areaList = cityEle.elements();

                        for (Element areaEle : areaList) {
                            /**
                             * 获取areaList 下得code和name
                             */
                            System.out.println(areaEle.getName() + "    " + areaEle.getText());

                            if("code".equals(areaEle.getName())){
                                areaRegion.setRegionCode(areaEle.getText());
                            }
                            if("name".equals(areaEle.getName())){
                                areaRegion.setRegionShortName(areaEle.getText());
                                areaRegion.setRegionName(areaEle.getText());

                            /**
                             * 拼接成其他数据add到数据库
                             */
                                areaRegion.setRegionParentId(code33);
                                areaRegion.setRegionLevel(3);
                                areaRegion.setStatus(1);

                            ReginonResult areaResult= regionDao.insertRegion(areaRegion);

                            }
                        }

                    }


                }
                System.out.println();


                System.out.println();
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

}