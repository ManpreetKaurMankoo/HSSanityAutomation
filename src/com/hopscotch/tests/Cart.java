package com.hopscotch.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hopscotch.propertiesreaderutilities.SeleniumDOMReader;
import com.hopscotch.propertiesreaderutilities.TestDataReader;
import com.hopscotch.seleniumutilities.SeleniumGeneralUtilitites;
import com.hopscotch.seleniumutilities.SeleniumWorkerUtilities;
import com.hopscotch.websiteutilities.HopscotchWebsiteUtilitites;

public class Cart {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchWebsite() throws IOException {
		driver = new ChromeDriver();
		driver.get(TestDataReader.pdpUrl());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 7, groups = {"Cart"})
	public void testAddToCart() throws NumberFormatException, InterruptedException, IOException {
		int cartQty = Integer.parseInt(HopscotchWebsiteUtilitites.addItemToCart(driver));
		Assert.assertEquals(cartQty, TestDataReader.expectedQtyToBeAdded());
	}
	
	@Test(priority = 8, dependsOnGroups = {"Cart"})
	public void testIncreaseCartQty() throws NumberFormatException, InterruptedException, IOException{
		int increasedQty = Integer.parseInt(HopscotchWebsiteUtilitites.increaseQty(driver, TestDataReader.qtyToBeIncreasedTo()));
		Assert.assertEquals(increasedQty, TestDataReader.qtyToBeIncreasedTo());
	}
	
	@Test(priority = 9, dependsOnGroups = {"Cart"}, groups = {"Pincode"})
	public void testAddPincode() throws InterruptedException, IOException {
		HopscotchWebsiteUtilitites.enterPincode(driver);
		Assert.assertTrue(SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.EddIdentifier()).isDisplayed());
	}
}
