package com.hopscotch.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class Search {
	
	WebDriver driver;

	@BeforeTest
	public void launchWebsite() throws IOException {
		driver = new ChromeDriver();
		driver.get(TestDataReader.webSiteUrl());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 12)
	public void searchProduct() throws InterruptedException, IOException {
		HopscotchWebsiteUtilitites.searchProduct(driver);
		Assert.assertTrue(SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.searchIdentifier()).isDisplayed());
	}
}