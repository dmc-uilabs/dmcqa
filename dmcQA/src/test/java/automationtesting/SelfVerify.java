package automationtesting;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Home;
import pageObjects.ManageAccount;
import resources.base;

public class SelfVerify extends base{
	public static Logger Log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		GoogleLogin(driver);

	}

	//
	@Test
	public void VerifySelf()
	{
		Home l = new Home(driver);
		l.getUserMenu().click();
		sleepThreadWait2();
		l.getMyAccount().click();
		sleepThreadWait2();
		
		ManageAccount mp = new ManageAccount(driver);
		mp.findOrganization().clear();
		mp.findOrganization().sendKeys("DMC QA Organization");
		sleepThreadWait2();
		mp.chooseOrganization().click();
		//start changing from here
		mp.enterToken().click();
		mp.enterToken().sendKeys(codeVerify);
		sleepThreadWait2();
		mp.verifyAccount().click();
		sleepThreadWait();
		Log.info("Account Successfully Verified");
	}


	@AfterTest
	public void teardown(){
		logout lp = new logout();
		lp.logoutAccount();
		driver.close();
		driver = null;
	}
}
