package com.sample.tests.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleSearchTest {
	
	private ChromeDriver driver;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("http://booking.com");
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
