package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int counter =1;
    int retryLimit =3;
    @Override
    public boolean retry(ITestResult retry) {
        if (retryLimit>counter){
            counter++;
            return true;
        }
        return false;
    }
}
