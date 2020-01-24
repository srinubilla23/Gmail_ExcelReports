package resultinExcel;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Gmailvalidation 
{
	WebDriver driver;
	  @Parameters({"Browser"})	
	  @Test(priority = 1) // Describe Browser
	  public void openBrowser(String Browser)
	  {
		  System.out.println("Enter Browser Name: "+ Browser);
		  Scanner sc=new Scanner(System.in);
		  String str=sc.nextLine();
		  
		  if (str.equalsIgnoreCase("c")) {
				System.setProperty("webdriver.chrome.driver", "E:\\Jar Files\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (str.equalsIgnoreCase("f")) {
				System.setProperty("webdriver.gecko.driver", "E:\\Jar Files\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (str.equalsIgnoreCase("f")) {
				System.setProperty("webdriver.ie.driver", "E:\\Jar Files\\Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	  }
	  
	  @Parameters({"search"})
	  @Test(priority = 2) // This is Browser Link
	  public void link(String search) throws Exception
	  {
		  driver.get(search);
	  }
	  
	  @Test
	  public void Excelvalues() throws Exception
	  {
		  File f=new File("F:\\EclipseProject\\ex.xlsx");
		  Workbook wb=Workbook.getWorkbook(f);
		  Sheet sh=wb.getSheet(0);
		  int row=sh.getRows();
		  int col=sh.getColumns();
	  }
	   
}
