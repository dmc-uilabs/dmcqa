package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {
	public WebDriver driver;

	By title  = By.xpath("/html/body/div[2]/div/div/div[1]/h1");
	By user_menu = By.id("user-menu");
	By myaccount = By.id("my-account");
	By myorganization = By.id("my-organization");
	By logout = By.id("logout");
	By workspacestab = By.xpath("//*[@id='workspaces']/span");
	By notifyIcon = By.id("notifications");
	By request = By.cssSelector("md-menu-item[ng-if='item.unread']");
	
	By about = By.xpath("//*[@id='about']/span");
	By academia = By.id("academia");
	
	//Site: https://dev-web2.opendmc.org/#/
	//By NavBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	public Home(WebDriver driver) {
		//Auto-generated constructor stub
		this.driver=driver;
	}
	
	public WebElement getAboutFromNavBar()
	{
		return driver.findElement(about);
	}
	public WebElement getAcademiaTab()
	{
		return driver.findElement(academia);
	}
	public WebElement getUserMenu()
	{
		return driver.findElement(user_menu);
	}
	public WebElement getMyAccount()
	{
		return driver.findElement(myaccount);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getWorkspacesTab()
	{
		return driver.findElement(workspacestab);
	}
	public WebElement seeNotifications()
	{
		return driver.findElement(notifyIcon);
	}
	public WebElement goToRequest()
	{
		return driver.findElement(request);
	}
	public WebElement logout()
	{
		return driver.findElement(logout);
	}
	
}
