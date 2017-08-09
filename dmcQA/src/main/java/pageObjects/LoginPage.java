package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
public WebDriver driver;

	String Selenium_User1 = "dmctest.uilabs@gmail.com";
	String Selenium_Pass1 = "ilvqQ.;%Q*Ce=U6X4?4$";

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
	
	//Site: https://uilabs.idp.cirrusidentity.com/module.php/core/loginuserpass.php?AuthState=_a6f3506db4fd21bfd29316061cc77ee74d8e74cfb0%3Ahttps%3A%2F%2Fuilabs.idp.cirrusidentity.com%2Fsaml2%2Fidp%2FSSOService.php%3Fspentityid%3Dhttps%253A%252F%252Fdev-web1.opendmc.org%252Fshibboleth%26cookieTime%3D1501467976%26RelayState%3Dss%253Amem%253Ad956c692306bdb16483d8b3ace7e3adaaf1de97357f1a85784da77afc159b476
	//Site: https://accounts.google.com/signin/oauth/identifier?client_id=220522369979-opd8pck88l8mms84jsr03v4o079ohi7s.apps.googleusercontent.com&as=54a6df65463e617e&destination=https%3A%2F%2Fprojectdmc-dev-web1.cirrusidentity.com&approval_state=!ChRKRTVIMms3Qzd5c2ZMdVlJVzBlcRIfZzlxWXNMdmJhM0FVa0FoVURVeHIzUl9LMG5objJSVQ%E2%88%99ADiIGyEAAAAAWX_m4_fTxYfIAK7JV02dYxayRS18jJT4&passive=1209600&oauth=1&sarp=1&scc=1&xsrfsig=AHgIfE9u4zd5a65I1HVNMYc3Z6P8vpcHBA&flowName=GeneralOAuthFlow

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
