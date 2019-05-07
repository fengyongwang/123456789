package com.merchant.util;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/7
 */
public class DomXml {

    public static void main(String[] args) throws Exception {
        SAXReader reader = new SAXReader();
        File file = new File("D:\\test\\product\\testArea.xml");
        Document document = reader.read(file);
        Element root = document.getRootElement();
        System.out.println(root.getName());

        List<Element> childElements = root.elements();

        for (Element child : childElements) {

            /**
             * 获取省provinceList
             */
            System.out.println(child.getName());




            //未知子元素名情况下
            List<Element> elementList = child.elements();
            for (Element ele : elementList) {
                /**
                 * 获取provinceList 下子元素得code和name
                 */
                System.out.println(ele.getName() + ": " + ele.getText());


                /**
                 * 获取provinceList下得cityList
                 */
                List<Element> cityList=  ele.elements();

                /**
                 * 获取cityList 下得code和name
                 */
                for (Element cityEle:cityList) {
                    System.out.println(cityEle.getName()+"    "+cityEle.getText());

                    /**
                     * 获取cityList 下得areaList
                     */
                    List<Element> areaList=cityEle.elements();

                    for (Element areaEle:areaList) {
                        /**
                         * 获取areaList 下得code和name
                         */
                        System.out.println(areaEle.getName()+"    "+areaEle.getText());

                    }

                }


            }
            System.out.println();


            System.out.println();
        }
    }

}
