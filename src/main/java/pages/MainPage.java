package pages;

import org.openqa.selenium.support.PageFactory;

public class MainPage extends BookBasePage {

    public MainPage() {
        PageFactory.initElements(driver, this);
    }
}
