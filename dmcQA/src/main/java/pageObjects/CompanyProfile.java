package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompanyProfile {
	public WebDriver driver;

	By details = By.xpath("/html/body/div[2]/div/md-content/div[4]/div[2]/div[1]/div/div[3]/div[2]/a");
	By verifyUser = By.xpath("/html/body/div[2]/div/md-content/div[4]/div[2]/div[1]/div/div[4]/div[2]/button[3]");
	By finalVerify = By.cssSelector("button[ng-click='emailToken()']");
	By catchToken = By.xpath("//*[@id='dialog_38']/md-content/div[1]/h4");
	By close = By.cssSelector("button[ng-click='cancel()']");
	
	public CompanyProfile(WebDriver driver) {
		//Auto-generated constructor stub
		this.driver=driver;
	}

	
	public WebElement seeUserDetails()
	{
		return driver.findElement(details);
	}
	public WebElement acceptRequest()
	{
		return driver.findElement(verifyUser);
	}
	public WebElement finalizeVerification()
	{
		return driver.findElement(finalVerify);
	}
	public WebElement saveVerificationToken()
	{
		return driver.findElement(catchToken);
	}
	public WebElement closePopUp()
	{
		return driver.findElement(close);
	}
}
