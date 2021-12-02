package amasonMethods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmasonMethodss {
	Scanner scan = new Scanner(System.in);

	// Method for list the catergory and Select the catergory
	public void catergory(WebDriver drive) {
		List<WebElement> optionsToSelect = drive.findElements(By.xpath("//select[@id='searchDropdownBox']//option"));
		int noOfCatergory = optionsToSelect.size();
		System.out.println("No : of catergory=" + noOfCatergory);
		for (WebElement option : optionsToSelect) {
			int index = optionsToSelect.indexOf(option);
			String Text = option.getText();
			// System.out.println("List of Catergory");
			System.out.println(index + "." + Text);}

		System.out.println("Enter the catergory number to select item = ");
		int indexToSelect = scan.nextInt();
		// optionText[option.indexOf(textToSelect)]=textToSelect.getText();
		// String textToSelect =scan.next();
		if (indexToSelect <= optionsToSelect.size()) {
			System.out.println("Trying to select based on index: " + indexToSelect);
			optionsToSelect.get(indexToSelect).click();
			// WebElement web = optionsToSelect.get(0);
//System.out.println(web.getText());
		} else {
			drive.findElement(By.xpath("//select[@id='searchDropdownBox']//option[contains(text(),'Books')]")).click();
			drive.findElement(By.xpath("//select[@id='searchDropdownBox']//option[contains(text(),'All Categories')]"))
					.click();}

	}

	// method search
	public void search(WebDriver drive) throws InterruptedException {
		
		System.out.println("Enter the product to search =");
		String textToSelect=scan.nextLine();
		textToSelect +=scan.nextLine();
		for( int j =1 ; j<=textToSelect.length(); j++) {
			System.out.print  ("Character by charater= ");
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
	drive.findElement(By.id("nav-search-submit-button")).click();}
	//drive.findElement(By.id("nav-search-submit-button")).click();
	
		//product searchlist
	public void searchList(WebDriver drive) {
		
		
java.util.List<WebElement> list = drive.findElements(
				By.xpath("//div[contains(@class,'s-main-slot')]//div[@data-component-type='s-search-result']"));
		System.out.println("No.Of product listed below After the search= "+list.size());
	//	WebElement item = null;
		boolean itemFound = false;
		for (WebElement li : list) {
			String index = li.getAttribute("data-index");
		  
			//Converting String into int using Integer.parseInt()  
			int i=Integer.parseInt(index);  
			//System.out.println(i);  
			String itemxpath = "//div[@data-index='" + index + "']//h2//span";
			WebElement currentItem = drive.findElement(By.xpath(itemxpath));
			String itemName =currentItem.getText();

			System.out.println(index+"."+itemName);
			
			// System.out.println(li.getText());
			//System.out.println(itemName);
			// System.out.println(li.getText());
      
				if(!itemFound) {
					System.out.println("Enter the index to select the product =");
				scan.nextInt();
			}
		}

		
		}

	}
	
	

