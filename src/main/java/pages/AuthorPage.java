package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorPage extends AbstractBasePage {
    public AuthorPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='ant-btn sc-1t4pdxh-0 kAlGSv ant-btn-primary ant-btn-lg ant-btn-block']")
    private WebElement read;

    @Step("Нажать на кнопку Читать отрывок")
    public void clickOnRead() {
        read.click();
    }
}
