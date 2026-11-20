import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssertionPerform {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		System.out.println(driver.findElement(By.cssSelector("input[id*= 'friendsandfamily']")).isSelected());

		// Assertion pass here

		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*= 'friendsandfamily']")).isSelected());

		driver.findElement(By.cssSelector("input[id*= 'friendsandfamily']")).click();

		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*= 'friendsandfamily']")).isSelected());

		// here execution will stop due failed assertion

		// Assert.assertFalse(driver.findElement(By.cssSelector("input[id*=
		// 'friendsandfamily']")).isSelected());

		System.out.println(driver.findElement(By.cssSelector("input[id*= 'friendsandfamily']")).isSelected());

		driver.close();

	}

}
