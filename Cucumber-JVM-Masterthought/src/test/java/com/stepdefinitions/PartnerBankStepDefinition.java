package com.stepdefinitions;

import org.junit.Assert;

import com.cucumber.context.TestContext;
import com.framework.libraries.LogUtils;
import com.pageobjects.PartnerBankPage;
import com.pageobjects.RegistrationPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author r.moharana this is execution class for the partner bank page,
 *         valid cucumber glue codes for the feature file
 */
public class PartnerBankStepDefinition {

	TestContext testContext;
	PartnerBankPage partnerPage;
	RegistrationPage registerPage;
	private static final LogUtils LOGGER = new LogUtils(PartnerBankStepDefinition.class);

	public PartnerBankStepDefinition(TestContext context) {

		testContext = context;
		partnerPage = testContext.getPageObjectLibrary().getPartnerBankPage();
		registerPage = testContext.getPageObjectLibrary().getRegistrationPage();
	}

	@Given("^User is on xyz partner banks page$")
	public void user_is_on_xyz_partner_banks_page() throws Throwable {

		LOGGER.info("********** Validate partner bank feature execution started ***********");
		partnerPage.navigateToPartnerBankPage();
	}

	@When("^User selects Learn More for the bank having A1 Moody's country rating$")
	public void user_selects_Learn_More_for_the_bank_having_A_Moody_s_country_rating() throws Throwable {

		partnerPage.clickLearnMoreOfA1RatingBank();
	}

	@Then("^User navigates to corresponding partner bank's offers page and can see Invest now option$")
	public void user_navigates_to_corresponding_partner_bank_s_offers_page_and_can_see_Invest_now_option()
			throws Throwable {

		Assert.assertTrue(partnerPage.verifyPartnerBankNameinHeader());
	}

	@When("^User click on Invest now button$")
	public void user_click_on_Invest_now_button() throws Throwable {

		partnerPage.clickInvestNow();
	}

	@Then("^User navigates to registration page$")
	public void user_navigates_to_registration_page() throws Throwable {

		Assert.assertTrue(registerPage.getRegisterPageHeaderText().equals("Register with xyz now"));
		LOGGER.info("User successfully reached to regiestration page through partner bank");
		LOGGER.info("********** Validate xyz partner bank feature execution completed ***********");
	}

}
