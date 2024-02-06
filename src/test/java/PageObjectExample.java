import org.example.MainSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class PageObjectExample {
    private MainSteps mainSteps = new MainSteps();

    @Test
    @DisplayName("Попытка регистрации с невалидным телефоном")
    void registrationWithIncorrectPhoneNumber() {
        mainSteps.openVtbSite();

        assertThat("Проверить, что лого ВТБ оторажается",
                mainSteps.isVtbLogoVisible(), equalTo(true));

        mainSteps.openVtbOnlineLoginPage()
                .openRegistrationPage()
                .enterPhoneNumber("000 000-00-00")
                .getSmsCode();

        assertThat("Проверить, что оторажается ошибка регистрации",
                mainSteps.isRegistrationErrorVisible(), equalTo(true));

        mainSteps.backToLoginPage();

        assertThat("Проверить, что вернулись на страницу регистрации",
                mainSteps.isPhoneNumberFieldVisible(), equalTo(true));
    }

    @Test
    @DisplayName("Регистрации с валидным телефоном")
    void registrationWithCorrectPhoneNumber() {
        mainSteps.openVtbSite();

        assertThat("Проверить, что лого ВТБ оторажается",
                mainSteps.isVtbLogoVisible(), equalTo(true));


        mainSteps.openVtbOnlineLoginPage()
                .openRegistrationPage()
                .enterPhoneNumber("981 885-01-14")
                .getSmsCode();

        assertThat("Проверить, что ошибка регистрации не отображается",
                mainSteps.isRegistrationErrorVisible(), equalTo(false));

        mainSteps.backToLoginPage();

        assertThat("Проверить, что вернулись на страницу регистрации",
                mainSteps.isPhoneNumberFieldVisible(), equalTo(true));
    }
}
