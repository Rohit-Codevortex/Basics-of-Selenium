import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddingArrayOfProductsIntoCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		String[] requiredProducts = {"Cucumber","Beans","Pumpkin","Apple"};

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		
//convert Array to ArrayList------------------------------------------------------------------------------------>
		
		List<String> product = Arrays.asList(requiredProducts);
		
		Thread.sleep(2000);		
		

		for (int i = 0; i < products.size(); i++) {
			
			String[] name = products.get(i).getText().split("-");
			String vegName = name[0].trim();
			
			int j=0;

			if (product.contains(vegName)) {
				
				j++;
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				
				if(j==3)
				{
					break;
				}
				
			}
		}
		
		System.out.println("Test passed");
		
		//driver.close();

	}

}
