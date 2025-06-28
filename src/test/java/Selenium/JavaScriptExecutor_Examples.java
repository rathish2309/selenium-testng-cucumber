package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor_Examples {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver webDriver = new ChromeDriver();

        JavaScriptExecutor_Examples examples = new JavaScriptExecutor_Examples();

//        examples.getPageTitle(webDriver);
//
//        examples.clickElement(webDriver);

    }

    //Get Page title
    public void getPageTitle(WebDriver webDriver) throws RuntimeException, InterruptedException {
        webDriver.get("https://www.geeksforgeeks.org/node-js/how-to-handle-file-upload-in-node-with-multer-and-postman/");
        Thread.sleep(2000);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        String title = (String) javascriptExecutor.executeScript("return document.title");
        System.out.println(title);
    }

    public void clickElement(WebDriver webDriver){
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click",webDriver.findElement(By.xpath("//a[text()='How to handle file upload in Node.js ?']")));
    }

    public void scrollToBottom(WebDriver webDriver){
        webDriver.get("https://www.geeksforgeeks.org/node-js/how-to-handle-file-upload-in-node-with-multer-and-postman/");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
    }

}
