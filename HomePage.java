package SwagLabsRepository;

import org.openqa.selenium.By;

public class HomePage {

	public By menu=By.className("bm-burger-button");
	public By Logout=By.id("logout_sidebar_link");
	public By SaucelabsBackpack=By.xpath("//div[starts-with(text(),'Sauce Labs Backpack')]");
	public By SaucelabsBikeLight=By.xpath("//div[starts-with(text(),'Sauce Labs Bike Light')]");
	public By SaucelabsBoltTshirt=By.xpath("//div[starts-with(text(),'Sauce Labs Bolt T-Shirt')]");
	public By SaucelabsFleeceJacket=By.xpath("//div[starts-with(text(), 'Sauce Labs Fleece Jacket')]");
	public By SaucelabsOnesie=By.xpath("//div[starts-with(text(), 'Sauce Labs Onesie')]");
	public By SaucelabsTshirt=By.xpath("//div[starts-with(text(), 'Test.allTheThings() T-Shirt (Red)')]");
}
