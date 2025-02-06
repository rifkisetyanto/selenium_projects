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
import pageObjectRepository.ProductCatalogue;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productName = "BANARSI SAREE";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//login
		LandingPage landingPage = new LandingPage(driver);
		landingPage.go_to_URL();
		landingPage.loginApplication("rifki@academy.com", "Admin12345");
		
		//dashboard
		//eksplisit wait.
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		productCatalogue.addToCart(productName);
		
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
