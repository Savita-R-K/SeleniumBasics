import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumBasics.Selectors;

import java.time.Duration;

public class Assignment6OptimizedTextUsage {
    @Test
    public void optimizedTextUsage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //checkbox
        WebElement checkboxOpt = driver.findElements(By.xpath("//legend[text()='Checkbox Example']/..//input")).get(0);
        checkboxOpt.click();
        //grab Text from the checked check box
        String text="";
        for(int i=0;i<driver.findElements(By.xpath("//legend[text()='Checkbox Example']/..//input")).size();i++){
            if(driver.findElements(By.xpath("//legend[text()='Checkbox Example']/..//input")).get(i).isSelected()){
                text=driver.findElements(By.xpath("//legend[text()='Checkbox Example']/..//label")).get(i).getText().trim();
            }
        }
        //dropdown
        WebElement selectEle=driver.findElement(By.id("dropdown-class-example"));
        Select dropdown=new Select(selectEle);
        dropdown.selectByVisibleText(text);
        //input name
        driver.findElement(By.cssSelector("input#name")).sendKeys(text);
        driver.findElement(By.cssSelector("input#alertbtn")).click();
        //check alert contains the text entered
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(text));

    }
}
