package com.hexacta.drivers;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@AllArgsConstructor
public class Driver {

    public static WebDriver driver;
//,"--headless=new"
    public static Driver web(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--incognito");
        driver = new ChromeDriver(options);
        return new Driver();
    }

    public WebDriver inTheWebPage(String url) {
        driver.get(url);
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}