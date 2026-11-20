package IntermediateCode;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class FrameConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
//-------------------------------Frame Concept ------------------------------------------------->
		
		System.out.println("No of iframes tag:" + driver.findElements(By.tagName("iframe")).size());
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		
		//driver.findElement(By.id("draggable")).click();
		
		Actions a = new Actions(driver);
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, target).build().perform();
		
//------------------------to check validation --------------------------------------------------------->
		
		String expected = driver.findElement(By.xpath("//div[@id='droppable'] //p")).getText();
		String actual = "Dropped!";
		
		Assert.assertEquals(expected, actual);
		
//------------------ if we need to perform any action outside the frame ----> we have to switch driver to default content ---->
		
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'demo-description')] //p")).getText());
		
		
		
		System.out.println("Test Passed");
		
		driver.close();
	}

}
