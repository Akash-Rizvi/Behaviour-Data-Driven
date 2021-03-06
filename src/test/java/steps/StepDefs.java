package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import page.LoginPage;
import util.BrowserFactory;

public class StepDefs {

	WebDriver driver;
	LoginPage loginpage;

	@Before
	public void Before_run() {
		driver = BrowserFactory.init();
		loginpage = PageFactory.initElements(driver, LoginPage.class);

	}

	@Given("^User is on the TechFios Login Page$")
	public void user_is_on_the_TechFios_Login_Page() throws Throwable {
		driver.get("https://techfios.com/billing/?ng=admin/");

	}

	@When("^User enters the username as \"([^\"]*)\"$")
	public void user_enters_the_username_as(String username) throws Throwable {
		loginpage.enterUserName(username);
		Thread.sleep(2000);

	}

	@When("^User enters the password as \"([^\"]*)\"$")
	public void user_enters_the_password_as(String password) throws Throwable {
		loginpage.enterPassword(password);

	}

	@When("^User clicks on the log in button$")
	public void user_clicks_on_the_log_in_button() throws Throwable {
		loginpage.clickSigninButton();
		Thread.sleep(2000);

	}

	@When("^User enters the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_and(String username, String password) throws Throwable {
		loginpage.enterCredentials(username, password);

	}

	@Then("^User should be able to see the DashBoard Page$")
	public void user_should_be_able_to_see_the_DashBoard_Page() throws Throwable {
		// loginpage.getPageTitle();
		String expectedTitle = "Dashboard- iBilling";
		String actualTitle = loginpage.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);

	}
	@After
	public void tear_down() {
		driver.close();
		driver.quit();
	}

}

