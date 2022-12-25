package ecomm.SeleniumAutomation.PageObjects;

import ecomm.SeleniumAutomation.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalog extends AbstractComponents {
    WebDriver driver;
    public ProductCatalog(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement loader;

    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement cartIcon;


    By productsList = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector("button.btn.w-10.rounded");
    By toastMessage = By.id("toast-container");

    public List<WebElement> getProductsList() {
        waitForElementToBeVisible(productsList);
        return products;
    }

    public WebElement getProductByName(String productTitle) {
        WebElement prod = products.stream().filter(product ->
                product.findElement(By.cssSelector("b")).getText().equals(productTitle)).findFirst().orElse(null);
        return prod;
    }

    public void addProductToCart(String productTitle) throws InterruptedException {
        WebElement prod = getProductByName(productTitle);
        prod.findElement(addToCart).click();
//        waitForElementToBeVisible(toastMessage);
//        waitForElementToBeInvisible(loader);
        Thread.sleep(5000);
    }

}
