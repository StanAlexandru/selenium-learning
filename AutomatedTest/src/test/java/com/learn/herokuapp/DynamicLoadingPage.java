package com.learn.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.learn.base.BasePageObject;

public class DynamicLoadingPage extends BasePageObject {
	
	private static final String PAGE = "http://the-internet.herokuapp.com/dynamic_loading/2";
	
	private By startButtonLocator = By.xpath("//button");

	private By finishLocator = By.xpath("//div[@id='finish']/h4[1]");

	public DynamicLoadingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void open() {
		// Open Page
		driver.get(PAGE);
		System.out.println("Page opened!");
		
	}
	
	public void clickStartButton(){
		// Get Start Button Element and click
		find(startButtonLocator).click();
	}

	public void waitForFinish() {
		// Define wait for 10 seconds
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.presenceOfElementLocated(finishLocator));
	}

	public String getFinishElementText() {
		// Get finish Element
		WebElement finish = driver.findElement(finishLocator);
		return finish.getText();
	}

}
