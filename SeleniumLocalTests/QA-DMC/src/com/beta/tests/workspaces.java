//import packages
package com.beta.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.Robot;
import java.awt.Toolkit;
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
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;

//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class workspaces
{
    public static void main(String[] args)
    {
    	
		//Getting Local Environment Variables
		//User Credentials
        String Selenium_User1 = System.getenv("Selenium_User1");
        String Selenium_Pass1 = System.getenv("Selenium_Pass1");

        //System.out.println(Selenium_User1);
        //System.out.println(Selenium_Pass1);
        
        
        //Site to test
        String sitePrefix = "beta";
        String siteURL = ".opendmc.org";
        String sitePreAndURL = "https://" + sitePrefix + siteURL;
        
        //Local Document Locations
        String profilePictureLocation = "/home/marson/Pictures/defaultProfilePicture.png";
        String companyLogo = "null";
        String companyPicture = "null";
        String companyVideo = "null";
        String workspaceCreationDoc = "null";
        String workspaceDoc1 = "null";
        String workspaceDoc2 = "null";
        String applicationDoc1 = "null";
        String applicationDoc2 = "null";
        String applicationDoc3 = "null";
        String applicationDoc4 = "null";
        String serviceApplicationDoc = "null";
        String serviceApplicationPicture = "null";
        
        //Workspaces
        String workspacePrivate = "Private Workspace4";
        String workspacePublicAll = "Public-to-All Workspace";
        String workspacePublicWithInvite = "Public-with-Invite Workspace";

        for (int i = 0; i < 1; i++)
    	{
	        //Set Path to Browser Driver
	        System.setProperty("webdriver.chrome.driver", "/home/marson/Downloads/chromedriver");
	        //System.setProperty("webdriver.gecko.driver", "/home/m/Downloads/geckodriver");
	        //String userAgent = "Mozilla/5.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; GTB7.4; InfoPath.2; SV1; .NET CLR 3.3.69573; WOW64; en-US)";
	        //ChromeOptions co = new ChromeOptions();
	        //co.addArguments("user-agent=" + userAgent);
	        //DesiredCapabilities cap = DesiredCapabilities.chrome();
	        //cap.setCapability(ChromeOptions.CAPABILITY , co);
	        
	        //Initialize a Browser
	        WebDriver driver= new ChromeDriver();
	        //WebDriver driver2 = new ChromeDriver();
	        //WebDriver driver = new FirefoxDriver();
	        
	        //Wait created
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	
	        //Maximize browser
	        //driver.manage().window().maximize();	        
	
	        //Open a _.opendmc.org website
	        driver.get(sitePreAndURL + "/#/");      
	        
	        //Login Function logs into site via google
	        login(driver, Selenium_User1, Selenium_Pass1, wait);
	
	        //Test WorkSpaces
	        //workspace(driver, wait, workspacePrivate, workspacePublicAll, workspacePublicWithInvite);
	        //workspace(driver2, wait, workspacePrivate, workspacePublicAll, workspacePublicWithInvite);
	
	        //Check that rest/companies endpoint can be reached
	        //restCompanies(driver, wait, sitePreAndURL);
	        
	        //Check if you can get to the My Company section of website
	        //myOrganization(driver, wait, sitePreAndURL);
	        
	        //Check My Profile
	        userProfile(driver, wait, sitePreAndURL, profilePictureLocation);
	        
	        //Logout of DMC
	        //logout(driver, wait);
	        
	        driver.close();
    	}
    	
    	System.out.println("Score \n Login \t My Organization \t My Workspaces \t /rest/companies \n Score1 \t Score2 \t Score3 \t Score4");
    }

    public static void login(WebDriver driver, String Selenium_User1, String Selenium_Pass1, WebDriverWait wait)
    {
        //Log into site
        //Find Login and Click
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.login-button")));           
    	driver.findElement(By.cssSelector("a.login-button")).click();

        //WebDriverWait wait = new WebDriverWait(driver, 10);           

        //Filter field to be searched as Google, Choose google from box
        driver.findElement(By.cssSelector("i.idp-icon-Google")).click();

        //Log in using Google
        //Enter User Name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email"))); 
        driver.findElement(By.id("Email")).sendKeys(Selenium_User1);
        driver.findElement(By.id("next")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //Enter Password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Passwd")));           
        driver.findElement(By.cssSelector("#Passwd")).sendKeys(Selenium_Pass1);
        driver.findElement(By.cssSelector("#signIn")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public static void logout(WebDriver driver, WebDriverWait wait)
    {
        //driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div/div[3]/md-menu/button")).click();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.findElement(By.cssSelector("#my-projects-page > div.md-open-menu-container.md-whiteframe-z2.md-default-theme.md-active.md-clickable > md-menu-content > md-menu-item:nth-child(7) > button")).click();
    }

    public static void workspace(WebDriver driver, WebDriverWait wait, String workspacePrivate, String workspacePublicAll, String workspacePublicWithInvite)
    {
        //Go to my workspaces
        //driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div/div[3]/md-menu/button")).click();
        driver.findElement(By.cssSelector("body > div.ng-isolate-scope > header > div.top-header.header-padding.layout.layout-row > div > div > div.layout.layout-column > md-menu > button > span")).click();
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("body > div.md-open-menu-container.md-whiteframe-z2.md-default-theme.md-active.md-clickable > md-menu-content > md-menu-item:nth-child(3) > a > span")).click();
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //Get to Work Space Form
        driver.findElement(By.cssSelector("#my-projects-page > div.ng-scope > div.page-header.ng-scope > md-toolbar > div > a > span")).click();

    

        //Fill Out Form Part One
        //title
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#input_4")));           
        driver.findElement(By.cssSelector("#input_4")).sendKeys(workspacePrivate);
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //Date
        //driver.findElement(By.cssSelector("#input_6")).sendKeys("12/25/2017");

        

        //Type 1 Public/Private
        driver.findElement(By.cssSelector("#select_10")).click();
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //Private
        driver.findElement(By.cssSelector("#select_option_9 > div.md-text")).click();
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //Public
        //driver.findElement(By.cssSelector("#select_option_8 > div.md-text")).click();


        //Type 2 If Public
        //driver.findElement(By.cssSelector("#select_value_label_3 > span:nth-child(1)")).click();
        //Public 1
        //driver.findElement(By.cssSelector("#select_option_16 > div.md-text")).click();
        //Public 2
        //driver.findElement(By.cssSelector("#select_option_17 > div.md-text")).click();

        
        //Overview
        driver.findElement(By.cssSelector("#input_11")).sendKeys("Private Project OverView");
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //Tag
        driver.findElement(By.cssSelector("#input_12")).sendKeys("Private Project");
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //Tag Add
        driver.findElement(By.cssSelector("#tab-content-0 > div > md-content > ap-tab-one > div > div.layout.layout-row.layout-align-space-between-start.layout-fill.layout-padding > div:nth-child(1) > div > div.content-panel-body > md-content:nth-child(2) > div > form > button > span")).click();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        //Next
        driver.findElement(By.cssSelector("#tab-content-0 > div > md-content > ap-tab-one > div > div.btn-next-block.layout.layout-row.layout-align-end-center.layout-padding > button > span")).click();
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        //Fill out Form Part Two
        //Choose Users
        //driver.findElement(By.cssSelector("#input_13")).sendKeys("marcin");
        //driver.findElement(By.cssSelector("#tab-content-1 > div > md-content > ap-tab-two > div > div.layout.layout-row.layout-fill.layout-margin.layout-padding > div.content-column.flex.flex-70.layout.layout-column > div > div.content-panel-body > md-content.md-padding.top-content.layout.layout-row.layout-align-start-center.md-default-theme > form > div > div > div.layout.layout-row")).click();

        //Page down
        //Save/Create
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tab-content-1 > div > md-content > ap-tab-two > div > div.btn-next-block.layout.layout-row.layout-align-end-center.layout-padding > button.md-raised.md-primary.md-button.md-default-theme")));           
        driver.findElement(By.cssSelector("#tab-content-1 > div > md-content > ap-tab-two > div > div.btn-next-block.layout.layout-row.layout-align-end-center.layout-padding > button.md-raised.md-primary.md-button.md-default-theme")).click();

        //Are you taken to the newly created workspace?
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.ng-scope > ui-view > div.page-header.margin-bottom-35.ng-scope > md-toolbar > h1 > div > a")));           
        WebElement workspaceNameCreated = driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div.page-header.margin-bottom-35.ng-scope > md-toolbar > h1 > div > a"));
        String workspaceNameCreatedStr = "Workspace name Not Found";
        workspaceNameCreatedStr = workspaceNameCreated.getText();
        System.out.println(workspaceNameCreatedStr);
//        if(workspaceNameCreatedStr == workspacePrivate)
//        {
//        	System.out.println("This workspace is the name you requested");
//        }
//        else
//        {
//        	System.out.println("This workspace is the name you requested or space was not made");
//        }
        
        //Return to My Workspaces
        //Go to my workspaces
        //driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div/div[3]/md-menu/button")).click();
        driver.findElement(By.cssSelector("body > div.ng-isolate-scope > header > div.top-header.header-padding.layout.layout-row > div > div > div.layout.layout-column > md-menu > button > span")).click();
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("body > div.md-open-menu-container.md-whiteframe-z2.md-default-theme.md-active.md-clickable > md-menu-content > md-menu-item:nth-child(3) > a > span")).click();
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
        //Is New workspace Present?
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#myProjectsList > div.content-panel-body.flex.flex-100.layout.layout-column > md-content:nth-child(1) > div > div.rp-panel__title.my-projects.layout.layout-row > h2 > a")));           
        WebElement newWorkspaceList = driver.findElement(By.cssSelector("#myProjectsList > div.content-panel-body.flex.flex-100.layout.layout-column > md-content:nth-child(1) > div > div.rp-panel__title.my-projects.layout.layout-row > h2 > a"));
        String newWorkspaceListStr = "Workspace name Not Found";
        newWorkspaceListStr = newWorkspaceList.getText();
        System.out.println("On My Workspace List:" + newWorkspaceListStr);
        
        
      
      

    }
    
    public static void restCompanies(WebDriver driver, WebDriverWait wait, String sitePreAndURL)
    {
    	//URL is entered to visit ~.opendmc.org/rest/companies
    	driver.get(sitePreAndURL + "/rest/companies");
    	
    	//boolean exists = driver.findElements(By.xpath("/html/body/pre/text()") ).size() != 0;
    	////driver.getPageSource().contains("General Electric");
    	
    	
    	long startTime = System.currentTimeMillis(); //fetch starting time
    	while(false||(System.currentTimeMillis()-startTime)<10000)
    	{
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > pre")));

    		//Check if the element is returned to the screen
    		if(!driver.findElements(By.cssSelector("body > pre")).isEmpty())
        	{
                System.out.println("Rest/Comapnies can be reached");
                break;
            }
        	else
        	{
                System.out.println("Rest/Comapnies can not be reached");
                break;
        	}	
    	}
    	System.out.println("Out of Loop");
    }
    
    public static void myOrganization(WebDriver driver, WebDriverWait wait, String sitePreAndURL)
    {	
    	//Go back to Home page
    	driver.get(sitePreAndURL + "/#/");
    	
    	//For when My Organization is in the header
    	//visitMyOrgMethod1(driver, wait);
    	
    	//For when My Organization is not in the Main Menu
    	visitMyOrgMethod2(driver, wait);
    	
    	//Uncomment below and comment out line above will cause test to fail if need to test if test is run appropriatly
    	//driver.findElement(By.cssSelector("body > div.ng-isolate-scope > header > div.bottom-header.header-padding.layout.layout-row.ng-scope > div > div > div > div > a")).click();
    
    	if(!driver.findElements(By.cssSelector("body > div.ng-scope > div > md-content > div.layout.layout-row > div.company-profile-header.flex.flex-80.layout.layout-column > div:nth-child(1) > div > h2")).isEmpty())
    	{
            System.out.println("Did find organization name on DMC Organization page");
            WebElement organizationName= driver.findElement(By.cssSelector("body > div.ng-scope > div > md-content > div.layout.layout-row > div.company-profile-header.flex.flex-80.layout.layout-column > div:nth-child(1) > div > h2"));
            String organizationNameStr = "Organization name Not Found";
            organizationNameStr = organizationName.getText();
            System.out.println(organizationNameStr);
    	}
    	else
    	{
            System.out.println("Did not find organization name on DMC Organization page age");
    	}
    }
    
    public static void visitMyOrgMethod1(WebDriver driver, WebDriverWait wait)
    {
    	//Variable for if element is found
    	//int elementFound = 0;
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.ng-isolate-scope > header > div.bottom-header.header-padding.layout.layout-row.ng-scope > div > div > div > div > md-menu:nth-child(2) > button > span")));
    	//elementFound = 1;
    	driver.findElement(By.cssSelector("body > div.ng-isolate-scope > header > div.bottom-header.header-padding.layout.layout-row.ng-scope > div > div > div > div > md-menu:nth-child(2) > button > span")).click();
    
    }
    
    public static void visitMyOrgMethod2(WebDriver driver, WebDriverWait wait)
    {
    	//Click on Marketplace Drop-down
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/header/div[2]/div/div/div/div/md-menu[1]/button/ng-md-icon")));
    	driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div/div/div/div/md-menu[1]/button/ng-md-icon")).click();
    	
    	//Click on on my Storefront
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/md-menu-content/md-menu-item[2]/a/span")));
    	driver.findElement(By.xpath("/html/body/div[6]/md-menu-content/md-menu-item[2]/a/span")).click();
    	
    	//Click on Storefront Organization name
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.ng-scope > ui-view > div > div.content-column.right-content.flex.flex-80.layout.layout-column > div > div > md-content > div.company-title.layout.layout-row.layout-align-start-start.layout-padding > div > a > h2")));
    	driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div > div.content-column.right-content.flex.flex-80.layout.layout-column > div > div > md-content > div.company-title.layout.layout-row.layout-align-start-start.layout-padding > div > a > h2")).click();    	
    }
    public static void userProfile(WebDriver driver, WebDriverWait wait, String sitePreAndURL, String profilePictureLocation)
    {
    	//Visit home page
    	driver.get(sitePreAndURL + "/#/");
    	
    	//Go to Profile Page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.ng-isolate-scope > header > div.top-header.header-padding.layout.layout-row > div > div > div.layout.layout-column > md-menu > button > span")));
    	driver.findElement(By.cssSelector("body > div.ng-isolate-scope > header > div.top-header.header-padding.layout.layout-row > div > div > div.layout.layout-column > md-menu > button > span")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.md-open-menu-container.md-whiteframe-z2.md-default-theme.md-active.md-clickable > md-menu-content > md-menu-item:nth-child(2) > a")));
        driver.findElement(By.cssSelector("body > div.md-open-menu-container.md-whiteframe-z2.md-default-theme.md-active.md-clickable > md-menu-content > md-menu-item:nth-child(2) > a")).click();
       
    	//Click on edit profile
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.ng-scope > div > md-content > div:nth-child(1) > div.profile-header.flex.flex-85.layout.layout-column > div.layout.layout-row.layout-align-center-center > div.layout.layout-row.layout-align-center-center.ng-scope > a")));
        driver.findElement(By.cssSelector("body > div.ng-scope > div > md-content > div:nth-child(1) > div.profile-header.flex.flex-85.layout.layout-column > div.layout.layout-row.layout-align-center-center > div.layout.layout-row.layout-align-center-center.ng-scope > a")).click();
    	
    	//Edit the profile fields
        //User Job Title Field
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#input_35")));
        driver.findElement(By.cssSelector("#input_35")).click();
        driver.findElement(By.cssSelector("#input_35")).sendKeys("Job Title Test Example");
        
        //Location Field
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#input_36")));
        driver.findElement(By.cssSelector("#input_36")).click();
        driver.findElement(By.cssSelector("#input_36")).sendKeys("User Test Location");
        
        //Description Field
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#input_37")));
        driver.findElement(By.cssSelector("#input_37")).click();
        driver.findElement(By.cssSelector("#input_37")).sendKeys("User Test Location");
    	
        //Skills Field
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#input_40")));
        driver.findElement(By.cssSelector("#input_40")).click();
        driver.findElement(By.cssSelector("#input_40")).sendKeys("Skill1 to Stay");
        driver.findElement(By.cssSelector("#tab-content-38 > div > md-content > div > form > button")).click();
        driver.findElement(By.cssSelector("#input_40")).click();
        driver.findElement(By.cssSelector("#input_40")).sendKeys("Skill2 to Remove");
        driver.findElement(By.cssSelector("#tab-content-38 > div > md-content > div > form > button")).click();
        driver.findElement(By.cssSelector("#input_40")).click();
        driver.findElement(By.cssSelector("#input_40")).sendKeys("Skill3 to Stay");
        driver.findElement(By.cssSelector("#tab-content-38 > div > md-content > div > form > button")).click();      
        
    	//Edit Profile Picture
        //Open the windows to choose file
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.ng-scope > div > md-content > div.layout.layout-row > div.flex.flex-20 > div.layout.layout-column > div > div.content-panel-body.layout.layout-row.layout-align-space-between-start.layout-wrap > md-content")));
        driver.findElement(By.cssSelector("body > div.ng-scope > div > md-content > div.layout.layout-row > div.flex.flex-20 > div.layout.layout-column > div > div.content-panel-body.layout.layout-row.layout-align-space-between-start.layout-wrap > md-content")).click();   
   
        fileLocationUpload(profilePictureLocation);
        
    	//Save
   	
    	//Check Elements were saved
    }
    public static void fileLocationUpload(String documentLocation)
    {
        try
        {   
        	//System.out.println("About to press down.");
        	Robot robot1 = new Robot();
        	robot1.delay(1000);
        	robot1.keyPress(KeyEvent.VK_DOWN);
        	robot1.keyRelease(KeyEvent.VK_DOWN);
        	robot1.delay(1000);
        	//System.out.println("Pressed down already.");
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        }

        //System.out.println("Typing out file location.");

        for(int i = 0; i < documentLocation.length(); i++)
    	{
	        try
	        {
		        Robot robot = new Robot();
		        //robot.delay(1000);
	            //char letter = '/';
	            char letter = documentLocation.charAt(i);

	            if (letter != '/' && letter != '.' && letter != ' ' && letter != '-' && letter != '_')
	            {
		            //System.out.println("I'm inside the IF! ...Somehow.");
	            	boolean upperCase = Character.isUpperCase(letter);
		            char upperLetter = Character.toUpperCase(letter);
		            String variableName = "VK_" + upperLetter;
		            Class clazz = KeyEvent.class;
		            Field field = clazz.getField( variableName );
		            int keyCode = field.getInt(null);
		            
		            if (upperCase) robot.keyPress( KeyEvent.VK_SHIFT );
	            	robot.keyPress( keyCode );
		            robot.keyRelease( keyCode );
		            if (upperCase) robot.keyRelease( KeyEvent.VK_SHIFT );
	            }

	            if (letter == '/')
	            {
	            	robot.keyPress( KeyEvent.VK_SLASH );
	            	robot.keyRelease( KeyEvent.VK_SLASH );
	            }
	            
	            if (letter == '.')
	            {
	            	robot.keyPress( KeyEvent.VK_PERIOD );
	            	robot.keyRelease( KeyEvent.VK_PERIOD );
	            }
	            
//	            if (letter == '\')
//	            {
//	            	robot.keyRelease( KeyEvent.VK_QUOTE );
//	            }
	            
	            if (letter == ' ')
		        {
		            robot.keyPress( KeyEvent.VK_SPACE );
	            	robot.keyRelease( KeyEvent.VK_SPACE );
		        }
	            
	            if (letter == '-')
		        {
		            robot.keyPress( KeyEvent.VK_MINUS );
	            	robot.keyRelease( KeyEvent.VK_MINUS );
		        }
	            
	            if (letter == '_')
		        {
		            robot.keyPress( KeyEvent.VK_UNDERSCORE );
	            	robot.keyRelease( KeyEvent.VK_UNDERSCORE );
		        }
	            
	        }
	        catch(Exception e)
	        {
	            System.out.println(e);
	        }
    	}
        
        try
        {
	        Robot robot2 = new Robot();
	    	robot2.keyPress(KeyEvent.VK_ENTER);
		  	robot2.keyRelease(KeyEvent.VK_ENTER);
			robot2.delay(1000);
			robot2.keyPress(KeyEvent.VK_ENTER);
		  	robot2.keyRelease(KeyEvent.VK_ENTER);
			robot2.delay(1000);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}