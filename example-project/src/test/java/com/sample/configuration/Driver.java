package com.sample.configuration;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	
	private Driver() {
		
	}
	
	private static WebDriver driver;
	
	private static final HashMap <String, Class<?>> map = new HashMap<String, Class<?>>() {
		{
			put("chrome", ChromeDriver.class);
			put("firefox", FirefoxDriver.class);
		}
	};
	
	public static void init(String browser, Capabilities capabilities) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> driverClass = map.get(browser);
		driver = (WebDriver) driverClass.getConstructor(Capabilities.class).newInstance(capabilities);
	}
	
	public static WebDriver get() {
		return driver;
	}

}
