package automationtesting;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Home;
import pageObjects.ManageAccount;
import pageObjects.Profile;
import resources.base;

public class accountContactTest extends base {
	
	
	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();		
		driver.get(prop.getProperty("url"));
		login(driver);
	}
	
	//My Account Settings - Contact Information
	@Test
	public static void myAccount(){
		String phoneNum = "5555555555";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //wait
        driver.navigate().refresh();
		 
        sleepThreadWait();
       
        Home home = new Home(driver);
        ManageAccount privacy = new ManageAccount(driver);
        
         
        home.getUserMenu().click();
       
         
        sleepThreadWait2();
        /*	//Verify that it is on correct page
		String pageTitle = driver.getTitle();
		System.out.println("Reached to " + pageTitle);
		Assert.assertTrue(pageTitle.contains("Manage Account"));*/
        
        home.getMyAccount().click();
		
        //Click on Privacy tab
        privacy.getPrivacyTab().click();
		
		sleepThreadWait2(); //wait

		//Validate whether phone checkbox is selected by default
		System.out.println("Before Clicking: Is Phone Checkbox Selected: " + privacy.getPhoneCheckbox().isSelected());

		sleepThreadWait(); //wait

		privacy.getPhoneCheckbox().click();
		System.out.println("After Clicking: Is Phone Checkbox Selected:  " + privacy.getPhone().isDisplayed());

		sleepThreadWait2(); //wait
		
		//Enter in Contact Information
		enterContactInfo(driver, wait, phoneNum, privacy);

		//Remove Contact information
		removeContactInfo(driver, wait, phoneNum, privacy);

		

	}//end of myAccount

	public static void enterContactInfo(WebDriver driver, WebDriverWait wait, String phoneNum, ManageAccount privacy){
		//Enter in Phone Number
		System.out.println("Entering in Contact Information");
		privacy.getPhone().sendKeys(phoneNum);
		
		//Hit the Save button
		privacy.getSavePrivacy().click();
		System.out.println("Added Phone Number:" + phoneNum);

		sleepThreadWait2(); //wait
	
		//check in my profile if the contact information is visible
		System.out.println("Currently on " + driver.getTitle() + " Page"); //check page
		
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		sleepThreadWait2(); //wait
		driver.get("https://portal.opendmc.org/profile.php#/542");
		
		System.out.println("Currently on " + driver.getTitle() + " Page"); //check page
		
		sleepThreadWait2(); //wait
		
		Profile p = new Profile(driver);
		p.getContactTab().click();
		
		System.out.println("Is Phone Number Visible: " + p.getPhoneDisplayed().isDisplayed());

	}//end of enterContactInfo()
	
	public static void removeContactInfo(WebDriver driver, WebDriverWait wait, String phoneNum, ManageAccount privacy){
		System.out.println("Removing Contact Information");
		
		driver.navigate().to("https://portal.opendmc.org/account.php#/542/basics");
		sleepThreadWait2(); //wait
		
	     //Click on Privacy tab
        privacy.getPrivacyTab().click();
		//clear number
		sleepThreadWait2(); //wait
		privacy.getPhone().clear();
	
		
		//Unclick and Save
		privacy.getPhoneCheckbox().click();
		privacy.getSavePrivacy().click();
		System.out.println("Removed Phone Number:" + phoneNum);

		sleepThreadWait2(); //wait

		//check in my profile if the contact information is visible
		//System.out.println("Currently on " + driver.getTitle() + " Page"); //check page
		
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		sleepThreadWait2(); //wait
		driver.get("https://portal.opendmc.org/profile.php#/538");
		
		//System.out.println("Currently on " + driver.getTitle() + " Page"); //check page
		sleepThreadWait2(); //wait
		Profile p = new Profile(driver);
		p.getContactTab().click();
		//System.out.println("Is Phone Number Visible: " + driver.findElement(By.xpath("//*[@id='input_5']")).isDisplayed());

	}//end of removeContactInfo()
	
	
}
