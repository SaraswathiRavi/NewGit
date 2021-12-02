package seleniumWebDriverMethods;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class websitesAtomationMethods {
	 static void UpToWindowMax(int a) {
		
		 // TODO Auto-generated method stub
		 WebDriverManager.chromedriver().setup();
			Scanner scan = new Scanner(System.in);

			System.out.println("Enter the catergory to find the product =");
			String catergory = "Books";
			// String Product_toSelect = scan.next();
			String textToSelect = "kids comics";

			WebDriver drive = new ChromeDriver();
			drive.get("https://www.amazon.in/");
			drive.manage().window().maximize();
		 
		 java.util.List<WebElement> list = drive.findElements(
					By.xpath("//div[contains(@class,'s-main-slot')]//div[@data-component-type='s-search-result']"));
			System.out.println(list.size());
			WebElement item = null;
			boolean itemFound = false;
			for (WebElement li : list) {
				String itemxpath = "//div[@data-index='" + li.getAttribute("data-index") + "']//h2//span";
				WebElement currentItem = drive.findElement(By.xpath(itemxpath));
				String itemName =currentItem.getText();

				System.out.println(itemName);
				// System.out.println(li.getText());
				if (itemFound)
					continue;
				if(itemName.toLowerCase().contains(sc.toLowerCase())) {
					item =currentItem;
					itemFound = true;
				}
			}
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 }
}
