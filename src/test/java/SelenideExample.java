import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class SelenideExample {

    @Test
    void primerSelenide() {
        open("https://www.vtb.ru/");
        $(By.xpath("(//a[@href='/'])[3]")).shouldBe(Condition.visible);
    }
}
