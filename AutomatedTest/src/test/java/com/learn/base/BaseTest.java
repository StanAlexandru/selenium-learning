package com.learn.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	protected void setUp() {
		driver = createChromeDriver();
	}

	private WebDriver createChromeDriver() {
		// Creating Driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Every time the driver does not find an element 
		// on the page it will wait for 10 seconds
		
		//Implicit wait is applied to ALL elements in the Scripts
		//Explicit wait needs ExpectedConditions
		//NOT A GOOD PRACTICE TO 
		//MAKE ALL TESTS WAIT FOR ELEMENTS
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}

	@AfterMethod(alwaysRun = true)
	protected void tearDown() {		
		// Quit Driver
		driver.quit();
	}
}
