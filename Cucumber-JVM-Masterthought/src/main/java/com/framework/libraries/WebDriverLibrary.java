package com.framework.libraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.framework.enums.DriverType;
import com.framework.enums.EnvironmentType;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author r.moharana This class is the webdriver factory, it return the driver
 *         type(local or remote) based on the value provided in properties file
 */
public class WebDriverLibrary {

	private static WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;

	public WebDriverLibrary() {

		driverType = FileReaderLibrary.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderLibrary.getInstance().getConfigReader().getEnvironment();
	}

	// return webdriver instance
	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {

		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		}
		return driver;

	}

	private WebDriver createRemoteDriver() {

		throw new RuntimeException("RemoteWebDriver is not yet implemented");

	}

	// create local webdriver intance
	private WebDriver createLocalDriver() {

		switch (driverType) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case INTERNETEXPLORER:
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		}

		if (FileReaderLibrary.getInstance().getConfigReader().getBrowserWindowSize())
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderLibrary.getInstance().getConfigReader().getImplicitlyWait(),
				TimeUnit.SECONDS);
		return driver;
	}

}
