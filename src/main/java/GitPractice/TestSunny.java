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

        int a =5;

        int x = 11;


        String Chawla = "chawla";

    }
    public static void testMethod2(){
        landingPage = new LandingPage();
        landingPage.loadConfig();
    }
    public static void calculation(){
        int a =2;
        int b=3;
        int c= a+b;
    }
}
