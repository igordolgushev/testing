package ru.renCredit.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.renCredit.WebDriverSettings;

public class DepositPage extends WebDriverSettings {
    private By insideBank = By.cssSelector("#section_1 > div > div > form > div.calculator__content > div.internet-bank > div > div:nth-child(2) > label");
    private By amount = By.name("amount");
    private By trim = By.cssSelector("#section_1 > div > div > form > div.calculator__content > div:nth-child(4) > div.range_wrapper.calculator__slide-row > div.range.js-range.ui-slider.ui-slider-horizontal.ui-widget.ui-widget-content.ui-corner-all > span");
    private By dwnlForm = By.cssSelector("#section_2 > div > div.tabs.js-tabs > div.tabs-content > div:nth-child(1) > div.deposits-terms__info-doc-row > div > h3 > a");

    public DepositPage(ChromeDriver driver) {
        this.driver = driver;
    }

    //Ожидаем загрузки страницы
    public void waitDownloadPage() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".jq-checkbox.checked .jq-checkbox__div")));
    }

    //чекбокс "В отделении банка"
    public void setInsideBank() {
        driver.findElement(insideBank).click();
    }

    //сумма вклада
    public void setAmount(String check) {
        driver.findElement(amount).sendKeys(check);
    }

    //Передвигаем ползунок "На срок"
    public void setTrim(int step) {
        WebElement element = driver.findElement(trim);
        element.click();
        for (int i = 0; i < step; i++)
            element.sendKeys(Keys.ARROW_LEFT);
    }

    //Выгружаем Печатную Форму "Общие условия по вкладам"
    public void downLoadDocument() {
        //download атрибут элемента
        String script = "document.querySelector('#section_2 > div > div.tabs.js-tabs > div.tabs-content > div:nth-child(1) > div.deposits-terms__info-doc-row > div > h3 > a').setAttribute('download','the-download-file.pdf');";
        ((JavascriptExecutor)driver).executeScript(script);
        driver.findElement(dwnlForm).click();
    }



}
