package ApplyStream;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class FilterTheWebTableUsingJavaStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Rice");
		
		
		String normalPriceValue = driver.findElement(By.xpath("//table[@class='table table-bordered'] //tr/td/following-sibling::td[1]")).getText();
		
		 List<String> streamPrice;
		
		do {
			
			List<WebElement> allElements = driver.findElements(By.xpath("//table[@class='table table-bordered'] //tr/td[1]"));
		    streamPrice = allElements.stream().filter(s->s.getText().contains("Rice")).map(s-> getPriceValue(s)).collect(Collectors.toList());
		    
		    if(streamPrice.size() < 1)
		    {
		    	driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		    }
			
		}while(streamPrice.size()<1);
		
		streamPrice.forEach(s->System.out.println(s));
		
		
		
		
		Assert.assertEquals(normalPriceValue, streamPrice.get(0));
		
		System.out.println("Test was passed");
		
		driver.close();

	}

	private static String getPriceValue(WebElement s) {
		
		
	String streamPriceValue =	s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		
		return streamPriceValue;
	}

}
