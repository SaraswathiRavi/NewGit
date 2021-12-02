package seleniumWebDriverMethods;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmasonXpath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub	
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium Chrome jar files\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver drive = new ChromeDriver();
		
		drive.get("https://www.amazon.in/");
		drive.manage().window().maximize();
		
		//drive.findElement(By.xpath("//div[@id='nav-xshop']//a[contains(text(),'Mobiles')]")).click();
		//Using id
		drive.findElement(By.id("twotabsearchtextbox")).sendKeys("Watches");
		//Using id
		drive.findElement(By.id("nav-search-submit-button")).click();
		//Xpath to click the check box
		drive.findElement(By.xpath("//div[@id ='brandsRefinements']//li[contains(@aria-label,'Titan')]//i")).click();
		
		//Xpath to locate the image 
		drive.findElement(By.xpath("//span[@class ='rush-component']//a[contains(@href ,'/Titan-Karishma-Analog-Black-Watch-NK1639')]")).click();	
		ArrayList<String> tabs = new ArrayList<String>(drive.getWindowHandles());
		
		for(String Handles : tabs) {
			
			drive.switchTo().window(tabs.get(1));
            Thread.sleep(3000);
		
            }
		//xpath to check the product 
		String Text_product=drive.findElement(By.id("productTitle")).getText();
		System.out.println(Text_product);
		
		drive.findElement(By.id("add-to-cart-button")).click();
		drive.findElement(By.xpath("//a[text()='Fashion']")).click();
		drive.findElement(By.xpath("//span[contains(text(),'Bags & Luggage')]")).click();
		drive.findElement(By.xpath("//ol[@class ='sl-sobe-carousel-viewport-row-inner']//a[contains(text(),'Suitcases and more')]")).click();
		drive.findElement(By.xpath("//span[contains(text(),'American Tourister Nylon 55 cms Blue Travel Duffle (40X (0) 01 008)')]")).click();
	
		
ArrayList<String> tabs2 = new ArrayList<String>(drive.getWindowHandles());
		
for(String Handles : tabs2) {
			
			drive.switchTo().window(tabs2.get(2));
            Thread.sleep(3000);
}

        
		drive.findElement(By.id("add-to-cart-button")).click();
		//drive.findElement(By.id("hlb-ptc-btn-native")).click();
		drive.findElement(By.id("nav-cart")).click();
		drive.findElement(By.id("sc-buy-box-ptc-button")).click();
		drive.findElement(By.id("createAccountSubmit")).click();
		drive.findElement(By.id("ap_customer_name")).sendKeys("saras");
		drive.findElement(By.id("ap_phone_number")).sendKeys("8825498616");
		drive.findElement(By.id("ap_password")).sendKeys("abcs%^&%^");
		//drive.findElement(By.id("ap_password_check")).sendKeys("abcs%^&%^");
		
	drive.findElement(By.id("continue")).click();
	drive.findElement(By.xpath("//h4[contains(text(),'Are you an existing customer?')]"));
	drive.findElement(By.xpath("//h4[contains(text(),'New to Amazon?')]"));

		    
		  
		
		
		
		
	}

}
