package com.learn.base;

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
		return driver;
	}

	@AfterMethod(alwaysRun = true)
	protected void tearDown() {		
		// Quit Driver
		driver.quit();;
	}
}
