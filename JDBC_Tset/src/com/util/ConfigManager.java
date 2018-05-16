package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

	private static ConfigManager manager = new ConfigManager();
	private static Properties properties;

	private ConfigManager() {
		properties = new Properties();
		InputStream stream = ConfigManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			properties.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static synchronized ConfigManager getInstance() {
		return manager;
	}

	public static String getValue(String key) {
		return properties.getProperty(key);
	}

}