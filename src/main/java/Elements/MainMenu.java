package Elements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainMenu {

    @FindBy(xpath = "//input[@class='ant-input']")
    private WebElement inputSearch;

    public MainMenu(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @Step("Ввести в поле поиска значение {text}")
    public void setInputSearch(String text) {
        inputSearch.sendKeys(text);

    }
}
