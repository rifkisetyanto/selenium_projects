package eCommerce_App;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GreenKart_Demo {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));	
		String[] namaItem = {"Cucumber","Tomato","Brocolli"};
		int j = 0;
		
		for(int i = 0; i < products.size(); i++) {
			
			//memvalidasi teks nya sampai menemukan teks yang sesuai dengan yang kita mau
			String nama = products.get(i).getText();
			/**
			 * Eliminasi pada teks yang didapatkan oleh selenium
			 * Trim == spasi nya
			 * SPlit == teks nya
			 * 
			 * Brocolli | 1 Kg
			 */
			String[] namaProduk = nama.split("-");
			// Index[0] = Brocolli
			// Index[1] = 1 Kg
			String namaProdukFix = namaProduk[0].trim();
			
			List<String> listItem = Arrays.asList(namaItem);
			
			if(listItem.contains(namaProdukFix)) {
				// klik add To Cart
//				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
			}
			if(j==listItem.size()) {
				break;
			}
		}
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
	}

}