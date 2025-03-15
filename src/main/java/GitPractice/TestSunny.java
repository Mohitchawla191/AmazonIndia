package GitPractice;

import base.BaseClass;
import org.testng.annotations.Test;
import pageObject.LandingPage;

public class TestSunny extends BaseClass {
    static LandingPage landingPage;
    @Test
    public static void testMethod1(){
        landingPage = new LandingPage();
        landingPage.launchApp();


    }
    public static void testMethod2(){
        landingPage = new LandingPage();
        landingPage.loadConfig();
    }
}
