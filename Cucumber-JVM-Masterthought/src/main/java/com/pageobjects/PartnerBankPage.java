package com.pageobjects;

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
 * @author r.moharana this class helps the activities of partner bank page
 *         every action on the page is done here
 */

public class PartnerBankPage extends CommonPage{

	WebDriver driver;
	static String MOODY_A1_RATING_BANK;
	static String A1_RATING_BANK_NAME;
	CommonPage commonPage;
	private static final LogUtils LOGGER = new LogUtils(PartnerBankPage.class);

	public PartnerBankPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//span[@class='bank-archive-item-country-rating-score'][contains(text(),'A1')]")
	private WebElement moodyA1rating;

	@FindBy(how = How.XPATH, using = "//div[@id='sticky-wrapper']//a[contains(text(),'Invest now')]")
	private WebElement investNowButton;

	@FindBy(how = How.XPATH, using = "//div[@class='aff-page-title']//h1")
	private WebElement partnerBankInvestPage;

	public void navigateToPartnerBankPage() {

		driver.get(FileReaderLibrary.getInstance().getConfigReader().getApplicationUrl() + "bank/");
	}

	public void findMoodyA1Rating() {

		MOODY_A1_RATING_BANK = moodyA1rating.getText().trim();
	}

	public void clickLearnMoreOfA1RatingBank() {
		checkSelectRegionPopup();
		findMoodyA1Rating();
		findA1PartnerBankName();
		driver.findElement(By.xpath("//span[contains(text(),'" + MOODY_A1_RATING_BANK + "')]/../../..//a")).click();
	}

	public void clickInvestNow() {

		Utilities.waitForVisibilityofElement(driver, investNowButton);
		investNowButton.click();
	}

	// method to find A1 bank name
	public void findA1PartnerBankName() {

		A1_RATING_BANK_NAME = driver
				.findElement(By.xpath("//span[contains(text(),'" + MOODY_A1_RATING_BANK + "')]/../..//../div"))
				.getText().trim();
		LOGGER.info("The A1 rating partner bank is " + A1_RATING_BANK_NAME);
	}

	public boolean verifyPartnerBankNameinHeader() {

		Utilities.waitForVisibilityofElement(driver, partnerBankInvestPage);
		return partnerBankInvestPage.getText().trim().contains(A1_RATING_BANK_NAME);

	}
	

}
