package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageAccount {
public WebDriver driver;
	
	//profile
	By profile = By.cssSelector("md-list-item.ng-scope:nth-child(2) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1)");
	By displayname = By.id("editDisplayNameProfile");
	By jobtitle = By.id("input_13");
	By textbox = By.id("richdiv");
	By upload = By.id("documentDropZone");
	By skillsTab = By.xpath("/html/body/div[2]/ui-view/div/div[2]/div/div/md-content/div/md-content/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]/span");
	By enterSkill = By.id("input_17");
	By add = By.xpath("//*[@id='tab-content-15']/div/md-content/div/form/button/span");
	By viewProfile = By.xpath("/html/body/div[2]/ui-view/div/div[2]/div/div/md-content/div/md-content/div/div[2]/div[2]/a/span");
	By save = By.xpath("/html/body/div[2]/ui-view/div/div[2]/div/div/md-content/div/md-content/div/div[2]/div[2]/button");
	
	
	//privacy
	By privacy = By.cssSelector("body > div.ng-scope > ui-view > div > div.content-column.left-content.margin-right12-5.flex.flex-20.layout.layout-column > div > div > md-content > md-list > md-list-item:nth-child(3) > a > div.md-list-item-text.layout.layout-column.ng-scope > div");
	By publicPhoneCheckbox = By.xpath("/html/body/div[2]/ui-view/div/div[2]/div/div/md-content/div[2]/div[1]/div/div[2]/md-checkbox/div[1]");
	By phone = By.id("input_12");
	By savePrivacy = By.xpath("/html/body/div[2]/ui-view/div/div[2]/div/div/md-content/div[1]/button");
	
	public ManageAccount(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}
	
	public WebElement getProfilePage()
	{
		return driver.findElement(profile);
	}
	public WebElement getDisplayName()
	{
		return driver.findElement(displayname);
	}
	public WebElement getJobTitle()
	{
		return driver.findElement(jobtitle);
	}
	public WebElement getTextbox()
	{
		return driver.findElement(textbox);
	}
	public WebElement getUpload()
	{
		return driver.findElement(upload);
	}
	public WebElement getSkillsTab()
	{
		return driver.findElement(skillsTab);
	}
	public WebElement getEnterSkill()
	{
		return driver.findElement(enterSkill);
	}
	public WebElement getAdd()
	{
		return driver.findElement(add);
	}
	public WebElement getViewProfile()
	{
		return driver.findElement(viewProfile);
	}
	public WebElement getSave()
	{
		return driver.findElement(save);
	}
	
	
	
	public WebElement getPrivacyTab()
	{
		return driver.findElement(privacy);
	}
	public WebElement getPhoneCheckbox()
	{
		return driver.findElement(publicPhoneCheckbox);
	}
	public WebElement getPhone()
	{
		return driver.findElement(phone);
	}
	public WebElement getSavePrivacy()
	{
		return driver.findElement(savePrivacy);
	}
	
	
}
