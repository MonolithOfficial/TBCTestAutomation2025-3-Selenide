package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTests {
    @BeforeClass
    public void setUp(){
//        ChromeOptions options = new ChromeOptions()
//                .setExperimentalOption(
//                        "prefs",
//                        Map.of(
//                                "credentials_enable_service", false,
//                                "profile.password_manager_enabled", false
//                        )
//                );
        Configuration.browser = "chrome";
        Configuration.timeout = 8000;
//        Configuration.holdBrowserOpen = true;
        open("https://jqueryui.com/slider/");
    }

    @Test(groups = {"selenide_test_cases"})
    public void testChainedSelector() {
        SelenideElement closestElement = $(withTagAndText("h3", "Interactions"))
                .parent().closest("div"); // closest searches only up
        System.out.println(closestElement.innerHtml());
    }

    public void testFindFilter() {
        open("https://www.telerik.com/support/demos");

        // find (დააკვირდით, რომ find(WebElementCondition condition) მეთოდი წვდომადია ElementsCollection ობიექტებიდან მხოლოდ,
        // პარამეტრად იღებს WebElementCondition-ს, აბრუნებს SelenideElement).
        // როდის ვიყენებთ? - როდესაც გვაქვს კოლექცია და გვინდა იქიდან რამე ერთი ელემენტი ამოვიღოთ რაღაც კონდიციის საფუძველზე.
        SelenideElement navBar = $x("//div[@data-tlrk-plugin='navspy']"); // მოგვაქვს ნავბარი
        SelenideElement desktopLink = navBar
                .$$(byTagName("a")) // მოგვაქვს ყველა ენქორ ტეგი
                .find(Condition.exactText("Desktop")); // ვიღებთ იმ ენქორ ტეგს, რომლის ტექსტი არის ზუსტად 'Desktop'

        // findAll (დააკვირდით, რომ findAll მეთდი წვდომადია SelenideElement ობიექტებიდან მხოლოდ,
        // პარამეტრად იღებს By-ს (რამე ლოკატორს), აბრუნებს ElementsCollection-ს).
        // როდის ვიყენებთ? - როდესაც გვაქვს ერთეულოვანი ვებელემენტი და გვინდა მასში მოვძებნოთ *რამდენიმე* ელემენტი.
        // SelenideElement-საც აქვს find მეთოდი, ოღონდ ის პარამეტრად იღებს By-ს და არა WebElementConditions.
        ElementsCollection anchorLinks = navBar.findAll(byTagName("a")); // ჩათვალეთ, რომ $$ და findAll ერთი და იგივეა.

        // filter (წვდომადია მხოლოდ ElementsCollection-ის ობიექტებიდან მხოლოდ,
        // პარამეტრად იღებს WebElementCondition-ს, აბრუნებს კოლექციას)
        // როდის ვიყენებთ? - როცა გვაქვს კოლექცია და აქედან გვინდა გავფილტროთ ელემენტები რაღაც ქონდიშენის საფუძველზე
        // და ისევ კოლექცია მივიღოთ (გაფილტრული)
        ElementsCollection someKindOfAnchorLinks = navBar.findAll(byTagName("a"))
                .filter(Condition.partialText("p")); // მოგვაქვს ყველა ენქორ ტეგი, რომლის ტექსტიც შეიცავს p-ს.
    }
}
