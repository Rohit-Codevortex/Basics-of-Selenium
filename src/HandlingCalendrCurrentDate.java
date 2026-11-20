import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HandlingCalendrCurrentDate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.xpath("//a[@value='AIP']")).click();
		
		
		
		Thread.sleep(1000);
		
		//parent - child relationship locator to identify the objects to uniquely
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD']")).click();
		
		
		
//<----------------- Handling Calendar part only for current date, becuase only current date have uniqye class or id otherwise it have multiple common class or id 
// We will further study about future dates
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
		
		Thread.sleep(1000);
		
		System.out.println("Success");
		
		driver.close();
		
		
		
		

	}

}
