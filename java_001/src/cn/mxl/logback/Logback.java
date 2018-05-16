
package cn.mxl.logback;

import java.io.IOException;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

public class Logback {

	
	public static void main(String[] args) throws IOException, JoranException {
		//找到logback.xml 配置文件
		load("G:\\Logback_Demo\\Logback_Base/logback.xml");
		org.slf4j.Logger logger = LoggerFactory.getLogger(Logback.class);
		logger.debug("你好!我是Logback");
	}
	
	public static void load(String externalConfigFileLocation)
			throws IOException, JoranException {
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		JoranConfigurator configurator = new JoranConfigurator();
		configurator.setContext(lc);
		lc.reset();
		configurator.doConfigure(externalConfigFileLocation);
		StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
	}
}

