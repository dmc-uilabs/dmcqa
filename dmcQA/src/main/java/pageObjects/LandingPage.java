package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Site: https://dev-web2.opendmc.org/#/
public class LandingPage {
	public WebDriver driver;
	
	By login=By.id("login");
	
	public LandingPage(WebDriver driver) {
		// Auto-generated constructor stub
		this.driver=driver;
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
}
