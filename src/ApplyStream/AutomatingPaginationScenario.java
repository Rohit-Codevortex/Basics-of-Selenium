package ApplyStream;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutomatingPaginationScenario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		
//---------------------------------------- Automating pagination starts from here --------------------------->		
		// scan the name column with getText ->Beans->print the price of the Rice------------------
		
		List<String> price;
		
		do {
			List<WebElement> pageElements = driver.findElements(By.xpath("//table[@class='table table-bordered']  //tr/td[1]"));
			price = pageElements.stream().filter(s-> s.getText().contains("Beans")).map(s->getVeggiePrice(s)).collect(Collectors.toList());
			
			if(price.size()<1)
			{
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
			
		}while(price.size()<1);
		
		

	     price.forEach(s->System.out.println(s));
	     
	     driver.close();

	}
	
	
	
	private static String getVeggiePrice(WebElement s) {
		
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText(); // use concept of minidriver
			
			return priceValue;
		}

}
