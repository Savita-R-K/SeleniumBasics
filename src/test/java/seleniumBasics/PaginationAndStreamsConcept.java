package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PaginationAndStreamsConcept {
    @Test
    public void verifyWhetherTheProductsInTableAreSorted() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        //sorts
        driver.findElement(By.xpath("//th[1]")).click();

        List<WebElement> productEle;
        List<String> productList = new ArrayList<>();
        WebElement nextBtn = driver.findElement(By.xpath("//a[@aria-label='Next']/.."));
        while (true) {
            productEle = driver.findElements(By.xpath("//tr/td[1]"));
            productList=productEle.stream().map(ele->ele.getText()).toList();
            if (!nextBtn.getAttribute("class").equals("disabled")) {
                driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
                nextBtn=driver.findElement(By.xpath("//a[@aria-label='Next']/.."));
            } else {
                break;
            }
        }
        List<String> newSortedProductList=productList.stream().sorted().toList();
        Assert.assertEquals(productList,newSortedProductList);
    }

    @Test
    public void getThePriceOfParticularProductAmongPages() {
        String productName="Wheat";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        //sorts
        driver.findElement(By.xpath("//th[1]")).click();

        List<WebElement> productEle;
        WebElement nextBtn = driver.findElement(By.xpath("//a[@aria-label='Next']/.."));
        while (true) {
            productEle = driver.findElements(By.xpath("//tr/td[1]"));
            for (WebElement ele : productEle) {
                if(productName.equals(ele.getText())){
                    System.out.println("Price of "+productName+" is "+ele.findElement(By.xpath("following-sibling::td[1]")).getText());
                    break;
                }
            }
            if (!nextBtn.getAttribute("class").equals("disabled")) {
                driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
                nextBtn=driver.findElement(By.xpath("//a[@aria-label='Next']/.."));
            } else {
                break;
            }
        }
    }

    @Test
    public void validateSearchFunctionality(){
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/greenkart/#/offers");

        driver.findElement(By.id("search-field")).sendKeys("Rice");

        List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));

        //1 results

        List<WebElement> filteredList= veggies.stream()
                .filter(veggie->veggie.getText().contains("Rice"))
                .toList();

        //1 result

        Assert.assertEquals(veggies.size(), filteredList.size());
    }
}