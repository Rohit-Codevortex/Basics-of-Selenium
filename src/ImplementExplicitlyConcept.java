
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ImplementExplicitlyConcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		String[] requiredProducts = { "Cucumber", "Beans", "Pumpkin", "Apple" };

//-------------------------------- Here we use Implicitly wait ----------------------------------------------->		

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

//-------------------------->Static  Method Calling -------------------------------------------------------------->

		ImplicExplicitConcept.addItems(driver, requiredProducts);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();

//------Apply coupon Code rahulshettyacademy----- with Explicitly Wait---------------------------------------------------------->
                           //--------------------------Explicitly wait implementation------------------------>
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));

		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));

		String actualMessage = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();

		System.out.println(actualMessage);

		Assert.assertEquals(actualMessage, "Code applied ..!");

		driver.findElement(By.xpath("//button[text()='Place Order']")).click();

//----------------------------------- Select country from where you belong. from the dropdown button------------>

		List<WebElement> countries = driver.findElements(By.xpath("//div[@class='wrapperTwo'] //select/option"));

		for (WebElement country : countries) {
			if (country.getText().equalsIgnoreCase("India")) {
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

//-------------------------------- Method for adding items into cart ---------------------------------------->	

	public static void addItems(WebDriver driver, String[] requiredProducts) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		int j = 0;
		for (int i = 0; i < products.size(); i++) {

			String[] name = products.get(i).getText().split("-");
			String vegName = name[0].trim();

			List<String> product = Arrays.asList(requiredProducts); // ------ to save memory , it may take less memory
																	// to extract products name;

			if (product.contains(vegName)) {

				j++;

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); // ------>
																										// parent- child
																										// relation;

				if (j == requiredProducts.length) {
					break;
				}

			}
		}

	}

}
