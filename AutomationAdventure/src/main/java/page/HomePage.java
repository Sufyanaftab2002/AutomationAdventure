package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private final String logoutButtonText = "Logout";
    By addCart = By.id("add-to-cart-sauce-labs-backpack");
    By removeButton = By.id("remove-sauce-labs-backpack");
    By shoppingCartButton = By.id("shopping_cart_container");
    By cartItem = By.className("cart_item");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCart() {
        driver.findElement(addCart).click();
    }

    public String verifyItemIsAdded() {
        return driver.findElement(removeButton).getText();
    }

    public void clickCartButton() {
        driver.findElement(shoppingCartButton).click();
    }

    public Boolean verifyCartPageItem() {
        return driver.findElement(cartItem).isDisplayed();
    }
}
