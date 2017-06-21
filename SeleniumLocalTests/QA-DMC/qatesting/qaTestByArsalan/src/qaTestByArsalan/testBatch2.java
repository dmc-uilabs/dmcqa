package qaTestByArsalan;

import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

		//Site to test
		String sitePrefix = "portal";
		String siteURL = ".opendmc.org";
		String sitePreAndURL = "https://" + sitePrefix + siteURL;

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
			myProfile(driver, wait);
		}
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

	public static void myProfile(WebDriver driver, WebDriverWait wait){
			//Declare any Variables
		 	String documentLocation = "/home/arsalan/Pictures/office.jpg";
		 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //wait

			//driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div/div[3]/md-menu/button/span")).click();
			//driver.findElement(By.xpath("/html/body/div[6]/md-menu-content/md-menu-item[2]/a/span")).click();
	        driver.navigate().refresh();
			 
	        sleepThreadWait();
	         
			 driver.navigate().to("https://portal.opendmc.org/profile.php#/538");
			 
			 //Click edit profile 
			 driver.findElement(By.xpath("/html/body/div[2]/div/md-content/div[1]/div[2]/div[2]/div[1]/a/span")).click();
			 
			 //Display Name
			 /*
			 driver.findElement(By.xpath("//*[@id='editDisplayNameProfile']")).clear();
			 driver.findElement(By.xpath("//*[@id='editDisplayNameProfile']")).sendKeys("Arsalan Chaudhry");
			 
			 driver.manage().timeouts().implicitlyWait(15 , TimeUnit.SECONDS); //wait
			 
			 //Job Title
			 driver.findElement(By.xpath("//*[@id='input_44']")).clear();
			 driver.findElement(By.xpath("//*[@id='input_44']")).sendKeys("DMCIntern");
			 
			//Location 
			 driver.findElement(By.xpath("//*[@id='input_46']")).clear();
			 driver.findElement(By.xpath("//*[@id='input_46']")).sendKeys("UI LABS TEST");
			 
			 //My Description
			 driver.findElement(By.xpath("//*[@id='richdiv']")).clear();
			 driver.findElement(By.xpath("//*[@id='richdiv']")).sendKeys("This is my description");
			 
			 //My Skills
			 driver.findElement(By.xpath("/html/body/div[2]/div/md-content/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]/span")).click();
			 driver.findElement(By.xpath("//*[@id='input_50']")).sendKeys("Test"); //enter skill
			 driver.findElement(By.xpath("//*[@id='tab-content-48']/div/md-content/div/form/button/span")).click();//add
			 */
			 //Upload and Change Photo
			 //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //wait
			 sleepThreadWait();
			 
			 driver.findElement(By.xpath("/html/body/div[2]/div/md-content/div/div[1]/button")).click(); //hit change photo
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //wait
			 driver.findElement(By.xpath("//*[@id='documentDropZone']/div/div/span[2]")).click();//document drop 
			 
			 fileLocationUpload(documentLocation);
	}//end of myProfile

	
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
	
	
	//Wait for the mentioned seconds
	public static void sleepThreadWait(){
		try {
			Thread.sleep(6000);
			
		}catch(InterruptedException e){
			
			e.printStackTrace();
		}
	}//end of sleepThreadWait()
	
	
	public static void myAccount(WebDriver driver, WebDriverWait wait){
		//Navigate to my account settings
		
		//Click on Privacy tab
		
		//Click on phone button
		
		//Enter in Phone Number
		
		//Hit the Save button
		
		//Open New Tab and check in my profile if the contact information is visible
		
		//Remove Contact information
		
	}//end of myAccount

}//end of class
