package IntermediateCode;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotUsingTopathMethod {

	public static void main(String[] args) throws IOException {
		
		

	        WebDriver driver = new ChromeDriver();

	        try {
	        	
	            driver.manage().window().maximize();
	            driver.get("https://www.google.com");

	            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	            File destination = new File("D:\\TestingScreenShotStroredBySelenium\\NewScreenShot.png");

	            System.out.println("Screenshot captured: " + source.exists());

	            Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

	            System.out.println("Screenshot saved: "+ destination.exists());

	        } 
	        finally 
	        {
	            driver.quit();
	        }
		

	}

}
