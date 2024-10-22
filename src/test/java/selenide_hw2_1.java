import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class selenide_hw2_1 {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void findSolutions () {

        open("");
        $(".HeaderMenu-nav").$(byText("Solutions")).hover();
        $$("a.HeaderMenu-dropdown-link").findBy(text("Enterprises")).click();
        $("h1#hero-section-brand-heading").shouldHave(text("The AI-powered\n" + "developer platform."));
    }
}