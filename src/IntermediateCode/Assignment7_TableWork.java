package IntermediateCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment7_TableWork {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

//---------------------------- Window ko Scroll karna h -------------------------------------------------------->	

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");

		Thread.sleep(3000);

		int rows = driver.findElements(By.xpath("//div[@class='left-align'] //tr")).size();
		int column = driver.findElements(By.xpath("//div[@class='left-align'] //tr/th")).size();

		System.out.println("Total No of Rows:-  " + rows);
		System.out.println("Total No of Column:-  " + column);

		List<WebElement> datas = driver.findElements(By.xpath("//div[@class='left-align'] //tr[2]/td"));

		for (WebElement data : datas) {
			System.out.print(" " + "| " + data.getText());
		}
		
		System.out.println();
		
		driver.close();

	}

}
