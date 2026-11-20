package IntermediateCode;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files; //// this google Guva files 

//------------------------------  we can import this also import java.nio.file.Files; ------------------------------>
//---------------------------> so we can use Files.copy(source.toPath(), destination.toPath());

public class ScreenshotUsingFiles {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destination = new File("D:\\TestingScreenShotStroredBySelenium\\Pictures2\\NewScreenShot.png");
		
		Files.copy(source, destination);
		
		System.out.println("Screenshot saved successfully!");

        driver.quit();

	}

}
