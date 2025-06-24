package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void formTest() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTests() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Roman");
        $("#lastName").setValue("Filatov");

        $("#userEmail").setValue("romanf@gmail.com");

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("9085693730");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $("select.react-datepicker__year-select").selectOption("1982");
        $(".react-datepicker__day--018").click(); //:not(.react-datepicker__day--outside-month)

        $("#subjectsInput").setValue("Physics").pressEnter().scrollTo();

        $("#hobbiesWrapper").$(byText("Sports")).click();

        $("#uploadPicture").uploadFromClasspath("img/main-2.jpg");

        $("#currentAddress").setValue("Proxladnaya street 28");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Roman Filatov"), text("romanf@gmail.com"),
                text("Male"), text("9085693730"), text("18 January,1982"), text("Physics"), text("Sports"),
                text("main-2.jpg"), text("Proxladnaya street 28"), text("Haryana Karnal"));
    }
}
