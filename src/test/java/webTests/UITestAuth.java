package webTests;
import org.testng.annotations.Test;
import pages.BookMainPage;

import java.io.IOException;

public class UITestAuth extends UITest {
    /** Тест-кейс успешной авторизации */
    @Test
    public void authTest () throws IOException {
        //todo: шаги тест-кейса
        BookMainPage bookMainPage = new BookMainPage(driver);
        String username = System.getProperty("username");
        String password = System.getProperty("password");

        bookMainPage.clickOnLogin(); //1. Нажать на кнопку 'войти'
        takeScreenshot(driver, "step1auth"); // Скриншот 1
        bookMainPage.setEmail(username); //2. Ввести в поле 'Ваша электронная почта' {email}
        takeScreenshot(driver, "step2auth"); // Скриншот 2
        bookMainPage.setPassword(password); //3. Ввести в поле 'Пароль' {password}
        takeScreenshot(driver, "step3auth"); // Скриншот 3
        bookMainPage.clickOnLogIn(); //4. Нажать на кнопку 'Войти'
        takeScreenshot(driver, "step4auth"); // Скриншот 4
    }
}
