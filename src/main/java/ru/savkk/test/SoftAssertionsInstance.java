package ru.savkk.test;
import cucumber.api.java.After;
import org.assertj.core.api.SoftAssertions;
import java.util.List;

public class SoftAssertionsInstance {
    private static SoftAssertions instance;

    /**
     * Создаем единый Instance SoftAssertion, чтобы собирать все ошибки в один объект,
     * т.к. Instance может вызываться в разных классах.
     * */
    public static SoftAssertions getSoftAssertionsInstance(){
        if (instance == null) {
            instance = new SoftAssertions();
        }
        return instance;
    }

    /**
     * Надо удалять текущий Instance SoftAssertion - т.к. сохраняются ошибки
     * со всех тестов(сценариев)
     * */
    private static void resetSoftAssertionsInstance(){
        instance = null;
    }

    @After
    public void clearData() throws Throwable {
        try {
            List<Throwable> errors = getSoftAssertionsInstance().errorsCollected();
            if (errors.size() != 0 ) {
                for(Throwable curError : errors) {
                    System.out.println(curError.getMessage());
                }
                throw new Throwable("Тест не прошел проверку SoftAssert");
            }
        }
        finally {
            resetSoftAssertionsInstance();
        }
    }

}
