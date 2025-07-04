package rahulShettyAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class OpeningLinksInDifferentTabsAndGetTitle {
    @Test()
    public void footerDriver() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        System.out.println(driver.findElements(By.tagName("a")).size());

        //links present in the footer
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));// Limiting webdriver scope
        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        //3-links present in the particular column of footer driver
        WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columndriver.findElements(By.tagName("a")).size());

        //4- click on each link in the column and check if the pages are opening-
        for (int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000L);
        }// opens all the tabs

        //get title of all tabs
        Set<String> abc = driver.getWindowHandles();//4
        Iterator<String> it = abc.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }

    }
}
