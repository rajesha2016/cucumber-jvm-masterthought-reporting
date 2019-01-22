package com.framework.libraries;

import org.openqa.selenium.WebDriver;

import com.pageobjects.OffersPage;
import com.pageobjects.PartnerBankPage;
import com.pageobjects.RegistrationPage;

/**
 * @author r.moharana This class helps to create every page object. If
 *         applications have multiple step definitions file then with the help
 *         of this class we can avoid object creation again and again in step
 *         definition files
 */
public class PageObjectLibrary {

	private WebDriver driver;
	private OffersPage offersPage;
	private PartnerBankPage partnerPage;
	private RegistrationPage registerPage;

	public PageObjectLibrary(WebDriver driver) {

		this.driver = driver;
	}

	// initialize OffersPage object, if already present then return the
	// current instance.
	public OffersPage getOffersPage() {

		return (offersPage == null) ? offersPage = new OffersPage(driver) : offersPage;
	}

	// initialize PartnerBankPage object, if already present then return
	// the current instance.
	public PartnerBankPage getPartnerBankPage() {

		return (partnerPage == null) ? partnerPage = new PartnerBankPage(driver) : partnerPage;
	}

	// initialize RegistrationPage object, if already present then return the
	// current instance.
	public RegistrationPage getRegistrationPage() {

		return (registerPage == null) ? registerPage = new RegistrationPage(driver) : registerPage;
	}

}
