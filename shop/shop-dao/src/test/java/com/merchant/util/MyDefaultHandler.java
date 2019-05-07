package com.merchant.util;


import com.merchant.shop.po.data.Region;
import lombok.extern.log4j.Log4j;
import org.xml.sax.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;

import java.io.File;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/5
 */
@Log4j
public class MyDefaultHandler extends DefaultHandler {


    Region region;

    public void startDocument() throws SAXException {

        System.out.println("startDocument...");

    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if("provinceList".equals(qName)){
            region=new Region();
            region.setRegionLevel(1);
//            region.setRegionParentId(-1);
        }

        if("cityList".equals(qName)){
            region=new Region();
            region.setRegionLevel(2);
//            region.setRegionParentId(1);
        }

        if("areaList".equals(qName)){
            region=new Region();
            region.setRegionLevel(3);
//            region.setRegionParentId(2);
        }

        System.out.println("qName:"+qName);
    }

    public void characters(char ch[], int start, int length) throws SAXException {
       String str= new String(ch,start,length);
//        region.setRegionName(str);
        System.out.println("str:"+str);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("endElement");
    }

    public void endDocument() throws SAXException {
        System.out.println("endDocument");
    }

    public static void main(String[] args) {
        try {
            File xmlFile = new File("D:\\test\\product\\area.xml");

            SAXParserFactory factory = SAXParserFactory.newInstance();

            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(xmlFile, new MyDefaultHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
