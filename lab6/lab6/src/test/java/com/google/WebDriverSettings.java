package com.google;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {

    public WebDriver driver;

    @Before
    public void setUp() {

        // @param имя_драйвера, путь_до_драйвера
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver_78_0_3904_70.exe");
        driver = new ChromeDriver(); // если не указать тип драйвера и путь до него в строке выше, то не скомпилируется

        System.out.println("Start");
    }

    @After
    public void close() {
        System.out.println("Test close");
        driver.quit(); // закрыть браузер после тестов
    }

}
