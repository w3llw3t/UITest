package web;
import Elements.MainMenu;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AbstractPage;
import pages.BookPage;
import pages.LoginPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Listeners({ io.qameta.allure.testng.AllureTestNg.class })
public class UITest {
    private WebDriver driver;

    @BeforeClass
    public void setup() throws IOException {
        loadProperties();
        setupDriver();
    }

    @Step("Загрузить конфигурацилнные файлы")
    private void loadProperties() throws IOException {
        // Читаем конфигурационные файлы в System.properties
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
    }
    @Step("Создать экземпляр драйвера")
    private void setupDriver() {
        // Создание экземпляра драйвера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        // Устанавливаем размер окна браузера, как максимально возможный
        driver.manage().window().maximize();
        // Установим время ожидания для поиска элементов
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Установить созданный драйвер для поиска в веб-страницах
        AbstractPage.setDriver(driver);
    }

    /** Тест-кейс по поиску книги */
    @Test
    public void searchBook () {
        //todo: шаги тест-кейса
        String url = System.getProperty("site.url");
        driver.get(url); //предусловие: открыта главная страница сайта

        MainMenu mainMenu = new MainMenu(driver); //1. Ввести в поле "Книга или автор" - Галапагосы
        mainMenu.setInputSearch("Галапагосы");

        BookPage bookPage = new BookPage(driver);
        bookPage.clickOnBook(); //2. Нажать на иконку полученной книги
        bookPage.clickOnRead(); //3. Нажать на кнопку 'читать отрывок'

    }
    /** Тест-кейс успешной регистрации */
    @Test
    public void reg() {
        String url = System.getProperty("site.url");
        driver.get(url); //предусловие: открыта главная страница сайта

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLogin(); //1. Нажать на кнопку 'войти'
        loginPage.clickOnReg(); //2. Нажать на кнопку 'Зарегистрироваться'
        loginPage.setEmail("nicepal223@gmail.com"); //3. Ввести в поле 'Ваша электронная почта' {email}
        loginPage.setPassword("Password!23"); //4. Ввести в поле 'Пароль' {password}
        loginPage.finalClickOnReg(); //5. Нажать на кнопку 'Зарегистрироваться'
    }
    /** Тест-кейс успешной авторизации */
    @Test
    public void auth() {
        String url = System.getProperty("site.url");
        driver.get(url); //предусловие: открыта главная страница сайта
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickOnLogin(); //1. Нажать на кнопку 'войти'
        loginPage.setEmail("nicepal223@gmail.com"); //2. Ввести в поле 'Ваша электронная почта' {email}
        loginPage.setPassword("Password!23"); //3. Ввести в поле 'Пароль' {password}
        loginPage.clickOnLogIn(); //2. Нажать на кнопку 'войти'
    }
    @AfterTest
    public void close() {
        if (driver != null) {
            // Закрываем одно текущее окно браузера
            driver.close();
            // Закрываем все открытые окна браузера, завершаем работу браузера, освобождаем ресурсы
            driver.quit();
        }
    }
}