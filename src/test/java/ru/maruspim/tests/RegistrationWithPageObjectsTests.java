package ru.maruspim.tests;
import org.junit.jupiter.api.Test;
import ru.maruspim.pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends FormTestBase {


    @Test
    void successfulFillFormTest() {


        registrationPage.openPage()
                .setFirstName("Maria")
                .setLastName("Pimenova")
                .setUserEmail("kitty@gmail.com")
                .setGender("Female")
                .setMobileNumber("1357924680")
                .setSubjects("Physics")
                .setHobby("Music")
                .uploadPicture("images/batty.jpg")
                .setCurrentAddress("Baker Street, 221B")
                .setStateAndCity("Haryana")
                .setStateAndCity("Karnal");




        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("1997")).click();
        $(".react-datepicker__month-select").$(byText("December")).click();
        $(".react-datepicker__day--031").click();


        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();


        $(".modal-body").shouldHave(text("Maria"), text("Pimenova"),
                text("kitty@gmail.com"), text("Female"), text("1357924680"),
                text(31 + " " + "December" + "," + 1997),
                text("Physics"), text("Music"), text("Sports"),
                text("batty.jpg"), text("Baker Street, 221B"),
                text("Haryana" + " " + "Karnal"));

    }
}
