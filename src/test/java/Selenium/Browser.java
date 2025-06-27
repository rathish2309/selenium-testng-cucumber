package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browser {
    public static void main(String[] args) {

        System.getProperty("path of the browser jar");

        WebDriverManager.chromedriver().setup();
        WebDriver driver;

        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

        driver = new ChromeDriver();
        driver.navigate().to(url);
        System.out.println(driver.getTitle());
        driver.quit();

//        driver = new FirefoxDriver();
//        driver.navigate().to(url);
//        driver.quit();
//
//        driver = new EdgeDriver();
//        driver.navigate().to(url);
//        driver.quit();
//
//        driver = new SafariDriver();
//        driver.navigate().to(url);
//        driver.quit();

    }
}
