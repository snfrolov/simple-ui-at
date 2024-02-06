package org.example;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainSteps {
    private MainPage mainPage = new MainPage();

    @Step("Зайти на сайт ВТБ")
    public MainSteps openVtbSite() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000L;
        open("https://www.vtb.ru/");
        getWebDriver().manage().window().maximize();
        return this;
    }

    @Step("Вернуть флаг отображения лого сайта ВТБ")
    public boolean isVtbLogoVisible() {
        return mainPage.isVtbLogoVisible();
    }

    @Step("Открыть страницу логина в ВТБ Онлайн")
    public MainSteps openVtbOnlineLoginPage() {
        mainPage.clickLoginButton();
        switchTo().window("Интернет-банк ВТБ Онлайн: вход в личный кабинет");
        return this;
    }

    @Step("Открыть страницу регистрации клиента в ВТБ Онлайн")
    public MainSteps openRegistrationPage() {
        mainPage.clickBecomeClientButton();
        return this;
    }

    @Step("Заполнить номер телефона клиента")
    public MainSteps enterPhoneNumber(String phoneNumber) {
        mainPage.enterPhoneNumber(phoneNumber);
        return this;
    }

    @Step("Нажать кнопку получения СМС кода")
    public MainSteps getSmsCode() {
        mainPage.clickGetCodeButton();
        return this;
    }

    @Step("Вернуть флаг отображения ошибки регистрации")
    public boolean isRegistrationErrorVisible() {
        return mainPage.isRegistrationErrorVisible();
    }

    @Step("Вернуться на страницу логина")
    public MainSteps backToLoginPage() {
        mainPage.clickBackButton();
        return this;
    }

    @Step("Вернуть флаг отображения поля номера телефона")
    public boolean isPhoneNumberFieldVisible() {
        return mainPage.isPhoneNumberFieldVisible();
    }
}
