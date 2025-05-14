package pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css = ".totalRow button")
	WebElement checkOut;
	
	
	public boolean productMatch(String productName) {
		boolean match = cartProducts.stream().anyMatch(matching->matching.getText().equals(productName));
		return match;
	}

	public void goToCheckOutPage() {
		checkOut.click();
	}
	
}
