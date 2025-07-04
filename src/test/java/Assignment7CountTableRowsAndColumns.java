import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Assignment7CountTableRowsAndColumns {
    @Test
    public void noOfRowsColumns(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

        //print no. of rows with heading
        int rows=driver.findElements(By.xpath("//legend[text()='Web Table Example']/../table//tr")).size();
        System.out.println("No. of rows : "+rows);

        //print no. of columns
//        int tableData = driver.findElements(By.xpath("//legend[text()='Web Table Example']/../table//td")).size();
//        int tableRowsExcludingHeading=driver.findElements(By.xpath("//legend[text()='Web Table Example']/../table//td/..")).size();
//        int columns= tableData/tableRowsExcludingHeading;
//        System.out.println("No. of coloumns : "+columns);

        //or
        int columns=driver.findElements(By.xpath("//legend[text()='Web Table Example']/../table//th")).size();
        System.out.println("No. of columns : "+columns);

        //print data based on row no
        int rowNum=2;
        List<WebElement> table=driver.findElements(By.xpath("(//legend[text()='Web Table Example']/../table//td/..)["+rowNum+"]/td"));
        System.out.println("Table data of row no."+rowNum);
        for(WebElement i:table){
            System.out.println(i.getText());
        }

    }

}
