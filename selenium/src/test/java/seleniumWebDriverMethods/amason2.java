package seleniumWebDriverMethods;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class amason2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Enter the catergory to find the product =");
		String catergory =scan.next();
		String Product_toSelect = scan.next();
		//String textToSelect = scan.next();
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Chrome jar files\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver drive = new ChromeDriver();
		drive.get("https://www.amazon.in/");
		
		drive.manage().window().maximize();
		
		
		//click the drop down
		Select sel = new Select (drive.findElement(By.id("searchDropdownBox")));
		sel.selectByVisibleText(catergory);
		//search the product stored in the string
		drive.findElement(By.id("twotabsearchtextbox")).sendKeys(Product_toSelect);
		
	    
	Thread.sleep(5000);
	
	List<WebElement> optionsToSelect = drive.findElements(By.xpath("//div[@id ='nav-flyout-searchAjax']//div[@class ='s-suggestion']//span"));

	System.out.println(optionsToSelect.size());
	for(WebElement element : optionsToSelect){
		
	    System.out.println(element.getText());
	   if(element.getText().toLowerCase().equals("comics")) {
	     System.out.println("Trying to select: "+"Kids comics");
		   element.click();
	        break;
	}}
	drive.findElement(By.xpath("//span[@class ='rush-component']//a[contains(@href ,'/English-Story-Books-Kids')]")).click();
	
	
	ArrayList<String> tabs = new ArrayList<String>(drive.getWindowHandles());
	
	for(String Handles : tabs) {
		
		drive.switchTo().window(tabs.get(1));
        Thread.sleep(3000);
      
	
        }
	drive.findElement(By.id("add-to-cart-button")).click();
	//checking in cart
			drive.findElement(By.xpath("//a[@id='nav-cart']")).click();
			java.util.List<WebElement> cartOption=drive.findElements(By.xpath("//div[@data-name='Active Items']//div[@class='sc-list-item-content']//span[@class='a-truncate-cut']"));   //cart items are stored in this list
			for(WebElement ele:cartOption) {   //iteration for cart products
				if(ele.getText().toLowerCase().contains("comics")) {
					System.out.println("the given item is added in cart");
					continue;
					}
				}
 
}
	}
