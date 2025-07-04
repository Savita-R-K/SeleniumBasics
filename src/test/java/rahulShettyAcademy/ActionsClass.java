package rahulShettyAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsClass {
    @Test
    public void ActionsExample() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Actions a =new Actions(driver);
        a.moveToElement(driver.findElement(By.cssSelector("input#twotabsearchtextbox")));
        WebElement searchBox=driver.findElement(By.cssSelector("div.nav-search-field input"));
       //enter text and double click on text
        a.moveToElement(searchBox).click().sendKeys("Hello").doubleClick().perform();

    }

}
