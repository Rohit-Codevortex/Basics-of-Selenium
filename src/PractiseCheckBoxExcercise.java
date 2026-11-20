import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PractiseCheckBoxExcercise {

	public static void main(String[] args) throws InterruptedException {
		
		
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		
		
		driver.findElement(By.id("checkBoxOption1")).click();
		
		WebElement checkbox = driver.findElement(By.id("checkBoxOption1"));
		
		if(checkbox.isSelected())
		{
			checkbox.click();
		}
		
		driver.findElement(By.id("checkBoxOption3")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='radio1']")).click();
		
		//driver.findElement(By.xpath("//option[@value='option1']")).click();
		
		driver.findElement(By.xpath("//select[@id='dropdown-class-example'] //option[@value='option1']")).click();  //---> parent- child xpath
		
		
//-----------------------------work with AutoSuggestion DropDown ---------------------------------------------------------------------->
		
	   driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("ind");
	   
	   List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
	   
	   System.out.println(options.size());
	   
	   for( WebElement option : options)
	   {
		   if(option.getText().equalsIgnoreCase("India"))
		   {
			   option.click();
			   break;
		   }
	   }
		
		
		driver.close();
		

	}

}
