package SwagLabsTestCases;

import org.testng.annotations.Test;

import SwagLabsRepository.HomePage;
import SwagLabsRepository.LoginPage;

public class Trial extends Utility {

	LoginPage objlogin = new LoginPage();
	HomePage objhome = new HomePage();
	
	@Test(priority=1)
	public void launchchrome()
	{
		initbrowser();
	}
	
	@Test(priority=2)
	public void login()
	{
		elementfinder(objlogin.Userid).sendKeys("standard_user");
		elementfinder(objlogin.Password).sendKeys("secret_sauce");
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
