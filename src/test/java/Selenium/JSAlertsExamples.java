package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSAlertsExamples {

    //only with one button
    public void jsAlert(WebDriver webDriver) throws InterruptedException {
        webDriver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();
        Thread.sleep(2000);
        webDriver.switchTo().alert().accept();
    }

    //only with 2 button
    public void jsConfirm(WebDriver webDriver) throws InterruptedException {
        //Accept
        webDriver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
        Thread.sleep(2000);
        webDriver.switchTo().alert().accept();

        //Dismiss
        webDriver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
        Thread.sleep(2000);
        webDriver.switchTo().alert().dismiss();
    }

    //JS Prompt
    public void jsPrompt(WebDriver webDriver) throws InterruptedException {
        webDriver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();
        Thread.sleep(2000);
        Alert alert = webDriver.switchTo().alert();
        alert.sendKeys("JS PROMPT");
        Thread.sleep(2000);
        alert.accept();
    }

    //BasicAuthPopUp
    public void basicAuthPop(WebDriver webDriver) throws InterruptedException {
        Thread.sleep(5000);
        webDriver.get("https:admin:admin@the-internet.herokuapp.com/basic_auth");
    }


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        try {

            JSAlertsExamples alertsExamples = new JSAlertsExamples();
//            webDriver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
//            alertsExamples.jsAlert(webDriver);
//            alertsExamples.jsConfirm(webDriver);
//            alertsExamples.jsPrompt(webDriver);
            alertsExamples.basicAuthPop(webDriver);
        } finally {
            webDriver.quit();
        }

    }

}
