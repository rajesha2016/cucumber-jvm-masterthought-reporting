package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.libraries.Utilities;

/**
 * @author r.moharana common scenario handle for feature files
 */
public class CommonPage {

	WebDriver driver;

	public CommonPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'OK')]")
	private WebElement selectRegionSubmitButton;

	public void checkSelectRegionPopup() {
		Utilities.waitForVisibilityofElement(driver, selectRegionSubmitButton);
		selectRegionSubmitButton.click();
		Utilities.waitForGivenTime(2000);
	}

}
