package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	WebDriver driver;
	public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
	}

	
	
	public void waitUntillElementVisible(By findBy) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));		
	}
	
	public void waitUntillElementDisappear(By findBy) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));		
	}
}
