package ru.renCredit.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.renCredit.WebDriverSettings;

public class HomePage extends WebDriverSettings {
    private By btn_Deposit = By.cssSelector("body > div.content > div.main-screen > div.main-screen__content > div > div.services.services_main > div:nth-child(3) > div.service__title > a:nth-child(1)");
    private By btn_Card = By.cssSelector("body > div.content > div.main-screen > div.main-screen__content > div > div.services.services_main > div:nth-child(1) > div.service__title > a:nth-child(1)");

    public HomePage(ChromeDriver driver) {
        this.driver = driver;
    }

    public ChromeDriver depositBtnClick() {
        driver.findElement(btn_Deposit).click();
        return driver;
    }

    public ChromeDriver cardBtnClick() {
        driver.findElement(btn_Card).click();
        return  driver;
    }
}
