import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

//import vtb.loginPage.LoginPage;
//import vtb.mainPage.MainPage;


public class VtbTest {

    @Before
    public void enter_home(){
        open("https://www.vtb.ru/");
    }

    @Test
    public void testWithoutPageObject() {
        /*
         * Тест авторизации
         * */
        String cardNUmberOrLogin = "5555666677778888";
        String password = "\"5555666677778888\"";
        $(byXpath("//a[text()='ВТБ-Онлайн']")).click();
        $(byXpath("//label[text()='Номер карты или логин (УНК)']")).parent().$(byXpath("input")).sendKeys(cardNUmberOrLogin);
        $(byXpath("//button[text()='Далее']")).click();
        $(byXpath("//label[text()='Пароль']")).parent().$(byXpath("input")).sendKeys(password);
        $(byXpath("//button[text()='Войти']")).click();
        $(byXpath("//div[text()='Проверьте логин, правильность пароля и срок его действия.']"));
    }

    @Test
    public void testWithPageObject() {
        /*
        * Тест авторизации с использованием PajeObject
        * */
        $(byXpath("//a[text()='ВТБ-Онлайн']")).click();
        $(byXpath("//div[text()='Вход в ВТБ-Онлайн']"));
//        LoginPage.login("5555666677778888", "5555666677778888");
        $(byXpath("//div[text()='Проверьте логин, правильность пароля и срок его действия.']"));
//        MainPage.clickLogin();
    }

    public Stream<SelenideElement> getStreamOfNavigationItems() {
        return $$(byXpath("//div[@class='navigation__second__item']")).stream();
    }

    @Test
    public void testtemp(){
        /*
         * Тест - проверка что на каждой странице из меню "шапки", отображается такая же "шапка" меню.
         * */
        List<String> shapkaMenu = getStreamOfNavigationItems().map((x)->x.getText()).collect(Collectors.toList());
        List<String> shapkaMenuHrefs = getStreamOfNavigationItems().map((x)->x.$(byXpath("a")).attr("href")).collect(Collectors.toList());
        for(String curHref : shapkaMenuHrefs) {
            open(curHref);
            $(byXpath("//div[@class='navigation__second__item']")).shouldBe(Condition.visible);
            Assert.assertEquals(shapkaMenu , getStreamOfNavigationItems().map((x)->x.getText()).collect(Collectors.toList()));
        }
    }

//    public static void main(String[] args) {
//    }


}
