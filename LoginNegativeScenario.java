package SwagLabsTestCases;

import java.util.ArrayList;

import org.testng.annotations.Test;

import SwagLabsRepository.HomePage;
import SwagLabsRepository.LoginPage;

public class LoginNegativeScenario extends Utility {

	LoginPage objlogin = new LoginPage();
	HomePage objhome = new HomePage();
	
	ArrayList<String> Username=dataread("D:\\Selenium\\Setup\\SwagLabs TestCases\\TestData.xlsx", "Sheet3",0);
	ArrayList<String> Password=dataread("D:\\Selenium\\Setup\\SwagLabs TestCases\\TestData.xlsx", "Sheet3",1);
	
	@Test(priority=1)
	public void launchchrome()
	{
		initbrowser();
	}
	
	@Test(priority=2)
	public void login()
	{
		for(int i=0; i<Username.size(); i++)
		{
			elementfinder(objlogin.Userid).sendKeys(Username.get(i));
			elementfinder(objlogin.Password).sendKeys(Password.get(i));
			elementfinder(objlogin.loginbutton).click();
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			elementfinder(objhome.menu).click();
			elementfinder(objhome.Logout).click();
		}
	}
	
}
