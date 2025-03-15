package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public static Properties prop;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeTest
    public void loadConfig() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/configurations/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public static void launchApp() {
        String browserName = System.getProperty("browser", "chrome");
        System.out.println("Browser name is " + browserName);

        if (browserName.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver.set(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("safari")) {
            driver.set(new SafariDriver());
        }

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        getDriver().manage().window().maximize();
        getDriver().get(prop.getProperty("url"));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public static void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove(); // Prevent memory leaks
        }
    }
}
