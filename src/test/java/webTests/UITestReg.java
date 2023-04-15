package webTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookMainPage;

import java.io.IOException;

public class UITestReg extends UITest {

    /** Тест-кейс успешной регистрации */
    @Test
    public void regTest () throws IOException {
        //todo: шаги тест-кейса
        BookMainPage bookMainPage = new BookMainPage(driver);
        String username = System.getProperty("username");
        String password = System.getProperty("password");

        bookMainPage.clickOnLogin(); //1. Нажать на кнопку 'войти'
        takeScreenshot(driver, "step1auth"); // Скриншот 1
        bookMainPage.clickOnReg(); //2. Нажать на кнопку 'Зарегистрироваться'
        bookMainPage.setEmail(username); //3. Ввести в поле 'Ваша электронная почта' {email}
        takeScreenshot(driver, "step2auth"); // Скриншот 2
        bookMainPage.setPassword(password); //4. Ввести в поле 'Пароль' {password}
        takeScreenshot(driver, "step3auth"); // Скриншот 3
        bookMainPage.finalClickOnReg(); //5. Нажать на кнопку 'Зарегистрироваться'
        takeScreenshot(driver, "step4auth"); // Скриншот 4

    }
}
