package hw.w5.d1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebTableHoover {

	public static void main(String[] args) throws InterruptedException {
		FirefoxDriver driver = new FirefoxDriver();
		// launch browser
		driver.get("https://erail.in/");

		// Maximise browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Accept the cookie
		driver.findElement(By.xpath("//button[@class='fc-button fc-cta-consent fc-primary-button']")).click();

		// enter the MAS to the from
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).clear();
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).sendKeys("MAS", Keys.ENTER);
		;
		// driver.findElement(By.xpath("//input[@id='txtStationFrom']")).click();

		// enter the MDU to the to
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).clear();
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).sendKeys("MDU", Keys.ENTER);
		;

		// un-check the date
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();

		//Retrieving the data from the table
		Thread.sleep(2000);
		List<WebElement> trainname = driver.findElements(By
				.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']/tbody//tr/td[2]"));
		int totalTrainCount = trainname.size();
		for (int i = 1; i <= totalTrainCount; i++) {

			//driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']/tbody//tr[" + i + "]/td[2]"));
			System.out.println("train" +(i)+ ": "+ trainname.get(i).getText());

		}

	}

}
