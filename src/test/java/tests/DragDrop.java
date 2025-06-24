package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragDrop {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void DragAndDropTest() {
        //Открыть страничку
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Перемещаем элемент A на элемент B
        //$("#column-a").dragAndDrop(to("#column-b"));

        SelenideElement source = $("#column-a");
        SelenideElement target = $("#column-b");
        $(source).shouldHave(text("A"));
        $(target).shouldHave(text("B"));

        actions().clickAndHold(source).moveToElement(target).release().perform();
        $(source).shouldHave(text("B"));
        $(target).shouldHave(text("A"));
    }
}
