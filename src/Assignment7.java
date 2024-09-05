import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\EK744JY\\OneDrive - EY\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr"));
		System.out.println(rows.size());
		List<WebElement> coloumns = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th"));
		System.out.println(coloumns.size());
		List<WebElement> row3 =  driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[3]/td"));
		for(int i=0;i<row3.size();i++)
		{
			System.out.println(row3.get(i).getText());
		}
		
		

	}

}
