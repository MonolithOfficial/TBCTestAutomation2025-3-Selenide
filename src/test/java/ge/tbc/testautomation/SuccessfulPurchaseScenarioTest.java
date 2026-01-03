package ge.tbc.testautomation;

import com.codeborne.selenide.*;
import ge.tbc.testautomation.steps.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static ge.tbc.testautomation.data.Constants.*;
import static ge.tbc.testautomation.Util.CustomCondition.textOfLength;

@Test(groups = {"E2E - successful product purchase - SCRUM-T18"})
public class SuccessfulPurchaseScenarioTest extends BaseTest{
    private static final Logger logger = LogManager.getLogger();

    @BeforeClass
    @Parameters("browserType")
    public void setUp(String browserType) {

        if (browserType.equalsIgnoreCase("chrome")) {
            logger.info("Configuring {} browser for test automation.", browserType);
            ChromeOptions options = new ChromeOptions();

            Map<String, Object> prefs = new HashMap<>();

            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);

            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-infobars");
            options.addArguments("--incognito");
            WebDriverRunner.setWebDriver(new ChromeDriver(options));
            Configuration.browser = "chrome";
        } else if (browserType.equalsIgnoreCase("firefox")) {
            Configuration.browser = "firefox";
        }
        Configuration.timeout = 8000;
//        Configuration.holdBrowserOpen = true;
        open("https://www.saucedemo.com/");
    }

    @Test(description = "Login as standard user", priority = 1)
    public void loginAsStandardUser() {
        loginSteps
                .fillUserNameInput()
                .fillPasswordInput()
                .clickLoginButton();
    }

    @Test(description = "Add backpack to cart", priority = 2, dependsOnMethods = {"loginAsStandardUser"}, enabled = false)
    public void addToCart() {
        dashboardSteps
                .clickAddToCart()
                .assertRemoveButtonVisibility();
    }

    @Test(description = "Review the cart", priority = 3, invocationCount = 5, successPercentage = 80)
    public void reviewCart() {
        cartSteps.goToCart();
        cartSteps.assertCartItemsSize(1);
    }

    @Test(description = "Go to checkout page", priority = 4, timeOut = 10)
    public void goToCheckout() {
        cartSteps.goToCheckout();
        checkoutSteps.assertCheckoutLabel();
    }

    @Test(description = "Enter checkout information", priority = 5)
    public void enterInformation() {
        checkoutSteps.fillInformation(
                "John", "Cena", "100100"
        );
    }

    @Test(description = "Proceed to final page", priority = 6)
    public void proceedToFinalPage() {
        checkoutSteps.goToCheckoutOverview();
        overviewSteps.assertOverviewLabel();
    }

    @Test(description = "Finish order", priority = 7)
    public void finishOrder() {
        overviewSteps
                .finishOrder()
                .assertSuccessMessage();
    }
}
