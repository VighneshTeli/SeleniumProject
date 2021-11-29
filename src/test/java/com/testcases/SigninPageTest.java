package com.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.pages.SigninPage;

public class SigninPageTest extends BasePage {
	SigninPage sp = new SigninPage();
	@BeforeMethod
	public void setup()
	{
		initialization();
	}
	
	@BeforeTest
	public void Reportsetup() {
		ExtentReportSetup();
	}
	
	
	@Test
	public void validateTitleTest()
	{
		ExtentTest test = extent.createTest("AmazonTitleTestCase");
		String actual = sp.validateTitle();
		Assert.assertEquals(actual,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		test.log(Status.PASS, "ValidateTitleTestCasePassed");
	}
	
	@Test
	public void validateLoginTest() throws InterruptedException
	{
		ExtentTest test = extent.createTest("AmazonLoginTestCase");
		String user = prop.getProperty("username");
		String passw = prop.getProperty("password");	
		String ans = sp.validateLogin(user,passw);
		Assert.assertEquals(ans,"Hello, Vighnesh");
		test.log(Status.PASS, "ValidateLoginTestCasePassed");
	}
	
	@Test
	public void validateAddressDisplayTest() throws InterruptedException
	{
		ExtentTest test = extent.createTest("AmazonAddressTestCase");
		validateLoginTest();
		Assert.assertTrue(sp.validateAddressDisplay());
		test.log(Status.PASS, "ValidateAddressTestCasePassed");
	}
	
	@AfterTest
	public void GenerateReport() {
		CloseReportSetup();
	}
	
	
	@AfterMethod
	public void setupend()
	{
		teardown();
	}
}
