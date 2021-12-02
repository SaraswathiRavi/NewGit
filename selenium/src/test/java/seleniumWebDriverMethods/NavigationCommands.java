package seleniumWebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {
	public static void main(String[] args) {    
    	System.setProperty("webdriver.chrome.driver","D:\\Selenium Chrome jar files\\chromedriver_win32 (1)\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver(); 
	   // driver.manage().window().maximize();
            driver.get("https://www.javatpoint.com/");          // Navigate the URL path by string method
            driver.findElement(By.xpath("//div[@id='link']//a[contains(text(),'Python')]")).click(); 
            driver.navigate().back();           // navigate to the previous through browser history
            driver.navigate().forward();           // Navigate to the next page through browser history, it happened only after the back method
            driver.navigate().to("//div[@id='link']//a[contains(text(),'Python')]");  
            driver.navigate().refresh();           // the refresh method refresh the current web page in the window
            driver.close();   
    }  
	

}
