package ApplyStream;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuildCustomSeleniumMethodUsingStream {

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//table[@class='table table-bordered']  //tr/th[1]")).click();
		
		List<WebElement> listElements = driver.findElements(By.xpath("//table[@class='table table-bordered']  //tr/td[1]"));
		
		List<String> price = listElements.stream().filter(s-> s.getText().contains("Beans")).map(s->getVeggiePrice(s)).collect(Collectors.toList());

	     price.forEach(s->System.out.println(s));
	     
	     driver.close();
	
	}
	
	
	
	//--------------------------------------- target to get the beans price ------------------------------------------>	

	private static String getVeggiePrice(WebElement s) {
		
	String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText(); // use concept of minidriver
		
		return priceValue;
	}
}
