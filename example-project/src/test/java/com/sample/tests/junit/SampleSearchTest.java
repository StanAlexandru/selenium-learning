package com.sample.tests.junit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sample.configuration.Configuration;
import com.sample.configuration.Driver;

public class SampleSearchTest {
	
	private WebDriver driver;

	@Before
	public void setUp() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, FileNotFoundException, IOException {	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		Driver.init(Configuration.get("browser"), capabilities);
		driver = Driver.get();
		driver.get(Configuration.get("url"));
	}
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testSampleSearch() {
		driver.findElement(By.id("ss")).click();
		driver.findElement(By.id("ss")).clear();
		driver.findElement(By.id("ss")).sendKeys("London");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.id("ss")).click();
	}

}
