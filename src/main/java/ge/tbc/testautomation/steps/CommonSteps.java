package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.pages.CommonPage;

public class CommonSteps {
    CommonPage commonPage = new CommonPage();

    public CommonSteps goToCart(){
        commonPage.cartIcon.click();

        return this;
    }
}
