package com.pageobjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.libraries.FileReaderLibrary;
import com.framework.libraries.LogUtils;
import com.framework.libraries.Utilities;

/**
 * @author r.moharana this class helps the activities of offers page
 *         every action on the page is done here
 */
public class OffersPage extends CommonPage{

	WebDriver driver;
	static String highestInterestRate;
	CommonPage commonPage;
	private static final LogUtils LOGGER = new LogUtils(OffersPage.class);

	public OffersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'OK')]")
	private WebElement selectRegionSubmitButton;

	@FindBy(how = How.ID, using = "early_termination_cb")
	private WebElement easyAccessCheckboxInput;

	@FindBy(how = How.XPATH, using = "//input[@id='early_termination_cb']/../..")
	private WebElement easyAccessCheckboxLabel;

	@FindBy(how = How.XPATH, using = "//*[@class='prot-listing-count-element ng-scope']")
	private WebElement easyAccessSearchCount;

	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Register')]")
	private WebElement registerwith;

	// navigate to offers page
	public void navigateToOffersPage() {

		driver.get(FileReaderLibrary.getInstance().getConfigReader().getApplicationUrl() + "our-offers/");
	}

	public void clickEasyAccessCheckbox() {

		checkSelectRegionPopup();
		Utilities.waitForVisibilityofElement(driver, easyAccessCheckboxInput);
		easyAccessCheckboxInput.click();

	}

	public int getEasyAccessOffersCount() {

		String easyAccessLabel = easyAccessCheckboxLabel.getText().trim();
		LOGGER.info("Easy access offers count is " + getCountFromText(easyAccessLabel));
		return getCountFromText(easyAccessLabel);
	}

	public int getSearchCount() {

		String easySearchCount = easyAccessSearchCount.getText().trim();
		LOGGER.info("Offer Search count is " + getCountFromText(easySearchCount));
		return getCountFromText(easySearchCount);
	}

	// this method get the integer value from the string
	public int getCountFromText(String text) {
		String txt = Utilities.getTextGivenExpression(text, "\\d+");
		return Integer.parseInt(txt);
	}

	// this method get the float value from the string
	public double getInterestFromText(String interest) {

		String interestRate = Utilities.getTextGivenExpression(interest, "[-+]?[0-9]*\\.?[0-9]+");

		return Double.parseDouble(interestRate);
	}

	public void clickRegisterButton() {

		driver.findElement(By.xpath("//div[contains(text(),'" + highestInterestRate
				+ "')]/../../..//span[contains(text(),'Register now')]")).click();
	}

	// this method find the highest interest rate on search results
	public void findHighestInterestRate() {

		List<Double> intRateList = new ArrayList<Double>();

		List<WebElement> interestRate = driver
				.findElements(By.xpath("//div[@class='prot-offer-header-interest-rate']"));

		for (WebElement rate : interestRate) {
			intRateList.add(getInterestFromText(rate.getText().trim()));
		}

		// get the arraylist in descending order
		Collections.sort(intRateList, (I1, I2) -> (I1 > I2) ? -1 : (I1 < I2) ? 1 : 0);
		highestInterestRate = String.valueOf(intRateList.get(0));
		LOGGER.info("The highest interest rate is " + highestInterestRate);

	}


}
