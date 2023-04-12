package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static pages.AbstractPage.driver;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "(//a[@class='sc-1au9i1l-18 gQNwbl cy-login-button'])[2]")
    private WebElement login;
    @FindBy(xpath = "//button[@class='ant-btn sc-1t4pdxh-0 iRSnxd cy-toggle-form-registration ant-btn-normal ant-btn-sm ant-btn-block']")
    private WebElement regButton;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//button[@class='ant-btn sc-1t4pdxh-0 kAlGSv cy-login-submit-button ant-btn-primary ant-btn-lg ant-btn-block']")
    private WebElement finalClick;
    @FindBy(xpath = "//button[@class='ant-btn sc-1t4pdxh-0 kAlGSv cy-login-submit-button ant-btn-primary ant-btn-lg ant-btn-block']")
    private WebElement logIn;

    @Step("Нажать на кнопку 'Войти'")
    public void clickOnLogin() {
        login.click();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Attach the screenshot to the Allure report
        try {
            Allure.addAttachment("Screenshot", new FileInputStream(screenshot));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Step("Нажать на кнопку регистрации")
    public void clickOnReg() {
        regButton.click();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Attach the screenshot to the Allure report
        try {
            Allure.addAttachment("Screenshot", new FileInputStream(screenshot));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Step("Ввести в поле 'Ваша электронная почта' {email}")
    public void setEmail(String ema) {
        email.sendKeys(ema);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Attach the screenshot to the Allure report
        try {
            Allure.addAttachment("Screenshot", new FileInputStream(screenshot));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Step("Ввести в поле 'Пароль' {password}")
    public void setPassword(String pass) {
        password.sendKeys(pass);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Attach the screenshot to the Allure report
        try {
            Allure.addAttachment("Screenshot", new FileInputStream(screenshot));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Step("Нажать на кнопку 'Зарегистрироваться'")
    public void finalClickOnReg() {
        finalClick.click();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Attach the screenshot to the Allure report
        try {
            Allure.addAttachment("Screenshot", new FileInputStream(screenshot));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Step("Нажать на кнопку Войти")
    public void clickOnLogIn() {
        logIn.click();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Attach the screenshot to the Allure report
        try {
            Allure.addAttachment("Screenshot", new FileInputStream(screenshot));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
