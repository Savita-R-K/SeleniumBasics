package seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class InvokingDiffDrivers {

	public static void main(String[] args) {
		
		//invoking different drivers //close and quit difference
		
		
		
		//Chrome Driver
		
		//download chrome driver - version should be same as the chrome installed on pc
		// https://googlechromelabs.github.io/chrome-for-testing/
		
		//1st way to invoke chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "C:/Users/280679/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		//2nd way is just skip the above line selenium manager will download and place the chrome driver in path
		WebDriver driver1=new ChromeDriver();
		driver1.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(driver1.getTitle());
		System.out.println(driver1.getCurrentUrl());
		//closes only original window
		driver1.close();
		
		
		
		//Firefox driver->geckodriver
		//real firefox driver or browser must be present
		
		//download gecko driver
		// https://github.com/mozilla/geckodriver/releases
		
		System.setProperty("webdriver.gecko.driver", "C:/Users/280679/Downloads/geckodriver-v0.36.0-win-aarch64/geckodriver.exe");
		WebDriver driver2=new FirefoxDriver();
		driver2.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(driver2.getTitle());
		System.out.println(driver2.getCurrentUrl());
		driver2.close();
		
		
		
		//Edge driver->edge
		//real edge driver or browser must be present
		
		//download edge driver
		// https://developer.microsoft.com/en-in/microsoft-edge/tools/webdriver?form=MA13LH
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\280679\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver3=new EdgeDriver();
		driver3.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(driver3.getTitle());
		System.out.println(driver3.getCurrentUrl());
		driver3.close();
		
		
		
		
		//quit method closes all the windows opened during automation
		//driver.quit();
		
		
		
	}

}
