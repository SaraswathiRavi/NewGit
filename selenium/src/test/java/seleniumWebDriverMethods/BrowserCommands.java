package seleniumWebDriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommands {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Selenium Chrome jar files\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		/*BROWSER COMMANDS(6)
		 * driver.get("url");
		 * driver.getTitle();
		 * driver.getCurrentUrl();
		 * driver.getPageSource();
		 * driver.close();
		 * driver.quit();
		 */
		
		//1...driver.get() command
		driver.get("https://demoqa.com/");
		
		//maximize the window
		driver.manage().window().maximize();
		
		
		//2...driver.gettitle()command
		String pageTitle = driver.getTitle();
		System.out.println("the title of the page is:"+pageTitle);
		
		//3...driver.getCurrentUrl()command
		 String CurrentUrl = driver.getCurrentUrl();
		 System.out.println("the current url is:"+CurrentUrl);
		 
		 
		 //4...driver.getPageSource()command
		 String PageSource = driver.getPageSource();  
		 System.out.println("the page source is:"+PageSource);
		 
		 //5...driver.close()
		driver.close();
		 //6...driver.quit()
		// driver.quit();
	}

}
