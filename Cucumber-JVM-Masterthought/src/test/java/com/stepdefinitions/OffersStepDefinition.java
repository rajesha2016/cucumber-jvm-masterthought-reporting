package com.stepdefinitions;

import org.junit.Assert;

import com.cucumber.context.TestContext;
import com.framework.libraries.LogUtils;
import com.pageobjects.OffersPage;
import com.pageobjects.RegistrationPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author r.moharana this is execution class for the offers page, valid
 *         cucumber glue codes for the feature file
 */
public class OffersStepDefinition {

	OffersPage offersPage;
	TestContext testContext;
	RegistrationPage registerPage;
	private static final LogUtils LOGGER = new LogUtils(OffersStepDefinition.class);

	public OffersStepDefinition(TestContext context) {

		testContext = context;
		offersPage = testContext.getPageObjectLibrary().getOffersPage();
		registerPage = testContext.getPageObjectLibrary().getRegistrationPage();
	}

	@Given("^User is on xyz offers page$")
	public void user_is_on_xyz_offers_page() throws Throwable {

		LOGGER.info("********** Validate interest rate offers feature execution started ***********");
		offersPage.navigateToOffersPage();
	}

	@When("^User selects easy access checkbox$")
	public void user_selects_easy_access_checkbox() throws Throwable {

		offersPage.clickEasyAccessCheckbox();
	}

	@Then("^User see same number of search offers matches to easy access$")
	public void user_see_same_number_of_search_offers_matches_to_easy_access() throws Throwable {

		Assert.assertTrue(offersPage.getEasyAccessOffersCount() == offersPage.getSearchCount());
		LOGGER.info("Easy access offers count matches to Search result");
	}

	@When("^User gets list of interest rate$")
	public void user_gets_list_of_interest_rate() throws Throwable {

		offersPage.findHighestInterestRate();
	}

	@Then("^User clicks on register for highest interest rate offer$")
	public void user_clicks_on_register_for_highest_interest_rate_offer() throws Throwable {

		offersPage.clickRegisterButton();
	}

	@And("^Register with xyz now page will be opened$")
	public void register_with_xyz_now_page_will_be_opened() throws Throwable {

		Assert.assertTrue(registerPage.getRegisterPageHeaderText().equals("Register with xyz now"));
		LOGGER.info("User successfully reached to regiestration page through offers");
		LOGGER.info("********** Validate interest rate offers feature execution completed ***********");
	}
}
