package ge.tbc.testautomation;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static ge.tbc.testautomation.Constants.*;

@Test(groups = {"E2E - successful product purchase - SCRUM-T18"})
public class SuccessfulPurchaseScenarioTest {

    @BeforeClass
    public void setUp(){
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();

        // Turn off Chrome password manager UI
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--incognito");
        WebDriverRunner.setWebDriver(new ChromeDriver(options));
        Configuration.browser = "chrome";
        Configuration.timeout = 8000;
//        Configuration.holdBrowserOpen = true;
        open("https://www.saucedemo.com/");
    }

    @Test(description = "Login as standard user", priority = 1)
    public void loginAsStandardUser(){
        SelenideElement usernameInput = $(byId("user-name"));
        usernameInput.sendKeys(Constants.STANDARD_USER);

        SelenideElement passwordInput = $(byId("password"));
        passwordInput.sendKeys(Constants.PASSWORD);

        SelenideElement loginButton = $(byId("login-button"));
        loginButton.click();
    }

    @Test(description = "Add backpack to cart", priority = 2)
    public void addToCart(){
        SelenideElement addToCartButton = $x("//div[text()='Sauce Labs Backpack']//following::button[1]");
        addToCartButton.click();

        SelenideElement removeButton = $(byId("remove-sauce-labs-backpack"));
        removeButton.shouldBe(Condition.visible);
    }

    @Test(description = "Review the cart", priority = 3)
    public void reviewCart(){
        SelenideElement cartIcon = $("a.shopping_cart_link");
        cartIcon.click();

        ElementsCollection cartItems = $$("div.cart_item");
//        cartItems.filter()
        for (SelenideElement element : cartItems){
            // if you want to iterate
        }
        cartItems.shouldHave(CollectionCondition.size(1));
    }

    @Test(description = "Go to checkout page", priority = 4)
    public void goToCheckout(){
        SelenideElement checkoutButton = $(byId("checkout"));
        checkoutButton.click();

        SelenideElement checkoutPageLabel = $("span.title");
        checkoutPageLabel.shouldHave(Condition.text(CHECKOUT_LABEL));
    }

    @Test(description = "Enter checkout information", priority = 5)
    public void enterInformation() {
        SelenideElement firstNameInput = $(byId("first-name"));
        SelenideElement lastNameInput = $(byId("last-name"));
        SelenideElement zipCodeInput = $(byId("postal-code"));

        firstNameInput.sendKeys("Joee");
        lastNameInput.sendKeys("Doe");
        zipCodeInput.sendKeys("0200");
    }

    @Test(description = "Proceed to final page", priority = 6)
    public void proceedToFinalPage() {
        SelenideElement continueButton = $(byId("continue"));
        continueButton.click();

        SelenideElement checkoutPageLabel = $("span.title");

        checkoutPageLabel.shouldHave(Condition.text(CHECKOUT_OVERVIEW_LABEL));
    }

    @Test(description = "Finish order", priority = 7)
    public void finishOrder() {
        SelenideElement finish = $(byId("finish"));
        finish.click();

        // chained
        SelenideElement successMessage = $("h2.complete-header").shouldHave(Condition.text(SUCCESS_MESSAGE));;
//        Assert.assertEquals(successMessage.getText(), SUCCESS_MESSAGE);
    }
}
