package IntermediateCode;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AssignmentOfFrameConcept {
	
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		System.out.println(driver.findElements(By.tagName("frame")).size());
	
//----------------------------> first we have to switch driver to middle frame from the defalut content driver------------------------------>		
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
		
//------------------------------> now driver switch fro the insider frame which is exist in middle frame-------->		
		
		driver.switchTo().frame(driver.findElement(By.id("#content")));
		System.out.println(driver.findElement(By.id("#content")).getText());
		
		driver.close();
	}

}
