import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class Assignment8HandlingAutoSuggestionDropdown {
    @Test
    public void autoSuggestionDropdown(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        String country="uni";
        String countryToSelect="United States (USA)";
        WebElement inputEle=driver.findElement(By.cssSelector("input#autocomplete"));
        inputEle.sendKeys(country);
        List<WebElement> countriesDisplayed=driver.findElements(By.cssSelector("ul#ui-id-1 div"));
        for(WebElement countryName:countriesDisplayed){
            if(countryName.getText().equals(countryToSelect)){
                countryName.click();
                break;
            }
        }
        System.out.println(inputEle.getAttribute("value"));
        Assert.assertEquals(((JavascriptExecutor)driver).executeScript("return arguments[0].value;", inputEle),countryToSelect);

    }

    @Test
    public void rahulShetty() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");

        driver.findElement(By.id("autocomplete")).sendKeys("ind");
        Thread.sleep(2000);

        //navigating down towards the options 2 nd option India so two times Keys.DOWN
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
    }
}
