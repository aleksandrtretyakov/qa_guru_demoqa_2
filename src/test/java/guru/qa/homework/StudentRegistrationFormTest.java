package guru.qa.homework;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("demoqa")
public class StudentRegistrationFormTest extends TestBase {

    @Test
    void fillFormTest() {

        String firstName = "Aleksandr";
        String lastName = "Tretyakov";
        String email = "aleks@tret.com";
        String gender = "Male";
        String phoneNumber = "8123456789";
        String month = "March";
        String year = "2000";
        String date = "04";
        String subject = "Maths";
        String hobby = "Sports";
        File file = new File("src/test/resources/qr-code.png");
        String currentAddress = "Street #1";
        String state = "Haryana";
        String city = "Karnal";
        String formTitle = "Thanks for submitting the form";


        step("Open student registration form", () -> {
            open("/automation-practice-form");
        });


        step("Fill student registration form", () -> {
            $("#firstName").setValue(firstName);
            $("#lastName").setValue(lastName);
            $("#userEmail").setValue(email);
            $(byText(gender)).click();
            $("#userNumber").setValue(phoneNumber);
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption(month);
            $(".react-datepicker__year-select").selectOption(year);
            $(".react-datepicker__day--0" + date).click();
            $("#subjectsInput").setValue(subject).pressEnter();
            $(byText(hobby)).click();
            $("#uploadPicture").uploadFile(file);
            $("#currentAddress").setValue(currentAddress);
            $("#react-select-3-input").setValue(state).pressEnter();
            $("#react-select-4-input").setValue(city).pressEnter();
            $("#submit").pressEnter();
        });


        //        Asserts
        step("Verify student registration form", () -> {
            $("#example-modal-sizes-title-lg").shouldHave(text(formTitle));
            $(".table-responsive").$(byText("Student Name")).parent()
                    .shouldHave(text (firstName + " " + lastName));
            $(".table-responsive").$(byText("Student Email")).parent()
                    .shouldHave(text (email));
            $(".table-responsive").$(byText("Gender")).parent()
                    .shouldHave(text (gender));
            $(".table-responsive").$(byText("Mobile")).parent()
                    .shouldHave(text (phoneNumber));
            $(".table-responsive").$(byText("Date of Birth")).parent()
                    .shouldHave(text (date + " " + month + "," + year));
            $(".table-responsive").$(byText("Subjects")).parent()
                    .shouldHave(text (subject));
            $(".table-responsive").$(byText("Hobbies")).parent()
                    .shouldHave(text (hobby));
            $(".table-responsive").$(byText("Picture")).parent()
                    .shouldHave(text ("qr-code.png"));
            $(".table-responsive").$(byText("Address")).parent()
                    .shouldHave(text (currentAddress));
            $(".table-responsive").$(byText("State and City")).parent()
                    .shouldHave(text (state + " " + city));
        });

        step("Close the form", () -> {
            $(byText("Close")).pressEnter();
        });
    }
}


