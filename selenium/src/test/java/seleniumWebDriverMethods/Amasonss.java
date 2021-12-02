package seleniumWebDriverMethods;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amasonss {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// changess
		WebDriverManager.chromedriver().setup();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the catergory to find the product =");
		String catergory = scan.nextLine();
		System.out.println("Enter the textToSelect to find the product =");
		String textToSelect = scan.nextLine();
System.out.println("Enter the itemName to find the product =");
		String itemName = scan.nextLine();
		//scan.nextLine();
		//String Product_toSelect = scan.next();
		
        int index = 2;
		WebDriver drive = new ChromeDriver();
		drive.get("https://www.amazon.in/");
		drive.manage().window().maximize();

		// Click on Country Dropdown
		WebElement AllCat = drive.findElement(
				By.xpath("//select[@id='searchDropdownBox']//option[contains(text(),'" + catergory + "')]"));
		drive.findElement(By.id("nav-search-dropdown-card")).click();
		List<WebElement> allOptions = (List<WebElement>) drive
				.findElements(By.xpath("//select[@id='searchDropdownBox']//option"));
		System.out.println("No:of catergory list = " + allOptions.size());
		for (WebElement ListofCategory : allOptions) {
			System.out.println(ListofCategory.getText());
			if (AllCat.isDisplayed()) {
				AllCat.click();
				// continue;
			} else {
				catergory = "All Categories";
				AllCat.click();
			}
			continue;
		}
		// search the product
		for (int j = 0; j <= textToSelect.length(); j++) {
			System.out.println(textToSelect.substring(0, j));
			drive.findElement(By.id("twotabsearchtextbox")).clear();
			drive.findElement(By.id("twotabsearchtextbox")).sendKeys(textToSelect.substring(0, j));
			Thread.sleep(2000);
			List<WebElement> optionsToSelect = drive
					.findElements(By.xpath("//div[@id ='nav-flyout-searchAjax']//div[@class ='s-suggestion']"));
			for (WebElement element : optionsToSelect) {

				System.out.println(element.getText());
			}
		}
		drive.findElement(By.id("nav-search-submit-button")).click();//click the search icon
		
		//select the product
		WebElement currentItemfound = null ;
		List<WebElement>  list = drive.findElements(
				By.xpath("//div[contains(@class,'s-main-slot')]//div[@data-component-type='s-search-result']"));
		for(WebElement lis : list) {
			String itemxpath = "//div[@data-index='" + lis.getAttribute("data-index") + "']//h2//span";//gives the index of the product
			//System.out.println("item xpath ="+itemxpath);
            System.out.println("Lis text"+lis.getText());//lis and item name are same
			WebElement currentItem = drive.findElement(By.xpath(itemxpath));
			System.out.println("currentItem ="+currentItem);
			String itemName1 =currentItem.getText();//gives the text of the product
			//System.out.println("item name ="+itemName1);
			if(itemName1.toLowerCase().equals(itemName.toLowerCase())) {	
				currentItemfound=currentItem;
				currentItemfound.click();
			}
		}	
		
	/*	
	WebElement	nameOfProduct =drive.findElement(By.xpath("//div[@data-index ='"+index+"']"));
		String nameOfProducts =nameOfProduct.getText();
		System.out.println(nameOfProducts);
		nameOfProduct.click();
	*/
		  
		//window handle
		String parent=drive.getWindowHandle();
		System.out.println("parent= "+parent);
		Set<String>s=drive.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{	
		String child_window=I1.next();
		
		System.out.println("Child URl= "+child_window);
		if(!parent.equals(child_window))
		{
		drive.switchTo().window(child_window);
		System.out.println(drive.switchTo().window(child_window).getTitle());
		}
		}
		
		//drive.findElement(By.id("add-to-cart-button")).click();
		//drive.findElement(By.xpath("//span[@id='nav-cart-count']")).click();
		//switch to the parent window
		//drive.switchTo().window(parent);

	}

	private static WebElement click() {
		// TODO Auto-generated method stub
		return null;
	}
}
