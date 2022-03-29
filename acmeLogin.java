import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class acmeLogin {

	public static void main(String[] args) {
	
		
		
		WebDriverManager.chromedriver().setup(); 
	
		ChromeDriver driver = new ChromeDriver();
	
		driver.get("https://acme-test.uipath.com/login");
		
		driver.manage().window().maximize();
		
	    driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kumar.testleaf@gmail.com");
        
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@12");
	    
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// to get title
		
	    String text = driver.findElement(By.xpath("//a[text()='ACME System 1']")).getText();
		
		System.out.println(text);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		//logout
		
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		
		//close
		
		driver.close();
		
		
		
		

	}

}
