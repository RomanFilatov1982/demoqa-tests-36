package celenide2;

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
    static void openEnterprises() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void downloadEnterprises() {
        open("https://github.com");

        $(withTagAndText("button","Solutions" )).hover();

        $(".list-style-none").shouldBe(visible);
        $("[aria-labelledby=solutions-by-company-size-heading]").$(byText("Enterprises")).click();

        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }
}
