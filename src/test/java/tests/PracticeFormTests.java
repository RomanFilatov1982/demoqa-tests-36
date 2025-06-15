package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTests(){
        open("/automation-practice-form");
        $("#firstName").setValue("Roman");
        $("#lastName").setValue("Filatov");
        $("#userEmail").setValue("romanf@gmail.com");
        $("[for=gender-radio-1]").click();
        //$("[for=gender-radio-1]").shouldBe(checked);
        //$("[for=gender-radio-2]").shouldNotBe(checked);
        //$("[for=gender-radio-3]").shouldNotBe(checked);
        $("#userNumber").setValue("9085693730");
        $(".react-datepicker-wrapper").click();
        //$("select.react-datepicker__month-select").shouldBe(visible).click();
        $("select.react-datepicker__month-select").shouldBe(visible).selectOption("January");
        //$("select.react-datepicker__year-select").shouldBe(visible).click();
        $("select.react-datepicker__year-select").shouldBe(visible).selectOption("1982");
        $$(".react-datepicker__day").findBy(text("18")).click();
        $("#subjectsInput").setValue("Fisics");
        $("label[for=hobbies-checkbox-1]").click();
        //$("#uploadPicture").uploadFile(new File("path/to/Screenshot_46.png"));
        File file = new File("src/test/resources/Screenshot_46.png");
        $("#currentAddress").setValue("Proxladnaya street 28");
        //$(".css-yk16xz-control").click();
        $(".css-19bqh2r").click();
        $(".css-11unzgr").shouldBe(visible);
        $$(".css-11unzgr div").findBy(text("Haryana")).click();
        $("#city").click();
        $(".css-11unzgr").shouldHave(Condition.text("Karnal"));
        $(".css-11unzgr div").shouldHave(Condition.exactText("Karnal"));
        $("#submit").click();

    }
}
