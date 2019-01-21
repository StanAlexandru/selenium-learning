package com.learn.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.learn.base.BaseTest;
import com.learn.herokuapp.DynamicLoadingPage;

public class TroubleshootingTest extends BaseTest{

	@Test
	public void waitTest(){
		
		DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);

		dynamicLoadingPage.open();

		dynamicLoadingPage.clickStartButton();

		dynamicLoadingPage.waitForFinish();

		Assert.assertTrue(dynamicLoadingPage.getFinishElementText().equals("Hello World!"), "'Hello World!' is not present");

	}

	@Test
	@Ignore
	public void visibilityTest() {
		
		// Open Page
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		System.out.println("Page opened!");

		// Get Start Button Element
		WebElement startButton = driver.findElement(By.xpath("//button"));

		System.out.println("Is Start Button visible/displayed before click " + startButton.isDisplayed());

		// Click Start Button
		startButton.click();

		// Define wait for 10 seconds
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4[1]")));

		// Get finish Element
		WebElement finish = driver.findElement(By.xpath("//div[@id='finish']/h4[1]"));

		Assert.assertTrue(finish.getText().equals("Hello World!"), "'Hello World!' is not present");

		System.out.println("Is Start Button visible/displayed after click " + startButton.isDisplayed());
		if (startButton.isDisplayed()) {
			// Click Start Button
			startButton.click();
		}

	}

	@Test(expectedExceptions = StaleElementReferenceException.class)
	@Ignore
	public void staleElementTest() {

		// Open Page
		driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
		System.out.println("Page opened!");

		// Get Start Button Element
		WebElement link = driver.findElement(By.linkText("Click here"));

		link.click();

		// Wait for Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

		WebElement message = driver.findElement(By.id("flash"));

		link.click();
		System.out.println("Message: " + message);

		// stale element reference: element is not attached to the page document
		link.click();
		System.out.println("Message: " + message);

	}

	@Test
	@Ignore
	public void scrollTest() throws InterruptedException {

		// Open Page
		driver.get("http://the-internet.herokuapp.com/large");
		System.out.println("Page opened!");

		Thread.sleep(2000);

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0, 250)", "");

		Thread.sleep(2000);

	}

	@Test
	@Ignore
	public void hoverTest() throws InterruptedException {

		// Open Page
		driver.get("http://the-internet.herokuapp.com/hovers");
		System.out.println("Page opened!");

		WebElement picture = driver.findElement(By.xpath("//div[@class='figure']"));

		Actions action = new Actions(driver);
		action.moveToElement(picture).build().perform();
		Thread.sleep(3000);

		WebElement link = driver.findElement(By.xpath("//a[contains(text(), 'View profile')]"));
		link.click();
		Thread.sleep(3000);

	}

}
