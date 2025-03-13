package pageObject;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    public HomePage(){
        PageFactory.initElements(getDriver(), this);
    }
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBar;
    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;

    public SearchResultPage searchProduct(String searchedItem){
        searchBar.sendKeys(searchedItem);
        searchButton.click();
        return new SearchResultPage();
    }

}
