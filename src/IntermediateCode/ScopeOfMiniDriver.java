package IntermediateCode;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeOfMiniDriver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		
//------------------------------ scope of miniWebDriver only for footer(limiting WebDriver) ----------------------------------->
		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		
		System.out.println("Total anchor tag in footer:/n");
		
		System.out.print(footerDriver.findElements(By.tagName("a")).size());
		
//------------------------------------ scope of miniWebDriver only for single row of footer-------------------->
		WebElement singleColumnFooter = driver.findElement(By.xpath("//table[@class='gf-t'] //tr/td[1]"));
		System.out.print("Anchor tag in Single row of Footer:");
		int size = singleColumnFooter.findElements(By.tagName("a")).size();
		
		for(int i=0; i<size; i++)
		{
			String clickOn = Keys.chord(Keys.CONTROL, Keys.ENTER);
			singleColumnFooter.findElements(By.tagName("a")).get(i).sendKeys(clickOn);
			Thread.sleep(5000);
			
		}
		
		Set<String> childWindows = driver.getWindowHandles();   ///-------- It retrieves handles of already-open windows and tabs.
		Iterator<String> it = childWindows.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		driver.close();
		
		
	}

}
