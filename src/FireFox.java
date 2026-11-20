import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;




public class FireFox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		  driver.get("https://www.google.com");

	        System.out.println(driver.getTitle());

	        driver.quit();

	}

}
