package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SearchCodeTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void searchJUnit5CodeTest() {
        open("https://github.com");
        $(".search-input").click();
        //В строке поиска  ввести Selenide
        $("#query-builder-test").setValue("Selenide").pressEnter();
        //$("#query-builder-test").setValue("Selenide").pressEnter();

        //Выбрать из списка первый Selenide
        $$("[data-testid='results-list']").first().$("a").click();

        //Перейдите в раздел Wiki проекта
        $$("ul.UnderlineNav-body li").get(5).$("a").click();

        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        //$("#filter-bar li").lastChild().$("a").click();
        $$("[data-filterable-for='wiki-pages-filter']").last().click();


        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
    }
}