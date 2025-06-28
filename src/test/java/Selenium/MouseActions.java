package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.net.http.WebSocketHandshakeException;
import java.time.Duration;

public class MouseActions {


    public void rightClick(WebDriver webDriver, Actions actions) throws InterruptedException {
        webDriver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        Thread.sleep(5000);
        WebElement element = webDriver.findElement(By.xpath("//span[text()='right click me']"));
        actions.contextClick(element).build().perform();
        System.out.println(webDriver.findElement(By.xpath("//li/span[contains(normalize-space(text()), 'Delete')]")).getText());

    }


    public void doubleClick(WebDriver webDriver, Actions actions) throws InterruptedException {
        webDriver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        Thread.sleep(5000);
        WebElement element = webDriver.findElement(By.xpath("//span[text()='right click me']"));
        actions.doubleClick(element).build().perform();
    }

    public void dragAndDrop(WebDriver webDriver, Actions actions) throws InterruptedException {
        webDriver.get("https://the-internet.herokuapp.com/drag_and_drop");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(5000);
        WebElement src = webDriver.findElement(By.cssSelector("#column-a"));
        WebElement trg = webDriver.findElement(By.cssSelector("#column-b"));
        actions.dragAndDrop(src, trg).build().perform();
        Thread.sleep(5000);
    }

    public void mouseHover(WebDriver webDriver, Actions actions) throws InterruptedException {
        webDriver.get("https://the-internet.herokuapp.com/hovers");
        Thread.sleep(5000);
        WebElement element = webDriver.findElement(By.xpath("(//div[@class=\"figure\"])[2]"));
        Thread.sleep(5000);
        actions.moveToElement(element).build().perform();
        WebElement viewProfile = webDriver.findElement(By.xpath("(//a[@href=\"/users/2\"])"));
        Thread.sleep(5000);
        actions.moveToElement(viewProfile).click().build().perform();
        Thread.sleep(5000);
    }


    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().fullscreen();
        Actions actions = new Actions(webDriver);
        MouseActions mouseActions = new MouseActions();

        //right click
//        mouseActions.rightClick(webDriver, actions);


        //drag and drop
//        mouseActions.dragAndDrop(webDriver, actions);

        //mouse hover
        mouseActions.mouseHover(webDriver,actions);

        webDriver.quit();
    }

}
