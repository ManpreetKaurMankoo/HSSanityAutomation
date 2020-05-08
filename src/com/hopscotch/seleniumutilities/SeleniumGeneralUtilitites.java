package com.hopscotch.seleniumutilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumGeneralUtilitites {
	
//	WebDriverWait w;
	
	public static WebElement findElementById(WebDriver driver, String id) {
		return driver.findElement(By.id(id));
	}
	
	public static WebElement findElementByLinkText(WebDriver driver, String linkText) {
		return driver.findElement(By.linkText(linkText));
	}
	
	public static WebElement findElementByCss(WebDriver driver, String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector));
	}
	
	public static WebElement findElementByXpath(WebDriver driver, String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	public static WebElement findElementByName(WebDriver driver, String name) {
		return driver.findElement(By.name(name));
	}
	
	public static WebElement findElementByClassName(WebDriver driver, String className) {
		return driver.findElement(By.className(className));
	}
	
	public static void clickElement(WebElement element) {
		element.click();
	}
	
	public static void sendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}
	
	public static String getText(WebElement element) {
		return element.getText();
	}
	
	public static void clearText(WebElement element) {
		element.clear();
	}
	
	public static void enter(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}
	
	public static boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
//	public static boolean checkContains(WebElement element, String data) {
//		return element.contains(data);
//	}
	
	public static List<WebElement> findElementsByCss(WebDriver driver, String cssSelector) {
		return driver.findElements(By.cssSelector(cssSelector));
	}
	
	public static void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public static void explicitWait(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
//		WebDriverWait w = new WebDriverWait(driver, 20);
//		w.until(ExpectedConditions.elementToBeClickable(element));
	}
	
//	public static void explicitWaitForElementToAppear(WebElement element) {
//		w = new WebDriverWait(driver, 20);
//		w.until(ExpectedConditions.(element));
//	}
	
//	public static void explicitWaitForElementToDisappear(WebElement element) {
//		w = new WebDriverWait(driver, 20);
//		w.until(ExpectedConditions.(element));
//}
	
//	@BeforeMethod
//	public void launchWebsite() {
//		WebDriver driver = new ChromeDriver();
//		driver.get(Login.webSiteName);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//	}
	
//	@AfterMethod
//    public void terminateBrowser(){
//        driver.quit();
//    }
}
