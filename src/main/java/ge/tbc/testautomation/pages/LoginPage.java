package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

// you can use lombok
public class LoginPage {
    public SelenideElement usernameInput = $(byId("user-name"));
    public SelenideElement passwordInput = $(byId("password"));
    public SelenideElement loginButton = $(byId("login-button"));
}
