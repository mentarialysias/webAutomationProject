package stepdefinitions.webAutomation;

import webAutomation.actions.DashboardPageActions;
import webAutomation.actions.LoginPageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import webAutomation.utils.HelperClass;

public class MenuPageSteps {

	LoginPageActions objLogin = new LoginPageActions();
	DashboardPageActions objDashboardPage = new DashboardPageActions();

	String loginPageUrl = "https://www.saucedemo.com/";
	String aboutPageUrl = "https://saucelabs.com/";


	@Given("User login successfully and navigated to dashboard page")
	public void user_login_successfully_and_navigated_to_dashboard_page() throws InterruptedException{
		//navigate to url website
		HelperClass.openPage(loginPageUrl);
		// login to application
		objLogin.loginStep("standard_user", "secret_sauce");
		Thread.sleep(2000);
	}
	@When("User clicks on side bar menu")
	public void user_clicks_on_side_bar_menu() throws InterruptedException {
		// Click side bar menu
		objDashboardPage.hamburgerButtonClick();
		Thread.sleep(2000);
	}
	@When("User clicks on logout button")
	public void user_clicks_on_logout_button() throws InterruptedException {
		// Click logout button
		objDashboardPage.logoutButtonClick();
		Thread.sleep(2000);
	}
	@Then("User should be able to logout from the web application and display the login page")
	public void user_should_be_able_to_logout_from_the_web_application_and_display_the_login_page() throws InterruptedException {
		// User logout successfully and navigated
		String currentUrl = HelperClass.getCurrentUrl();
		Assert.assertEquals(loginPageUrl, currentUrl);
		Thread.sleep(2000);
	}

	@Then("User clicks on reset app state button")
	public void user_clicks_on_reset_app_state_button() throws InterruptedException {
		// Click reset app state button
		objDashboardPage.resetAppStateButtonClick();
		Thread.sleep(2000);
	}

	@When("User clicks on about button")
	public void user_clicks_on_about_button() throws InterruptedException {
		objDashboardPage.aboutButtonClick();
		Thread.sleep(2000);
	}

	@Then("User should be able to navigate to the about page")
	public void user_should_be_able_to_navigate_to_the_about_page() throws InterruptedException {
		String currentUrl = HelperClass.getCurrentUrl();
		Assert.assertEquals(aboutPageUrl, currentUrl);
		Thread.sleep(2000);
	}









}