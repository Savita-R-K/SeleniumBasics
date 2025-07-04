import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Assignment3LoginAddToCartAndWaits {
    WebDriver driver=new ChromeDriver();
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));;
    @Test
    public void login(){
        driver.navigate().to("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //username
        driver.findElement(By.cssSelector("input#username")).sendKeys("rahulshettyacademy");
        //password
        driver.findElement(By.cssSelector("input#password")).sendKeys("learning");
        //user type
        driver.findElement(By.cssSelector("input[value='user']")).click();
        //click okay
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
        driver.findElement(By.xpath("//button[@id='okayBtn']")).click();

        //dropdown
        WebElement dropdown=driver.findElement(By.cssSelector("select[class='form-control']"));
        //wait.until(ExpectedConditions.visibilityOf(dropdown));
        Select selectDropdown= new Select(dropdown);
        selectDropdown.selectByVisibleText("Consultant");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.cssSelector("input#signInBtn")).click();

        //product list
        List<WebElement> productList=driver.findElements(By.xpath("//app-card-list/app-card//button"));
        for(WebElement ele:productList){
            ele.click();
        }
        //verify whether the products are added to cart
        String noOfProducts= String.valueOf(productList.size());
        String checkoutBtnText=driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).getText();
        Assert.assertTrue(checkoutBtnText.contains(noOfProducts));
    }
}
