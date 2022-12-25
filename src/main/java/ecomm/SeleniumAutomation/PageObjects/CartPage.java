package ecomm.SeleniumAutomation.PageObjects;

import ecomm.SeleniumAutomation.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponents {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cartSection h3")
    List<WebElement> productsInCart;

    @FindBy(xpath = "//button[normalize-space()='Checkout']")
    WebElement checkoutButton;

    public boolean validateCartHasProduct(String productTitle) {
        Boolean match = productsInCart.stream().anyMatch(prodTitle -> prodTitle.getText().equals(productTitle));
        return match;
    }

    public CheckoutPage clickOnCheckoutButton() {
        checkoutButton.click();
        return new CheckoutPage(driver);
    }
}
