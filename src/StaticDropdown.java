
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class StaticDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			WebDriver driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			
			
			WebElement staticDropDown  = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropDown = new Select(staticDropDown);
		
		dropDown.selectByVisibleText("INR");
		System.out.println(dropDown.getFirstSelectedOption().getText());
		
		dropDown.selectByValue("AED");
		System.out.println(dropDown.getFirstSelectedOption().getText());
		

	}

}
