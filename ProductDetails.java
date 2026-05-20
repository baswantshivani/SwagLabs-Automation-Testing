package SwagLabsRepository;

import org.openqa.selenium.By;

public class ProductDetails {

	public By Productname=By.xpath("//div[@class='inventory_details_name large_size']");
	public By Productdesc=By.xpath("//div[@class='inventory_details_desc large_size']");
	public By ProductPrice=By.xpath("//div[@class='inventory_details_price']");
}
