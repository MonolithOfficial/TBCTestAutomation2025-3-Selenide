package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.LoginPage;

public class LoginSteps extends CommonSteps{
    LoginPage loginPage = new LoginPage();

    public LoginSteps fillUserNameInput(){
        loginPage.usernameInput.sendKeys(Constants.STANDARD_USER);

        return this;
    }

    public LoginSteps fillUserNameInput(String username){
        loginPage.usernameInput.sendKeys(username);

        return this;
    }

    public LoginSteps fillPasswordInput(){
        loginPage.passwordInput.sendKeys(Constants.PASSWORD);

        return this;
    }

    public LoginSteps fillPasswordInput(String password){
        loginPage.passwordInput.sendKeys(password);

        return this;
    }

    public LoginSteps clickLoginButton(){
        loginPage.loginButton.click();

        return this;
    }
}
