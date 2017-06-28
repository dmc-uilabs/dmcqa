package qaTestByArsalan;

import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import java.awt.List;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testBatch2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Create any Variables
		String Selenium_User1 = System.getenv("Selenium_User1");
		String Selenium_Pass1 = System.getenv("Selenium_Pass1");
	 	String documentLocation1 = "/home/arsalan/Desktop/Selenium/dmcqa/SeleniumLocalTests/QA-DMC/qatesting/documentUploads/office.jpg";
	 	String documentLocation2 = "/home/arsalan/Desktop/Selenium/dmcqa/SeleniumLocalTests/QA-DMC/qatesting/documentUploads/uilabs.jpg";
	 	String name1 = "Arsalan Chaudhry 1";
	 	String name2 = "Arsalan Chaudhry 2";
	 	String jobTitle1 = "DMC Intern 1";
	 	String jobTitle2 = "DMC Intern 2";
	 	String locat1 = "UI LABS 1";
	 	String locat2 = "UI LABS 2";
	 	String myDescription1 = "This is my description 1";
	 	String myDescription2 = "This is my description 2";
	 	String tag1 = "Test Tag 1";
	 	String tag2 = "Test Tag 2";
	 	String phoneNum = "5555555555";

		//Site to test 
		String sitePrefix = "portal";
		String siteURL = ".opendmc.org";
		String sitePreAndURL = "https://" + sitePrefix + siteURL;
		
		System.out.println("Starting Execution...");
		
		for(int i = 0; i < 1; i++){
			// Change as per your chromedriver download location
			System.setProperty("webdriver.chrome.driver", "/home/arsalan/Desktop/Selenium/chromedriver");

			//Chrome browser
			WebDriver driver= new ChromeDriver();

			//Wait created
			 WebDriverWait wait = new WebDriverWait(driver, 30);

			//Maximize browser
			driver.manage().window().maximize();

			//Open portal DMC home page
			driver.get(sitePreAndURL + "/#/");
			System.out.println("DMC Portal Opened");

			//Login
			login(driver, Selenium_User1, Selenium_Pass1, wait);
			
			//Profile
			myProfile(driver, wait, documentLocation1, name1, jobTitle1, locat1, myDescription1, tag1);
			//profilePageContent(driver, wait, name1, jobTitle1, locat1, myDescription1, tag1);
			
			sleepThreadWait(); //wait
			
			//Re-Run Profile Test
			myProfile(driver, wait, documentLocation2, name2, jobTitle2, locat2, myDescription2, tag2);
			//profilePageContent(driver, wait, name2, jobTitle2, locat2, myDescription2, tag2);
			
			//My Account 
			 myAccount(driver,wait, phoneNum);	
			
			//Close the browser
			//driver.close();
		}
		System.out.println("Execution Done...");
	}//end of main()


	/*  For Login  */
	public static void login(WebDriver driver, String Selenium_User1, String Selenium_Pass1, WebDriverWait wait){
		 //Find login button and click
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.login-button")));
		driver.findElement(By.cssSelector("a.login-button")).click();

		//Search for institution
		driver.findElement(By.cssSelector("i.idp-icon-UILabs")).click(); //Login using UI LABS

		//Provide User Name and password

		//Log in using UI LABS
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cred_userid_inputtext")));
		driver.findElement(By.id("cred_userid_inputtext")).sendKeys(Selenium_User1);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cred_password_inputtext")));
		driver.findElement(By.id("cred_password_inputtext")).sendKeys(Selenium_Pass1);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//Hit the sign in button
		driver.findElement(By.cssSelector("#cred_keep_me_signed_in_checkbox")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cred_sign_in_button")));
		driver.findElement(By.cssSelector("#cred_sign_in_button")).click();


	   System.out.println("Login was successful");

	}//end of login()

	public static void myProfile(WebDriver driver, WebDriverWait wait, String document, String name, String jobTitle, String location, String description, String tag){
			//driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div/div[3]/md-menu/button/span")).click();
			//driver.findElement(By.xpath("/html/body/div[6]/md-menu-content/md-menu-item[2]/a/span")).click();
		 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //wait
	        driver.navigate().refresh();
			 
	         sleepThreadWait();
	         
			 driver.navigate().to("https://portal.opendmc.org/profile.php#/538");
			 
			 //Click edit profile 
			 driver.findElement(By.xpath("/html/body/div[2]/div/md-content/div[1]/div[2]/div[2]/div[1]/a/span")).click();
			 
			 //Display Name
			 driver.findElement(By.xpath("//*[@id='editDisplayNameProfile']")).clear();
			 driver.findElement(By.xpath("//*[@id='editDisplayNameProfile']")).sendKeys(name);
			 
			 sleepThreadWait2(); //wait
			 
			 //Job Title
			 driver.findElement(By.xpath("//*[@id='input_45']")).clear();
			 driver.findElement(By.xpath("//*[@id='input_45']")).sendKeys(jobTitle);
			 
			//Location 
			 driver.findElement(By.xpath("//*[@id='input_46']")).clear();
			 driver.findElement(By.xpath("//*[@id='input_46']")).sendKeys(location);
			 
			 sleepThreadWait2(); //wait
			 
			 //My Description
			 driver.findElement(By.xpath("//*[@id='richdiv']")).clear();
			 driver.findElement(By.xpath("//*[@id='richdiv']")).sendKeys(description);
			 
			 //My Skills
			 driver.findElement(By.xpath("/html/body/div[2]/div/md-content/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]/span")).click();
			 driver.findElement(By.xpath("//*[@id='input_50']")).sendKeys(tag); //enter skill
			 driver.findElement(By.xpath("//*[@id='tab-content-48']/div/md-content/div/form/button/span")).click();//add
			 
			 
			 //Upload and Change Photo
			 sleepThreadWait2();
			 
			 driver.findElement(By.xpath("/html/body/div[2]/div/md-content/div/div[1]/button")).click(); //hit change photo
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //wait
			 driver.findElement(By.xpath("//*[@id='documentDropZone']/div/div/span[2]")).click();//document drop 
			 
			 fileLocationUpload(document);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //wait
			 
			 driver.findElement(By.xpath("/html/body/div[2]/div/md-content/div/div[2]/div[2]/button[2]/span")).click(); //save
			 
			 sleepThreadWait(); //wait
			 driver.navigate().refresh();
			 
			 sleepThreadWait(); //wait
			 driver.navigate().refresh();
			 
			 System.out.println("Picture uploaded");
	}//end of myProfile()

	
	//Function to upload a file / photo
	public static void fileLocationUpload(String documentLocation){
		//Go to search bar
		try{
			Robot robot1 = new Robot();
			robot1.delay(1000);
			
			for(int i = 0; i < 3; i++){
				robot1.keyPress(KeyEvent.VK_TAB);
				robot1.keyRelease(KeyEvent.VK_TAB);	
				robot1.delay(1000);
			}

			robot1.delay(1000);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
		//Go to location of file
			try{
				StringSelection stringSelection = new StringSelection(documentLocation);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, stringSelection);

				Robot robot2 = new Robot();
				robot2.keyPress(KeyEvent.VK_CONTROL);
				robot2.keyPress(KeyEvent.VK_V);
				robot2.keyRelease(KeyEvent.VK_V);
				robot2.keyRelease(KeyEvent.VK_CONTROL);

				
			}catch(Exception e){
				System.out.println(e);
			}
			
		//Enter
		try{
			Robot robot3 = new Robot();
			robot3.keyPress(KeyEvent.VK_ENTER);
			robot3.keyRelease(KeyEvent.VK_ENTER);
			robot3.delay(1000);
			
		}catch(Exception e){
			System.out.println(e);
		}
																																																	
	}//end of fileLocationUpload()
	
	
	//Wait for the mentioned seconds (6)
	public static void sleepThreadWait(){
		try {
			Thread.sleep(6000);
			
		}catch(InterruptedException e){
			
			e.printStackTrace();
		}
	}//end of sleepThreadWait()
	
	
	//Wait for the mentioned seconds (3)
	public static void sleepThreadWait2(){
		try {
			Thread.sleep(3000);
			
		}catch(InterruptedException e){
			
			e.printStackTrace();
		}
	}//end of sleepThreadWait2()
	
	//Function to verify if the given input is found 
	public static void profilePageContent(WebDriver driver, WebDriverWait wait, String name, String jobTitle, String location, String description, String tag){
		String bodyText = driver.findElement(By.tagName("body")).getText();
		//name
		Assert.assertTrue("Name not found!", bodyText.contains(name));
		//job title
		Assert.assertTrue("Job title not found!", bodyText.contains(name));
		//location
		Assert.assertTrue("Location not found!", bodyText.contains(name));
		//description
		Assert.assertTrue("Description not found!", bodyText.contains(name));
		//tag
		Assert.assertTrue("Tag not found!", bodyText.contains(name));
		
	}//end of function
	
	
	//My Account Settings - Contact Information
	public static void myAccount(WebDriver driver, WebDriverWait wait, String phoneNum){
		//Navigate to my account settings
		driver.navigate().refresh();
		 
        sleepThreadWait2(); //wait
         
		driver.navigate().to("https://portal.opendmc.org/account.php#/538/basics");
		
		sleepThreadWait2(); //wait
		
		//Verify that it is on correct page
		String pageTitle = driver.getTitle();
		System.out.println("Reached to " + pageTitle);
		Assert.assertTrue(pageTitle.contains("Manage Account"));
		 
		//Click on Privacy tab
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/div[1]/div/div/md-content/md-list/md-list-item[2]/a/div[1]/div")).click();
		
		
		//Validate whether phone checkbox is selected by default
		System.out.println("Before Clicking: Is Phone Checkbox Selected: " + driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/div[2]/div/div/md-content/div[2]/div[1]/div[1]/div[2]/md-checkbox/div[2]/span")).isSelected());
		sleepThreadWait(); //wait
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/div[2]/div/div/md-content/div[2]/div[1]/div[1]/div[2]/md-checkbox/div[2]/span")).click();
		System.out.println("After Clicking: Is Phone Checkbox Selected:  " + driver.findElement(By.xpath("//*[@id='input_6']")).isDisplayed());
		
		sleepThreadWait2(); //wait
		
		//Enter in Contact Information
		enterContactInfo(driver, wait, phoneNum);

		//Remove Contact information
		removeContactInfo(driver, wait, phoneNum);
		
	}//end of myAccount

	public static void enterContactInfo(WebDriver driver, WebDriverWait wait, String phoneNum){
		//Enter in Phone Number
		System.out.println("Entering in Contact Information");
		driver.findElement(By.xpath("//*[@id='input_6']")).sendKeys(phoneNum);
		//Hit the Save button
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/div[2]/div/div/md-content/div[1]/button/span")).click();
		System.out.println("Added Phone Number:" + phoneNum);
		
		sleepThreadWait2(); //wait
		
		//check in my profile if the contact information is visible
		System.out.println("Currently on " + driver.getTitle() + " Page"); //check page
		
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		sleepThreadWait2(); //wait
		driver.get("https://portal.opendmc.org/profile.php#/538");
		
		System.out.println("Currently on " + driver.getTitle() + " Page"); //check page
		
		sleepThreadWait2(); //wait
		driver.findElement(By.xpath("/html/body/div[2]/div/md-content/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]/span")).click();
		System.out.println("Is Phone Number Visible: " + driver.findElement(By.xpath("//*[@id='input_5']")).isDisplayed());
	}//end of enterContactInfo()
	
	public static void removeContactInfo(WebDriver driver, WebDriverWait wait, String phoneNum){
		System.out.println("Removing Contact Information");
		
		driver.navigate().to("https://portal.opendmc.org/account.php#/538/basics");
		sleepThreadWait2(); //wait
		
		//Click on Privacy tab
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/div[1]/div/div/md-content/md-list/md-list-item[2]/a/div[1]/div")).click();
		
		//clear number
		sleepThreadWait2(); //wait
		driver.findElement(By.xpath("//*[@id='input_6']")).clear();
		
		//Unclick and Save
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/div[2]/div/div/md-content/div[2]/div[1]/div[1]/div[2]/md-checkbox/div[2]/span")).click();
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/div[2]/div/div/md-content/div[1]/button/span")).click();
		System.out.println("Removed Phone Number:" + phoneNum);
		
		sleepThreadWait2(); //wait
		
		//check in my profile if the contact information is visible
		//System.out.println("Currently on " + driver.getTitle() + " Page"); //check page
		
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		sleepThreadWait2(); //wait
		driver.get("https://portal.opendmc.org/profile.php#/538");
		
		//System.out.println("Currently on " + driver.getTitle() + " Page"); //check page
		
		sleepThreadWait2(); //wait
		driver.findElement(By.xpath("/html/body/div[2]/div/md-content/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]/span")).click();
		//System.out.println("Is Phone Number Visible: " + driver.findElement(By.xpath("//*[@id='input_5']")).isDisplayed());

	}//end of removeContactInfo()
	
}//end of class
