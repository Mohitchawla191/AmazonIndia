package testCases;

import base.BaseClass;
import listeners.RetryAnalyzer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.*;
import utils.DataProviderClass;

public class LoginTest extends BaseClass {
    static LandingPage landingPage;
    @Test(dataProvider = "validCredentials", dataProviderClass = DataProviderClass.class, priority = 1, groups = "Smoke", enabled = true)
    public static void validLoginTest(String userId, String password){
        landingPage = new LandingPage();

        LoginPage loginPage= landingPage.initiateSignIn();
        HomePage homePage = loginPage.validLogin(userId,password);
    }
    @Test(dataProvider = "invalidCredentials", dataProviderClass = DataProviderClass.class, priority = 2, enabled = false)
    public static void invalidLoginTest(String userId, String password){
        landingPage = new LandingPage();

        LoginPage loginPage= landingPage.initiateSignIn();
        HomePage homePage = loginPage.invalidLogin(userId,password);
    }
}
