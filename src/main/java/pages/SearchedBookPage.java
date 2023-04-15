package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchedBookPage extends AbstractBasePage {

    public SearchedBookPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[contains(text(),'Путешествие на край света: Галапагосы')]/parent::a")
    private WebElement picture;

    @Step("Нажать на иконку первой книги")
    public void clickOnPicture() {
        picture.click();
    }
}
