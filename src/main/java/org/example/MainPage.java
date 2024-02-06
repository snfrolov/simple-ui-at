package org.example;

import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Name;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    @Name("Логотип ВТБ")
    private final SelenideElement vtbLogo = $(By.xpath("(//a[@href='/'])[3]"));

    @Name("Кнопка логина в ВТБ Онлайн")
    private final SelenideElement loginButton = $(By.xpath("//a[@data-component='header-login-link-desktop']"));

    @Name("Кнопка 'Стать клиентом'")
    private final SelenideElement becomeClientButton = $(By.xpath("//*[text()='Стать клиентом']"));

    @Name("Поле 'Номер телефона'")
    private final SelenideElement phoneNumberField = $(By.xpath("//input[@data-test-id='phone_maskedfield_input']"));

    @Name("Кнопка 'Получить код'")
    private final SelenideElement getCodeButton = $(By.xpath("//button[@data-test-id='submit-lite-button']"));

    @Name("Ошибка регистрации")
    private final SelenideElement registrationError = $(By.xpath("//h2[text()='Вход временно невозможен']"));

    @Name("Кнопка 'Вернуться ко входу'")
    private final SelenideElement backButton = $(By.xpath("//*[contains(text(),'входу')]"));

    public boolean isVtbLogoVisible() {
        return vtbLogo.isDisplayed();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickBecomeClientButton() {
        becomeClientButton.click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void clickGetCodeButton() {
        getCodeButton.click();
    }

    public boolean isRegistrationErrorVisible() {
        return registrationError.isDisplayed();
    }

    public void clickBackButton() {
        backButton.click();
    }

    public boolean isPhoneNumberFieldVisible() {
        return phoneNumberField.isDisplayed();
    }
}
