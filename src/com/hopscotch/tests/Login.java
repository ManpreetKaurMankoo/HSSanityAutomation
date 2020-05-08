package com.hopscotch.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hopscotch.propertiesreaderutilities.SeleniumDOMReader;
import com.hopscotch.propertiesreaderutilities.TestDataReader;
import com.hopscotch.seleniumutilities.SeleniumGeneralUtilitites;
import com.hopscotch.seleniumutilities.SeleniumWorkerUtilities;
import com.hopscotch.websiteutilities.HopscotchWebsiteUtilitites;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Login {
	
	public WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	
//	@BeforeClass
//	public static void startTest() {
//		report = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReportsResults.html");
//		test = report.startTest("LoginReport");
//	}
	
	@BeforeMethod //Doubt 1 - Unable to use the same driver instance if BeforeMethod is abstracted under SeleniumGeneralUtilities
	public void launchWebsite() throws IOException {
		
//		ChromeOptions chrome_options = new ChromeOptions();
//		chrome_options.addArguments("--no-sandbox");
//		chrome_options.addArguments("--headless");
//		chrome_options.addArguments("--disable-dev-shm-usage");
//		
		driver = new ChromeDriver();
		driver.get(TestDataReader.webSiteUrl());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	
//	@AfterClass
//	public static void endTest() {
//		report.endTest(test);
//		report.flush();
//	}
	
//	@AfterMethod
//    public void terminateBrowser(){
//        driver.quit();
//    }
	
	// Login with valid credentials
	@Test(priority = 0)
	@Parameters({"loginName"})
	public void emailLoginWithValidCredentials(String loginName) throws IOException {
		HopscotchWebsiteUtilitites.loginWithCredentials(driver, TestDataReader.validUserName(), TestDataReader.validPassword());

		WebElement email = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.emailIdentifier());
		Assert.assertTrue(email.isDisplayed() && email.getText().contains(loginName));
//		if(TestDataReader.validUserName().equals(email.getText()))
//			test.log(LogStatus.PASS, "Logged in with valid credentials");
//		else
//			test.log(LogStatus.FAIL, "Did not log in with valid credentials");
	}
	
	// Login with invalid password
	@Test(priority = 1)
	public void emailLoginWithInvalidPassword() throws IOException {
		HopscotchWebsiteUtilitites.loginWithCredentials(driver, TestDataReader.validUserName(), TestDataReader.invalidPassword());
		Assert.assertTrue(SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.invalidLoginMsgIdentifier()).isDisplayed());
//		if((SeleniumDOMReader.invalidLoginMsgIdentifier().)
//			test.log(LogStatus.PASS, "Did not login due to Invalid password");
//		else
//			test.log(LogStatus.FAIL, "invalid password login case failed");
	}
	
	// Login with invalid username
	@Test(priority = 3)
	public void emailLoginWithInvalidUsername() throws IOException {		
		HopscotchWebsiteUtilitites.loginWithCredentials(driver, TestDataReader.invalidUserName(), TestDataReader.validPassword());
		Assert.assertTrue(SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.invalidLoginMsgIdentifier()).isDisplayed());
	}
	
	// Login with valid mob credentials
	@Test(priority = 4)
	@Parameters({"loginName"})
	public void mobLoginWithValidCredentials(String loginName) throws IOException {
		HopscotchWebsiteUtilitites.loginWithCredentials(driver, TestDataReader.validMobile(), TestDataReader.validMobPassword());
		
		WebElement email = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.emailIdentifier());
		Assert.assertTrue(email.isDisplayed() && email.getText().contains(loginName));
	}
	
	// Login with invalid mob password
	@Test(priority = 5)
	public void mobLoginWithInvalidPassword() throws IOException {
		HopscotchWebsiteUtilitites.loginWithCredentials(driver, TestDataReader.validMobile(), TestDataReader.invalidPassword());
		Assert.assertTrue(SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.invalidLoginMsgIdentifier()).isDisplayed());
	}
	
	// Login with invalid mob no
	@Test(priority = 6)
	public void mobLoginWithInvalidMobile() throws IOException {			
		HopscotchWebsiteUtilitites.loginWithCredentials(driver, TestDataReader.invalidMobile(), TestDataReader.validMobPassword());
		Assert.assertTrue(SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.invalidMobPasswordMsgIdentifier()).isDisplayed());
	}

	
}
