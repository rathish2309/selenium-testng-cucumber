package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.http.WebSocketHandshakeException;

public class IFrames {

    public void iFrame(WebDriver webDriver) {
        webDriver.get("https://the-internet.herokuapp.com/iframe");
        webDriver.switchTo().frame("mce_0_ifr");
        WebElement element = webDriver.findElement(By.xpath("//p"));
        System.out.println(element.getText());
    }

    public void nestedFrames(WebDriver webDriver) throws Exception {

        webDriver.get("https://the-internet.herokuapp.com/nested_frames");

        Thread.sleep(5000);

        //switch to the top frame
        webDriver.switchTo().frame("frame-top");
        System.out.println("Switched to Top Frame");

        //switch to left frame
        webDriver.switchTo().frame("frame-left");
        String LeftFrame = webDriver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
        System.out.println("Left Frame : " + LeftFrame);

        webDriver.switchTo().parentFrame();

        webDriver.switchTo().frame("frame-middle");
        String MiddleFrame = webDriver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]")).getText();
        System.out.println("Left Frame : " + MiddleFrame);

    }

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().fullscreen();

        try {

            IFrames iFrames = new IFrames();
            iFrames.iFrame(webDriver);

            iFrames.nestedFrames(webDriver);
        } finally {
            webDriver.close();
        }

    }
}
