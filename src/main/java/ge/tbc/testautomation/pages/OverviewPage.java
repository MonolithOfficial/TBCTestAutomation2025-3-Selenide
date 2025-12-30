package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class OverviewPage extends CommonPage {
    public SelenideElement checkoutPageLabel = $("span.title");
    public SelenideElement finish = $(byId("finish"));
    public SelenideElement successMessage = $("h2.complete-header");
}
