package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Profile {
public WebDriver driver;
	
	By contacttab = By.xpath("/html/body/div[2]/div/md-content/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]/span");
	By phone = By.id("input_11");
	
	//Site: https://dev-web2.opendmc.org/account.php#/543/profile
	public Profile(WebDriver driver) {
		// Auto-generated constructor stub
		this.driver=driver;
	}
	
	public WebElement getContactTab()
	{
		return driver.findElement(contacttab);
	}
	public WebElement getPhoneDisplayed(){
		return driver.findElement(phone);
	}
}
