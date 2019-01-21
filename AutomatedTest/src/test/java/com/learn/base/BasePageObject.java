package com.learn.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePageObject {
	
	protected WebDriver driver;

	public BasePageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void openUrl(String url) {
		// Open Page
		driver.get(url);
		System.out.println("Page opened!");
	}
	
	public WebElement find(By locator) {
		return driver.findElement(locator);
	}
	
	public String getPageSource() {
		return driver.getPageSource();
	}


}
