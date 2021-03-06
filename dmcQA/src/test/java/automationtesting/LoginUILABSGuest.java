package automationtesting;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

///This is the test one
import resources.base;

public class LoginUILABSGuest extends base {
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
		Log.info("Successful Login");
	}
	
	
	@AfterTest
	public void teardown(){
		driver.close();
		driver = null;
	}
}
