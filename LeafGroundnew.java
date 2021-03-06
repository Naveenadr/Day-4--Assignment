import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundnew {

	 //Edit page
  	public void EditPage() {
		
		WebDriverManager.chromedriver().setup(); 
		
		ChromeDriver editdriver = new ChromeDriver();

		editdriver.get("http://leafground.com/pages/Edit.html");
		editdriver.manage().window().maximize();
		editdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		editdriver.findElement(By.id("email")).sendKeys("xyz@gmail.com");
		WebElement appendText = editdriver.findElement(By.xpath("//label[contains(text(), 'Append a text')]//following-sibling::input"));
		appendText.sendKeys("new text added", Keys.TAB);
		String defaultValue =editdriver.findElement(By.name("username")).getAttribute("value");
		System.out.println(defaultValue);
		editdriver.findElement(By.xpath("//label[contains(text(), 'Clear the text')]//following-sibling::input")).clear();
		WebElement disabledField = editdriver.findElement(By.xpath("//label[contains(text(), 'disabled')]//following-sibling::input"));
		if(!disabledField.isEnabled())
			System.out.println("Text field is disabled");
		else
			
			System.out.println("Text field is enabled");
		editdriver.close();
	}

	
	// Button page

	public void ButtonPage()
	{
       WebDriverManager.chromedriver().setup(); 
		
		ChromeDriver buttondriver = new ChromeDriver();
	
		buttondriver.get("http://leafground.com/pages/Button.html");
		buttondriver.manage().window().maximize();
	
		buttondriver.findElement(By.id("home")).click();
	    System.out.println(" home page open, on clicking");
	    buttondriver.findElement(By.xpath("//img[@alt = 'Buttons']")).click();
	    Point location = buttondriver.findElement(By.id("position")).getLocation();
	    System.out.println(location);
	    String color = buttondriver.findElement(By.id("color")).getCssValue("background-color");
	    System.out.println(color);
	    Dimension size = buttondriver.findElement(By.id("color")).getSize();
	    System.out.println(size);
	    buttondriver.close();

}
	
	//Link page
	
	public void LinkPage()
	{
       WebDriverManager.chromedriver().setup(); 
		
		ChromeDriver linkdriver = new ChromeDriver();
		linkdriver.get("http://leafground.com/pages/Link.html");
		
		linkdriver.findElement(By.linkText("Go to Home Page")).click();
		
		linkdriver.findElement(By.linkText("Verify am I broken?")).click();
		if(linkdriver.getTitle().contains("404"))
		System.out.println("Link is broken");
		else
			System.out.println("Link is not broken");	
		
		linkdriver.findElement(By.linkText("How many links are available in this page?")).click();
		List<WebElement> linkList = linkdriver.findElements(By.tagName("a"));
		System.out.println(linkList.size());
		linkdriver.close();
	}
	
	
	//image page
	
		public void ImagePage()
		{
	       WebDriverManager.chromedriver().setup(); 
			
			ChromeDriver imagedriver = new ChromeDriver();
			imagedriver.get("http://leafground.com/pages/Image.html");
			imagedriver.findElement(By.xpath("//label[text() = 'Click on this image to go home page']//following-sibling::img")).click();
			System.out.println("Clicked image");
			
			if(imagedriver.findElement(By.xpath("//label[text() = 'Am I Broken Image?']//following-sibling::img")).getAttribute("onclick") != null);
			System.out.println("Not broken");
			else
				System.out.println("Broken");
			
			imagedriver.findElement(By.xpath("//label[text() = 'Click me using Keyboard or Mouse']//following-sibling::img")).click();
			System.out.println("Clicked on Keyboard ");
			imagedriver.close();
}
		//Drop down page
		
			public void DdPage()
			{
		       WebDriverManager.chromedriver().setup(); 
				
				ChromeDriver dddriver = new ChromeDriver();
				dddriver.get("http://leafground.com/pages/Dropdown.html");	
                Select select1 = new Select(dddriver.findElement(By.id("dropdown1")));
                select1.selectByIndex(1);
				System.out.println("Selected using index");
				
				Select select2 = new Select(dddriver.findElement(By.name("dropdown2")));
				select2.selectByVisibleText("Selenium");
				System.out.println("Selected using text");
				
				Select select3 = new Select(dddriver.findElement(By.id("dropdown3")));
				select3.selectByValue("3");
				System.out.println("Selected using value");
				
				Select noOfoption = new Select(dddriver.findElement(By.className("dropdown")));
				List<WebElement> OptionsList = noOfoption.getOptions();
				
				for(WebElement eachOption: OptionsList)
				{
					String optionText = eachOption.getText();
					System.out.println(optionText);
				}
				
				dddriver.findElement(By.xpath("//option[text() = 'You can also use sendKeys to select']//parent::select")).sendKeys("Selenium", Keys.ENTER);
				
				List<WebElement> totalElementinList = new Select(dddriver.findElement(By.xpath("//option[text() = 'Select your programs']//parent::select"))).getOptions();
				
				for(int i =1; i<totalElementinList.size(); i++)
				{
					totalElementinList.get(i).click();
					System.out.println("Selected Option");
				}
		
				//Check box page
				
				public void CheckPage()
				{
			       WebDriverManager.chromedriver().setup(); 
					
					ChromeDriver cbdriver = new ChromeDriver();
					cbdriver.get("http://leafground.com/pages/checkbox.html");	
					cbdriver.findElement(By.xpath("//label[text() = 'Select the languages that you know?']//following-sibling::input")).click();
					System.out.println("JAVA");
				
					WebElement cnfmCheck = cbdriver.findElement(By.xpath("//label[text() = 'Confirm Selenium is checked']//following-sibling::input"));
					if(cnfmCheck.isSelected())
						System.out.println(" selected already");
					else
						cbdriver.findElement(By.xpath("//div[contains(text(), 'Selenium')]/input")).click();
					
					
					List<WebElement> deSelectChecklist = cbdriver.findElements(By.xpath("//label[text() = 'DeSelect only checked']/following-sibling::input"));
					
					for(int i=0; i<deSelectChecklist.size(); i++)
					{
						System.out.println(deSelectChecklist.get(i).getAttribute("checked"));
						
						
						if(deSelectChecklist.get(i).getAttribute("checked")!= null && deSelectChecklist.get(i).getAttribute("checked").equals("true"))
						{
							deSelectChecklist.get(i).click();
							
						    System.out.println("Clicked on check box");
						}
						
					}
					
					
					
					List<WebElement>  allOptions = cbdriver.findElements(By.xpath("//label[contains(text(), 'Select all below checkboxes')]//following-sibling::input"));
					for(WebElement eachOption : allOptions)
					{
						eachOption.click();
						System.out.println("clicked on Option");
						
					}
			}		
}
