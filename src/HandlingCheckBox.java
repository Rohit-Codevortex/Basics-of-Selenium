import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandlingCheckBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
           WebDriver driver = new ChromeDriver();
		
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		  driver.manage().window().maximize();
		
		  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		  
		 System.out.println( driver.findElement(By.cssSelector("input[id*= 'friendsandfamily']")).isSelected());		  
		 driver.findElement(By.cssSelector("input[id*= 'friendsandfamily']")).click();
		 System.out.println( driver.findElement(By.cssSelector("input[id*= 'friendsandfamily']")).isSelected());	
		 
		 
		  
		  System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		  

	}

}
