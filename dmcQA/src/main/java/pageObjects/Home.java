package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {
	public WebDriver driver;

	By title  = By.xpath("/html/body/div[2]/main/section/div[1]/h1[1]");
	By user_menu = By.id("user-menu");
	By myaccount = By.xpath("//*[@id='my-account']/span");
	By myorganization = By.id("my-organization");
	By logout = By.id("logout");
	
	By workspacestab = By.xpath("//*[@id='workspaces']/span");
	
	//By NavBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	public Home(WebDriver driver) {
		//Auto-generated constructor stub
		this.driver=driver;
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
	public WebElement getWorkspacesTab(){
		return driver.findElement(workspacestab);
	}
}
