package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import ge.tbc.testautomation.data.CredentialProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class ParametrizationTests extends BaseTest{
    @BeforeClass
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.timeout = 8000;
        open("https://www.saucedemo.com/");
    }



    @Test(dataProviderClass = CredentialProvider.class, dataProvider = "SauceDemoCredentials")
    public void loginTest(String username, String password){
        loginSteps
                .fillUserNameInput(username)
                .fillPasswordInput(password)
                .clickLoginButton();
    }

    @AfterMethod
    public void logout(){
        loginSteps.logout();
    }
}
