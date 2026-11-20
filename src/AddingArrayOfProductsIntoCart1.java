import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingArrayOfProductsIntoCart1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		String[] requiredProducts = { "Cucumber", "Beans", "Pumpkin", "Apple" };

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

//convert Array to ArrayList to save memory------------------------------------------------------------------------------------>

		List<String> product = Arrays.asList(requiredProducts);

		// Thread.sleep(2000);

		int j = 0;
		for (int i = 0; i < products.size(); i++) {

			String[] name = products.get(i).getText().split("-");
			String vegName = name[0].trim();

			if (product.contains(vegName)) {

				j++;

// --------------------------------> Change occur here --------------------------------------------------------->				

				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click();

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); // ------>
																										// parent- child
																										// relation;

				if (j == requiredProducts.length) {
					break;
				}

			}
		}

		driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
		
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		
//----------------------------------- Select country from where you belong. from the dropdown button------------>
		
		List<WebElement> countries = driver.findElements(By.xpath("//div[@class='wrapperTwo'] //select/option"));
		
		for(WebElement country: countries)
		{
			if(country.getText().equalsIgnoreCase("India"))
			{
				country.click();
				break;
			}
		}

		System.out.println("Test passed");
		
//------------------------------------- select checkBox------------------------------------------------------>
		
		driver.findElement(By.className("chkAgree")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		

		Thread.sleep(9000);
		driver.close();

	}

}
