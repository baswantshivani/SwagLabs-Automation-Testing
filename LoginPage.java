package SwagLabsRepository;

import org.openqa.selenium.By;

public class LoginPage {

	public By Userid=By.id("user-name");
	public By Password=By.name("password");
	public By loginbutton=By.name("login-button");
	public By errormsg=By.xpath("//h3[@data-test='error']");
}
