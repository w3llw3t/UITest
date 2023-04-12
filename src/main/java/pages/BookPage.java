package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Страница с найденными книгами */

public class BookPage extends BookBasePage {

    public BookPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//img[@class='hh1ehr-1 eyqzzt'])[1]")
    private WebElement picture;
    @FindBy(xpath = "//a[@class='ant-btn sc-1t4pdxh-0 kAlGSv ant-btn-primary ant-btn-lg ant-btn-block']")
    private WebElement read;

    @Step("Нажать на иконку полученной книги")
    public void clickOnBook() {
        picture.click();
    }
    @Step("Нажать на кнопку 'Читать отрывок'")
    public void clickOnRead() {
        read.click();
    }

}
