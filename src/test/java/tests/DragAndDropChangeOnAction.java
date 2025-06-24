package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropChangeOnAction {
    @BeforeAll
    static void dragAndDrop() {
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void DragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").dragAndDrop(to("#column-b"));

        SelenideElement source = $("#column-a");
        SelenideElement target = $("#column-b");
        $(source).shouldHave(text("A"));
        $(target).shouldHave(text("B"));

        actions().clickAndHold(source).moveToElement(target).release().perform();
        $(source).shouldHave(text("B"));
        $(target).shouldHave(text("A"));
    }
}
