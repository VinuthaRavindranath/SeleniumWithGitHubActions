package ecomm.SeleniumAutomation.PageObjects;

import ecomm.SeleniumAutomation.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends AbstractComponents {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement countrySelectDropDown;

    @FindBy(css = "button> span")
    List<WebElement> dropDownOptions;

    @FindBy(css = ".action__submit")
    WebElement submitButton;

    By dropDownSuggestion=By.cssSelector(".ta-results");


    public void verifyCountrySelection(String Country){
        countrySelectDropDown.sendKeys("Ind");
        waitForElementToBeVisible(dropDownSuggestion);
        for (WebElement options : dropDownOptions) {
            if (options.getText().equalsIgnoreCase(Country)) {
                options.click();
                break;
            }
        }
    }

    public OrderConfirmationPage clickOnSubmitButton(){
        submitButton.click();
        return new OrderConfirmationPage(driver);
    }
}
