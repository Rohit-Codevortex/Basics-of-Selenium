package IntermediateCode;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
//---------------------------------------------------------------------------------------------------------------------	
		
		List<WebElement>  checkBoxes = driver.findElements(By.xpath("//div[@id='checkbox-example']//input[@type='checkbox']"));
		
		String option = "option2"; 
		String selectedCheckBox=" ";
		
		for(WebElement checkBox : checkBoxes)
		{
			if(checkBox.getDomAttribute("value").trim().contains(option))
			{
				checkBox.click();
				selectedCheckBox = checkBox.getDomAttribute("value");
				break;
			}
		}
		
//---------------------------------------------------------------------------------------
		List<WebElement> dropDowns = driver.findElements(By.xpath("//select[@id='dropdown-class-example'] //option"));
		
		
		for(WebElement dropDown : dropDowns)
		{
			if(dropDown.getDomAttribute("value").contains(selectedCheckBox))
			{
				dropDown.click();
				break;
				
				
			}
		}
		
//--------------------------------------------------------------------------------------------------------------------
		driver.findElement(By.id("name")).sendKeys(selectedCheckBox);
		driver.findElement(By.id("confirmbtn")).click();
		Alert alert = driver.switchTo().alert();
		
		String message = alert.getText();
		alert.accept();
		
		
		
		if(message.contains(selectedCheckBox))
		{
			System.out.println("Alert Message Success");
		}
		else
		{
			System.out.println("Something wrong with Exceution");
		}
		
		driver.close();
		
		

	}

}
