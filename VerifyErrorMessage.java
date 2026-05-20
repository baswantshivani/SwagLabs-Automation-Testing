package SwagLabsTestCases;

import java.util.ArrayList;

import org.testng.annotations.Test;

//import SwagLabsRepository.HomePage;
import SwagLabsRepository.LoginPage;

public class VerifyErrorMessage extends Utility {

	LoginPage objlogin = new LoginPage();
	//HomePage objhome = new HomePage();
	
	ArrayList<String> Username=dataread("D:\\Selenium\\Setup\\SwagLabs TestCases\\TestData.xlsx", "Sheet2",0);
	ArrayList<String> Password=dataread("D:\\Selenium\\Setup\\SwagLabs TestCases\\TestData.xlsx", "Sheet2",1);
	
	String experrormsg="Epic sadface: Sorry, this user has been locked.";
	
	@Test(priority=1)
	public void launchchrome()
	{
		initbrowser();
	}
	
	@Test(priority=2)
	public void login()
	{
		starttestcase("Login Negative Scenario");
		
		for(int i=0; i<Username.size(); i++)
		{
			elementfinder(objlogin.Userid).sendKeys("locked_out_user");
			elementfinder(objlogin.Password).sendKeys("secret_sauce");
			elementfinder(objlogin.loginbutton).click();
			
			String actualerrormsgL=elementfinder(objlogin.errormsg).getText();
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		compare(experrormsg, actualerrormsgL, "Error message displaying as expected","Error message mismatch");
		
		
		
		}
	}
}
