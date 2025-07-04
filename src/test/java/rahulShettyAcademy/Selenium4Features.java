package rahulShettyAcademy;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Selenium4Features {
    @Test
    public void RelativeLocatorsAboveBelowToLeftOfToRightOf() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

        WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        //flex elements are not supported so it search and click other below elements
        driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();

        WebElement iceCreamLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();

        WebElement rdb = driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
    }

    @Test
    public void multipleWindowsTabs() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //TAB1
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        //new tab switching
        driver.switchTo().newWindow(WindowType.TAB);
        //TAB2
        driver.get("https://rahulshettyacademy.com/");

        //gives current window title as default content
        driver.switchTo().defaultContent();
        System.out.println("default content among two tabs" + driver.getTitle());
        Thread.sleep(3000);

        //new window switching
        driver.switchTo().newWindow(WindowType.WINDOW);
        //Window 2 - TAB 1
        driver.get("https://google.com");
        driver.findElement(By.id("APjFqb")).sendKeys("expedia");


        //handles is a set ->where we cannot access handles based on index
        //list->to access using index
        Set<String> handles = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(handles);
        driver.switchTo().window(windowList.get(0));
        driver.switchTo().window(windowList.get(1));
        driver.switchTo().window(windowList.get(2));

        //has three handles
        Iterator<String> it = handles.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            Thread.sleep(5000);
            System.out.println("Titles of webpages opened " + driver.getTitle());
        }

        //gives current window title as default content//google
        driver.switchTo().defaultContent();
        System.out.println("default content among three windows " + driver.getTitle());
    }

    @Test
    public void elementScreenshot() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("Expedia");
        File screenshot=searchBox.getScreenshotAs(OutputType.FILE);
        //Common io -> import jar for File Util
        FileUtils.copyFile(screenshot,new File("C:\\Users\\280679\\SeleniumAutomation\\screenshots\\eleScreenshot.png"));
    }

    @Test
    public void getHeightWidthOfElement(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("Expedia");
        System.out.println(searchBox.getRect().getDimension().getHeight());
        System.out.println(searchBox.getRect().getDimension().getWidth());
    }
}