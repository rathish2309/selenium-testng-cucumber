import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class InputExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        InputExample example = new InputExample();
        try {
//            example.usingSendKeys(webDriver);
//            example.usingKeyActions(webDriver);
            example.usingKeyBoardActions(webDriver);
        } finally {
            webDriver.close();
            webDriver.close();
        }

    }

    public void usingSendKeys(WebDriver webDriver) throws InterruptedException {
        webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
        webDriver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
        webDriver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        Thread.sleep(4000);
        System.out.println(webDriver.getTitle());
    }

    public void usingKeyActions(WebDriver webDriver) throws InterruptedException {
        webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Actions actions = new Actions(webDriver);
        //username
        actions.moveToElement(webDriver.findElement(By.xpath("//input[@name=\"username\"]"))).click().perform();
        actions.sendKeys("Admin");

        //password
        actions.moveToElement(webDriver.findElement(By.xpath("//input[@name=\"password\"]"))).click().perform();
        actions.sendKeys("Admin");

        //submit
        actions.moveToElement(webDriver.findElement(By.xpath("//button[@type=\"submit\"]"))).click().perform();

        Thread.sleep(3000);

        System.out.println(webDriver.getTitle());
    }

    public void usingKeyBoardActions(WebDriver webDriver) throws InterruptedException {
        webDriver.get("https://www.diffchecker.com/");

        webDriver.wait(5000);

        Actions actions = new Actions(webDriver);

        WebElement input1 = webDriver.findElement(By.xpath("(//div[@role=\"textbox\"])[1]/div"));

        actions.moveToElement(input1).click();

        actions.keyUp(Keys.SHIFT)
                .sendKeys("ADMIN")
                .keyUp(Keys.SHIFT)
                .build()
                .perform();

        System.out.println(input1);

    }
}
