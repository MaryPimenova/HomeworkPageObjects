package ru.maruspim.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    // Selenide elements / locator / etc
    SelenideElement formHeaderText = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            mobileNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobby = $("#hobbiesWrapper"),
            pictureUpload = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateCity = $("#stateCity-wrapper");

    // Actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        formHeaderText.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setMobileNumber(String value) {
        mobileNumberInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value);

        return this;
    }
    public RegistrationPage setHobby(String value) {
        hobby.$(byText(value)).click();

        return this;
    }
    public RegistrationPage uploadPicture(String value) {
        pictureUpload.uploadFromClasspath(value);

        return this;
    }
    public RegistrationPage setCurrentAddress(String value) {
       currentAddressInput.setValue(value);

        return this;
    }
    public RegistrationPage setStateAndCity(String value) {
        stateCity.$(byText("value")).click();

        return this;
    }
}
