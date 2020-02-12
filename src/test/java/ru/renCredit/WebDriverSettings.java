package ru.renCredit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WebDriverSettings {

    public ChromeDriver driver;

    @BeforeTest
    public void setUp() {
        //Указываем путь к драйверу
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void close() {
        //Тест завершен закрываем браузер
        driver.quit();
    }

}
