package guru.qa.homework;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

public class StudentRegistrationFormWithPageObjectTest {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUpTest() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    String firstName = "Aleksandr";
    String lastName = "Tretyakov";
    String email = "aleks@tret.com";
    String phoneNumber = "8123456789";
    String month = "March";
    String year = "2000";
    String date = "04";
    String subject = "Maths";
    File file = new File("src/test/resources/qr-code.png");
    String currentAddress = "Street #1";
    String state = "Haryana";
    String city = "Karnal";

    @Test
    void fillFormTest() {

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .chooseGenderMale("Male")
                .setPhoneNumber(phoneNumber)
                .chooseDateOfSomething(month, year, date)
                .setSubject(subject)
                .chooseHobby("Sports")
                .uploadFile(file)
                .addressInput(currentAddress)
                .setState(state)
                .setCity(city)
                .clickOnSubmit();

//                Asserts
        registrationFormPage.resultFormNameCheck("Thanks for submitting the form")
                .resultFormDataCheck("Student Name", "Aleksandr Tretyakov")
                .resultFormDataCheck("Student Email", "aleks@tret.com")
                .resultFormDataCheck("Gender", "Male")
                .resultFormDataCheck("Mobile", "8123456789")
                .resultFormDataCheck("Date of Birth", "04 March,2000")
                .resultFormDataCheck("Subjects", "Maths")
                .resultFormDataCheck("Hobbies", "Sports")
                .resultFormDataCheck("Picture", "qr-code.png")
                .resultFormDataCheck("Address", "Street #1")
                .resultFormDataCheck("State and City", "Haryana Karnal");

    }
}


