package com.learn.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learn.base.BasePageObject;

public class LoginPage extends BasePageObject{
	
	
	private static final String PAGE = "http://the-internet.herokuapp.com/login";
	
	private static final String USERNAME = "tomsmith";
	private static final String PASSWORD = "SuperSecretPassword!";
	
	private By usernameLocator = By.id("username");
	private By passwordLocator = By.cssSelector("input[name=password]");
	private By loginButtonLocator = By.xpath("//button[@type='submit']");
	

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void openPage() {
		openUrl(PAGE);
	}
	
	public SecurePage login() {
		
		// Typing username and Password
		// Enter tomsmith for the username and SuperSecretPassword! for the password.
		find(usernameLocator).sendKeys(USERNAME);
		find(passwordLocator).sendKeys(PASSWORD);
		
		// Pause test for 2 seconds to view set values
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Click login button
		find(loginButtonLocator).click();
		
		return new SecurePage(driver);
	}	

}
