package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FindBrokenLinksInThePage {
    @Test()
    public void linksInFooter() throws IOException {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        driver.manage().window().maximize();
        //links present in the footer
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//div[@id='gf-BIG']//li/a"));
        for (WebElement linkEle : listOfLinks) {
            String url = linkEle.getAttribute("href");
            System.out.println(url);
            try {
                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestMethod("HEAD");
                conn.connect();
                softAssert.assertTrue(conn.getResponseCode() < 400, "The link with text " + linkEle.getText() + " is broken with response code " + conn.getResponseCode());
                System.out.println(conn.getResponseCode());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //report all the failures at the end
        softAssert.assertAll();

    }

}
