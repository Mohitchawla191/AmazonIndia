package utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "validCredentials")
    public Object[][] validCredentials(){
        return new Object[][]{{"9870451991","Mohit@123"},{"mohitchawla.geek@gmail.com","Mohit@123"}};
    }
    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials(){
        return new Object[][]{{"2233445577","Mohit@111"}, {"mohitchawla.rock@gmail.com","Mohit@111"}};
    }
}
