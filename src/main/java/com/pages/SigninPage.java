package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class SigninPage extends BasePage {
	
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
	
	
	public String validateLogin(String id, String pass) throws InterruptedException
	{
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.findElement(By.id("ap_email")).sendKeys(id);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys(pass);
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(3000);
		String actual = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
		return actual;
	}
	
	public boolean validateAddressDisplay()
	{
		boolean add = driver.findElement(By.id("nav-global-location-popover-link")).isDisplayed();
		return add;
	}
}
