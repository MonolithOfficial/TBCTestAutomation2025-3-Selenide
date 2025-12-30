package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage extends CommonPage {
    public ElementsCollection cartItems = $$("div.cart_item");
    public SelenideElement checkoutButton = $(byId("checkout"));

}
