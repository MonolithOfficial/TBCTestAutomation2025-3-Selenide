package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage extends CommonPage{
    public SelenideElement checkoutPageLabel = $("span.title");
    public SelenideElement firstNameInput = $(byId("first-name"));
    public SelenideElement lastNameInput = $(byId("last-name"));
    public SelenideElement zipCodeInput = $(byId("postal-code"));
    public SelenideElement continueButton = $(byId("continue"));
}
