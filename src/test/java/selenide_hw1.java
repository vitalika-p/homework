import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class selenide_hw1 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";

    }

    
@Test
void shouldFindSelenideRepositoryAtTheTop() {

    open("/selenide/selenide");
    $("a#wiki-tab").click();
    $("#wiki-pages-filter").setValue("SoftAssertions");
    $("#wiki-pages-box").$(byText("SoftAssertions")).shouldBe(visible).click();
    $("#wiki-body").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }"""));
   }
}
