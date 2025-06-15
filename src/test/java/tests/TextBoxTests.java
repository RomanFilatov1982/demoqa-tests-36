package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }
    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Roman");
        $("#userEmail").setValue("romaF@gmail.com");
        $("#currentAddress").setValue("Some street 28");
        $("#permanentAddress").setValue("Another street 28");
        $("#submit").click();
        
        $("#output").$("#name").shouldHave(text("Roman"));
        $("#output").$("#email").shouldHave(text("romaF@gmail.com"));
        $("#output").$("#currentAddress").shouldHave(text("Some street 28"));
        $("#output").$("#permanentAddress").shouldHave(text("Another street 28"));
    }

}