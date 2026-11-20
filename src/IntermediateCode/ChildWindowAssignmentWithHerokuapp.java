package IntermediateCode;

//------------------------------------> Herokuapp with multiple window --------------------------------------->

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class ChildWindowAssignmentWithHerokuapp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.findElement(By.xpath("//div[@class ='example'] //a")).click();
		
		Set<String> window = driver.getWindowHandles();  //[parentId, childId]
		Iterator<String> it = window.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
	System.out.println(	driver.findElement(By.xpath("//div[@class='example'] //h3")).getText());
	
//-------------------------> driver switch to child window to parent window --------------------------->
	
	driver.switchTo().window(parentId);
	System.out.println(	driver.findElement(By.xpath("//div[@class='example'] //h3")).getText());
	driver.quit();
	
	
		

	}

}
