package cn.io.Reader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Test02 {
	/**
	 * 字符输出流
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//创建字符输出流对象
			Writer fw = new  FileWriter("io/io.txt",true);
			String info = "哈哈哈哈哈";
			//写入数据
			fw.write(info);
			//关闭流
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
