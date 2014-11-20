package org.joaopiccinini.plugin.changemanagementplugin.pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.support.PageFactory.initElements;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPageTest {

	private WebDriver driver;

	@Before
	public void initializeDriver() {
		driver = new FirefoxDriver();
	}

	@After
	public void finalizeDriver() {
		driver.close();
	}

	@Test
	public void shouldAuthenticateInLoginPage() {
		LoginPage loginPage = initElements(driver, LoginPage.class);

		URL url = this.getClass().getResource("/pages/login.html");
		loginPage.open(url).authenticate("1", "2");

		assertThat(loginPage.getTitle(), is(equalTo("Pagina login")));
	}
}