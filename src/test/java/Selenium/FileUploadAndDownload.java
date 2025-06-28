package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.security.Key;
import java.time.Duration;

public class FileUploadAndDownload {


    public void fileUpload(WebDriver driver) throws InterruptedException {
        driver.get("https://practice-automation.com/file-upload/");
        Thread.sleep(2000);  // Optional wait

        WebElement fileInput = driver.findElement(By.id("file-upload"));

        // Set full absolute path
        fileInput.sendKeys("C:\\Users\\Raphael R Rathish\\Downloads\\selenium_recap_list.pdf");

        // Submit the form
        driver.findElement(By.id("upload-button")).click();  // Optional if needed
    }

    public void fileDownload(WebDriver webDriver) throws Exception {

        webDriver.get("https://the-internet.herokuapp.com/download");

        Thread.sleep(5000);

        webDriver.findElement(By.linkText("Happy Automation.jpg")).click();

        Thread.sleep(5000);

        //Identify whether the downloaded file is there in the local

        File file = new File("C:\\Users\\Raphael R Rathish\\Downloads");

        for (File listFile : file.listFiles()) {
            boolean contains = listFile.getName().contains("Happy Automation.jpg");
            if (contains) {
                System.out.println("File is downloaded");
                break;
            }
        }


    }


    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver webDriver = new ChromeDriver();

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--disable-notifcations");

        FileUploadAndDownload fileUploadAndDownload = new FileUploadAndDownload();

//        fileUploadAndDownload.fileDownload(webDriver);

        fileUploadAndDownload.fileUpload(webDriver);

        webDriver.close();

    }

}
