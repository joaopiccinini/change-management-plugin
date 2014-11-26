package org.joaopiccinini.plugin.changemanagementplugin.pages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverTest {
	protected WebDriver driver;

	@Before
	public void initializeDriver() {
		driver = new FirefoxDriver();
	}

	@After
	public void finalizeDriver() {
		driver.close();
		driver.quit();
	}
}
