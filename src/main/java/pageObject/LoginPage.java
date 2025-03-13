package pageObject;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.CommonUtils;

import java.util.Base64;

public class LoginPage extends BaseClass {
    public LoginPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy (xpath = "//input[@name='email']")
    WebElement mobileOrEmailField;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement continueButton;
    @FindBy (id = "ap_password")
    WebElement passwordField;
    @FindBy(id = "signInSubmit")
    WebElement submitButton;
    @FindBy(xpath = "//h1[contains(text(),'Looks like you are new to Amazon')]")
    WebElement errorMessage;
    @FindBy (xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    WebElement userGreeting;

    public HomePage validLogin(String userId, String password){
        mobileOrEmailField.sendKeys(userId);
        continueButton.click();
        CommonUtils.explicitWait(passwordField,3);
        passwordField.sendKeys(password);
        submitButton.click();
        String actualGreeting = userGreeting.getText();
        String expectedGreeting = "Hello, "+prop.getProperty("userFirstName");
        Assert.assertEquals(actualGreeting, expectedGreeting, "Greeting Not matched");
        System.out.println("Successfully Login");
        return new HomePage();
    }
    public HomePage invalidLogin(String userId, String password){
        mobileOrEmailField.sendKeys(userId);
        continueButton.click();
        CommonUtils.explicitWait(errorMessage,3);
        Assert.assertTrue(errorMessage.isDisplayed());
        return new HomePage();
    }

}
