package stepDefinitions;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageResourses;
import pageObjects.LoginPageResourses;
import pageObjects.PortalHomePage;
import pageObjects.ResetPasswordPage;
import resources.Base;


public class StepDefinition extends Base{
	WebDriver driver;
	LoginPageResourses logPage;
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
	@Given("Initialize the browser with chrome and delete cookies")
	public void initialize_the_browser_with_chrome_and_delete_cookies() throws IOException {
		driver = initializeDriver();
		driver.manage().deleteAllCookies();	
	
	}

	@Given("Navigate to {string} website")
	public void navigate_to_website(String string) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		driver.get(string);
	}

	@Given("Click on login link on the home page to land on secure sign in page")
	public void click_on_login_link_on_the_home_page_to_land_on_secure_sign_in_page() throws InterruptedException {
		HomePageResourses res = new HomePageResourses(driver);
		if(res.getPopups().size() > 0) {
			res.getPopUp().click();
			logPage = res.pressLoginButton();
		}
		else {
			logPage = res.pressLoginButton();
		}	
	}

//	@When("User types {string} and {string} and logs in")
//	public void user_types_and_and_logs_in(String string, String string2) throws IOException, InterruptedException {
//		logPage.emailPrompt().sendKeys(string);//(getLoginType());
//		Thread.sleep(3000);
//		logPage.passwordPrompt().sendKeys(string2); //(getPasswordType());
//		Thread.sleep(3000);
//		logPage.submitButton().click();
//	}

	 @When("^User types (.+) and (.+) and logs in$")
	    public void user_types_and_and_logs_in(String username, String password) throws Throwable {
		 logPage.emailPrompt().sendKeys(username);//(getLoginType());
			Thread.sleep(3000);
			logPage.passwordPrompt().sendKeys(password); //(getPasswordType());
			Thread.sleep(3000);
			logPage.submitButton().click();
			Thread.sleep(30000);
	    }




	@Then("Verify that User is successfuly logged in")
	public void verify_that_user_is_successfuly_logged_in() {
		PortalHomePage page = new PortalHomePage(driver);
		Assert.assertTrue(page.getSearchBox().isDisplayed());
	}
	
	@And("^Close browsers$")
    public void close_browsers() throws Throwable {
		driver.close();
    }
}
