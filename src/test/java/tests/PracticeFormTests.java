package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTests(){
        open("/automation-practice-form"); // правильно

       //executeJavaScript("S('#fixedban').remove()");
       //executeJavaScript("S('footer').remove()");

        //Name
        $("#firstName").setValue("Roman");
        $("#lastName").setValue("Filatov");

        //Email
        $("#userEmail").setValue("romanf@gmail.com");

        //Gender
        $("#genterWrapper").$(byText("Male")).click();
        //$("[for=gender-radio-1]").click();
        //$("#gender-radio-1").parent().click();
        //$(byText("Other")).click();

        // Блок Mobile
        $("#userNumber").setValue("9085693730");

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $("select.react-datepicker__year-select").selectOption("1982");
        $(".react-datepicker__day--018").click(); //:not(.react-datepicker__day--outside-month)

        //Subjects
        $("#subjectsInput").setValue("Physics").pressEnter().scrollTo();

        //Hobbies
        $("#hobbiesWrapper").$(byText("Sports")).click();

        //Picture
        $("#uploadPicture").uploadFromClasspath("img/main-2.jpg");
        //$("#uploadPicture").uploadFile(new File("src/test/resources/img/main-2.jpg"));

        //Current Address
        $("#currentAddress").setValue("Proxladnaya street 28");

        //State and City
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        //$("#react-select-3-option-2").click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        //button Submit
        $("#submit").click();

        //last Form
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Roman Filatov"), text("romanf@gmail.com"),
        text("Male"), text("9085693730"), text("18 January,1982"), text("Physics"), text("Sports"),
        text("main-2.jpg"), text("Proxladnaya street 28"), text("Haryana Karnal"));
    }
}
