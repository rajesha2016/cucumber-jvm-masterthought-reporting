package com.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.cucumber.context.TestContext;

import cucumber.api.Scenario;
import cucumber.api.java.After;

/**
 * @author r.moharana cucumber hooks class helps in setting up before scenario
 *         and after scenario activities
 */
public class Hooks {

	TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}

	/**
	 * @param scenario
	 *            take screenshot in case of failed scenario and embeded to
	 *            cucumber report also attach the screenshot
	 */
	@After
	public void embedScreenshot(Scenario scenario) {

		if (scenario.isFailed()) {
			try {
				scenario.write("Current Page URL is " + testContext.getWebDriverLibrary().getDriver().getCurrentUrl());
				byte[] screenshot = ((TakesScreenshot) testContext.getWebDriverLibrary().getDriver())
						.getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}

		}

	}
	
}
