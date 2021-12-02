package seleniumWebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsFirstPart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Selenium Chrome jar files\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		WebElement element=driver.findElement(By.xpath("//a[contains(text(),'Sign')]"));
		element.click();
		element=driver.findElement(By.id("email_create"));
		
		element.sendKeys("hello world");
		
		element.clear();
		element.sendKeys("hello_world@gmail.com");
		boolean display=element.isDisplayed();
		boolean enable=element.isEnabled();
		boolean select=element.isSelected();
		element.submit();
		System.out.println("Display "+display);
		System.out.println("Enable "+enable);
	    System.out.println("Select "+select);
			

		
		
		
	
	}

}
