package seleniumWebDriverMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonTolistSearchProduct {

	private static final String Index = null;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
Scanner scan = new Scanner (System.in);
		
		System.out.println("Enter the catergory to find the product =");
		String catergory ="Books";
		//String Product_toSelect = scan.next();
		String textToSelect = "kids comics";
		int IndexNumber = 1;
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Chrome jar files\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver drive = new ChromeDriver();
		drive.get("https://www.amazon.in/");
		
		drive.manage().window().maximize();
		
		
		//click the drop down
		Select sel = new Select (drive.findElement(By.id("searchDropdownBox")));
		sel.selectByVisibleText(catergory);
		//search the product stored in the string
		
	//Thread.sleep(5000);
for( int j =1 ; j<=textToSelect.length(); j++) {
		
		System.out.println(textToSelect.substring(0, j));
		drive.findElement(By.id("twotabsearchtextbox")).clear();
		drive.findElement(By.id("twotabsearchtextbox")).sendKeys(textToSelect.substring(0, j));
		Thread.sleep(2000);
	List<WebElement> optionsToSelect = drive.findElements(By.xpath("//div[@id ='nav-flyout-searchAjax']//div[@class ='s-suggestion']"));
	for(WebElement element : optionsToSelect){

	   System.out.println(element.getText());
	}
	}

//product select one
drive.findElement(By.id("nav-search-submit-button")).click();
//drive.findElement(By.id("nav-search-submit-button")).click();

for(int i =1 ; i<= IndexNumber ;i++) {
List<WebElement> proToAdded=drive.findElements(By.xpath("//img[@data-image-index ='"+IndexNumber+"']"));    
for(WebElement ele:proToAdded) { 
	System.out.println(ele.getText());
	ele.click();
}


String Url = drive.getCurrentUrl();
String id = drive.getWindowHandle();
// System.out.println("Window Handle=" +id); //gives the object id
System.out.println("Child url= "+ Url);// giving child window // gives the url

Set<String>   Urls  = drive.getWindowHandles();

System.out.println(Urls);

//second product

}
//drive.findElement(By.xpath("//span[normalize-space()='The Illustrated Stories Of Akbar and Birbal: Classic Tales From India']")).click();
//ArrayList<String> tabs2 = new ArrayList<String>(drive.getWindowHandles());
//drive.switchTo().window(tabs2.get(2));
drive.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
drive.findElement(By.xpath("//span[@id='nav-cart-count']")).click();
java.util.List<WebElement> cartOption1=drive.findElements(By.xpath("//div[@data-name='Active Items']//div[@class='sc-list-item-content']//span[@class='a-truncate-cut']"));   //cart items are stored in this list
float total=0.00f;
for(WebElement ele:cartOption1) { 
	//System.out.println("hi");//iteration for cart products
	
	if((ele.getText().contains("Vikram and Betaal (Illustrated) – Updated edition 2021")) &&(ele.getText().contains("Cat Kid Comic Club")))
			{
		System.out.println("the given item is added in cart");
		//continue;
		}
	System.out.println(ele.getText()+" price :"+ele.findElement(By.xpath("..//ancestor::div[@class='sc-list-item-content']//p[@class='a-spacing-mini']")).getText());
	String amo=ele.findElement(By.xpath("..//ancestor::div[@class='sc-list-item-content']//p[@class='a-spacing-mini']")).getText();
	total=total+Float.parseFloat(amo);
	}
System.out.println("No Of product at last ="+cartOption1.size());
	}

}
