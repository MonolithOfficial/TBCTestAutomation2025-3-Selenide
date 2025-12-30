package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.pages.OverviewPage;

import static ge.tbc.testautomation.data.Constants.CHECKOUT_OVERVIEW_LABEL;
import static ge.tbc.testautomation.data.Constants.SUCCESS_MESSAGE;

public class OverviewSteps extends CommonSteps {
    OverviewPage overviewPage = new OverviewPage();
    public OverviewSteps assertOverviewLabel(){
        overviewPage.checkoutPageLabel.shouldHave(Condition.text(CHECKOUT_OVERVIEW_LABEL));

        return this;
    }

    public OverviewSteps finishOrder(){
        overviewPage.finish.click();

        return this;
    }

    public OverviewSteps assertSuccessMessage(){
        overviewPage.successMessage.shouldHave(Condition.text(SUCCESS_MESSAGE));

        return this;
    }
}
