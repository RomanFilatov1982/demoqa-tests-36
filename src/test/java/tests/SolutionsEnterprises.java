package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class SolutionsEnterprises {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void downloadEnterprises() {
        //Открыть страничку GitHub
        open("https://github.com");

        //Навести мышкой из HeaderMenu на Solutions
        $(withTagAndText("button","Solutions" )).hover();

        //Кликнуть на Enterprises
        $(".list-style-none").shouldBe(visible);
        $("[aria-labelledby=solutions-by-company-size-heading]").$(byText("Enterprises")).click();

        //Проверить что существует заголовок "The AI-powered developer platform"
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }
}
