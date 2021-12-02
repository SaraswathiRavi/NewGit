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

public class HtmlPractice2 {

	public void Alldatass(WebDriver driver) throws InterruptedException {
		for (int i = 1; i <= 6; i++) {
			driver.findElement(By.xpath("//a[@data-dt-idx=" + i + "]")).click();
			getData(driver);
			pagess(driver);
			Thread.sleep(6000);
		}
	}
	public void reversedatass(WebDriver driver) throws InterruptedException {
		for (int i =6; i >= 1; i--) {
			System.out.println("Read from reverse");
		
			driver.findElement(By.xpath("//a[@data-dt-idx=" + i + "]")).click();
			getData(driver);
			pagess(driver);
			Thread.sleep(6000);
		}
	}
	public void Singledatass(WebDriver driver) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the value");
		int Startnum=scan.nextInt();
		for (int i = Startnum; i <= Startnum; i++) {
			driver.findElement(By.xpath("//a[@data-dt-idx=" + i + "]")).click();
			getData(driver);
			pagess(driver);
			Thread.sleep(6000);
		}
	}

	public void rangedatass(WebDriver driver) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the value for range");
		int Startnum=scan.nextInt();
		int Endnum =scan.nextInt();
		for (int i = Startnum; i <= Endnum; i++) {
			driver.findElement(By.xpath("//a[@data-dt-idx=" + i + "]")).click();
			getData(driver);
			pagess(driver);
			Thread.sleep(6000);
		}
	}
	public void pagess(WebDriver driver) {
		List<WebElement> PagesList = driver.findElements(By.xpath("//div[@id ='example_paginate']//span//a"));
		for (WebElement Pag : PagesList) {
			if (Pag.getAttribute("class").contains("current")) {
				System.out.println("Number: of the Page selected:" + Pag.getText());

				break;
			}
		}
	}

	public void getData(WebDriver driver) {
		HashMap<String, String> Inner = new HashMap<String, String>();// table, datas
		List<WebElement> rowdatas = driver.findElements(By.xpath("//table[@id ='example']//tbody//tr"));// datas(row)
		List<WebElement> Tablename = driver.findElements(By.xpath("//table[@id='example']//thead//th"));// table name
		// List<WebElement> ColumnWise = driver.findElements(By.xpath("//table[@id
		// ='example']//td/.."));
		int j=1;
		//driver.findElement(By.xpath("//a[@data-dt-idx=" + j + "]")).click();
		for (WebElement datass : rowdatas) {// navigate row wise
			//driver.findElement(By.xpath("//a[@data-dt-idx=" + j + "]")).click();
			List<WebElement> data = datass.findElements(By.xpath(".//td"));
			for (int i = 0; i <= data.size() - 1; i++) {
				Inner.put(Tablename.get(i).getText(), data.get(i).getText());
			}
			System.out.println("Haspmap");
			Outer(Inner, j);
			j += 1;
		}
	}

	public void Outer(HashMap<String, String> Inner, int j) {
		HashMap<Integer, HashMap<String, String>> Outer = new HashMap<Integer, HashMap<String, String>>();
		Outer.put(j, Inner);
		System.out.println(Outer);
	}

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws InterruptedException {
		HtmlPractice hp = new HtmlPractice();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://datatables.net/examples/data_sources/dom");

		ArrayList<String> Selections =new ArrayList<String>();
		Selections.add("ALL") ;
		Selections.add("single");
		Selections.add("Range");
		Selections.add("Reverse");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the oprtion to Select");
		String options=scan.next();
		System.out.println(Selections);
		HtmlPractice2 hp1 = new HtmlPractice2();
		//System.out.println(Selections.get(1));
		if(Selections.get(0).equalsIgnoreCase(options)){
			hp1.Alldatass(driver);
		}else if(Selections.get(1).equalsIgnoreCase(options)){
			hp1.Singledatass(driver);
		}else if(Selections.get(2).equalsIgnoreCase(options)){
			hp1.rangedatass(driver);
		}else if(Selections.get(3).equalsIgnoreCase(options)){
			hp1.reversedatass(driver);
		}
		}
		
		
	}


