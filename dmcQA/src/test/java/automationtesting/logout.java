package automationtesting;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Home;
import pageObjects.LandingPage;
import resources.base;

public class logout extends base {
	public static Logger Log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		GoogleLogin(driver);
	}

	
	@Test
	public void logoutAccount()
	{

		Home l = new Home(driver);
		l.getUserMenu().click();
		sleepThreadWait2();
		l.logout().click();
		sleepThreadWait2();
		driver.navigate().refresh();
	    sleepThreadWait2();

		Log.info("Successful Logout");
	}


	@AfterTest
	public void teardown(){
		driver.close();
		driver = null;
	}
}
