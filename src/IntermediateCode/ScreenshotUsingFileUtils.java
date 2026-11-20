package IntermediateCode;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class ScreenshotUsingFileUtils {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://developer.chrome.com/docs/chromedriver/capabilities");
		
		
//--------------- Url constructor  is depericate onwards java 20( so this is old apparoach)---------- to create url object.--->		
		
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source,new File("D:\\TestingScreenShotStroredBySelenium\\Pictures\\ScreenShot.png"));
		
		driver.close();

	}

}
