package Lokators;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.bidi.script.LocalValue.setValue;

public class CssXpathExamples {
    void cssXpathExamples(){
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
        $("[data-testid=email]").setValue("1");
        $(by("data-testid", "email")).setValue("1");

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email">
        $("[id=email]").setValue("1");
        $("#email").setValue("1");
        $("input#email").setValue("1");
        $x("//*[@id='email']").setValue("1");
        $x("//input[@id='email']").setValue("1");

        // <input type="email" class="inputtext login_form_input_box" name="email">
        $("[name=email]").setValue("1");
        $(byName("email")).setValue("1");

        // <input type="email" class="inputtext login_form_input_box">
        $("[class = login_form_input_box]");
        $(".login_form_input_box");
        $(".inputtext.login_form_input_box");
        $("input.login_form_input_box");
        $x("//input[@class=inputtext'][@class='login_form_input_box']");

        /*
        <div class="inputtext">
        <input type="email" class="inputtext login_form_input_box">

        <div>
         */
        $(".inputtext .login_form_input_box");
        $(".inputtext").$(".login_form_input_box");

        // <div>Hello qa.guru</div>
        $x("//div[text()='Hello qa.guru']");
        $(byText("Hello qa.guru"));
        $(withText("lo qa.guru"));


    }
}
