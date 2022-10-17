package com.junxiao.xml;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class LoadXmlFileTest {

    private static String tableName = "items";

    @Test
    public void testLoad() throws URISyntaxException {
//        String filePath = "E:\\files\\sample1.xml";
//        File xmlFile = new File(filePath);
        File xmlFile = new File(LoadXmlFileTest.class.getResource("/sample1.xml").toURI().getPath());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc = null;
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        if(doc != null) {
            System.out.println("Root element:" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("item");
            System.out.println("Nodes:");
            for (int i = 0; i < nodeList.getLength(); i ++) {
                Node node = nodeList.item(i);
                System.out.println("\nNode Element:" + node.getNodeName() );
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element ele = (Element) node;
                    System.out.println("item-id:" + ele.getElementsByTagName("item-id").item(0).getTextContent());
                    System.out.println("item-name:" + ele.getElementsByTagName("item-name").item(0).getTextContent());
                    System.out.println("item-cost:" + ele.getElementsByTagName("item-cost").item(0).getTextContent());

                    StringBuilder sb = new StringBuilder();
                    sb.append("insert into "+ tableName + " values");
                    sb.append('(');
                    sb.append(ele.getElementsByTagName("item-id").item(0).getTextContent() + ", ");
                    sb.append(ele.getElementsByTagName("item-name").item(0).getTextContent() + ", ");
                    sb.append(ele.getElementsByTagName("item-cost").item(0).getTextContent());
                    sb.append(");");
                    System.out.println("SQL query: " + sb.toString());
                }
            }
        }

    }
}
