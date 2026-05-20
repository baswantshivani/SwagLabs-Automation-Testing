package SwagLabsTestCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import SwagLabsRepository.HomePage;
import SwagLabsRepository.LoginPage;
import SwagLabsRepository.ProductDetails;

public class VerifyProductList extends Utility {

	LoginPage objlogin = new LoginPage();
	HomePage objhome = new HomePage();
	ProductDetails objprod = new ProductDetails();
	
	ArrayList<String> Username=dataread("D:\\Selenium\\Setup\\SwagLabs TestCases\\TestData.xlsx", "Sheet2", 0);
	ArrayList<String> Password=dataread("D:\\Selenium\\Setup\\SwagLabs TestCases\\TestData.xlsx", "Sheet2", 1);
	
	ArrayList<String> ExpProdList=dataread("D:\\Selenium\\Setup\\SwagLabs TestCases\\TestData.xlsx", "Sheet5", 0);
	
	@Test(priority=1)
	public void launchchrome()
	{
		initbrowser();
	}

	@Test(priority=2)
	public void login()
	{
		starttestcase("Verifying Product List");
		
		for(int i=0; i<Username.size(); i++)
		{
			elementfinder(objlogin.Userid).sendKeys(Username.get(i));
			elementfinder(objlogin.Password).sendKeys(Password.get(i));
			elementfinder(objlogin.loginbutton).click();
			
			ArrayList<String> ActualProdList = new ArrayList<String>();
			
            markstatus("info", "Testing List of Products with user" + Username.get(i));
            
            List<WebElement> allproducts = driver.findElements(By.xpath("//div[@data-test='inventory-item-name']"));
			
			for(int j=0; j<allproducts.size(); j++)
			{
				String temp = allproducts.get(j).getText();
				ActualProdList.add(temp);
			}
			
			for(int a=0; a<ActualProdList.size(); a++)
			{
				compare(ExpProdList.get(a), ActualProdList.get(a), "Product name displaying as expected -" + ExpProdList.get(a),
						"Product names are not displaying as expected" + ExpProdList.get(a));
			}
			
			ActualProdList.clear();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			elementfinder(objhome.menu).click();
			elementfinder(objhome.Logout).click();
			
		}
	}
}
