package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ConfigUtil;

import java.util.Properties;

public class LoginPage {

    static Properties configProperties;
    protected static String baseUrlSauceDemo = setConfig().getProperty("baseUrlSauceDemo");
    protected static String homePageUrlSauceDemo = setConfig().getProperty("homePageUrlSauceDemo");
    protected static String username = setConfig().getProperty("webUserName");
    protected static String password = setConfig().getProperty("webPassword");

    By userNameTextBox = By.id("user-name");
    By passwordTextBox = By.id("password");
    By loginButton = By.id("login-button");
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static Properties setConfig() {
        return configProperties = ConfigUtil.getConfig("config");
    }

    public void navigateToSauceDemo() {
        driver.get(baseUrlSauceDemo);
    }

    public void verifyUserIsOnLoginPage() {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, baseUrlSauceDemo);
    }

    public void enterUserName() {
        driver.findElement(userNameTextBox).sendKeys(username);
    }

    public void enterPassword() {
        driver.findElement(passwordTextBox).sendKeys(password);
    }

    public HomePage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

    public void verifyUserIsOnHomePage() {
        String homePageSwagLabs = driver.getCurrentUrl();
        Assert.assertEquals(homePageSwagLabs, homePageUrlSauceDemo);
    }
}
