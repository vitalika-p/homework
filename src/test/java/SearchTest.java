import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class SearchTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        chromedriver().setup();

    }

    
@Test
void shouldFindSelenideRepositoryAtTheTop() {

    //Открыть страницу Selenide в GitHub
    open("/selenide/selenide");
    //Перейти в раздел Wiki проекта
    $("a#wiki-tab").click();
    //Убедиться, что в списке страниц (Pages) есть страница SoftAssertions (добавила проверку через поиск)
    $("[placeholder='Find a page…']").setValue("SoftAssertions").pressEnter();
    //Увидеть из скрытых элементов
    $("#wiki-pages-filter").setValue("SoftAssertions");
    $("#wiki-pages-box").$(byText("SoftAssertions")).shouldBe(visible).click();
    //Открыть страницу SoftAssertions, проверить, что внутри есть пример кода для JUnit5
    $("a.Truncate-text.text-bold.py-1").click();
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
            "}"));

   }
}
