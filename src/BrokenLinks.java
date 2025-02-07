

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\EK744JY\\OneDrive - EY\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//broken link
		//step 1 -Is to get all urls tied up to the links using selenium
		// java menthods call URL's and gets you the status codes
		//if status >400 then that url is not working -. link tied to which is broken
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a = new SoftAssert();
		for(WebElement link :links)
		{
			String url = link.getAttribute("href");
			HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode= conn.getResponseCode();
			System.out.println(respCode);
			a.assertTrue(respCode<400,"The link with Text"+link.getText()+"is broken with code"+ respCode);
			
		}
		a.assertAll();
		
		
		
		
		

	}

}
