package com.hopscotch.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hopscotch.propertiesreaderutilities.SeleniumDOMReader;
import com.hopscotch.propertiesreaderutilities.TestDataReader;
import com.hopscotch.seleniumutilities.SeleniumGeneralUtilitites;
import com.hopscotch.seleniumutilities.SeleniumWorkerUtilities;
import com.hopscotch.websiteutilities.HopscotchWebsiteUtilitites;

public class UserProfile {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchWebsite() throws IOException {
		driver = new ChromeDriver();
		driver.get(TestDataReader.pdpUrl());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 10)
	public void testAddAddress() throws InterruptedException, IOException {
		HopscotchWebsiteUtilitites.addItemToCart(driver);
		HopscotchWebsiteUtilitites.increaseQty(driver, TestDataReader.qtyToBeIncreasedTo());
		HopscotchWebsiteUtilitites.addAddress(driver, TestDataReader.mobile(), TestDataReader.name(), TestDataReader.zipCode(), TestDataReader.address());
		Assert.assertTrue(SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.paymentIdentifier()).isDisplayed());
	}
	
	@Test(priority = 11)
	@Parameters({"loginName"})
	public void testChangeProfileDetails(String loginName) throws IOException, InterruptedException {
		driver.get(TestDataReader.webSiteUrl());
		HopscotchWebsiteUtilitites.loginWithCredentials(driver, TestDataReader.validUserName(), TestDataReader.validPassword());
		HopscotchWebsiteUtilitites.changeProfileDetails(driver, loginName);
		Assert.assertTrue(SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.profileUpdateMsgIdenitifier()).isDisplayed());
	}
	
}
