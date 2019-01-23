package com.sample.tests.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleSearchTest {
	
	private ChromeDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("http://booking.com");
	}
	@AfterMethod
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
