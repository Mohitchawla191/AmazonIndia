package pageObject;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

import java.util.Comparator;
import java.util.List;

public class SearchResultPage extends BaseClass {
    public SearchResultPage(){
        PageFactory.initElements(getDriver(), this);
    }
    @FindBy (xpath = "//a[@class='a-link-normal s-line-clamp-2 s-link-style a-text-normal']/h2/span")
    List<WebElement> searchResults;
    @FindBy(xpath = "//button[text()='Add to cart']")
    WebElement addToCartButton;

    public ProductPage selectProduct(String item){
        for (WebElement searchItem : searchResults){
            if (searchItem.getText().contains(item)){
                searchItem.click();
            }
        }
        return new ProductPage();
    }

}
