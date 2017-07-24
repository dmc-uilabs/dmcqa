package automationtesting;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;


import resources.base;

public class LoginUILABSGuest extends base {
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
