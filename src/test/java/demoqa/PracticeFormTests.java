package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browser = FIREFOX;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterAll
    static void afterAll(){
        // Configuration.holdBrowserOpen = false;
    }

    @Test
    void FillTestBoxFormTest() {
        String userName = "Damien"; // вынос значения в переменную
        String lastName = "Stevens";
        String userEmail = "damien_stevens@marvin.com";
        String gender = "Male";
        String userNumber = "2037932834";
        String subjects = "Lorem ipsum";
        String currentAddress = "58 Roman Rd, LEEDS, LS2 3ZR";
        String state = "Haryana";
        String city = "Panipat";


        open("/automation-practice-form");
        //executeJavaScript("$('#fixedban').remove()"); // прячет рекламу со страницы
        //executeJavaScript("$('#footer').remove()"); // прячет футер со страницы

        $(".text-center").shouldHave(text("Practice Form"));
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        //Gender:
        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue(userNumber);

        //Календарь
        // выбор года
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day--021:not(.react-datepicker__day--outside-month)").click(); //когда два одинаковых числа, н-р, "30"


        //$("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("pictures/1.jpg"); // метод uploadFromClasspath работает только для элемента, у которого есть type="file"
        $("#currentAddress").setValue(currentAddress);

        $("#state").scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").scrollIntoView(true).click();


        // check results
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").$(byText("Student Name")).sibling(0).shouldHave(text(userName + " " + lastName));
        $(".table").$(byText("Student Email")).sibling(0).shouldHave(text(userEmail));
        $(".table").$(byText("Gender")).sibling(0).shouldHave(text(gender));
        $(".table").$(byText("Mobile")).sibling(0).shouldHave(text(userNumber));
        $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("21 May,1989"));
        //$(".table").$(byText("Subjects")).sibling(0).shouldHave(text(subjects));
        $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Music"));
        $(".table").$(byText("Picture")).sibling(0).shouldHave(text("1.jpg"));
        $(".table").$(byText("Address")).sibling(0).shouldHave(text(currentAddress));
        $(".table").$(byText("State and City")).sibling(0).shouldHave(text(state + " " + city));
        $("#closeLargeModal").click();

    }
}
