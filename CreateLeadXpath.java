import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadXpath {

	public static void main(String[] args) {
	
		
		WebDriverManager.chromedriver().setup(); 
	
		ChromeDriver driver = new ChromeDriver();
	
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("HCL");
		
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Naveena");
		
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("D R");
		
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Naveena");
		
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("Ravichandran");
		
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		
		driver.findElement(By.id("createLeadForm_description")).sendKeys("QA");
		
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("drnaveena2612@gmail.com");
		
		// Select source
		WebElement eleSource = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		
		Select dd = new Select(eleSource);
		
		dd.selectByVisibleText("New York");
		
		driver.findElement(By.name("submitButton")).click();
		
        driver.findElement(By.linkText("Edit")).click();
		
		driver.findElement(By.id("updateLeadForm_description")).clear();
		
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Quality Analyst");
		
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		
		String text = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		
		System.out.println(text);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		
	}


	}


