package seleniumBasics;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    @Test
    public void takeScreenshot() throws IOException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://google.com");
        File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //copy the file to the local machine
        FileUtils.copyFile(screenShot,new File("C:\\Users\\280679\\SeleniumAutomation\\screenshots\\screenshot.png"));
    }
}
