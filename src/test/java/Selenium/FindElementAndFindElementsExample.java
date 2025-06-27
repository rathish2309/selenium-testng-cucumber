package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class FindElementAndFindElementsExample {

    public static void main(String[] args) throws IOException {

        //WebDriver Setup
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        //navigate to url
        webDriver.navigate().to("https://www.saucedemo.com");

        //Reading userName and Password from property file
        File file = new File("src/test/java/Credentials.Properties");
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        //Get Locator of input fields - Find Element
        WebElement userName = webDriver.findElement(By.xpath("//input[@id=\"user-name\"]"));
        WebElement passWord = webDriver.findElement(By.xpath("//input[@id=\"password\"]"));
        userName.sendKeys(username);
        passWord.sendKeys(password);

        //click on login button
        webDriver.findElement(By.cssSelector(".submit-button.btn_action")).click();

        if (webDriver.getTitle().contains("Swag Labs")) {
            System.out.println("Login is SuccessFull");

            webDriver.findElement(By.xpath("//button[@id=\"react-burger-menu-btn\"]")).click();

            //Get List of all the options in Hamburger - FindElements
            List<WebElement> elementList = webDriver.findElements(By.cssSelector("nav.bm-item-list > a"));

            //iterate over all the elements and print their name
            System.out.println("Hamburger Menu Options ");
            elementList.parallelStream().forEach(n -> System.out.println(n.getText()));

        } else {
            System.out.println("Login Failed");

        }

        webDriver.quit();

    }

}
