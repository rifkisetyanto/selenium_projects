package pengenalan_Locator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locator_Selenium_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String nama = "rifki";
		ChromeDriver driver = new ChromeDriver(); //Buka browser Chrome
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //waktu tunggu secara global
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); //Kunjungi Link
		driver.findElement(By.id("inputUsername")).sendKeys(nama); //input Username
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy"); //input Password
		driver.findElement(By.className("signInBtn")).click(); //klik Sign In Button
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+nama+",");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.close();
	}

}
