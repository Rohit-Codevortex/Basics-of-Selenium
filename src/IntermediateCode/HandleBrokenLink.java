package IntermediateCode;

import java.io.IOException;

import java.net.HttpURLConnection;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandleBrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		  driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		  
		  
		  List<WebElement> links = driver.findElements(By.cssSelector("div[id='gf-BIG'] a"));
		  
		  for(WebElement link : links)
		  {
			  String url = link.getDomAttribute("href");

			  if (url == null || url.isBlank()) {
			      continue;
			  }

			  URI uri = new URI(url);

			  // Skip relative URLs and non-HTTP links
			  if (!uri.isAbsolute()
			          || !(url.startsWith("http://")
			          || url.startsWith("https://"))) {
			      continue;
			  }

			  HttpURLConnection conn =
			          (HttpURLConnection) uri.toURL().openConnection();

			  conn.setRequestMethod("HEAD");
			  conn.setConnectTimeout(5000);
			  conn.setReadTimeout(5000);

			  int responseCode = conn.getResponseCode();

			  System.out.println(responseCode + " : " + url);

			  conn.disconnect();
		  }
		  
		  driver.close();
		  

	}

}
