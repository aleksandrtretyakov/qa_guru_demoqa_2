package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void fillFormtest() {
        open("/text-box");
        String name = "Aleksandr Tretyakov";
        String email = "aleks@tret.com";
        String currentAddress = "street 1";
        String permanentAddress = "street 2";

        $("[id = userName]").setValue(name);
        $("[id = userEmail]").setValue(email);
        $("[id = currentAddress]").setValue(currentAddress);
        $("[id = permanentAddress]").setValue(permanentAddress);
        $("[id = submit]").click();

//        Asserts
        $("[id = output]").shouldHave(text(name), text(email), text(currentAddress), text(permanentAddress));
        $("[id = output] [id=name").shouldHave(text(name));
//
    }
}
