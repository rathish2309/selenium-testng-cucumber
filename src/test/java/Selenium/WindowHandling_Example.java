package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandling_Example {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();

        //Single Window
        try {
            WindowHandling_Example example = new WindowHandling_Example();
            webDriver.get("https://the-internet.herokuapp.com/windows");
            example.singleWindowHandling(webDriver);
            example.multipleWindowHandling(webDriver);
        } finally {
            webDriver.close();
            webDriver.quit();
        }

    }

    public void singleWindowHandling(WebDriver webDriver) throws InterruptedException {
        //getID of Single Window
        Thread.sleep(5000);
        String windowID = webDriver.getWindowHandle();
        System.out.println(webDriver.getTitle());
    }

    public void multipleWindowHandling(WebDriver webDriver) throws InterruptedException {
        //get ID of multiple Window
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("//a[contains(normalize-space(text()), 'Click')]")).click();
        Thread.sleep(5000);
        Set<String> multipleWindowID = webDriver.getWindowHandles();
        multipleWindowID.stream().forEach(n -> System.out.println(webDriver.switchTo().window(n).getTitle()));
    }
}
