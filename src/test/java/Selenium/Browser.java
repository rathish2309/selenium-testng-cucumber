package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browser {

    WebDriver webDriver;

    public void openBrowser(String url) {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.navigate().to(url);
        System.out.println("Navigate to URL " + url);
    }

    public void closeBrowser() {
        webDriver.close();
        webDriver.quit();
    }

    public static void main(String[] args) {
        Browser browser = new Browser();
        try {
            browser.openBrowser("URL");
        } finally {
            browser.closeBrowser();
        }

    }
}
