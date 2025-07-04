package seleniumBasics;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightSearch {

	static WebDriver driver= new ChromeDriver();
    @Test
	public static void main(String args[]) throws InterruptedException {
        Scanner scan =new Scanner(System.in);
		//spicejet.com
		
		driver.navigate().to("http://www.spicejet.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//TRIP info
		
		//*From -> to

		System.out.print("Enter from city : ");
		String fromCity=scan.next();
		System.out.println("\nEnter to city : ");
		String toCity=scan.next();
		while(fromCity.equals(toCity)) {
			System.out.println("Please Enter two different Cities");
			System.out.println("Enter from city : ");
			fromCity=scan.next();
			System.out.println("Enter to city : ");
			toCity=scan.next();
		}
		//SELECT FROM
		driver.findElement(By.xpath("//div[text()='From']/following-sibling::div/input")).sendKeys(fromCity);
		//SELECT TO
		driver.findElement(By.xpath("//div[text()='To']/following-sibling::div/input")).sendKeys(toCity);		
		
		//*trip type and dates
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		//can book flights within date of one year
        LocalDate today = LocalDate.now();
        LocalDate oneYearLater = today.plusYears(1);

        String tripType = "";

        while (true) {
            System.out.print("Enter trip type (r for Round Trip, o for One Way): ");
            tripType = scan.next().toLowerCase();

            if ("r".equals(tripType)) {
                driver.findElement(By.xpath("//div[text()='round trip']")).click();

                LocalDate departureDate = readValidDate(scan, formatter, today, oneYearLater, "Enter Departure Date (yyyy-MM-dd): ");
                LocalDate returnDate;
                while (true) {
                    returnDate = readValidDate(scan, formatter, today, oneYearLater,"Enter Return Date (yyyy-MM-dd): ");
                    if (returnDate.isBefore(departureDate)) {
                        System.out.println("Return date must be after or same as Departure date. Please re-enter.");
                    } else {
                        break;
                    }
                }
                
                driver.findElement(By.xpath("//div[text()='Departure Date']/..")).click();
                WebElement departureDateClick = driver.findElement(By.xpath("//div[contains(@data-testid,'undefined-month')]//div[contains(text(),'"+getMonth(departureDate)+"')] [text()='"+getYear(departureDate)+"']/../following-sibling::div[2]//div[text()='"+getDate(departureDate)+"']/.."));
                waitForVisiblityOfEle(departureDateClick);
                jsClick(departureDateClick);
                driver.findElement(By.xpath("//div[text()='Return Date']/..")).click();
                WebElement returnDateClick=driver.findElement(By.xpath("//div[contains(text(),'"+getMonth(returnDate)+"')] [text()='"+getYear(returnDate)+"']/../following-sibling::div[2]//div[text()='"+getDate(returnDate)+"']/.."));
                waitForVisiblityOfEle(returnDateClick);
                jsClick(returnDateClick);
                System.out.println("Round Trip dates set successfully.");
                break;

            } else if ("o".equals(tripType)) {
                driver.findElement(By.xpath("//div[text()='one way']")).click();

                LocalDate departureDate = readValidDate(scan, formatter, today, oneYearLater, "Enter Departure Date (yyyy-MM-dd): ");
                               
                driver.findElement(By.xpath("//div[text()='Departure Date']/..")).click();
                WebElement departureDateClick=driver.findElement(By.xpath("//div[contains(text(),'"+getMonth(departureDate)+"')] [text()='"+getYear(departureDate)+"']/../following-sibling::div[2]//div[text()='"+getDate(departureDate)+"']/.."));
                waitForVisiblityOfEle(departureDateClick);
                jsClick(departureDateClick);
                
                System.out.println("One Way departure date set successfully.");
                break;

            } else {
                System.out.println("Invalid input. Please enter 'r' or 'o'.");
            }
        }
        
        //*No.of adults, childreN
        
        
        //search flights
        driver.findElement(By.xpath("//div[text()='Search Flight']/..")).click();
        scan.close();
    }

	private static LocalDate readValidDate(Scanner scan, DateTimeFormatter formatter, LocalDate start, LocalDate end, String prompt) {
        LocalDate date = null;
        while (date == null) {
            System.out.print(prompt);
            String input = scan.next();
            try {
                date = LocalDate.parse(input, formatter);
                if (date.isBefore(start)) {
                    System.out.println("Date cannot be before today.");
                    date = null;
                } else if (date.isAfter(end)) {
                    System.out.println("Date cannot be more than one year from today.");
                    date = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            }
        }
        return date;
    }
	
	public static int getDate(LocalDate date) {
		System.out.println(date.getDayOfMonth());
		return date.getDayOfMonth();
	}
	public static int getYear(LocalDate date) {
		return date.getYear();
	}
	public static String getMonth(LocalDate date) {
		return date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		
	}
	
	public static void jsClick(WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", ele);
	}
	
	public static void waitForElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void waitForVisiblityOfEle(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
}
