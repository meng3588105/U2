package cn.mxl.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class Log4j_Demo {

		public static void main(String[] args) throws Exception{
			//创建logger对象
			Logger logger=Logger.getLogger(Log4j_Demo.class);
			//HTMLLayout html=new HTMLLayout();HTML格式
			//创建出需要指定的日志格式对象
			SimpleLayout layout=new SimpleLayout();
			//创建出需要指定的日志文件对象
			//第一个参数：输出端格式		第二个参数：输出位置		第三个参数:控制输出日志是否追加
			FileAppender appender=new FileAppender(layout,"G:/Log4J_Demo/log4j.log",true);
			//为Logger对象加入一个输出端
			logger.addAppender(appender);
			//指定默认配置
			BasicConfigurator.configure();
			//指定日志的输出级别
			logger.setLevel(Level.DEBUG);
			logger.debug("debug");
			logger.info("info");
			logger.error("error");
									
		}
			
}
