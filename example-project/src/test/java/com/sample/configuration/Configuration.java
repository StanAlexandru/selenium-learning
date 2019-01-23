package com.sample.configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Configuration {
	
	private static Properties properties;
	
	public static void load() throws FileNotFoundException, IOException {
		properties = new Properties();
		
		try (
			InputStream is = new FileInputStream(new File("config.properties"));
			BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))){
				properties.load(br);				
		} 
	} 

	public static String get(String option) throws FileNotFoundException, IOException {
		if(properties == null) {
			load();
		}		
		String value = properties.getProperty(option);
		if(value == null) {
			return "";
		}
		return value;
	}
}
