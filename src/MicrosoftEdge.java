import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;

public class MicrosoftEdge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver1 = new EdgeDriver();
		driver1.get("https://www.google.com");

        System.out.println(driver1.getTitle());

        driver1.quit();

	}

}
