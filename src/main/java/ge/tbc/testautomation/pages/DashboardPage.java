package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage extends CommonPage {
    public SelenideElement addToCartButton = $x("//div[text()='Sauce Labs Backpack']//following::button[1]");
    public SelenideElement removeButton = $(byId("remove-sauce-labs-backpack"));
}
