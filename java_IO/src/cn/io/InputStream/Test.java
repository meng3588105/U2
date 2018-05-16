package cn.io.InputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Test {
/**
 * 字节输入流
 * @param args
 */
	public static void main(String[] args) {
		try {
			//创建文件输入流对象
			InputStream is = new FileInputStream("io/io.txt");
			//创建字节输入流，可以看成一个'竹筒'
			byte[] buff = new byte[1024];
			//用于保存实际读取的字节数
			int hasRead=0;
			//舒勇循环宠物“取水”的一个过程
			while ((hasRead=is.read(buff))>0) {
				//取出“竹筒”中的水滴(字节)，将字节数组转换成字符串输入
				System.out.println(new String(buff,0,hasRead));
			}
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
