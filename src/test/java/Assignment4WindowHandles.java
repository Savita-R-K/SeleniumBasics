import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SuiteRunState;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Assignment4WindowHandles {
    @Test
    public void windowHandling(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> windows=driver.getWindowHandles();
        List<String> windowList=new ArrayList<>(windows);
        for (int i=windowList.size()-1;i>=0;i--){
            driver.switchTo().window(windowList.get(i));
            System.out.println(driver.findElement(By.tagName("h3")).getText());
        }
    }
}
