package ru.renCredit.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.renCredit.WebDriverSettings;

public class CardPage extends WebDriverSettings {
    private By cardOptions = By.cssSelector("a[href=\"https://rencredit.ru/app/card/cc_full\"]");
    private By surname = By.cssSelector("#t1");
    private By name = By.cssSelector("#t2");
    private By noSecondName = By.cssSelector("#section_1 > div.order-form-block__content > div > form > div:nth-child(1) > div:nth-child(4) > div > label > div");
    private By telephoneNumber = By.cssSelector("#t4");
    private By email = By.cssSelector("#t38");
    private By area = By.cssSelector("#s2-styler > div.jq-selectbox__select > div.jq-selectbox__select-text.placeholder");
    private By place = By.cssSelector("#s2-styler > div.jq-selectbox__dropdown > ul > li:nth-child(39)");

    public CardPage(ChromeDriver driver) {
        this.driver = driver;
    }

    //Ожидаем загрузку страницы
    public void waitDownloadPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardOptions));
    }

    //Выбираем карту
    public void showCardOptions() {
        driver.findElement(cardOptions).click();
    }

    //Ожидаем загрузку настроек карты
    public void waitCardOptions() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(surname));
    }

    //Задаем фамилие
    public void setSurname(String surname) {
        driver.findElement(this.surname).sendKeys(surname);
    }

    //Задаем имя
    public void setName(String name) {
        driver.findElement(this.name).sendKeys(name);
    }

    //Отмечаем "Нет отчества"
    public void setNoSecondName() {
        driver.findElement(noSecondName).click();
    }

    //Задаем мобильный телефон
    public void setTelephoneNumber(String telephoneNumber) {
        driver.findElement(this.telephoneNumber).sendKeys(telephoneNumber);
    }

    //Задаем e-mail
    public void setEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    //Выбрать значение из выпадающего списка "Где вы желаете получить карту"
    public void setPlace() {
        driver.findElement(area).click();
        driver.findElement(place).click();
    }
}