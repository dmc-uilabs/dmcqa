package qaTestByArsalan;

import org.junit.Assert;
import org.openqa.selenium.Alert;
//import packages
//package com.beta.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

//import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import java.awt.*;

//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;

//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class testBatch1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Create any variables 
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
		 
		 /* For creating chrome browser in incognito mode
		 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	     ChromeOptions options = new ChromeOptions();
	     options.addArguments("--incognito");
	     capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	     System.setProperty("webdriver.chrome.driver", "/home/arsalan/Desktop/Selenium/chromedriver");
		 WebDriver driver = new ChromeDriver(capabilities);
		 */
		 
		 //Wait created
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 
		 //Maximize browser
		 driver.manage().window().maximize();	 
		 
		 //Open portal DMC home page
		 driver.get(sitePreAndURL + "/#/");
		 System.out.println("DMC Portal Opened");
		 
		 //Login
		 login(driver, Selenium_User1, Selenium_Pass1, wait);
		 
		 //Check that rest/companies endpoint can be reached
		 //restCompanies(driver, wait, sitePreAndURL);
		 
         //About the DMC page
		 //coreAboutDMC(driver, wait);
		 
		 //DMC Academia Page
		 //coreAcademia(driver, wait);
		 
		 //DMC Security Page
		 //coreSecurity(driver, wait);
		 
		 //DMC Release Notes Page
		 //coreReleases(driver, wait);
		 
		 //Logout of the DMC
		 //logout(driver, wait);
		 
		//Close the browser
		//driver.close();
		 
        }//end of for-loop
		
		System.out.println("Execution Done");
	
	}//end of main()
	
	
	//Function to logout of the DMC
	/*
	public static void logout(WebDriver driver, WebDriverWait wait){
		   driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div/div[3]/md-menu/button/span")).click();
	       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	       driver.findElement(By.xpath("/html/body/div[4]/md-menu-content/md-menu-item[3]/button/span")).click();

	  } //end of logout()
	*/
	
	//Function to verify page title
	public static void verifyPageTitle(WebDriver driver){
		 //Verify page
		 String pageTitle = driver.getTitle();
		 System.out.println("Title is " + pageTitle);
		 //String expected_title = "Onboarding";
		 //Assert.assertEquals(expected_title, pageTitle);
		 Assert.assertTrue(pageTitle.contains("Onboarding"));
		 System.out.println("Test completed - Onboarding Page verifified");
	}//end of verifyPageTitle()

	
	//Function to check the the rest page returns the expected result
	public static void restCompanies(WebDriver driver, WebDriverWait wait, String sitePreAndURL){
    	//URL is entered to visit ~.opendmc.org/rest/companies
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait
    	driver.get("https://portal.opendmc.org/rest/companies");
    	
    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait
    	int exists = driver.findElements(By.xpath("/html/body/pre") ).size();
    	
    	/* 
    	 * Check if page returns a Blank, Whitelabel Error Page, or {"message":"REST Internal Error"} Page
    	 * If so the test failed 
    	 */
    	if(exists == 0){
    		System.out.println("Test Failed: Blank Page");
    	}
    	
    	if(exists != 0){
    		//System.out.println(exists);
    		if(driver.getPageSource().contains("Whitelabel Error Page")){
    			System.out.println("Test Failed: Whitelabel Error Page");
    		}
    		if(driver.getPageSource().contains("REST Internal Error")){
    			System.out.println("Test Failed: REST Internal Error");
    		}
    	}
    	//driver.getPageSource().contains("General Electric");
    	
    	long startTime = System.currentTimeMillis(); //fetch starting time

    	while(false||(System.currentTimeMillis()-startTime)<10000){
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > pre")));
    		//Check if the element is returned to the screen
    		if(!driver.findElements(By.cssSelector("body > pre")).isEmpty()){
                System.out.println("Rest/Comapnies can be reached");
                break;
        	}
        	else{
                System.out.println("Rest/Comapnies can not be reached");
                break;
        	}	
    	}
    	System.out.println("Out of Loop - Test Completed");
    }//end of restCompanies()
	

	/*  For Login  */
	public static void login(WebDriver driver, String Selenium_User1, String Selenium_Pass1, WebDriverWait wait){
		 //Find login button and click
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.login-button")));           
		driver.findElement(By.cssSelector("a.login-button")).click();
		
		//Search for institution 
		driver.findElement(By.cssSelector("i.idp-icon-UILabs")).click(); //Login using UI LABS
		//driver.findElement(By.cssSelector("i.idp-icon-Google")).click(); //Login using Google
		
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
		
		//Log in using Google 
		//For User Name
		/*
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId"))); 
       driver.findElement(By.id("identifierId")).sendKeys(Selenium_User1);
       driver.findElement(By.cssSelector("#identifierNext > content > span")).click();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);  
       
       //For Password
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")));           
       driver.findElement(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")).sendKeys(Selenium_Pass1);
       driver.findElement(By.cssSelector("#passwordNext > content > span")).click();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);*/
		
	   System.out.println("Login was successful");
	   
	}//end of login()


	/* For Core */
	public static void coreAboutDMC(WebDriver driver, WebDriverWait wait){
		 //Navigate to About the DMC page
         driver.navigate().refresh();
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 driver.navigate().to("https://portal.opendmc.org/onboarding.php#/home"); 
		 
		
		 //Verify page
		 String pageTitle = driver.getTitle();
		 System.out.println("Title is " + pageTitle);
		 //String expected_title = "Onboarding";
		 //Assert.assertEquals(expected_title, pageTitle);
		 Assert.assertTrue(pageTitle.contains("Onboarding"));
		 
		 
		 System.out.println("Currently on 1st Tab");
		 driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div > md-content > div > div > div:nth-child(12) > md-tabs > md-tabs-wrapper > md-tabs-canvas > md-pagination-wrapper > md-tab-item:nth-child(2) > span")).click();		
		 System.out.println("2nd Tab Clicked");
		 driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div > md-content > div > div > div:nth-child(12) > md-tabs > md-tabs-wrapper > md-tabs-canvas > md-pagination-wrapper > md-tab-item:nth-child(3) > span")).click();
		 System.out.println("3rd Tab Clicked");
		 driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div > md-content > div > div > div:nth-child(12) > md-tabs > md-tabs-wrapper > md-tabs-canvas > md-pagination-wrapper > md-tab-item.md-tab.ng-scope.ng-isolate-scope.md-active > span")).click();
		 System.out.println("4th Tab Clicked");
		 driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div > md-content > div > div > div:nth-child(12) > md-tabs > md-tabs-wrapper > md-tabs-canvas > md-pagination-wrapper > md-tab-item.md-tab.ng-scope.ng-isolate-scope.md-active > span")).click();
		 System.out.println("5th Tab Clicked");
		 driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div > md-content > div > div > div:nth-child(12) > md-tabs > md-tabs-wrapper > md-tabs-canvas > md-pagination-wrapper > md-tab-item.md-tab.ng-scope.ng-isolate-scope.md-active > span")).click();
		 System.out.println("6th Tab Clicked");
		 
		 //View Opportunities (Join Our Team Page)
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div > md-content > div > div > div:nth-child(18) > div > h3:nth-child(3) > p > span > a")).click();
		 
		
		 System.out.println("Test completed - Onboarding Page verifified");
	}//end of coreAboutDMC()
	
	
	//Academia Page Test
	public static void coreAcademia(WebDriver driver, WebDriverWait wait){
		//Declare any Variables
		int before = 0;
		int after  = 0;
	
		//Navigate to DMC Academia Page
        driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().to("https://portal.opendmc.org/academia.php#/");
		
		//Verify that it is on correct page
		String pageTitle = driver.getTitle();
		System.out.println("Title is " + pageTitle);
		Assert.assertTrue(pageTitle.contains("DMC Academia"));
		
		//Verify that Before clicking content should be hidden
		System.out.println("Before clicking on VIEW ACADEMIC CONTENT");
		System.out.println(driver.findElement(By.xpath("//*[@id='uniContent']/section[1]/div/div[2]/h1")).isDisplayed());
		
		//Verify Before clicking content should be hidden
		System.out.println("Before clicking on VIEW COURSERA CERTIFICATION");
		System.out.println(driver.findElement(By.xpath("//*[@id='courseraContent']/section[2]/div/div/h2")).isDisplayed());
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait
		
		//Check if the content is hidden 
		if((driver.findElement(By.xpath("//*[@id='uniContent']/section[1]/div/div[2]/h1")).isDisplayed()) == false && (driver.findElement(By.xpath("//*[@id='courseraContent']/section[2]/div/div/h2")).isDisplayed()) == false){
			before = 1;
		}
	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait
		
		
		driver.findElement(By.xpath("//*[@id='hideshowUni']")).click(); //Click on link
		
		//Verify that After clicking content should be visible
		System.out.println("After clicking on VIEW ACADEMIC CONTENT");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.xpath("//*[@id='uniContent']/section[1]/div/div[2]/h1")).isDisplayed());
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait
		
		driver.findElement(By.xpath("//*[@id='hideshowCou']")).click(); //Click on link
		
		//Verify that After clicking content should be visible
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("After clicking on VIEW COURSERA CERTIFICATION");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.xpath("//*[@id='courseraContent']/section[2]/div/div/h2")).isDisplayed());
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait
		
		//Check if the content is visible
		if((driver.findElement(By.xpath("//*[@id='uniContent']/section[1]/div/div[2]/h1")).isDisplayed()) == true && (driver.findElement(By.xpath("//*[@id='courseraContent']/section[2]/div/div/h2")).isDisplayed()) == true){
			after = 1;
		}
		
		//Check if the test passed or failed
		if(before == 0 && after == 0){
			System.out.println("Test FAILED");
		}
		else{
			System.out.println("Test completed - DMC Academia Page verifified");
		}
		
	}//end of coreAcademia()
	
	
	//DMC Core Security Page
	public static void coreSecurity(WebDriver driver, WebDriverWait wait){
		//Navigate to DMC Security Page
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().to("https://portal.opendmc.org/security.php#/");
		
		//Verify that it's on the correct Page
		String pageTitle = driver.getTitle();
		System.out.println("Title is " + pageTitle);
		Assert.assertTrue(pageTitle.contains("Security"));
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait
		driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > main > section > div:nth-child(2) > div:nth-child(2) > div > h3:nth-child(21) > a")).click();
		
		driver.navigate().refresh(); //refresh browser 
		
		//Verify that it's on the correct Page
		String pageTitle2 = driver.getTitle();
		System.out.println("Title is " + pageTitle2);
		Assert.assertTrue(pageTitle2.contains("Terms and Conditions"));
		
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > main > section > div:nth-child(2) > div:nth-child(4) > div > a")).click();
		
		driver.navigate().refresh(); //refresh browser 
		
		//Verify that it's on the correct Page
		String pageTitle3 = driver.getTitle();
		System.out.println("Title is " + pageTitle3);
		Assert.assertTrue(pageTitle3.contains("Contact Us"));
		
		//Successful 
		System.out.println("Test completed - DMC Security Page verifified");
		
	}//end of coreSecurity()
	
	
	//DMC Core Releases Page
	public static void coreReleases(WebDriver driver, WebDriverWait wait){
        //Navigate to Releases Page
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().to("https://portal.opendmc.org/release-notes.php#/");
		
		//Verify that it is on correct page
		String pageTitle = driver.getTitle();
		System.out.println("Title is " + pageTitle);
		Assert.assertTrue(pageTitle.contains("Release Notes"));
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait
		
		//Gets the information about all the releases, and checks if the current is different from previous releases Note However: 4,3,2 are the same
		String V1_8 = driver.findElement(By.xpath("//*[@id='tab-content-0']/div/md-content/div[1]/p")).getText();
		//System.out.println("V 0.1.8 " + V1_8);
		
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/md-content/div/div[3]/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]/span")).click();
		String V1_7 = driver.findElement(By.xpath("//*[@id='tab-content-1']/div/md-content/div[1]/p")).getText();
		//System.out.println("V 0.1.7 " + V1_7);
		
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/md-content/div/div[3]/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[3]/span")).click();
		String V1_6  = driver.findElement(By.xpath("//*[@id='tab-content-2']/div/md-content/div[1]/p[1]")).getText();
		//System.out.println("V 0.1.6 " + V1_6);
		
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/md-content/div/div[3]/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[4]/span")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String V1_5  = driver.findElement(By.xpath("//*[@id='tab-content-3']/div/md-content/div[1]/p[1]")).getText();
		//System.out.println("V 0.1.5 " + V1_5);
		
		
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/md-content/div/div[3]/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String V1_4  = driver.findElement(By.xpath("//*[@id='tab-content-4']/div/md-content/div/span/p[1]")).getText();
		//System.out.println("V 0.1.4 " + V1_4);
		
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/md-content/div/div[3]/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[6]/span")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String V1_3  = driver.findElement(By.xpath("//*[@id='tab-content-5']/div/md-content/div/p[1]")).getText();
		//System.out.println("V 0.1.3 " + V1_3);
		
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/md-content/div/div[3]/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[7]/span")).click();
		String V1_2  = driver.findElement(By.xpath("//*[@id='tab-content-6']/div/md-content/div/p[1]")).getText();
		//System.out.println("V 0.1.2 " + V1_2);
		
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/md-content/div/div[3]/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[8]/span")).click();
		String V1_1  = driver.findElement(By.xpath("//*[@id='tab-content-7']/div/md-content/div/div/p[1]")).getText();
		//System.out.println("V 0.1.1 BETA " + V1_1);
		
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/md-content/div/div[3]/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[9]/span")).click();
		String V1_0  = driver.findElement(By.xpath("//*[@id='tab-content-8']/div/md-content/div/div[1]/p[1]")).getText();
		//System.out.println("V 0.1.0 ALPHA " + V1_0);
		
		
		//Check if the current release is different from the previous releases
		if(V1_8 == V1_7){
			System.out.println("Test Failed: V 0.1.8 and V 0.1.7 are the same");
		}
		if(V1_8 == V1_6){
			System.out.println("Test Failed: V 0.1.8 and V 0.1.6 are the same");
		}
		if(V1_8 == V1_5){
			System.out.println("Test Failed: V 0.1.8 and V 0.1.5 are the same");
		}
		if(V1_8 == V1_4){
			System.out.println("Test Failed: V 0.1.8 and V 0.1.4 are the same");
		}
		if(V1_8 == V1_3){
			System.out.println("Test Failed: V 0.1.8 and V 0.1.3 are the same");
		}
		if(V1_8 == V1_2){
			System.out.println("Test Failed: V 0.1.8 and V 0.1.2 are the same");
		}
		if(V1_8 == V1_1){
			System.out.println("Test Failed: V 0.1.8 and V 0.1.1 BETA are the same");
		}
		if(V1_8 == V1_0){
			System.out.println("Test Failed: V 0.1.8 and V 0.1.0 ALPHA are the same");
		}
		
		//If we reached here test was successful
		System.out.println("Test completed - DMC Release Notes Page verifified");
	}//end of coreReleases()
	   
}//end of class 