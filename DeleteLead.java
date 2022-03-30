import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup(); 
		
		ChromeDriver driver = new ChromeDriver();
	
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
        driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
		
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("91");
		
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9876543212");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
// to get title
		
		Thread.sleep(3000);
		
	    String text = driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner x')]/a[1]")).getText();
		
		System.out.println(text);
		
		driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner x')]/a[1]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys("text");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//verify the lead got deleted
		
	    String verifyDeleted=driver.findElement(By.xpath("//div[@class='x-paging-info]"));
	     
	     if(verifyDeleted.equals("No records to display")) {
     	 System.out.println("Record deleted");
	   	}
	     else {
	    	 System.out.println("Record not deleted");
	     }
	    		 
		
		
		driver.close();
		
		
		
		
		
		
			
	

	}

}
