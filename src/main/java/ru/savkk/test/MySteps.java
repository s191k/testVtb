package ru.savkk.test;
import cucumber.api.java.ru.Допустим;
import cucumber.api.java.ru.И;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MySteps {

    @Допустим("^Заходим на сайт втб$")
    public void заходимНаСайтВтб() {
        open("https://www.vtb.ru/");
    }

    @И("^(\\d+) равно (\\d+)$")
    public void равно(int arg0, int arg1) {
        SoftAssertionsInstance.getSoftAssertionsInstance().
    }


}