package ecomm.SeleniumAutomation.PageObjects;

import ecomm.SeleniumAutomation.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponents {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement userPassword;

    @FindBy(id="login")
    WebElement loginButton;

    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client/");
    }

    public ProductCatalog login(String email , String password){
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        loginButton.click();
        return new ProductCatalog(driver);
    }

    public String getErrorMessage(){
        waitForVisibilityOfWebElement(errorMessage);
        String err=errorMessage.getText();
        return err;
    }




}
