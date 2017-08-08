package automationtesting;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Home;
import pageObjects.CompanyProfile;
import resources.base;

public class AdminVerify extends base {
	public static Logger Log = LogManager.getLogger(base.class.getName());
	private StringBuilder VerifyCode = new StringBuilder("");
	
	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		login(driver);

	}

	
	@Test
	public void VerifyMember()
	{
		Home l = new Home(driver);
		l.seeNotifications().click();
		sleepThreadWait2();
		l.goToRequest().click();
		sleepThreadWait();
		
		CompanyProfile vm = new CompanyProfile(driver);
		ScrollDown();
		vm.seeUserDetails().click();
		sleepThreadWait2();
		vm.acceptRequest().click();
		sleepThreadWait2();
		vm.finalizeVerification().click();
		sleepThreadWait2();
		Log.info("verification code sent");
		
		sleepThreadWait2();
		WebElement el = vm.saveVerificationToken();
		
		VerifyCode.append(el.getText());
		System.out.println(VerifyCode);
		codeVerify = VerifyCode.toString();
		Log.info("saved verification code");
		vm.closePopUp().click();
		sleepThreadWait2();
		Log.info("verification code confirmed");
		
	}
	
	public StringBuilder Test(){
		return this.VerifyCode;
	}
	
	public static void ScrollDown(){
		//Go to search bar
		try{
			int i = 2000;
			Robot robot1 = new Robot();
			robot1.delay(1000);
			
			robot1.keyPress(KeyEvent.VK_DOWN);
			robot1.delay(i);
			robot1.keyRelease(KeyEvent.VK_DOWN);	

			robot1.delay(1000);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@AfterTest
	public void teardown(){
		logout lp = new logout();
		lp.logoutAccount();
		driver.close();
		driver = null;
	}
}