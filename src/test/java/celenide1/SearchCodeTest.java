package celenide1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SearchCodeTest {
    @BeforeAll
    static void searchCode() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void searchJUnit5CodeTest() {

        open("https://github.com");
        $(".search-input").click();

        $("#query-builder-test").setValue("Selenide").pressEnter();

        $$("[data-testid='results-list']").first().$("a").click();

        $$("ul.UnderlineNav-body li").get(5).$("a").click();

        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions")).shouldBe(visible);
        $("[data-filterable-for=wiki-pages-filter]").$(byText("SoftAssertions")).click();

        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}\n"));
    }
}