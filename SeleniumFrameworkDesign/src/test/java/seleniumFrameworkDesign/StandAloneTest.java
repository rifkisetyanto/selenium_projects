package seleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		
		//login
		driver.findElement(By.id("userEmail")).sendKeys("rifki@academy.com");
		driver.findElement(By.id("userPassword")).sendKeys("Admin12345");
		driver.findElement(By.id("login")).click();
		
		//dashboard
		//eksplisit wait.
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
	}

}
