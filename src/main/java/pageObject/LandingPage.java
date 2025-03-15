package pageObject;

import base.BaseClass;
import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

import javax.swing.text.Utilities;
import java.util.List;
import java.util.Set;

public class LandingPage extends BaseClass {
    public LandingPage(){
        PageFactory.initElements(getDriver(), this);
    }
    @FindBy(xpath = "//span[text()='Hello, sign in']")
    WebElement helloSignInButton;

    @FindBy(xpath = "//span[text()='Sign in']")
    WebElement signInButton;


    public LoginPage initiateSignIn(){
        CommonUtils.hover(helloSignInButton);
        signInButton.click();
        return new LoginPage();
    }

}
