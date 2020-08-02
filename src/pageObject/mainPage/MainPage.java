import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public static void clickLogin() {
        $(byXpath("//a[text()='ВТБ-Онлайн']")).click();
        $$("23").forEach((x) -> {x.click();});
    }

}
