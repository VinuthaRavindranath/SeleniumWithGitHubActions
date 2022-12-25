package ecomm.SeleniumAutomation.PageObjects;

import ecomm.SeleniumAutomation.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends AbstractComponents {
    WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".hero-primary")
    WebElement orderConfirmationText;

    public String validateOrderConfirmation(){
        String text =orderConfirmationText.getText();
        return text;
    }
}
