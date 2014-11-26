package org.joaopiccinini.plugin.changemanagementplugin.pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.support.PageFactory.initElements;

import java.net.URL;

import org.junit.Test;

public class MainPageTest extends FirefoxDriverTest {

	@Test
	public void shouldOpenTheNewChangePage() {
		MainPage mainPage = initElements(driver, MainPage.class);

		URL url = this.getClass().getResource("/pages/main-page.html");
		mainPage.open(url).openNewChangePage();

		assertThat(driver.getTitle(), is(equalTo("Página nova mudança")));
	}
}