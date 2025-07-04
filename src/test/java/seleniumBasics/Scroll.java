package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Scroll {
    @Test
    public void scrollBrowser(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    @Test
    public void scrollElementInBrowser(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        //scrolltop=0 to scroll down
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=0");

    }

    @Test
    public void sumUpTheTableElements(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        int sum=0;
        for (WebElement element : driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"))) {
            sum+=Integer.parseInt(element.getText());
        }
        int totalSum=Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
        Assert.assertEquals(totalSum,sum);

    }


}
