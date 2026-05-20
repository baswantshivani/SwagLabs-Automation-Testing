package SwagLabsTestCases;

import java.util.ArrayList;

import org.testng.annotations.Test;

import SwagLabsRepository.HomePage;
import SwagLabsRepository.LoginPage;

public class LoginPositive extends Utility{

	LoginPage objlogin = new LoginPage();
	HomePage objhome = new HomePage();
	
	ArrayList<String> Username=dataread("D:\\Selenium\\Setup\\SwagLabs TestCases\\TestData.xlsx", "Sheet2",0);
	ArrayList<String> Password=dataread("D:\\Selenium\\Setup\\SwagLabs TestCases\\TestData.xlsx", "Sheet2",1);
	
	String expectedURL="https://www.saucedemo.com/inventory.html";
	
	@Test(priority=1)
	public void launchchrome()
	{
		initbrowser();
	}
	
	@Test(priority=2)
	public void login()
	{
		starttestcase("Login Positive Scenario");
		
		for(int i=0; i<Username.size(); i++)
		{
			elementfinder(objlogin.Userid).sendKeys(Username.get(i));
			elementfinder(objlogin.Password).sendKeys(Password.get(i));
			elementfinder(objlogin.loginbutton).click();
			
	
//	@Test(priority=2, dataProvider="loginData", dataProviderClass=TestData.class)
//	public void login(String username, String password)
//	{
//		
//		starttestcase("Login Positive Scenario" + username);
//		
//		elementfinder(objlogin.Userid).sendKeys(username);
//		elementfinder(objlogin.Password).sendKeys(password);
//		elementfinder(objlogin.loginbutton).click();
		
			String actualURL=driver.getCurrentUrl();
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		compare(expectedURL, actualURL, "Login successful with User" + Username.get(i),"Login Unsuccessful with User" + Username.get(i));
		
		elementfinder(objhome.menu).click();
		elementfinder(objhome.Logout).click();
		
		}
	}

}