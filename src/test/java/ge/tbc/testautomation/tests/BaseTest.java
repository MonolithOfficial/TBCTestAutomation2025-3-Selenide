package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.steps.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class BaseTest {
    LoginSteps loginSteps;
    DashboardSteps dashboardSteps;
    CartSteps cartSteps;
    CheckoutSteps checkoutSteps;
    OverviewSteps overviewSteps;

    @BeforeSuite
    public void config(){
        // maybe get some data
        System.out.println("Execution started on " + LocalDateTime.now());
    }

    @AfterSuite
    public void afterExecution(){
        // maybe delete some data
        System.out.println("Execution ended on " + LocalDateTime.now());
    }

    @BeforeClass
    public void initializeSteps(){
        loginSteps = new LoginSteps();
        dashboardSteps = new DashboardSteps();
        cartSteps = new CartSteps();
        checkoutSteps = new CheckoutSteps();
        overviewSteps = new OverviewSteps();
    }

    @AfterClass
    public void afterTestFinish(){
        System.out.println("Test class execution finished on " + LocalDateTime.now());
    }

    @BeforeMethod
    public void startMethod(Method method){
        System.out.println("Test method - " + method.getName() + " started on " + LocalDateTime.now());
    }
}
