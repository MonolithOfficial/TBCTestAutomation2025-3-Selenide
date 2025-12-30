package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.pages.CheckoutPage;

import static ge.tbc.testautomation.data.Constants.CHECKOUT_LABEL;

public class CheckoutSteps extends CommonSteps{
    CheckoutPage checkoutPage = new CheckoutPage();

    public CheckoutSteps assertCheckoutLabel(){
        checkoutPage.checkoutPageLabel.shouldHave(Condition.text(CHECKOUT_LABEL));

        return this;
    }

    public CheckoutSteps fillInformation(String firstname, String lastName, String zipCode){
        checkoutPage.firstNameInput.sendKeys(firstname);
        checkoutPage.lastNameInput.sendKeys(lastName);
        checkoutPage.zipCodeInput.sendKeys(zipCode);

        return this;
    }

    public CheckoutSteps goToCheckoutOverview(){
        checkoutPage.continueButton.click();

        return this;
    }
}
