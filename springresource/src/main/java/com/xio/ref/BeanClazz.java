package com.xio.ref;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: polarbear
 * @Date: 2019/6/29 10:27
 * @Description: Test_Demo
 */
public class BeanClazz {

    private static Map<String, Element> elements = new HashMap<String, Element>();

    public static void main(String[] args) {
        System.out.println(getBean("applicationfile.xml"));
    }

    public static String getBean(String filePath) {

        //借用dom4j的解析器
        SAXReader reader = new SAXReader(true);

        reader.setEntityResolver((publicId, systemId) -> null);

        //根据路径创建文件
        File xmlFile = new File(filePath);

        try {
            //用dom4j自带的reader读取去读返回一个Document
            Document doc = reader.read(xmlFile);
            //
            List eles = doc.getRootElement().elements();

            for (Object e : eles) {
                Element element = (Element) e;
                String id = element.attributeValue("id");
                elements.put(id, element);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return "";
    }


}
