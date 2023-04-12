package web;
import Elements.MainMenu;
import io.qameta.allure.Step;
import io.qameta.allure.Allure;
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AbstractPage;
import pages.BookPage;
import pages.LoginPage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class UITest {
    private WebDriver driver;

    @BeforeClass
    public void setup() throws IOException {
        loadProperties();
        setupDriver();
        setupTarget();
    }

    public static void setupTarget() {
        File directory = new File("target/screenshots");
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
    public void takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        Screenshot screenshot = new AShot().takeScreenshot(driver);
        String screenshotPath = "target/screenshots/" + screenshotName + ".png";
        ImageIO.write(screenshot.getImage(), "PNG", new File(screenshotPath));
        try (FileInputStream fis = new FileInputStream(screenshotPath)) {
            Allure.addAttachment(screenshotName, fis);
        }
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
    public void searchBook () throws IOException {
        //todo: шаги тест-кейса
        String url = System.getProperty("site.url");
        driver.get(url); //предусловие: открыта главная страница сайта

        MainMenu mainMenu = new MainMenu(driver); //1. Ввести в поле "Книга или автор" - Галапагосы
        mainMenu.setInputSearch("Галапагосы");
        takeScreenshot(driver, "step1search");

        BookPage bookPage = new BookPage(driver);
        bookPage.clickOnBook(); //2. Нажать на иконку полученной книги
        takeScreenshot(driver, "step2search");
        bookPage.clickOnRead(); //3. Нажать на кнопку 'читать отрывок'
        takeScreenshot(driver, "step3search");

    }
    /** Тест-кейс успешной регистрации */
    @Test
    public void reg() throws IOException {
        String url = System.getProperty("site.url");
        driver.get(url); //предусловие: открыта главная страница сайта

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLogin(); //1. Нажать на кнопку 'войти'
        takeScreenshot(driver, "step1");
        loginPage.clickOnReg(); //2. Нажать на кнопку 'Зарегистрироваться'
        takeScreenshot(driver, "step2reg");
        loginPage.setEmail("nicepal223@gmail.com"); //3. Ввести в поле 'Ваша электронная почта' {email}
        takeScreenshot(driver, "step3reg");
        loginPage.setPassword("Password!23"); //4. Ввести в поле 'Пароль' {password}
        takeScreenshot(driver, "step4reg");
        loginPage.finalClickOnReg(); //5. Нажать на кнопку 'Зарегистрироваться'
        takeScreenshot(driver, "step5reg");
    }
    /** Тест-кейс успешной авторизации */
    @Test
    public void auth() throws IOException {
        String url = System.getProperty("site.url");
        driver.get(url); //предусловие: открыта главная страница сайта
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickOnLogin(); //1. Нажать на кнопку 'войти'
        takeScreenshot(driver, "step1auth");
        loginPage.setEmail("nicepal223@gmail.com"); //2. Ввести в поле 'Ваша электронная почта' {email}
        takeScreenshot(driver, "step2auth");
        loginPage.setPassword("Password!23"); //3. Ввести в поле 'Пароль' {password}
        takeScreenshot(driver, "step3auth");
        loginPage.clickOnLogIn(); //4. Нажать на кнопку 'войти'
        takeScreenshot(driver, "step4auth");
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