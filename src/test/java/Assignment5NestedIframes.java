import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment5NestedIframes {
    @Test
    public void Iframe() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.switchTo().frame(0);
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.id("content")).getText());
        driver.switchTo().defaultContent();
    }

    @Test
    public void nestedIframes(){
        WebDriver driver=new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Nested Frames")).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());
    }
}
