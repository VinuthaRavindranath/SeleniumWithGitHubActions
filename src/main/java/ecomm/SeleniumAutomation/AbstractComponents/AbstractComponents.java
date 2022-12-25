package ecomm.SeleniumAutomation.AbstractComponents;

import ecomm.SeleniumAutomation.PageObjects.CartPage;
import ecomm.SeleniumAutomation.PageObjects.MyOrdersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponents {
    WebDriver driver;
    public AbstractComponents(WebDriver driver) {
        this.driver=driver;
    }

    public void waitForElementToBeVisible(By findBy){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForVisibilityOfWebElement(WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeInvisible(WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.invisibilityOf(element));
    }

    @FindBy(xpath="//button[@routerlink='/dashboard/cart']")
    WebElement cartIcon ;

    @FindBy (css="button[routerlink*='myorders']")
    WebElement ordersButton;

    public CartPage goToCartPage(){
        cartIcon.click();
        return new CartPage(driver);
    }

    public MyOrdersPage goToMyOrdersPage(){
        ordersButton.click();
        return new MyOrdersPage(driver);
    }
}
