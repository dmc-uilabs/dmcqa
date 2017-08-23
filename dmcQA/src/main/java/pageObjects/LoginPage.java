package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
public WebDriver driver;


	By emailUILabs = By.id("cred_userid_inputtext");
	By passwordUILabs=By.id("cred_password_inputtext");
	By keepMeSignedInUILabs=By.id("cred_keep_me_signed_in_checkbox");
	By signinUILabs=By.id("cred_sign_in_button");

	By emailUILabsGuest = By.id("username");
	By pwUILabsGuest = By.id("password");
	By submitUILabsGuest = By.xpath("/html/body/div[1]/div[2]/div/form/div/div[3]/input");

	By emailGoogle = By.id("identifierId");
	By nextGoogle = By.id("identifierNext");
	By pwGoogle = By.cssSelector("input[type='password']");
	By submitGoogle = By.id("passwordNext");
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;

	}

	public WebElement getEmailUILabs()
	{
		return driver.findElement(emailUILabs);
	}

	public WebElement getPasswordUILabs()
	{
		return driver.findElement(passwordUILabs);
	}
	public WebElement getKeepMeSignedInUILabs()
	{
		return driver.findElement(keepMeSignedInUILabs);
	}
	public WebElement getSignInUILabs()
	{
		return driver.findElement(signinUILabs);
	}


	public WebElement getEmailUILabsGuest()
	{
		return driver.findElement(emailUILabsGuest);
	}

	public WebElement getpwUILabsGuest()
	{
		return driver.findElement(pwUILabsGuest);
	}
	public WebElement getSubmitUIGuest()
	{
		return driver.findElement(submitUILabsGuest);
	}


	public WebElement getEmailGoogle()
	{
		return driver.findElement(emailGoogle);
	}

	public WebElement getPasswordGoogle()
	{
		return driver.findElement(pwGoogle);
	}
	public WebElement getNextGoogle()
	{
		return driver.findElement(nextGoogle);
	}
	public WebElement getSignInGoogle()
	{
		return driver.findElement(submitGoogle);
	}

}
