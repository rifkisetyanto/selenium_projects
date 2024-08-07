package eCommerce_App;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKart_Demo {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		//array == item dari yagn mau kita pilih.
		String namaItem [] = {"Cucumber - 1kg","Beetroot - 1kg","Tomato"};
		
		
		for(int i = 0; i < products.size(); i++) {
			
			//memvalidasi teks nya sampai menemukan teks yang sesuai dengan yang kita mau
			String nama = products.get(i).getText();
			/**
			 * split dan trim 
			 * trim == menghilangkan spasi
			 * split == memisahkan teks atau karakter yang kita inginkan
			 * 
			 */
			List<String> listItem = Arrays.asList(namaItem);
			if(listItem.contains(nama)) {
				// klik add To Cart
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
			}
			
		}
	}

}
1