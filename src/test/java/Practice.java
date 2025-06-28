import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64)...");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

//        //navigate to the page
//        driver.get("https://www.saucedemo.com/");
//
//
//        //find element by ID
//        String placeholder = driver.findElement(By.id("user-name")).getAttribute("placeholder");
//        System.out.println("Placeholder "+placeholder);
//
//        //find element by name
//        System.out.println("By Name "+driver.findElement(By.name("user-name")).toString());
//
//        //find element by className
//        System.out.println("By Class Name"+driver.findElement(By.className("login_password")).getText());
//
//        //find element by partiallink text
//        driver.navigate().to("https://the-internet.herokuapp.com/?ref=hackernoon.com");
//        System.out.println("Partial Text "+driver.findElement(By.partialLinkText("A/B")).getText());
//
//        //find element by Link
//        System.out.println("Link "+driver.findElement(By.linkText("A/B Testing")).getText().toUpperCase());
//
//        //find element by xpath
//        List<WebElement> webElements = driver.findElements(By.xpath("//ul//li"));
//        List<String> convertedList = webElements.stream()
//                .map(webElement -> webElement.getText().toUpperCase())
//                .toList();
//        convertedList.forEach(System.out::println);
//
//        driver.get("https://www.google.com/");
//        driver.findElement(By.xpath("//*[@aria-label=\"Search\"]")).click();
//        driver.findElement(By.xpath("//*[@aria-label=\"Search\"]")).sendKeys("Gartner");
//        List<WebElement> suggestedList = driver.findElements(By.xpath("(//div[@role=\"presentation\"]//ul[@role=\"listbox\"])[1]//li"));
//        suggestedList.parallelStream().toList().forEach(n-> System.out.println(n.getText()));

        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select select = new Select(driver.findElement(By.id("dropdown")));
        for (WebElement option : select.getOptions()) {
            System.out.println(option.getText());
        }

        driver.navigate().to("https://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("1.jpeg")).click();
        driver.close();
        driver.quit();

    }
}
