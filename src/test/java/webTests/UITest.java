package webTests;
import io.qameta.allure.Step;
import io.qameta.allure.Allure;
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.AbstractBasePage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static constans.Constants.TimeoutVariable.IMPLICIT_WAIT;

public abstract class UITest {
    protected WebDriver driver;

    @BeforeClass
    public void setup() throws IOException {
        loadProperties();
        setupDriver();
        setupTarget();
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
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        // Установить созданный драйвер для поиска в веб-страницах
        AbstractBasePage.setDriver(driver);
    }

    @Step("Создать папку со скриншотами")
    private static void setupTarget() {
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
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
    }

    @Step("Открыть сайт")
    @BeforeMethod
    public void open() {
        driver.get(System.getProperty("site.url"));
    }

    /**
     * Освобождение ресурсов
     */
    @AfterMethod
    public void closeM() {
        if (driver != null) {
            // Закрываем одно текущее окно браузера
            driver.close();
            // Закрываем все открытые окна браузера, завершаем работу браузера, освобождаем ресурсы
            driver.quit();
        }
    }
}