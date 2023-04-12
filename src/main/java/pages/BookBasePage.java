package pages;

import Elements.MainMenu;

public class BookBasePage extends AbstractPage{

    public MainMenu mainMenu() {
        return new MainMenu(driver);
    }
}
