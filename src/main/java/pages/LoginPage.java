package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    }
    @Step("Нажать на кнопку регистрации")
    public void clickOnReg() {
        regButton.click();
    }

    @Step("Ввести в поле 'Ваша электронная почта' {email}")
    public void setEmail(String ema) {
        email.sendKeys(ema);
    }
    @Step("Ввести в поле 'Пароль' {password}")
    public void setPassword(String pass) {
        password.sendKeys(pass);
    }
    @Step("Нажать на кнопку 'Зарегистрироваться'")
    public void finalClickOnReg() {
        finalClick.click();

    }
    @Step("Нажать на кнопку Войти")
    public void clickOnLogIn() {
        logIn.click();
    }
}
