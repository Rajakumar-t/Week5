package hw.w5.d1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.google.common.io.Files;

public class AmazonAction {

	public static void main(String[] args) throws InterruptedException, IOException {
		FirefoxDriver driver = new FirefoxDriver();
		//launch browser
		driver.get("https://www.amazon.in");
		
		//Maximise browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//input the text in search bar
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		
		//click the search button
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		//finding the price for the first list phone 
		WebElement priceele = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String price = priceele.getText();
		System.out.println("price of the first list = INR "+price);
		
		//finding the customer rating
		WebElement custemerelement = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]"));
		String customerrating = custemerelement.getText();
		System.out.println("Number of customer ratings for the first displayed product is : "+customerrating);
		
		//clicking the image**
		driver.findElement(By.xpath("//span[text()='OnePlus 11 5G (Eternal Green, 16GB RAM, 256GB Storage)']")).click();
		
		
		//screen shot 
		File scr = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("/Users/rthanaraj/Downloads/Screenshot/Amazon/sc/am.jpg");
		FileUtils.copyFile(scr,target);
		
		//window handling 
		Set<String> windowHandles = driver.getWindowHandles();
		List <String> all = new ArrayList<String>(windowHandles);
		driver.switchTo().window(all.get(1));
		Thread.sleep(30);
		File pic = driver.getScreenshotAs(OutputType.FILE);
		Files.copy(pic, new File ("/Users/rthanaraj/Downloads/Screenshot/Amazon/amazonscreenshot.jpeg"));
		//driver.close();
		
		
		//Adding to the cart using move to element and clicking 
		Thread.sleep(1000); 
		//Actions move = new Actions(driver);
		//move.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(3000);
		//WebElement cart = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']"));
		driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']")).click();
		//move.scrollToElement(cart).perform();
		//cart.click();
		
		
		//cart.click(); //span[@id='attach-accessory-cart-subtotal']
		Thread.sleep(3000);
		WebElement cartelement = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));
		//System.out.println(driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText());
		String cart1 = cartelement.getText();
		String ver = cartelement.getText();
		System.out.println("cart price = "+cart1 );
		System.out.println(ver);
		if (ver.equals(cart1)) {
			System.out.println("yes Verifed");
		}else {
			System.out.println("Not verified");
		}
		
		driver.close();
		driver.switchTo().window(all.get(0));
		driver.close();
		
	}

}
