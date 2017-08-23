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

public class aboutDMC extends base {
	public static Logger Log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		login(driver);
	}
	
	@Test
	public void aboutDMCTest(){
	//Navigate to About the DMC page
     driver.navigate().refresh();
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 driver.navigate().to("https://dev-web2.opendmc.org/onboarding.php#/home"); 
	 
	 //Verify page
	 String pageTitle = driver.getTitle();
	 Log.info("Title is " + pageTitle);
	 //String expected_title = "Onboarding";
	 //Assert.assertEquals(expected_title, pageTitle);
	 Assert.assertTrue(pageTitle.contains("Onboarding"));

	 Log.info("Currently on 1st Tab");
	 driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div > md-content > div > div > div:nth-child(12) > md-tabs > md-tabs-wrapper > md-tabs-canvas > md-pagination-wrapper > md-tab-item:nth-child(2) > span")).click();		
	 Log.info("2nd Tab Clicked");
	 driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div > md-content > div > div > div:nth-child(12) > md-tabs > md-tabs-wrapper > md-tabs-canvas > md-pagination-wrapper > md-tab-item:nth-child(3) > span")).click();
	 Log.info("3rd Tab Clicked");
	 driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div > md-content > div > div > div:nth-child(12) > md-tabs > md-tabs-wrapper > md-tabs-canvas > md-pagination-wrapper > md-tab-item.md-tab.ng-scope.ng-isolate-scope.md-active > span")).click();
	 Log.info("4th Tab Clicked");
	 driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div > md-content > div > div > div:nth-child(12) > md-tabs > md-tabs-wrapper > md-tabs-canvas > md-pagination-wrapper > md-tab-item.md-tab.ng-scope.ng-isolate-scope.md-active > span")).click();
	 Log.info("5th Tab Clicked");
	 driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div > md-content > div > div > div:nth-child(12) > md-tabs > md-tabs-wrapper > md-tabs-canvas > md-pagination-wrapper > md-tab-item.md-tab.ng-scope.ng-isolate-scope.md-active > span")).click();
	 Log.info("6th Tab Clicked");
	 

	 //View Opportunities (Join Our Team Page)
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div > md-content > div > div > div:nth-child(18) > div > h3:nth-child(3) > p > span > a")).click();


	 Log.info("Test completed - Onboarding Page verifified");
	}
	
	@AfterTest
	public void teardown(){
		driver.close();
		driver = null;
	}
}
