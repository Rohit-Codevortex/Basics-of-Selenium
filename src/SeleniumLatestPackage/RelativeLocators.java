package SeleniumLatestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with; /// import package specially Relative locator

public class RelativeLocators {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement namedEditBox = driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(namedEditBox)).getText());
		
//-----------------------------------------------> below Relative Locator ------------------------------------------------->
		
		WebElement dateBirthLabel = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateBirthLabel)).click(); // it skips his below input date of birth labe because it is flex component. it select next input element which submit button that why we put here click() method.

		
//----------------------------------- toLeftOf Relative Locator ----------------------------------------------->
		
		WebElement checkBoxIcecreamText = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkBoxIcecreamText)).click();
		
		
//----------------------------------------------> toRightOf Relative Locator <---------------------------------------------------------------------
		
		WebElement statusRaidoBtnRightText = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(statusRaidoBtnRightText)).getText());
		
		//driver.close();
	}

}
