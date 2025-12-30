package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    public LoginSteps fillUserNameInput(){
        loginPage.usernameInput.sendKeys(Constants.STANDARD_USER);

        return this;
    }

    public LoginSteps fillPasswordInput(){
        loginPage.passwordInput.sendKeys(Constants.PASSWORD);

        return this;
    }

    public LoginSteps clickLoginButton(){
        loginPage.loginButton.click();

        return this;
    }
}
