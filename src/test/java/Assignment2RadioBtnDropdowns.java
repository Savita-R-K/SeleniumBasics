import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment2RadioBtnDropdowns {
    @Test
    public void formFilling() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //name
        driver.findElement(By.xpath("//label[text()='Name']/../input")).sendKeys("John");
        //email
        driver.findElement(By.xpath("//label[text()='Email']/../input")).sendKeys("John@gmail.com");
        //password
        driver.findElement(By.xpath("//label[text()='Password']/../input")).sendKeys("John@123");
       //checkbox
        WebElement checkbox=driver.findElement(By.xpath("//label[contains(text(),'Check me out')]/../input"));
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected());
        //gender
        WebElement gender= driver.findElement(By.xpath("//label[text()='Gender']/../select"));
        Select genderDropdown=new Select(gender);
        genderDropdown.selectByVisibleText("Male");
        //radio btn
        WebElement employedRadioBtn=driver.findElement(By.xpath("//label[text()='Employed']/../input"));
        employedRadioBtn.click();
        Assert.assertTrue(employedRadioBtn.isEnabled());
        //dob
        driver.findElement(By.xpath("//label[text()='Date of Birth']/../input")).sendKeys("23-07-2025");
        //submit
        driver.findElement(By.cssSelector("input[value='Submit']")).click();
        //success msg
        WebElement successMsg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/strong"));
        Assert.assertEquals(successMsg.getText(),"Success!");
        driver.close();
    }

}
