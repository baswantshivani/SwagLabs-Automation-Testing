package SwagLabsTestCases;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Utility {

	ExtentHtmlReporter htmlReporter;
	ExtentTest logger;
	ExtentReports report;
    WebDriver driver;
	
	public void initbrowser()
	{
		String browsername;
		String ApplicationLink;
		
		try
		{
		FileInputStream fs = new FileInputStream("D:\\Selenium\\Setup\\SwagLabs TestCases\\TestData.xlsx"); //path of file;
				XSSFWorkbook workbook = new XSSFWorkbook(fs); //opens workbook
				XSSFSheet objsheet = workbook.getSheet("Sheet1"); //gets to a particular sheet
				
				XSSFRow objrow = objsheet.getRow(1);
				
				browsername = objrow.getCell(0).getStringCellValue();
				ApplicationLink=objrow.getCell(1).getStringCellValue();
				
				if(browsername.equals("Chrome"))
				{	
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--incognito");
					
					driver=new ChromeDriver(options);
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
					
				}
				else 
				{
					//to launch other browser
				}
					
				driver.get(ApplicationLink);
				
				workbook.close();
				fs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	
	public WebElement elementfinder(By objby)
	{
		WebElement temp = driver.findElement(objby);
		return temp;
	}
	

	public ArrayList<String> dataread(String filepath, String Sheetname, int cellno)
	{
		ArrayList<String> obja = new ArrayList<String>();
		
		try
		{
			FileInputStream fs = new FileInputStream(filepath); //path of file;
			XSSFWorkbook workbook = new XSSFWorkbook(fs); //opens workbook
			XSSFSheet objsheet = workbook.getSheet(Sheetname); //gets to a particular sheet
			
			
			int rowcount = objsheet.getLastRowNum();
		
			for(int i=1; i<=rowcount; i++)
			{
				XSSFRow objrow = objsheet.getRow(i);
                String value = objrow.getCell(cellno).getStringCellValue();	
                obja.add(value); 
			}			

			workbook.close();
			fs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return obja;
	}
	
	@BeforeSuite
	public void initreport()
	{
		String timeStamp=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());//to give date format for the file
		htmlReporter = new ExtentHtmlReporter("D:\\Selenium\\Setup\\SampleReports\\latestreport "+timeStamp+".html" );
		//Location of the folder
		//To maintain the uniqueness in the file name we give timestamp
		report=new ExtentReports(); //creating object of extentreports
		report.attachReporter(htmlReporter);
	}
	
	public void starttestcase(String testcasename)
	{
		logger=report.createTest(testcasename);
	}
	
	public void markstatus(String Statusname, String Description)
	{
		if(Statusname.equalsIgnoreCase("PASS"))
		{
			logger.log(Status.PASS, Description);
		}
		else if(Statusname.equalsIgnoreCase("FAIL"))
		{
			logger.log(Status.FAIL, Description);
		}
		else if(Statusname.equalsIgnoreCase("INFO"))
		{
			logger.log(Status.INFO, Description);
		}
	}
	
	public void compare(String expected, String actual, String passmessage, String failmessage)
	{
		if(expected.equals(actual))
		{
			markstatus("PASS", passmessage);
		}
		else
		{
			markstatus("FAIL", failmessage);
		}
	}
	
	@AfterSuite
	public void endreport()
	{
		report.flush();
	}
}
