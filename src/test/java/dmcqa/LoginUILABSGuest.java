package dmcqa;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.SelectYourInstitution;
import resources.base;


public class LoginUILABSGuest extends base{
	public static Logger Log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	
	}
	
	
	@Test
	public void loginGuest()
	{
		login(driver);
		
	}
	
	
	@AfterTest
	public void teardown(){
		driver.close();
		driver = null;
	}
}