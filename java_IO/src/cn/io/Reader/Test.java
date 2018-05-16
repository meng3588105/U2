package cn.io.Reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
/**
 * 字符输入流
 * @author 孟祥龙
 *
 */
public class Test {

	public static void main(String[] args) {
	
		try {	//创建字符输入流对象
			Reader fr =new FileReader("io/io.txt");
			
			//创建字符流
			char[] c = new char[32];
			int info = 0; //实际接受的字符串
			while ((info = fr.read(c))>0) {
				System.out.println(new String(c,0,info));
			}
			fr.close();//关闭流
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
