package com.hopscotch.websiteutilities;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hopscotch.propertiesreaderutilities.SeleniumDOMReader;
import com.hopscotch.propertiesreaderutilities.TestDataReader;
import com.hopscotch.seleniumutilities.SeleniumGeneralUtilitites;
import com.hopscotch.seleniumutilities.SeleniumWorkerUtilities;

public class HopscotchWebsiteUtilitites {
	
	public static void loginWithCredentials(WebDriver driver, String username, String password) throws IOException {
		
		WebElement accountLinkText = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.accountIdentifier());
		SeleniumGeneralUtilitites.clickElement(accountLinkText);
		
		WebElement primarySignInCss = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.primarySignInCssIdentifier());
		SeleniumGeneralUtilitites.clickElement(primarySignInCss);
		
		WebElement emailLinkText = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.emailLinkIdentifier());
		SeleniumGeneralUtilitites.clickElement(emailLinkText);
		
		WebElement loginId = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.loginIdIdentifier());
		SeleniumGeneralUtilitites.sendKeys(loginId, username);
		
		WebElement loginPassword = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.loginPasswordIdentifier());
		SeleniumGeneralUtilitites.sendKeys(loginPassword, password);
		
		WebElement signInXpath = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.signInXpathIdentifier());
		SeleniumGeneralUtilitites.clickElement(signInXpath);
	}

// Doubt 2 : does not give contains() method under SeleniumGeneralUtilities
//	public static boolean containsAssertion(WebDriver driver, String data) {
//		
//		WebElement emailContains = SeleniumGeneralUtilitites.findElementByXpath(driver, "//*[@class='account-info']//div[2]");
//		return SeleniumGeneralUtilitites.checkContains(emailContains, data);
//	}

	
	public static String addItemToCart(WebDriver driver) throws InterruptedException, IOException {
		
		Thread.sleep(2000); // Used this because unable to identify how to use the abstracted implicit/explicit methods of SeleniumGeneralUtilities
		
		WebElement selectSize = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.selectSizeIdentifier());
		SeleniumGeneralUtilitites.clickElement(selectSize);
		
		List<WebElement> selectFirstSize = SeleniumGeneralUtilitites.findElementsByCss(driver, ".option.ng-scope");
		SeleniumGeneralUtilitites.clickElement(selectFirstSize.get(0)); // doubt - get is a selenium method, so it will also have to be abstracted? Not able to achieve it.
		
		WebElement addToCartButton = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.addToCartIdentifier());
		SeleniumGeneralUtilitites.clickElement(addToCartButton);
		
		WebElement qty = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.qtyIdentifier());
		SeleniumGeneralUtilitites.explicitWait(driver, qty);
		return SeleniumGeneralUtilitites.getText(qty);
	}
	
	public static String increaseQty(WebDriver driver, int qtyToBeIncreasedTo) throws InterruptedException, IOException {
		
		WebElement cartIcon = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.cartIconIdentifier());
//		SeleniumGeneralUtilitites.explicitWait(driver, cartIcon);
		SeleniumGeneralUtilitites.clickElement(cartIcon);
		
		WebElement selectBox = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.selectBoxIdentifier()); // space at the end
		SeleniumGeneralUtilitites.clickElement(selectBox);
		
		List<WebElement> qtyDropDown = SeleniumGeneralUtilitites.findElementsByCss(driver, ".item");
		SeleniumGeneralUtilitites.clickElement(qtyDropDown.get(qtyToBeIncreasedTo-1)); // doubt - get is a selenium method, so it will also have to be abstracted? Not able to achieve it.

		Thread.sleep(2000); // Doubt 3 - Used this because unable to identify how to use the abstracted implicit/explicit methods of SeleniumGeneralUtilities - Tried below - but not working
//		SeleniumGeneralUtilitites.explicitWait(driver, SeleniumGeneralUtilitites.findElementByXpath(driver, "//*[@class='label ']"));
//		WebElement qtyLabel = SeleniumGeneralUtilitites.findElementByXpath(driver, "//*[@class='label ']");
//		String qtyText = SeleniumGeneralUtilitites.getText(qtyLabel);
		
		WebElement qtyLabel = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.qtyLabelIdentifier());
		String qtyText = SeleniumGeneralUtilitites.getText(qtyLabel);
		String arrQtyLabel[] = qtyText.split(" ");
		String increasedQty = arrQtyLabel[1];
		return increasedQty;	
	}
	
	public static void enterPincode(WebDriver driver) throws IOException {
		
		WebElement pincodeContainer = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.pincodeContainerIdentifier());
//		SeleniumGeneralUtilitites.explicitWait(driver, pincodeContainer);
		SeleniumGeneralUtilitites.clickElement(pincodeContainer);
		
		WebElement pincodeField = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.pincodeIdentifier());
		SeleniumGeneralUtilitites.clickElement(pincodeField);
		
		SeleniumGeneralUtilitites.sendKeys(pincodeField, TestDataReader.zipCode());
		
		WebElement confirmPincode = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.confirmPincodeIdentifier());
		SeleniumGeneralUtilitites.clickElement(confirmPincode);
	}
	
	public static void addAddress(WebDriver driver, String mobile, String name, String zipCode, String address) throws IOException {
		WebElement checkOutButton = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.checkOutButtonIdentifier());
		SeleniumGeneralUtilitites.clickElement(checkOutButton);
		
		WebElement mobileText = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.mobileTextIdentifier());
		SeleniumGeneralUtilitites.sendKeys(mobileText, mobile);
		
		WebElement continueForMobButton = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.continueForMobButtonIdentifier());
		SeleniumGeneralUtilitites.clickElement(continueForMobButton);
		
		WebElement cancelLink = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.cancelLinkIdentifier());
		SeleniumGeneralUtilitites.clickElement(cancelLink);
		
		WebElement nameText = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.nameTextIdentifier());
		SeleniumGeneralUtilitites.sendKeys(nameText, name);
		
		WebElement pincodeText = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.pincodeTextIdentifier());
		SeleniumGeneralUtilitites.sendKeys(pincodeText, zipCode);
		
		WebElement addressText = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.addressTextIdentifier());
		SeleniumGeneralUtilitites.explicitWait(driver, addressText);
		SeleniumGeneralUtilitites.sendKeys(addressText, address);
		
//		WebElement cityText = SeleniumGeneralUtilitites.findElementByName(driver, "city");
//		SeleniumGeneralUtilitites.sendKeys(cityText, city);
//		
//		WebElement stateText = SeleniumGeneralUtilitites.findElementByName(driver, "state");
//		SeleniumGeneralUtilitites.sendKeys(stateText, state);
//	
		WebElement continueForAddButton = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.continueForAddButtonIdentifier());
		SeleniumGeneralUtilitites.explicitWait(driver, continueForAddButton);
		SeleniumGeneralUtilitites.clickElement(continueForAddButton);
	}
	
	public static void changeProfileDetails(WebDriver driver, String name) throws IOException, InterruptedException {
		WebElement profileButton = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.profileButtonIdentifier());
	//	SeleniumGeneralUtilitites.explicitWait(driver, profileButton);
		Thread.sleep(2000);
		SeleniumGeneralUtilitites.clickElement(profileButton);
		
		WebElement profileName = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.profileNameIdentifier());
		SeleniumGeneralUtilitites.clickElement(profileName);
		
		WebElement changeName = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.changeNameIdentifier());
		SeleniumGeneralUtilitites.clickElement(changeName);
		SeleniumGeneralUtilitites.clearText(changeName);
		SeleniumGeneralUtilitites.sendKeys(changeName, name);
		
		WebElement saveButton = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.saveButtonIdentifier());
		SeleniumGeneralUtilitites.clickElement(saveButton);
		
	}
	
	public static void searchProduct(WebDriver driver) throws IOException {
		WebElement search = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.searchProductIdentifier());
//		SeleniumGeneralUtilitites.explicitWait(driver, search);
		SeleniumGeneralUtilitites.clickElement(search);
		
		WebElement searchText = SeleniumWorkerUtilities.workWithWebElement(driver, SeleniumDOMReader.searchTextIdentifier());
		SeleniumGeneralUtilitites.sendKeys(searchText, TestDataReader.product());
		SeleniumGeneralUtilitites.enter(searchText);
	}
}
