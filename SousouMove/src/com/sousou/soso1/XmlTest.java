package com.sousou.soso1;

import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;




public class XmlTest {
	public void xml(){
        try {  
            // 读取并解析XML文档  
            // SAXReader就是一个管道，用一个流的方式，把xml文件读出来  
            SAXReader reader = new SAXReader(); // User.hbm.xml表示你要解析的xml文档  
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("ceshi.xml");  
            Document doc = reader.read(in);  
            // 获取根节点  
            Element rootElt = doc.getRootElement();   
            //获取do节点  
            Element doElement = rootElt.element("do");   
            //获取do节点下的属性  
            String path=doElement.attributeValue("path");  
            String type=doElement.attributeValue("type");  
            //获取forward节点  
            Element forwardElement =doElement.element("forward");  
            //获取forward节点中的属性和文本值  
            String name=forwardElement.attributeValue("name");  
            String value=forwardElement.getText();  
            System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称  
            System.out.println("do节点："+doElement.getName());  
            System.out.println("do节点的属性path和type分别为："+path+"、"+type);  
            System.out.println("forward节点："+forwardElement.getName());  
            System.out.println("forward节点属性name为："+name);  
            System.out.println("forward节点的文本值为："+value);  
        } catch (DocumentException e) {  
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}
	public static void main(String[] args) {
		XmlTest a = new XmlTest();
		a.xml();
	}
}