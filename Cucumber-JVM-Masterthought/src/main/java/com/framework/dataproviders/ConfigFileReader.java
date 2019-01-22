package com.framework.dataproviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.framework.enums.DriverType;
import com.framework.enums.EnvironmentType;

/**
 * @author r.moharana This class helps to get properties file data and supply to
 *         UI scripts
 */
public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "Config//Configuration.properties";

	// constructor to initialize properties
	public ConfigFileReader() {

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
		}
	}

	// method to get implicit wait from properties file
	public long getImplicitlyWait() {

		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the configuration.properties file.");
	}

	// method to get baseurl from properties file
	public String getApplicationUrl() {

		String url = properties.getProperty("baseurl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the configuration.properties file.");
	}

	// method to get browser type from properties file
	public DriverType getBrowser() {

		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equals("chrome"))
			return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (browserName.equals("iexplorer"))
			return DriverType.INTERNETEXPLORER;
		else
			throw new RuntimeException(
					"Browser Name Key value in configuration.properties is not matched : " + browserName);
	}

	// method to get environment type from properties file
	public EnvironmentType getEnvironment() {

		String environmentName = properties.getProperty("environment");
		if (environmentName == null || environmentName.equalsIgnoreCase("local"))
			return EnvironmentType.LOCAL;
		else if (environmentName.equalsIgnoreCase("remote"))
			return EnvironmentType.REMOTE;
		else
			throw new RuntimeException(
					"Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}

	// method to get browser window size to maximize from properties file
	public Boolean getBrowserWindowSize() {

		String windowSize = properties.getProperty("windowMaximize");
		if (windowSize != null)
			return Boolean.valueOf(windowSize);
		return true;
	}

}
