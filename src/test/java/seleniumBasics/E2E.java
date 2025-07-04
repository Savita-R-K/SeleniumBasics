package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;

public class E2E {
    @Test
    public void searchFlight(){
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://www.spicejet.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //SELECT ROUND TRIP
        driver.findElement(By.xpath("//div[text()='round trip']")).click();
        //SELECT FROM
        driver.findElement(By.xpath("//div[text()='From']/following-sibling::div/input")).sendKeys("BLR");
        //SELECT TO
        driver.findElement(By.xpath("//div[text()='To']/following-sibling::div/input")).sendKeys("HYD");
        //DEPARTURE DATE
        //driver.findElement(By.xpath("//div[text()='Departure Date']/..")).click();
        driver.findElement(By.xpath("//div[contains(text(),'July')] [text()='2025']/../following-sibling::div[2]//div[text()='9']")).click();
        //RETURN DATE
        //driver.findElement(By.xpath("//div[text()='Return Date']/..")).click();
        driver.findElement(By.xpath("//div[contains(text(),'July')] [text()='2025']/../following-sibling::div[2]//div[text()='10']")).click();
        //dropdown
        driver.findElement(By.xpath("//div[text()='Currency']")).click();
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n']//div[text()='INR']")).click();

        //SEARCH FLIGHTS
        driver.findElement(By.xpath("//div[text()='Search Flight']/..")).click();

    }
}
