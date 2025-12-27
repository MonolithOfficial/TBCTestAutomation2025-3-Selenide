package ge.tbc.testautomation;

import com.codeborne.selenide.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Objects;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTests2 {
    @BeforeClass
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.timeout = 8000;
        Configuration.holdBrowserOpen = true;
        Configuration.downloadsFolder = System.getProperty("user.dir") + "/otherDownloadFolder";
    }

    @Test
    public void testFileUpload() {
        open("https://the-internet.herokuapp.com/upload");
        SelenideElement fileUploadInput = $(byId("file-upload"));
        File ronaldoImage = new File(System.getProperty("user.dir") + "/src/main/resources/ronaldokneeslide.jpg");
//        ClassLoader classLoader = this.getClass().getClassLoader();
//        File ronaldoImage = new File(Objects.requireNonNull(classLoader.getResource("ronaldokneeslide.jpg")).getFile());
        fileUploadInput.uploadFile(ronaldoImage);
        SelenideElement submitBtn = $(byId("file-submit"));
        submitBtn.click();
    }

    @Test
    public void downloadFile(){
        open("https://the-internet.herokuapp.com/download");
        SelenideElement downloadLink = $("a[href='download/FileImage.png']");
        File downloadedFile = downloadLink.download();
        String absolutePath = downloadedFile.getAbsolutePath();
        Assert.assertEquals(downloadedFile.getName(), "FileImage.png");
    }

    @Test
    public void filterTest(){
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
