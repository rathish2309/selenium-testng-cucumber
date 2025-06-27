package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Dropdown {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //https://the-internet.herokuapp.com/dropdown
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //adding implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {

            //validate Dropdown - Select dropdown
            WebElement element = driver.findElement(By.xpath("//select[@id=\"dropdown\"]"));
            Select select = new Select(element);

            //Get all the options
            List<WebElement> getOptions = select.getOptions();
            ListIterator<WebElement> webElementListIterator = getOptions.listIterator();
            while (webElementListIterator.hasNext()){
                System.out.println(webElementListIterator.next().getText());
            }


            //Select Dropdown by ID
            element.click();
            select.selectByIndex(1);
            System.out.println("Option Selected By ID " + element.getText());

            //Select Dropdown by Value
            element.click();
            select.selectByValue("2");
            System.out.println("Option Selected By Value " + element.getText());

            //Select Dropdown by Visible Text
            element.click();
            select.selectByVisibleText("Option 1");
            System.out.println("Option Selected By Visible Text " + element.getText());

        } catch (Exception e) {
            throw new NoSuchElementException();
        } finally {
            driver.quit();
        }
    }
}
