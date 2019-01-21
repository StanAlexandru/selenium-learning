package com.learn.test;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.learn.base.BaseTest;
import com.learn.herokuapp.LoginPage;
import com.learn.herokuapp.SecurePage;

public class FirstTest extends BaseTest{
	
	
	@Test
	@Ignore("openPageTest is included in loginTest")
	public void openPageTest() {	
		
		// Open Page
		driver.get("http://the-internet.herokuapp.com/login");
		System.out.println("Page opened!");
		
		// Pause test for 5 seconds to view the page
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	@Test
	public void loginTest() {	
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.openPage();
		
		SecurePage securePage = loginPage.login();
		
		securePage.waitForLogoutButton();
				
		Assert.assertTrue(securePage.islogoutButtonDisplayed(), "Logout Button is not displayed");
		
		// Verify 'You logged into a secure area!' is present
		Assert.assertTrue(securePage.getPageSource().contains("You logged into a secure area!"), "'You logged into a secure area!' is not present");
		
	}

}
