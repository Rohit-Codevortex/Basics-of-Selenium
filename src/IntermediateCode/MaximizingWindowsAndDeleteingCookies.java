
package IntermediateCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaximizingWindowsAndDeleteingCookies {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Open website
        driver.get("https://www.google.com");

        // 1. Maximize browser window
        driver.manage().window().maximize();

        // 2. Get all cookies
        System.out.println("Cookies before deletion:");
        System.out.println(driver.manage().getCookies());

        // 3. Delete all cookies
        driver.manage().deleteAllCookies();

        // 4. Verify cookies after deletion
        System.out.println("Cookies after deletion:");
        System.out.println(driver.manage().getCookies());

        // Close browser
        driver.quit();
    }
}
