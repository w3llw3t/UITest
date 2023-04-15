package webTests;
import org.testng.annotations.Test;
import pages.AuthorPage;
import pages.BookMainPage;
import pages.SearchedBookPage;

import java.io.IOException;

public class UITestSearchBook extends UITest {
    /** Тест-кейс по поиску книги */
    @Test
    public void searchBook () throws IOException {
        //todo: шаги тест-кейса
        BookMainPage bookMainPage = new BookMainPage(driver);
        SearchedBookPage searchedBookPage = new SearchedBookPage();
        AuthorPage authorPage = new AuthorPage();

        String inputBook = "Галапагосы";

        bookMainPage.findBook(inputBook); // 1. Ввести в поле поиска книги {text}
        takeScreenshot(driver, "searchBook1");
        searchedBookPage.clickOnPicture(); // 2. Нажать на иконку найденной книги
        takeScreenshot(driver, "searchBook2");
        authorPage.clickOnRead(); // 3. Нажать на кнопку Читать отрывок
        takeScreenshot(driver, "searchBook3");

    }
}
