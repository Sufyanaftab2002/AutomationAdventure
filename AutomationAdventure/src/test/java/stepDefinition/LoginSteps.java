package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.LoginPage;
import utils.BaseClass;

public class LoginSteps extends BaseClass {
    LoginPage login;

    @Given("User is on sauce demo Login page")
    public void user_is_on_sauce_demo_login_page() {
        login = launchApplication();
        login.verifyUserIsOnLoginPage();
    }

    @When("User enters the username")
    public void user_enters_the_username() {
        login.enterUserName();
    }

    @And("User enters the password")
    public void user_enters_the_password() {
        login.enterPassword();
    }

    @When("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        login.clickLoginButton();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        login.verifyUserIsOnHomePage();
    }

    @After
    public void afterScenario() {
        tearDown();
    }
}
