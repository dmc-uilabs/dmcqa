package automationtesting;
import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pageObjects.Home;
import pageObjects.LandingPage;

import resources.base;

public class validateTitle extends base {
	public static Logger Log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		Log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		
		login(driver);
		Log.info("Navigated to home page");
	}
	
	@Test
	public void validateAppTitle() throws IOException
	{
		Home  h = new Home(driver);
	
		Assert.assertEquals(h.getTitle().getText(), "DIGITAL MANUFACTURING COMMONS");
		Log.info("Successfully validated home page title");
		 
		
	}
	
	@AfterTest
	public void teardown(){
		driver.close();
		driver = null;
	}
}
