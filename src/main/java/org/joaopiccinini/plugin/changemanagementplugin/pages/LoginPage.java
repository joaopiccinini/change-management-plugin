package org.joaopiccinini.plugin.changemanagementplugin.pages;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

	private WebDriver driver;

	@FindBy(id = "cdusuario")
	private WebElement cdUsuario;

	@FindBy(id = "cdsenha")
	private WebElement cdSenha;

	@FindBy(id = "btnLogin")
	private WebElement btnLogin;

	public LoginPage(WebDriver webDriver) {
		driver = webDriver;
	}

	public LoginPage open(URL url) {
		driver.get("file:///" + url.getPath());
		return this;
	}

	public void authenticate(String user, String password) {
		LOGGER.info("Inserting the user credentials inside the web elements.");
		cdUsuario.sendKeys(user);
		cdSenha.sendKeys(password);

		LOGGER.info("Clicking in the login button to authenticate.");
		btnLogin.click();
	}

	public String getTitle() {
		return "Página login";
	}
}