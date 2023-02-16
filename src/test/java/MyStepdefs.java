import cucumber.api.java.ru.Допустим;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @cucumber.api.java.ru.Допустим("^Заходим на сайт втб$")
    public void заходимНаСайтВтб() {
        open("https://www.vtb.ru/");
    }

    @cucumber.api.java.ru.Допустим("^Сначала нажимаем кнопку ВТБ-Онлайн$")
    public void сначалаНажимаемКнопкуВТБОнлайн() {
        $(byXpath("//a[text()='ВТБ-Онлайн']")).click();
    }

    @cucumber.api.java.ru.Допустим("^Сначала вводим (\\d+)$")
    public void сначалаВводим(String cardNUmberOrLogin) {
        $(byXpath("//label[text()='Номер карты или логин (УНК)']")).parent().$(byXpath("input")).sendKeys(cardNUmberOrLogin);
    }

    @cucumber.api.java.ru.Допустим("^Нажимаем кнопку Далее$")
    public void нажимаемКнопкуДалее() {
        $(byXpath("//button[text()='Далее']")).click();
    }

    @cucumber.api.java.ru.Допустим("^Потом вводим (\\d+)$")
    public void потомВводим(String password) {
        $(byXpath("//label[text()='Пароль']")).parent().$(byXpath("input")).sendKeys(password);
    }

    @cucumber.api.java.ru.Допустим("^Нажимаем кнопку Войти$")
    public void нажимаемКнопкуВойти() {
        $(byXpath("//button[text()='Войти']")).click();
    }

    @Допустим("^Появилось Проверьте логин, правильность пароля и срок его действия\\.$")
    public void появилосьПроверьтеЛогинПравильностьПароляИСрокЕгоДействия() {
        $(byXpath("//div[text()='Проверьте логин, правильность пароля и срок его действия.']"));
    }

//    with PageObject

//    @Допустим("^Сначала нажимаем кнопку ВТБ-Онлайн используя PageObject$")
//    public void сначалаНажимаемКнопкуВТБОнлайнИспользуяPageObject() {
//        MainPage.clickLogin();
//    }
//
//    @Допустим("^Логинимся с (\\d+) и (\\d+) используя PageObject$")
//    public void логинимсяСЛогиномИПаролемИспользуяPageObject(String cardNUmberOrLogin, String password) {
//        LoginPage.login(cardNUmberOrLogin, password);
//    }

}
