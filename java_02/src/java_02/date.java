package java_02;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class date {
	public static void main(String[] args) {
		
		Date date1=new Date();//创建一个日历对象
		System.out.println(date1);//输出系统当前时间
		SimpleDateFormat ss=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");//时间日期转换格式类
		System.out.println("转换完成后:"+ss.format(date1));//转换
		
		
	}
	
}
