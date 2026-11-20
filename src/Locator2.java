import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.InterruptedException;

public class Locator2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
         WebDriver driver = new ChromeDriver();
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 
		 driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		 // Username
	        driver.findElement(By.id("username"))
	              .sendKeys("rahulshettyacademy");

	        // Password
	        driver.findElement(By.id("password"))
	              .sendKeys("Learning@830$3mK2");		 
	        
	     // Select the Admin radio button
	        driver.findElement(By.cssSelector("input[value='admin']")).click();
		 
		
		 
	
		 
		 //driver.findElement(By.linkText("Log in")).click();
		
		 ;
	}

}

