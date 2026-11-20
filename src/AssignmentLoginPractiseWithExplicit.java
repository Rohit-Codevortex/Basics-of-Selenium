import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class AssignmentLoginPractiseWithExplicit {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
//------------------------------- Explicitly wait  Handle here ----------------------------------------------------->		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(9));
		
		
		driver.findElement(By.cssSelector("#username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("Learning@830$3mK2");
		driver.findElement(By.xpath("//input[@value='user']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='okayBtn']")));
		
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		
		
		
		System.out.println("user radio button was clicked");
		
		
		driver.findElement(By.xpath("//input[@value='admin']")).click();
		
//--------------------------------------> DropDown button selection ---------------------------------------------------------------------------------> 
		
		List<WebElement> buttons = driver.findElements(By.xpath("//select[@class='form-control'] //option"));
		
		for(WebElement button: buttons)
		{
			if(button.getText().contains("Teacher"))
			{
				button.click();
				break;
			}
		}
		
//-------------------------------------> Check Box ---------------------->
		
		driver.findElement(By.cssSelector("input[id='terms']")).click();
		
		driver.findElement(By.cssSelector("#signInBtn")).click();
		
		
		
		
		
		
		System.out.println("Test passed");
		
		Thread.sleep(5000);
		driver.close();

	}

}
