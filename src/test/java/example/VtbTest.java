package example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;

//import org.openqa.selenium.By;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

//public class NewTest {
//    private WebDriver driver;
//    @Test
//    public void testEasy() {
//        driver.get("http://demo.guru99.com/test/guru99home/");
//        String title = driver.getTitle();
//        Assert.assertTrue(title.contains("Demo Guru99 Page"));
//    }
//    @BeforeTest
//    public void beforeTest() {
//        driver = new FirefoxDriver();
//    }
//    @AfterTest
//    public void afterTest() {
//        driver.quit();
//    }
//}
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class VtbTest {

//    @Before
    @BeforeTest
    public void enter_home() throws MalformedURLException {
//
//        open("https://www.vtb.ru/");
//        WebDriver driver;
        Configuration.browser = "chrome";
        Configuration.timeout = 20000;
        Configuration.pageLoadStrategy="normal";
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver.exe");

//        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.remote = "http://10.76.38.96:4444/wd/hub";
//        ChromeOptions opts = new ChromeOptions();
//        opts.addArguments("start-maximized");
//        driver = new ChromeDriver(opts);
//        WebDriverRunner.setWebDriver(driver);

//        driver.get("https://www.vtb.ru/");

        open("https://www.vtb.ru/");

        //        RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dr);

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

//        @AfterTest
//    public void afterTest() {
//        driver.quit();
//    }

}
