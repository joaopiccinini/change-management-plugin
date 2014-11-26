package org.joaopiccinini.plugin.changemanagementplugin.pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.support.PageFactory.initElements;

import java.net.URL;

import org.junit.Test;

public class LoginPageTest extends FirefoxDriverTest {

	@Test
	public void shouldAuthenticateInLoginPage() {
		LoginPage loginPage = initElements(driver, LoginPage.class);

		URL url = this.getClass().getResource("/pages/login-page.html");
		loginPage.open(url).authenticate("1", "2");

		assertThat(driver.getTitle(), is(equalTo(new MainPage(driver).getTitle())));
	}
}