package hw.w5.d2;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public FirefoxDriver driver;
	
@BeforeMethod	
public void precondition() {
	FirefoxOptions ff = new FirefoxOptions();
	ff.addArguments("--disable-notifications");
	driver = new FirefoxDriver(ff);
	driver.get("https://login.salesforce.com");
	driver.manage().window().maximize();
	driver.findElement(By.id("username")).sendKeys("bhuvanesh.moorthy@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("Testleaf@2025");
	driver.findElement(By.id("Login")).click();

}
@AfterMethod
public void postCondition() {
	driver.close();

}
}
