package IntermediateCode;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		Actions a = new Actions(driver);
		
		WebElement move = driver.findElement(By.xpath("//div[@id='nav-link-accountList']"));
		
		a.moveToElement(move).contextClick().build().perform();
		
		
		a.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		System.out.println("Test passed");
		
		//driver.close();

	}

}
