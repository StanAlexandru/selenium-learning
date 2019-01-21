package com.learn.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.learn.base.BasePageObject;

public class SecurePage extends BasePageObject{	
	
	By logoutButtonLocator = By.xpath("//a[@class='button secondary radius']");

	public SecurePage(WebDriver driver) {
		super(driver);
	}
	
	public void waitForLogoutButton() {
		// Requires selenium-chrome-driver replaced with selenium-java dependency
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(logoutButtonLocator));
	}
	
	
	public boolean islogoutButtonDisplayed() {
		// Verify logout button is displayed
		return find(logoutButtonLocator).isDisplayed();
	}

}
