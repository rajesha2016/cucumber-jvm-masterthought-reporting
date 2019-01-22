package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author r.moharana this class is common to both the features
 */
public class RegistrationPage {

	WebDriver driver;

	public RegistrationPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Register')]")
	private WebElement registerwithxyz;

	public String getRegisterPageHeaderText() {

		return registerwithxyz.getText().trim();

	}
}
