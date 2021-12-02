package selenium2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class HtmlPractice {
	public void datass(WebDriver driver,int count) {
		// TODO Auto-generated method stub
		HashMap<String,String> Inner =new HashMap<String,String>();//table, datas
		
		
		List<WebElement> rowdatas = driver.findElements(By.xpath("//table[@id ='example']//tbody//tr"));//datas(row)
		List<WebElement> Tablename = driver.findElements(By.xpath("//table[@id='example']//thead//th"));//table name
	    List<WebElement> ColumnWise = driver.findElements(By.xpath("//table[@id ='example']//td/.."));
		//for(int j=0;j<=ColumnWise.size()-1;j++) {
	    int j=0;
	    
		for(WebElement datass :rowdatas ) {//navigate row wise
		List <WebElement> data =datass.findElements(By.xpath(".//td"));
			for(int i =0; i<=data.size()-1;i++) {
			Inner.put(Tablename.get(i).getText(),data.get(i).getText());
			//count +=.1;
		}
			//count +=.1
			System.out.println("Haspmap");
			j+=1;
			
			Outer(Inner,j);
		}
		
		}
	private void Outer(HashMap<String,String> Inner,int j) {
		HashMap<Integer,HashMap<String,String>> Outer=new HashMap<Integer,HashMap<String,String>> ();
		Outer.put( j , Inner);
		System.out.println(Outer);
	}
	//}
	
	public void pagess(WebDriver driver) {
		List<WebElement> PagesList = driver.findElements(By.xpath("//div[@id ='example_paginate']//span//a"));
		for (WebElement Pag : PagesList) {
			if(Pag.getAttribute("class").contains("current"))
					{
				System.out.println("Number: of the Page selected:"+Pag.getText());
				
				break;
			}	 
		}
	}
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws InterruptedException {
		
		HtmlPractice hp = new HtmlPractice();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://datatables.net/examples/data_sources/dom");
		int Startnum =1;
		int Endnum = 6;
		Scanner scan = new Scanner(System.in);
		System.out.println("Select the option to display the data:\n 1.Select all option\n 2.Select the single option \n 3.Select fron a rage of option");	
	int n =scan.nextInt();
		switch (n) {
		case 1://all
			Startnum =1;
			Endnum = 6;
			break;
        case 2://any
        	System.out.println("Enter the single page to display the details:");
        	Startnum = scan.nextInt();
         Endnum =Startnum;
			break;
        case 3://range
        	System.out.println("Enter the start Range nad the end Range of the page to display the data:");
        	Startnum =scan.nextInt();
			Endnum = scan.nextInt();
	         break;
		default:
			break;
		}
				
		for(int i1=Startnum ; i1<=Endnum ;i1++) {
	    driver.findElement(By.xpath("//a[@data-dt-idx="+i1+"]")).click();
		hp.datass(driver,i1);
		//gets the data and print 
		hp.pagess(driver);//get the page number 
		Thread.sleep(8000);
		
		}
		
	}

	
}
