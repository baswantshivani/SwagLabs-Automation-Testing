package SwagLabsTestCases;

import java.util.ArrayList;

import org.testng.annotations.Test;

import SwagLabsRepository.HomePage;
import SwagLabsRepository.LoginPage;
import SwagLabsRepository.ProductDetails;

public class VerifySauceLabsRedTshirt extends Utility {

	LoginPage objlogin = new LoginPage();
	HomePage objhome = new HomePage();
	ProductDetails objprod = new ProductDetails();
	
	ArrayList<String> Username = dataread("D:\\Selenium\\Setup\\SwagLabs TestCases\\TestData.xlsx","Sheet2",0);
	ArrayList<String> Password = dataread("D:\\Selenium\\Setup\\SwagLabs TestCases\\TestData.xlsx","Sheet2",1);
	
	ArrayList<String> expProdDetails = dataread("D:\\Selenium\\Setup\\SwagLabs TestCases\\TestData.xlsx","Sheet4",5); 
	
	@Test(priority=1)
	public void launchchrome()
	{
		initbrowser();
	}
	
	@Test(priority=2)
	public void login()
	{
		starttestcase("Verifying Sauce Labs Red T-shirt Details");
		
		for(int i=0; i<Username.size(); i++)
		{
			elementfinder(objlogin.Userid).sendKeys(Username.get(i));
			elementfinder(objlogin.Password).sendKeys(Password.get(i));
			elementfinder(objlogin.loginbutton).click();
			
			elementfinder(objhome.SaucelabsTshirt).click();
			
			ArrayList<String> actualProdDetails = new ArrayList<String>();
			
			actualProdDetails.add(elementfinder(objprod.Productname).getText());
			actualProdDetails.add(elementfinder(objprod.Productdesc).getText());
			actualProdDetails.add(elementfinder(objprod.ProductPrice).getText());
			
			markstatus("info", "Sauce Labs Red T-shirt Details with user - " + Username.get(i));
			
			for(int j=0; j<actualProdDetails.size(); j++)
			{
				compare(expProdDetails.get(j), actualProdDetails.get(j), "Product details are as expected" + " - " + expProdDetails.get(j), 
						"Product details are not as expected" + " - " + expProdDetails.get(j));
			}	
		
		elementfinder(objhome.menu).click();
		elementfinder(objhome.Logout).click();	
		
		}
	}
}
