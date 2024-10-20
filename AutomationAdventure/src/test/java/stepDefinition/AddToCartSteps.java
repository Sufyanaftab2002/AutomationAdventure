package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page.HomePage;
import page.LoginPage;
import utils.BaseClass;

public class AddToCartSteps extends BaseClass {
    final String removeButtonTextToBeMatched = "Remove";
    LoginPage login;
    HomePage home;

    @Given("User is logged In")
    public void user_is_logged_in() {
        login = launchApplication();
        login.enterUserName();
        login.enterPassword();
        home = login.clickLoginButton();
    }

    @When("User clicks on add to cart button")
    public void user_clicks_on_add_to_cart_button() {
        home.clickAddToCart();
    }

    @And("product is added to the cart successfully")
    public void product_is_added_to_the_cart_successfully() {
        String removeButtonText = home.verifyItemIsAdded();
        Assert.assertEquals(removeButtonText, removeButtonTextToBeMatched);
    }

    @Then("User clicks on Cart")
    public void user_clicks_on_cart() {
        home.clickCartButton();
    }

    @Then("Item should be shown in the cart")
    public void item_should_be_shown_in_the_cart() {
        Assert.assertTrue(home.verifyCartPageItem());
    }

    @After
    public void afterScenario() {
        tearDown();
    }
}
