import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locators1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			WebDriver driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.automationexercise.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Signup / Login")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Ritik");
		driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("Ritik154@gmail.com");
		driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
		driver.findElement(By.id("id_gender1")).click();
		
		driver.findElement(By.cssSelector("input[data-qa='password'"));
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.cssSelector("input[data-qa='first_name']")).sendKeys("Ritik");
		driver.findElement(By.cssSelector("input[data-qa='last_name']")).sendKeys("devil");
		driver.findElement(By.cssSelector("input[data-qa='company']")).sendKeys("Tit");
		driver.findElement(By.cssSelector("input[data-qa='address']")).sendKeys("Apsr strree1");
		driver.findElement(By.cssSelector("input[data-qa='address2']")).sendKeys("Aprsr Street2");
		
		driver.close();
		
		
		
		

	}

}
