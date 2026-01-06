package ge.tbc.testautomation.Util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalDateTime;

public class CustomTestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger();
    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("Test {} failed on {}", result.getName(), LocalDateTime.now());
    }
}
