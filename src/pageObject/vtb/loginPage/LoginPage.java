package vtb.loginPage;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    public static void fillCardNumberOrLogin(String cardNUmberOrLogin) {
        $(byXpath("//label[text()='Номер карты или логин (УНК)']")).parent().$(byXpath("input")).sendKeys(cardNUmberOrLogin);
    }

    public static void clickNextButton() {
        $(byXpath("//button[text()='Далее']")).click();
    }

    public static void fillPassword(String password) {
        $(byXpath("//label[text()='Пароль']")).parent().$(byXpath("input")).sendKeys(password);
    }

    public static void clickEnterButton() {
        $(byXpath("//button[text()='Войти']")).click();
    }

    public static void login(String cardNUmberOrLogin, String password) {
        fillCardNumberOrLogin(cardNUmberOrLogin);
        clickNextButton();
        fillPassword(password);
        clickEnterButton();
    }

}
