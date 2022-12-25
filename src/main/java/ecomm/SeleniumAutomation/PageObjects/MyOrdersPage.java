package ecomm.SeleniumAutomation.PageObjects;

import ecomm.SeleniumAutomation.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyOrdersPage extends AbstractComponents {
    WebDriver driver;

    public MyOrdersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "table > tbody > tr > td:nth-child(3)")
    List<WebElement> OrderedProductsTitles;

    public boolean validateMyOrdersPage(String productTitle) {
        boolean match = OrderedProductsTitles.stream().anyMatch(title -> title.getText().equalsIgnoreCase(productTitle));
        return match;

    }
}
