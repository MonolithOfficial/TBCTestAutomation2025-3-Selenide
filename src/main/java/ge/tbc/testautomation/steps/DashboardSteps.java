package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.pages.CommonPage;
import ge.tbc.testautomation.pages.DashboardPage;

public class DashboardSteps extends CommonSteps {
    DashboardPage dashboardPage = new DashboardPage();

    public DashboardSteps clickAddToCart(){
        dashboardPage.addToCartButton.click();

        return this;
    }

    public DashboardSteps assertRemoveButtonVisibility(){
        dashboardPage.removeButton.shouldBe(Condition.visible);

        return this;
    }
}
