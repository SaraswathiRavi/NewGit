package seleniumWebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","D:\\Selenium Chrome jar files\\chromedriver_win32 (1)\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver(); 
		driver.get("http://automationpractice.com/index.php");
		
		//Xpath using contains method
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		
		//Locators using id
		driver.findElement(By.id("email_create"));
		
		//Locators using name
		driver.findElement(By.name("SubmitCreate"));
		
		//Locators using class
	    driver.findElement(By.className("form-control"));
	    
	   // Xpath with (link text)
	    driver.findElement(By.xpath("//div[contains(@id,'contact-link')]//a[@href ='http://automationpractice.com/index.php?controller=contact']")); 
	WebElement str = 	driver.findElement(By.tagName("a"));
	System.out.println(str);
	
	System.out.println("sasi changed");
	}
}
