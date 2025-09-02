package stepDefinition;

import com.actions.HelperClass;
import com.actions.HomepageActions;
import com.actions.LoginPageActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinitions {

	private LoginPageActions LOG;
	private HomepageActions HPA;

	@Before
	public void setUp() {
		HelperClass.setUpDriver();
	}

	@After
	public void tearDown() {
		HelperClass.quitDriver();
	}

	@Given("launch url in browser {string}")
	public void launch_url_in_browser(String Url) {
		HelperClass.openPage(Url);
		LOG = new LoginPageActions(HelperClass.getDriver());
		HPA = new HomepageActions(HelperClass.getDriver());
	}

	@When("Enter the username in textbox as {string} and Password as {string}")
	public void enter_the_username_in_textbox_as_and_password_as(String username, String password) throws InterruptedException {
		LOG.login(username, password);
	}

	@Then("Click login button and Home page should open")
	public void click_login_button_and_home_page_should_open() {
		// Wait until Dashboard is visible
		WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
		String dashboardText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[normalize-space()='Dashboard']"))).getText();

		Assert.assertTrue(
			"Expected Dashboard after login, but got: " + dashboardText,
			dashboardText.contains("Dashboard")
		);
		System.out.println("Successfully logged in. Dashboard is displayed.");
	}

	@When("Enter Username text as {string} and Password as {string}")
	public void enter_username_text_as_and_password_as(String username, String password) throws InterruptedException {
		LOG.login(username, password);
	}

	@Then("User should see the error message as {string}")
	public void user_should_see_the_error_message_as(String error) {
		Assert.assertEquals(LOG.getErrorMsg(), error);
	}
	
	@Then("User should see the required message as {string}")
	public void user_should_see_the_required_message_as(String required) {
		Assert.assertEquals(LOG.getMissingText(), required);
	}

}

