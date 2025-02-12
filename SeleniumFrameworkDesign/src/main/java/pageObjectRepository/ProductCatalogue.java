package pageObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//	WebElement prod = products.stream().filter(product->product.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
//	prod.findElement(By.cssSelector(".w-10")).click();
	
	@FindBy(css = ".mb-3")
	List<WebElement> products;

	By namaProduct = By.tagName("b");
	By addToCart = By.cssSelector(".w-10");
	By toastMessage = By.id("toast-container");
	
	
	public WebElement getProductByName(String productName) {
		WebElement prod = products.stream()
				.filter(product->product.findElement(namaProduct)
						.getText().equals(productName))
				.findFirst().orElse(null);
		return prod;
	}
	
	public void addToCart(String productName) {
		WebElement product = getProductByName(productName);
		product.findElement(addToCart).click();
		waitUntilElementAppear(toastMessage);
		waitUntilElementDissapear(toastMessage);
	}
	
	
}
