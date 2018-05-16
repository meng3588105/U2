package cn.mxl.kkk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {

	public static void main(String[] args) {
		//杈撳叆娴�
				InputStream fis = null;
				//杈撳嚭娴�
				OutputStream fos=null;
				
				try {
					fis= new FileInputStream("G:/IO/2323.png");//璇诲彇
					fos = new FileOutputStream("G:/IO/232.png",true);//杈撳嚭
					
					int len;//瀛樺偍璇诲叆鏁扮粍鐨勯暱搴�
					byte[]words = new byte[1024];
					while((len=fis.read(words))!=-1){
						System.out.println(new String(words,0,len));
						fos.write(words,0,len);
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				finally{
					//鍏抽棴娴�
					try {
						if (fis!= null) {
							fis.close();
						}
					} catch (IOException e) {
						
						e.printStackTrace();
					}

			}

			}
	}


