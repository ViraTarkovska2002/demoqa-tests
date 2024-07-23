package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        //Configuration.holdBrowserOpen = true;
        Configuration.browser = FIREFOX;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void FillTestBoxFormTest() {
        String userName = "Vasia Pupkin"; // вынос значения в переменную

        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        $("#userName").setValue(userName);
        $("#userEmail").setValue("vasia_pupkin@gmail.com");
        $("#currentAddress").setValue("Berlin");
        $("#permanentAddress").setValue("Paris");
        $("#submit").scrollIntoView(true).click();

        // $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave((text(userName)));
        $("#output #email").shouldHave((text("vasia_pupkin@gmail.com")));
        $("#output #currentAddress").shouldHave((text("Berlin")));
        $("#output #permanentAddress").shouldHave((text("Paris")));
        // или
        //$("#output").shouldHave(text("Vasia Pupkin"), text("vasia_pupkin@gmail.com"), text("Berlin"), text("Paris"));
    }
}
