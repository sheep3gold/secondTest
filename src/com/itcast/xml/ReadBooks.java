package com.itcast.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class ReadBooks {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read("/Users/yangxin/IdeaProjects/secondTest/src/com/itcast/xml/books.xml");
        Element rootElement = doc.getRootElement();
        List<Element> elements = rootElement.elements();
        for (Element book : elements) {
            String author = book.attributeValue("author");
            System.out.println(author);
            Element name = book.element("name");
            Element price = book.element("price");
            System.out.println(name.getText()+"---"+price.getText());
        }
    }
}
