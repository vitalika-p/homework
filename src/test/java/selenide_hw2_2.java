import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class selenide_hw2_2 {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void dragAndDropTest () {

        open("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void dragAndDropOtherTest () {

        open("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));
        $("#column-b header").shouldHave(text("A"));
    }
}