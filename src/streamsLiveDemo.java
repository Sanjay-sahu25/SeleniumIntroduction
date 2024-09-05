import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class streamsLiveDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\EK744JY\\OneDrive - EY\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on the coloumn 
		//capture all the web elements into list
		//capture text of all web elements into new (original) list
		//sort in the original list of step 3-. sorted list
		//compare original list vs sorted list
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		List<String>orgList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String>sortedList = orgList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(orgList.equals(sortedList));
		
		//scan the name coloumn if we getText -> Rice -> print the price of the Rice
		List<String> price ;
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
		
		    price = rows.stream().filter(s->s.getText().contains("Carrot")).map(s->
				{
			String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
			return pricevalue;
				}
		).collect(Collectors.toList());
	    price.forEach(a->System.out.println(a));
	    if(price.size()<1)
	    {
	    	driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
	    }
		}while(price.size()<1);		

	}

}
