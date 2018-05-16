package cn.io.InputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test02 {
/**
 * 字节输出流
 * @param args
 */
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("io/io.txt",true);
			String info = "这就是爱";
			//创建字节输出流
			byte []buff = info.getBytes();
			//写入数据
			os.write(buff, 0, buff.length);
			//关闭流
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
