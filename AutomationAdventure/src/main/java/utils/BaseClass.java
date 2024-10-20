package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import page.LoginPage;

public class BaseClass {

    public WebDriver driver;
    LoginPage login;

    public WebDriver setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeSuite(alwaysRun = true)
    public LoginPage launchApplication() {
        driver = setup();
        login = new LoginPage(driver);
        login.navigateToSauceDemo();
        return login;
    }

    public void tearDown() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
