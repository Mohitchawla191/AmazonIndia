package testCases;

import base.BaseClass;
import org.testng.annotations.Test;
import pageObject.*;
import utils.DataProviderClass;

public class SearchResultTest extends BaseClass {

    @Test(dataProvider = "validCredentials",dataProviderClass = DataProviderClass.class, priority = 3, groups = "Smoke")
    public static void searchResultTest(String userId, String password){
        LandingPage landingPage = new LandingPage();
        LoginPage loginPage= landingPage.initiateSignIn();
        HomePage homePage = loginPage.validLogin(userId,password);
        SearchResultPage searchResultPage = homePage.searchProduct(prop.getProperty("searchedItem"));
        ProductPage productPage = searchResultPage.selectProduct(prop.getProperty("expectedSearchResult"));
        GoToCart goToCart= productPage.addProductToCart();
    }
}
