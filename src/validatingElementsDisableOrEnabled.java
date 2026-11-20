import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class validatingElementsDisableOrEnabled {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
        WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.xpath("//a[@value='AIP']")).click();
		
		//parent - child relationship locator to identify the objects to uniquely
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD']")).click();
		
		
//----- Handling Calendar part only for current date, becuase only current date have uniqye class or id otherwise it have multiple common class or id 
		// We will further study about future dates
				
				driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
		
		
/* <!-- Handling ui elements are enabled or disabled?----------------------------------------------------->
		
		WebElement uiElement = driver.findElement(By.id("ctl00_mainContent_view_date2"));
		System.out.println(uiElement.isEnabled());
		
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		
		System.out.println(uiElement.isEnabled());
		
		*/
		
//----< Result1. Problem -->In modern web applications, an element may look disabled due to 
//CSS styling, while Selenium's isEnabled() returns true because the element is not actually disabled in HTML.
		
		
//----< solution --------->
		
System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));

if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5"))
{
	System.out.println("it enabled");
	Assert.assertTrue(true);
}
else {
	
	System.out.println("its disabled");
	Assert.assertTrue(false);
}
		
		
		driver.close();

	}

}

// this program give error ---> 
