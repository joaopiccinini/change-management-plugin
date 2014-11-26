package org.joaopiccinini.plugin.changemanagementplugin.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainPage.class);

	private static final int DEFAULT_WEBDRIVER_WAIT_TIMEOUT = 10;

	private WebDriver driver;

	@FindBy(css = ".toolbarslider-item.toolbarIcon:nth-child(13)")
	private WebElement newChangeElement;

	public MainPage(WebDriver webDriver) {
		driver = webDriver;
	}

	public MainPage open(URL url) {
		driver.get("file:///" + url.getPath());
		return this;
	}

	public void openNewChangePage() {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WEBDRIVER_WAIT_TIMEOUT);
		LOGGER.info("Configuring timer to wait for the New Change Element appearence.");
		WebElement newChangeLink = wait.until(elementToBeClickable(newChangeElement));

		LOGGER.info("Clicking on the New Change Element, named as \"{}\".", newChangeLink.getText());
		newChangeLink.click();

		LOGGER.info("The web driver is now working with \"{}\" windows.", driver.getWindowHandles().size());

		Object newChangePage = driver.getWindowHandles().toArray()[1];
		driver.switchTo().window(String.valueOf(newChangePage));
		LOGGER.info("The working window had changed to manipulate the New Change Page elements.");
		System.out.println(driver.getTitle());
	}

	public String getTitle() {
		return "Página principal";
	}
}