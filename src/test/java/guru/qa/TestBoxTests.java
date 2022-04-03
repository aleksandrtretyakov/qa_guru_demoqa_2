package guru.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {
    @Test
    void fillFormtest() {
        open("https://demoqa.com/text-box");

    }
}
