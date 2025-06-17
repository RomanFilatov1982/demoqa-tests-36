package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
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

        $("#subjectsInput").setValue("Fisics").pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click(); //правильно

        //$("#uploadPicture").uploadFile(new File("path/to/Screenshot_46.png"));
        File file = new File("src/test/resources/Screenshot_46.png");
        $("#currentAddress").setValue("Proxladnaya street 28");
        //$(".css-yk16xz-control").click();
        $("#state").click();
        $(".css-1pahdxg-control").shouldBe(visible);
        $$(". css-1uccc91-singleValue").findBy(text("Haryana")).click();
        $("#city").click();
        $(".css-11unzgr").shouldHave(Condition.text("Karnal"));
        $(".css-11unzgr div").shouldHave(Condition.exactText("Karnal"));
        $("#submit").click();

    }
}
