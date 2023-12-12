package pengenalan_Locator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator_Selenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver(); //Buka browser Chrome
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //waktu tunggu secara global
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); //Kunjungi Link
		driver.findElement(By.id("inputUsername")).sendKeys("rifki"); //input Username
		driver.findElement(By.name("inputPassword")).sendKeys("admin"); //input Password
		driver.findElement(By.className("signInBtn")).click(); //klik Sign In Button
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Rifki");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("portalQA@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("portalQAIndonesia@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("0218762141");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
	}
}
