package guru.qa.pages;

import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationFormPage setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    public RegistrationFormPage setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public RegistrationFormPage chooseGenderMale(String value) {
        $(byText("Male")).click();
        return this;
    }

    public RegistrationFormPage setPhoneNumber(String phoneNumber) {
        $("#userNumber").setValue(phoneNumber);
        return this;
    }

    public RegistrationFormPage chooseDateOfSomething(String month, String year, String date) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--" + date).click();
        return this;
    }

    public RegistrationFormPage setSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public RegistrationFormPage chooseHobby(String value) {
        $(byText("Sports")).click();
        return this;
    }

    public RegistrationFormPage uploadFile(File file) {
        $("#uploadPicture").uploadFile(file);
        return this;
    }

    public RegistrationFormPage addressInput(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
        return this;
    }

    public RegistrationFormPage setState(String state) {
        $("#react-select-3-input").setValue(state).pressEnter();
        return this;
    }

    public RegistrationFormPage setCity(String city) {
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }

    public RegistrationFormPage clickOnSubmit() {
        $("#submit").pressEnter();
        return this;
    }

    public RegistrationFormPage resultFormNameCheck(String value) {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationFormPage resultFormDataCheck(String key, String value) {
        $(".modal-body").shouldHave(text("Aleksandr Tretyakov"),
                text("aleks@tret.com"), text("Male"), text("8123456789"), text("04 March,2000"),
                text("Maths"), text("Sports"), text("qr-code.png"), text("Street #1"),
                text("Haryana Karnal"));
        $(byText("Close")).pressEnter();
        return this;
    }
}



