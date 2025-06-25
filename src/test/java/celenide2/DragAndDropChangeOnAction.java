package celenide2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
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
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        $("#column-a").dragAndDrop(to("#column-b"));
    }
    @Test
    void actionsTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        SelenideElement source = $("#column-a");
        SelenideElement target = $("#column-b");

        $(source).shouldHave(text("A"));
        $(target).shouldHave(text("B"));

        Selenide.actions().clickAndHold(source).moveToElement(target).release().perform();

        $(source).shouldHave(text("B"));
        $(target).shouldHave(text("A"));
    }
}
