package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshot_Examples {

    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();

        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://www.selenium.dev/");

        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File dst = new File("Screenshot.png");
        FileUtils.copyFile(src,dst);


    }
}
