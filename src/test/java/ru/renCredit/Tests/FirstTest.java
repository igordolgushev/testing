package ru.renCredit.Tests;

import org.testng.annotations.Test;
import ru.renCredit.Page.DepositPage;
import ru.renCredit.Page.HomePage;
import ru.renCredit.WebDriverSettings;

public class FirstTest extends WebDriverSettings {
    @Test
    public void firstTest() throws InterruptedException {
        //Переходим на url нужной страницы
        driver.get("https://rencredit.ru/");

        //Переходим на страницу "Вклады"
        HomePage homePage = new HomePage(driver);
        driver = homePage.depositBtnClick();

        //Загружаем страницу "Вклады"
        DepositPage depositPage = new DepositPage(driver);
        depositPage.waitDownloadPage();

        //Ставим галочку "В банке"
        depositPage.setInsideBank();

        //Задаем сумму вклада
        depositPage.setAmount("30000");

        //Устанавливаем срок вклада
        depositPage.setTrim(2);

        //Скачиваем pdf "Общие условия по вкладам"
        depositPage.downLoadDocument();

        //Задержка на закрытие 3 сек (время скачивания)
        Thread.sleep(3000);
    }
}