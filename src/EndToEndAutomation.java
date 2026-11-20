import java.time.Duration;
import java.util.List;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EndToEndAutomation {

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
	
		
//---------------------------------> second part(handle calendar part) ------------------------------------------------------------------------------>

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
		
		Thread.sleep(1000);
		
		System.out.println("Success");
		
		
		
		
//------------------------------------> 3rrd part Handling (Static DropDown)---------------------------------->		
	
        WebElement staticDropDown  = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropDown = new Select(staticDropDown);
		
		dropDown.selectByVisibleText("INR");
		System.out.println(dropDown.getFirstSelectedOption().getText());
		
		dropDown.selectByValue("AED");
		System.out.println(dropDown.getFirstSelectedOption().getText());
		
		
//-------------------------------------------> 4th part Handling(updated DropDown) from looping--------------------------->
		

		driver.findElement(By.id("divpaxinfo")).click();
		
		int i=1;
		
		
		while(i<5) {
			
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
//----------------------------------------------> 5th part Handling checkBox ----------------------------------------->
		
		driver.findElement(By.cssSelector("input[id*= 'friendsandfamily']")).click();
		
		System.out.println("Testing is completed");
		
		driver.close();

	}

}
