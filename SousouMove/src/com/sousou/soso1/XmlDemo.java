package com.sousou.soso1;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlDemo {
	
	MobileCard mobileCard = new MobileCard();
	 Document document = null; // dom树
	
	 
	/**
	 * 目的：  获取dom树
	 * @param file 需要 解析的xml文件
	 * @throws IOException 
	 */

	private static void addClass() throws IOException {
		 Element root = null; // dom树的根节点
		// 创建Document 实例
		Document document = DocumentHelper.createDocument();
		// 创建一个根节点
		root = document.addElement("GEN");
		// 在根节点下创建一个新节点
		Element classElement = root.addElement("JIHE");	
		// 给class节点新增属性
		classElement.addAttribute("ID", "13900000000");

				
				
				
				XMLWriter writer = null; // 创建输出流对象
				OutputFormat format = null;
				// 创建输出流格式化对象
				format = OutputFormat.createPrettyPrint();
				format.setEncoding("UTF-8"); // 设置编码格式
				writer = new XMLWriter(new FileWriter("xmlxml.xml"), format);
				// 真正的把dom树再次写入 xml文件中
				writer.write(document);
	
	}	
	
	public static void main(String[] args) {
		try {
			addClass();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
