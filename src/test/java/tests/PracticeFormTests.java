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
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTests(){
        open("/automation-practice-form"); // правильно
       // executeJavaScript("S('#fixedban').remove()");
        //executeJavaScript("S('footer').remove()");

        $("#firstName").setValue("Roman"); //правильно

        $("#lastName").setValue("Filatov"); //правильно

        $("#userEmail").setValue("romanf@gmail.com"); //правильно

        $("#genterWrapper").$(byText("Male")).click(); //правильно
        //$("[for=gender-radio-1]").click(); //правильно
        //$("#gender-radio-1").parent().click(); //правильно
        //$(byText("Other")).click(); //правильно

        $("#userNumber").setValue("9085693730"); //правильно

        $("#dateOfBirthInput").click(); //правильно
        $(".react-datepicker__month-select").selectOption("January"); // правильно
        $("select.react-datepicker__year-select").selectOption("1982"); //
        $(".react-datepicker__day--018").click(); //:not(.react-datepicker__day--outside-month)

        $("#subjectsInput").setValue("Physics").pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click(); //правильно

        $("#uploadPicture").uploadFromClasspath("/img/.png");
        //$("#uploadPicture").uploadFile(new File("src/test/resources/img/.png"));


        $("#currentAddress").setValue("Proxladnaya street 28");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        //$("#react-select-3-option-2").click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        $("#submit").click();

    }
}
