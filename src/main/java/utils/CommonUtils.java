package utils;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CommonUtils extends BaseClass {
    public static void hover(WebElement element){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }
    public static void explicitWait(WebElement element, int timeOut){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void switchWindow(int windowNo){
        Set<String> windowHandles = getDriver().getWindowHandles();
        List<String> list = new ArrayList(windowHandles);
        String windowId = list.get(windowNo);
        getDriver().switchTo().window(windowId);
    }
}
