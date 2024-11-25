package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginField = $("[data-test-id=login] input");

    private final SelenideElement passwordField = $("[data-test-id=password] input");

    private final SelenideElement loginButton = $("[data-test-id=action-login]");

    private final SelenideElement errorMessage = $("[data-test-id=error-notification]");

    public void badLogin() {
        errorMessage.shouldHave(text("Вы ввели пароль неверно 3 раза, система заблокирована")).shouldBe(visible);
    }

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        login(info);
        return new VerificationPage();
    }

    public void login(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
    }

    public void threeLogin(DataHelper.WrongAuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        loginButton.click();
        loginButton.click();
    }
}