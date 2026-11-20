import java.time.Duration;
import java.util.List;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Ram");
		driver.findElement(By.name("email")).sendKeys("ram134@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("ram@12345");
		driver.findElement(By.id("exampleCheck1")).click();
		
		List<WebElement> elements = driver.findElements(By.xpath("//select[@id='exampleFormControlSelect1'] //option"));
		
		for(WebElement element: elements)
		{
			if(element.getText().equalsIgnoreCase("Male")) {
				
				element.click();
				break;
			}
		}
		
		
		List<WebElement> radioButtons = driver.findElements(By.xpath("//div[@class= 'form-check form-check-inline'] //input"));
		for(WebElement radioButton: radioButtons)
		{
			if(radioButton.getDomAttribute("value").equalsIgnoreCase("option1")) {
				
				radioButton.click();
				break;
			}
		}
		
		
		driver.findElement(By.name("bday")).sendKeys("12-12-2007");
		
		driver.findElement(By.cssSelector("input[class='btn btn-success']")).click();
		
		Thread.sleep(3000);
		
		
		WebElement message = driver.findElement(By.cssSelector("div.alert.alert-success"));

		String actualMessage = message.getText().replace("×", "").trim();

			String expectedMessage ="Success! The Form has been submitted successfully!.";

			Assert.assertEquals(actualMessage, expectedMessage);

			System.out.println("Test Passed");

			driver.quit();

		driver.close();
		
	}

}
