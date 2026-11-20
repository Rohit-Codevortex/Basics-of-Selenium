import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.xpath("//div[@id='start']/button[text()='Start']")).click();
		
//---------------------------- Implement Fluent Wait from here ----------------------------------------------------->
		
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		
/*--------------------------> This checks whether the element exists in the DOM and returns ----------------------------->
 -----------------------------its WebElement reference.It does not check visibility.----------------------------------->		*/
		
		WebElement foo  = wait.until(new Function<WebDriver,WebElement>()
				{
			        public WebElement apply(WebDriver driver)
			        {
			        	return driver.findElement(By.xpath("//div[@id='finish']/h4"));
			        }
			
				});
//-------------------------------------->Why can isDisplayed() return false? ---------------------------------->
		
		System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed());
				driver.close();

			
/* ------------------> If the element is still hidden when isDisplayed() executes, the output can be false.

-------------------Also, your wait configuration is:----------------------------------------------->
-------------------- Timeout: 5 seconds-------------------------------------------------------------------->
------------------------- Polling interval: 3 seconds--------------------------------------------------------->
-------------------------------That means the condition is checked at intervals of approximately 3 seconds, not continuously.
------------------------------2. Corrected code using FluentWait--------------------------------------------->
---------------------------------The best fix is to wait for visibility, not just element existence.	*/	
				
				// Solution gives FluentWaitConceipt1.java file
				
	}

}
