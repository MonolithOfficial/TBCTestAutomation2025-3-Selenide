package ge.tbc.testautomation.tests;

import org.testng.annotations.Factory;

public class SuccessfulPurchaseScenarioExecutor {

    @Factory
    public Object[] userFactory(){
        return new Object[] {
                new SuccessfulPurchaseScenarioTest("standard_user", "secret_sauce"),
                new SuccessfulPurchaseScenarioTest("problem_user", "secret_sauce"),
                new SuccessfulPurchaseScenarioTest("performance_glitch_user", "secret_sauce"),
                new SuccessfulPurchaseScenarioTest("error_user", "secret_sauce"),
                new SuccessfulPurchaseScenarioTest("visual_user", "secret_sauce")
        };
    }
}
