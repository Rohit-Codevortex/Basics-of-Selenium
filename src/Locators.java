import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//reason why should we  use driver.mange()
		WebDriver  driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  // it's applicable gloabally
		
		
		driver.get("https://www.automationexercise.com/login");
		driver.findElement(By.name("email")).sendKeys("Student@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.className("btn")).click();
		driver.findElement(By.cssSelector("p[style='color: red;']"));
		driver.findElement(By.linkText("Home")).click();
		
		
		driver.close();
		
		
		

	}

}
