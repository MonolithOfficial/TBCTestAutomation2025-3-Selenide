package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CommonPage {
    public SelenideElement cartIcon = $("a.shopping_cart_link");
    public SelenideElement burgerIcon = $("#react-burger-menu-btn");
    public SelenideElement logoutBtn = $("#logout_sidebar_link");
}
