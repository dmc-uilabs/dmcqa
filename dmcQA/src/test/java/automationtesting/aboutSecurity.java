package automationtesting;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class aboutSecurity extends base{
	public static Logger Log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		login(driver);
	}
	
	@Test
	public void aboutSecurityTest(){
		//Navigate to DMC Security Page
				driver.navigate().refresh();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.navigate().to("https://dev-web2.opendmc.org/security.php#/");
				
				//Verify that it's on the correct Page
				String pageTitle = driver.getTitle();
				Log.info("Title is " + pageTitle);
				Assert.assertTrue(pageTitle.contains("Security"));
			
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait
				driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > main > section > div:nth-child(2) > div:nth-child(2) > div > h3:nth-child(21) > a")).click();
				driver.navigate().refresh(); //refresh browser 
				
				//Verify that it's on the correct Page
				String pageTitle2 = driver.getTitle();
				Log.info("Title is " + pageTitle2);
				Assert.assertTrue(pageTitle2.contains("Terms and Conditions"));
				
				driver.navigate().back();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > main > section > div:nth-child(2) > div:nth-child(4) > div > a")).click();
				
				driver.navigate().refresh(); //refresh browser 

				//Verify that it's on the correct Page
				String pageTitle3 = driver.getTitle();
				Log.info("Title is " + pageTitle3);
				Assert.assertTrue(pageTitle3.contains("Contact Us"));
				//Successful 
				Log.info("Test completed - DMC Security Page verifified");
	}
	
	@AfterTest
	public void teardown(){
		driver.close();
		driver = null;
	}
}
