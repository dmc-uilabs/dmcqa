package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectYourInstitution {
	public WebDriver driver;
	
	By uilabs = By.cssSelector(".idp-icon-UILabs");
	By uilabsguest = By.cssSelector(".idp-icon-UILabsGuestAccount");
	By google = By.cssSelector(".idp-icon-Google");
	
	//Site: https://apps.cirrusidentity.com/console/ds/index?entityID=https://beta.opendmc.org/shibboleth&return=https://dev-web2.opendmc.org/Shibboleth.sso/Login%3Ftarget%3Dhttps%3A%2F%2Fdev-web2.opendmc.org
	
	
	public SelectYourInstitution(WebDriver driver) {
		//Auto-generated constructor stub
		this.driver=driver;
		
	}

	public WebElement getUILabs()
	{
		return driver.findElement(uilabs);
	}
	public WebElement getUILabsGuest()
	{
		return driver.findElement(uilabsguest);
	}
	public WebElement getGoogle()
	{
		return driver.findElement(google);
	}
}
