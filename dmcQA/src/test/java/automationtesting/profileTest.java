package automationtesting;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Home;
import pageObjects.ManageAccount;
import resources.base;

public class profileTest extends base {
	public static Logger Log = LogManager.getLogger(base.class.getName());
	
 	String documentLocation1 = "/home/arsalan/Desktop/test3/dmcqa/dmcQA/documentUploads/office.jpg";
 	String documentLocation2 = "/home/arsalan/Desktop/test3/dmcqa/dmcQA/documentUploads/uilabs.jpg";
 	String name1 = "John Doe 1";
 	String name2 = "John Doe 2";
 	String jobTitle1 = "DMC Intern 1";
 	String jobTitle2 = "DMC Intern 2";
 	String locat1 = "UI LABS 1";
 	String locat2 = "UI LABS 2";
 	String myDescription1 = "This is my description 1";
 	String myDescription2 = "This is my description 2";
 	String tag1 = "Test Tag 1";
 	String tag2 = "Test Tag 2";
 	
	
	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();		
		driver.get(prop.getProperty("url"));
		login(driver);
	}
	
	@Test
	public void myProfile() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //wait
        driver.navigate().refresh();
		 
         sleepThreadWait();
       
         Home home = new Home(driver);
         ManageAccount myprofile = new ManageAccount(driver);
        
         
         home.getUserMenu().click();
       
         
         sleepThreadWait2();
         home.getMyAccount().click();
         //Profile Page
         myprofile.getProfilePage().click();

		 //Display Name
		 myprofile.getDisplayName().clear();
		 myprofile.getDisplayName().sendKeys(name1);
		 
		 sleepThreadWait2(); //wait
		 
		 //Job Title
		 myprofile.getJobTitle().clear();
		 myprofile.getJobTitle().sendKeys(jobTitle1);
		
		 sleepThreadWait2(); //wait

		 //My Description
		 myprofile.getTextbox().clear();
		 myprofile.getTextbox().sendKeys(myDescription1);
		 
		 //My Skills
		 myprofile.getSkillsTab().click();
		 myprofile.getEnterSkill().sendKeys(tag1);
		 myprofile.getAdd().click(); //add
		 
		 
		 //Upload and Change Photo
		 sleepThreadWait2();

		 myprofile.getUpload().click(); //document drop 
		 
		 fileLocationUpload(documentLocation1);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //wait
		 
		 myprofile.getSave().click(); //save
		 
		 sleepThreadWait(); //wait
		 driver.navigate().refresh();
		 
		 sleepThreadWait(); //wait
		 driver.navigate().refresh();

		 System.out.println("Picture uploaded");
		
	}
	
	@AfterTest
	public void teardown(){
		driver.close();
		driver = null;
	}
}
