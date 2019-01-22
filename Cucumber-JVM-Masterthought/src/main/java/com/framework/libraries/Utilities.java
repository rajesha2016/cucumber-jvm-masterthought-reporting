package com.framework.libraries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author r.moharana Utilities class to help in different activities
 */
public class Utilities {

	// wait for given time
	public static void waitForGivenTime(long waittime) {

		try {
			Thread.sleep(waittime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// return string based on the regular expression pattern
	public static String getTextGivenExpression(String text, String pat) {

		Pattern pattern = Pattern.compile(pat);
		Matcher matcher = pattern.matcher(text);
		String extractText = null;

		if (matcher.find()) {
			extractText = matcher.group(0).trim();
			return extractText;
		}
		return extractText;
	}

	// wait till element visibility
	public static void waitForVisibilityofElement(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

}
