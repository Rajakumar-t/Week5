package hw.w5.d2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SalesforcesAnnotationsInTestNG extends BaseClass{
	
	
	@Test
	public void name() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		//click the view button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//WebElement element = driver.findElement(By.xpath("//button[text()='View All']"));
		//Actions move = new Actions(driver);
		//move.moveToElement(element);
		///element.click();
		
		
		//click the legal entities 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Legal Entities']")).click();
		//Actions move = new Actions(driver);
		//move.sendKeys(Keys.PAGE_DOWN).perform();
		
		//Click on new button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		
		
		//Set<String> windowHandles = driver.getWindowHandles();
		//List <String> all = new ArrayList <String>(windowHandles);
		//System.out.println(all);
		//driver.switchTo().window(null);
		
		
		//input the entries as requested for company name and description
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TestLeaf");
		//driver.findElement(By.xpath("//p[text()='Legal Entities']")).click();
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys("Salesforces");
		
		
		//WebElement dropelement = driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value']"));
		//Select click = new Select(dropelement);
		//click.deselectByVisibleText("Active");
		//Actions move = new Actions(driver);
		//move.sendKeys(Keys.PAGE_DOWN).perform();
		//Thread.sleep(1000);
		//WebElement dropelement = driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value']"));
		//Select dropdown=new Select(dropelement);
		//dropdown.deselectByVisibleText("Active");
		//label[text()='Status']//following::button
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//label[text()='Status']//following::button"));
		driver.executeScript("arguments[0].click()",element);
		WebElement element2 = driver.findElement(By.xpath("//span[@title='Active']"));
		
		//This is advance click that is been used. 
		driver.executeScript("arguments[0].click()",element2);
		Thread.sleep(3000);
      
		
		// Click Save without filling Name
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

        // Verify alert message for missing Name field
        Thread.sleep(2000);
        WebElement alertMsg = driver.findElement(By.xpath("//div[text()='Complete this field.']"));
        String actualMessage = alertMsg.getText();
        String expectedMessage = "Complete this field.";
        
        if (actualMessage.equals(expectedMessage)) {
            System.out.println(" Yes, verified");
        } else {
            System.out.println(" Verification failed: Expected ");
        }
       /* WebElement alertMsg = driver.findElement(By.xpath("//div[text()='Complete this field.']"));
        String actualMessage = alertMsg.getText();
        String exptMsg = alertMsg.getText();
       */ //Assert.assertEquals(actualMessage, exptMsg, "Validation message mismatch for Name field.");
	}

}