package seleniumBasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	
	public static void main(String args[]) {
		//System.setProperty("webdriver.chrome.driver", "C:/Users/280679/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//open browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		//this wait helps only 
				//if- the url is changed by an action or 
				//something is loading
				//if same locator is already present in the present page and you are waiting for the next page locator, you may get wrong output
				//example if we are selecting a locator with tagname <p> and access text after clicking login button but we have the tag p in current page also, Then your assertions will fail
				//wait for something to show
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//login
		driver.findElement(By.name("username")).sendKeys("Admin");
		//regex for matching text
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("admin123");
		//driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
		
		//print username
		System.out.println("User logged in as "+driver.findElement(By.className("oxd-userdropdown-name")).getText());
		
		//print menu elements
		//parent to child traversal using css selector
		List<WebElement> menu=driver.findElements(By.cssSelector("ul[class='oxd-main-menu'] li span"));
		//List<WebElement> menu=driver.findElements(By.xpath("//ul[@class='oxd-main-menu']/li//span"));
		for(WebElement ele:menu) {
			System.out.print(ele.getText()+", ");
		}
		
		//logout
		driver.findElement(By.cssSelector("i.oxd-userdropdown-icon")).click();
		driver.findElement(By.linkText("Logout")).click();
		
		//verify user is on login page
		System.out.println("\nPage heading - "+driver.findElement(By.tagName("h5")).getText());
		
		driver.close();	
		
		String str = "tdhwjskaxn'sakjhfd'aKHFE";
		String[] arr = str.split("'");
		for(String i:arr) {
			System.out.println(i);
		}
	}
}
