package ru.renCredit.Tests;

import org.testng.annotations.Test;
import ru.renCredit.Page.CardPage;
import ru.renCredit.Page.HomePage;
import ru.renCredit.WebDriverSettings;

public class SecondTest extends WebDriverSettings {
    @Test
    public void secondTest() {
        //Переходим на url нужной страницы
        driver.get("https://rencredit.ru/");

        //Переходим на страницу "Карты"
        HomePage homePage = new HomePage(driver);
        driver = homePage.cardBtnClick();

        //Загружаем страницу "Карты"
        CardPage cardPage = new CardPage(driver);
        cardPage.waitDownloadPage();

        //Нажимаем "Заполнить зяавку карты"
        cardPage.showCardOptions();

        //Ожидаем загрузку формы заявки
        cardPage.waitCardOptions();

        //Задаем фамилие
        cardPage.setSurname("Иванов");

        //Задаем имя
        cardPage.setName("Иван");

        //Устанавливаем "Нет отчества"
        cardPage.setNoSecondName();

        //Задаем телефон
        cardPage.setTelephoneNumber("9991234567");

        //Задаем e-mail
        cardPage.setEmail("IvanIvanov@gmail.com");

        //Выбрать значение из выпадающего списка "Где вы желаете получить карту"
        cardPage.setPlace();
    }
}
