package com.jbk.basepackage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initialization() throws Exception {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/resources/data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome"))

		{ // FROM PROPERTY
			System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();

		}
		if (browserName.equalsIgnoreCase("firefox")) {

		}
		if (browserName.equalsIgnoreCase("IE")) {

		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

}
