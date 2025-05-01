package hw.w5.d1;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameAlertInteractionsTextVerify {

	public static void main(String[] args) throws InterruptedException {
		FirefoxDriver driver = new FirefoxDriver();
		// launch browser
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");

		// Maximise browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//accepting the pop-up
		driver.findElement(By.xpath("//div[@id=\"accept-choices\"]")).click();
		
		// Switching Frame
		driver.switchTo().frame("iframeResult");
		//WebElement tryit = driver.findElement(By.id("iframeResult"));
		//driver.switchTo().frame("tryit");

		// clicking accept button in iframe
		// Set<String> windowHandles = driver.getWindowHandles();
		// List<String> all = new ArrayList<String> (windowHandles);
		// System.out.println(all);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();

		// accepting the alert
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//Alert pop = driver.switchTo().alert();
		//pop.accept();
		WebElement element = driver.findElement(By.id("demo"));
		String text = element.getText();
		if (text.equals("You pressed OK!")) {
			System.out.println("OK alert was accepted and verified successfully.");
		} else if (text.equals("You pressed Cancel!")) {
			System.out.println("Cancel alert was dismissed and verified successfully.");
		}
	}
}
