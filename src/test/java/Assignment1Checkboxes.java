import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment1Checkboxes {
    @Test
    public void checkboxes(){
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //click on checkbox
        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertEquals(driver.findElement(By.id("checkBoxOption1")).isSelected(),true);
        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertEquals(driver.findElement(By.id("checkBoxOption1")).isSelected(),false);

    }

    @Test
    public void numberOfCheckboxesInThePage(){
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //no. of checkboxes
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
    }

}
