package guru.qa.homework;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest {

    @BeforeAll
    static void setUpTest() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {

        String firstName = "Aleksandr";
        String lastName = "Tretyakov";
        String email = "aleks@tret.com";
        String phoneNumber = "8123456789";
        String month = "March";
        String year = "2000";
        String subject = "Maths";
        File file = new File("src/test/java/guru/qa/resources/qr-code.png");
        String currentAddress = "Street #1";
        String state = "Haryana";
        String city = "Karnal";

        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText("Male")).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--004").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").pressEnter();

        //        Asserts
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Aleksandr Tretyakov"),
                text("aleks@tret.com"), text("Male"), text("8123456789"), text("04 March,2000"),
                text("Maths"), text("Sports"), text("qr-code.png"), text("Street #1"),
                text("Haryana Karnal"));
        $(byText("Close")).pressEnter();
    }
}


