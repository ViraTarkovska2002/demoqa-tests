package jUnit;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Browsers.FIREFOX;

public class FirstJUnitTest {

    // такая конструкция в jUnit называется жизненным циклом теста:
    @BeforeAll
    static void beforeAll() {
     Configuration.browser = FIREFOX;
        System.out.println("Это метод @BeforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Это метод @AfterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("    Это метод @BeforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("    Это метод @AfterEach");
    }

    @Test
    void firstTest() {
        System.out.println("            Это first тест");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void secondTest() {
        System.out.println("            Это second тест");
    }
}
