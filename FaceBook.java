import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup(); 
		
		ChromeDriver driver = new ChromeDriver();
	
		driver.get("https://en-gb.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Xxxxxx");
        
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Yyyyy");
        
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9999999999");
		
	    driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Abcd@1234");
		
		// Select source
		WebElement daySource = driver.findElement(By.xpath("//select[@id='day']"));
		
		Select day = new Select(daySource);
		
		day.selectByVisibleText("12");
		
	    WebElement monthSource = driver.findElement(By.xpath("//select[@id='month']"));
		
		Select month = new Select(monthSource);
		
		month.selectByVisibleText("Dec");
		
       WebElement yearSource = driver.findElement(By.xpath("//select[@id='year']"));
		
		Select year = new Select(yearSource);
		
		year.selectByVisibleText("1995");
		
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		

	}

}
