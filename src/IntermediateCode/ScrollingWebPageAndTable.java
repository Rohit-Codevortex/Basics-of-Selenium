package IntermediateCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollingWebPageAndTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//---------------------------- Window ko Scroll karna h -------------------------------------------------------->	
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);
//----------------------------------- window ke andar jo table present usko scroll karna h --------------------------->		
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop =5000");
		
//-------------------------- Handle Table Grid ----------------------------------------------------------->
		
		List<WebElement>  values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum =0;
		
		for(int i=0; i<values.size(); i++)
		{
			System.out.println(values.get(i).getText());
			sum += Integer.parseInt(values.get(i).getText());
			
		}
		
		System.out.println("Total Calculation:"+sum);
		
//----------------------- Now We perform Assertion on Toatal Calculation-------------------------------------------->
		
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(total, sum);
		
		System.out.println("Assertion was passed");

		
		
		driver.close();

	}

}
