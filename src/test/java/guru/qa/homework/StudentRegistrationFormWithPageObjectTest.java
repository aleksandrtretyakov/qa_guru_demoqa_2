package guru.qa.homework;

import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

import java.io.File;


public class StudentRegistrationFormWithPageObjectTest {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

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

    @Test
    void fillFormTest() {

        registrationFormPage.openPage();

        registrationFormPage.setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .chooseGenderMale(gender)
                .setPhoneNumber(phoneNumber)
                .chooseDateOfSomething(month, year, date)
                .setSubject(subject)
                .chooseHobby(hobby)
                .uploadFile(file)
                .addressInput(currentAddress)
                .setState(state)
                .setCity(city)
                .clickOnSubmit();

//                Asserts
        registrationFormPage.resultFormNameCheck(formTitle);

        registrationFormPage.resultFormDataCheck("Student Name", firstName + " " + lastName)
                .resultFormDataCheck("Student Email", email)
                .resultFormDataCheck("Gender", gender)
                .resultFormDataCheck("Mobile", phoneNumber)
                .resultFormDataCheck("Date of Birth", date)
                .resultFormDataCheck("Subjects", subject)
                .resultFormDataCheck("Hobbies", hobby)
                .resultFormDataCheck("Picture", "qr-code.png")
                .resultFormDataCheck("Address", currentAddress)
                .resultFormDataCheck("State and City", state + " " + city);

        registrationFormPage.closeForm();
    }
}


