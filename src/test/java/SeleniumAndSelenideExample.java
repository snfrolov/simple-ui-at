import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class SeleniumAndSelenideExample {

    @Test
    @DisplayName("Открытие сайта ВТБ - Selenium")
    void seleniumExample() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.vtb.ru/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='/'])[3]")));
        driver.quit();
    }

    @Test
    @DisplayName("Открытие сайта ВТБ - Selenide")
    void selenideExample() {
        open("https://www.vtb.ru/");
        $(By.xpath("(//a[@href='/'])[3]")).shouldBe(Condition.visible);
    }
}
