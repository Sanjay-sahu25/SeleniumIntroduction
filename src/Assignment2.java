import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/EK744JY/OneDrive - EY/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Sanjay");
		driver.findElement(By.name("email")).sendKeys("sanjaysahu2gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("password");
		WebElement checkbox = driver.findElement(By.id("exampleCheck1"));
		checkbox.click();
		WebElement staticdropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByIndex(1);
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("25-07-2001");
		driver.findElement(By.cssSelector("input[class*='btn-success']")).click();
		System.out.println(driver.findElement(By.cssSelector("div[class*='alert-success']")).getText());
		
		
		

	}

}
