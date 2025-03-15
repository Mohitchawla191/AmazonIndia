package GitPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestClass1 {
    public static void main(String[] args) {
        System.out.println("HP is coding well");
        int a = 5;
        System.out.println(a*2);
        System.out.println("resolved");


        WebDriver driver = new ChromeDriver();
        Set<String> wis = driver.getWindowHandles();
        List list = new ArrayList(wis);

    }
}
