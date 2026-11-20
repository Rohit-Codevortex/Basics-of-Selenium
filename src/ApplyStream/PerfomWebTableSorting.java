package ApplyStream;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class PerfomWebTableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//table[@class='table table-bordered']  //tr/th[1]")).click();
		
		List<WebElement> vegAndFruit = driver.findElements(By.xpath("//table[@class='table table-bordered']  //tr/td[1]"));
		
		List<String> originalList = vegAndFruit.stream().map(s-> s.getText()).collect(Collectors.toList());
		
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertEquals(originalList, sortedList);
		
		System.out.println("Test was passed");
		
		driver.close();
		

	}

}
