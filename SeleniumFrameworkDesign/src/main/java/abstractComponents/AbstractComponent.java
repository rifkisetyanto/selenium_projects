package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
	}

	public void waitUntilElementAppear(By ele) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));		
	}
	
	public void waitUntilElementDissapear(By ele) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ele));		
	}
}
