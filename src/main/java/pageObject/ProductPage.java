package pageObject;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.CommandLineArgs;
import utils.CommonUtils;

public class ProductPage extends BaseClass {
    public ProductPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(xpath="//input[@id='add-to-cart-button']")
    WebElement addToCart;
    @FindBy(id = "nav-cart-count")
    WebElement cartCounter;

    public GoToCart addProductToCart(){
        CommonUtils.switchWindow(1);
        CommonUtils.explicitWait(addToCart,3);
        addToCart.click();
        //Assert.assertEquals(cartCounter.getText(),1);
        cartCounter.click();
        return new GoToCart();
    }

}
