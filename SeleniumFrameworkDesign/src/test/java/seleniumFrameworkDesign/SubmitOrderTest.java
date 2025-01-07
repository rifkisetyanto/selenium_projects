package seleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjectRepository.LandingPage;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productName = "ADIDAS ORIGINAL";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		
		//login
		LandingPage landingPage = new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("rifki@academy.com");
		driver.findElement(By.id("userPassword")).sendKeys("Admin12345");
		driver.findElement(By.id("login")).click();
		
		//dashboard
		//eksplisit wait.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod = products.stream().filter(product->product.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".w-10")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean match = cartProducts.stream().anyMatch(matching->matching.getText().equals(productName));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.cssSelector(".form-group input")).sendKeys("ind");
		
		List<WebElement> country = driver.findElements(By.cssSelector(".ta-item"));
		country.stream()
		.filter(s->s.findElement(By.cssSelector(".ta-item span"))
				.getText()
				.equals("Indonesia")).findFirst().orElse(null).click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirmedMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(confirmedMessage, "THANKYOU FOR THE ORDER.");
		driver.quit();
	}
}
