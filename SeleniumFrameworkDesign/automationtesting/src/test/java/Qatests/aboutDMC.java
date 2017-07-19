package Qatests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import resources.base;

public class aboutDMC extends base {
	
	public void aboutDMCTest(){
	//Navigate to About the DMC page
     driver.navigate().refresh();
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 driver.navigate().to("https://portal.opendmc.org/onboarding.php#/home"); 
	 
	
	 //Verify page
	 String pageTitle = driver.getTitle();
	 System.out.println("Title is " + pageTitle);
	 //String expected_title = "Onboarding";
	 //Assert.assertEquals(expected_title, pageTitle);
	 Assert.assertTrue(pageTitle.contains("Onboarding"));

	 System.out.println("Currently on 1st Tab");
	 driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div > md-content > div > div > div:nth-child(12) > md-tabs > md-tabs-wrapper > md-tabs-canvas > md-pagination-wrapper > md-tab-item:nth-child(2) > span")).click();		
	 System.out.println("2nd Tab Clicked");
	 driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div > md-content > div > div > div:nth-child(12) > md-tabs > md-tabs-wrapper > md-tabs-canvas > md-pagination-wrapper > md-tab-item:nth-child(3) > span")).click();
	 System.out.println("3rd Tab Clicked");
	 driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div > md-content > div > div > div:nth-child(12) > md-tabs > md-tabs-wrapper > md-tabs-canvas > md-pagination-wrapper > md-tab-item.md-tab.ng-scope.ng-isolate-scope.md-active > span")).click();
	 System.out.println("4th Tab Clicked");
	 driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div > md-content > div > div > div:nth-child(12) > md-tabs > md-tabs-wrapper > md-tabs-canvas > md-pagination-wrapper > md-tab-item.md-tab.ng-scope.ng-isolate-scope.md-active > span")).click();
	 System.out.println("5th Tab Clicked");
	 driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div > md-content > div > div > div:nth-child(12) > md-tabs > md-tabs-wrapper > md-tabs-canvas > md-pagination-wrapper > md-tab-item.md-tab.ng-scope.ng-isolate-scope.md-active > span")).click();
	 System.out.println("6th Tab Clicked");
	 

	 //View Opportunities (Join Our Team Page)
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 driver.findElement(By.cssSelector("body > div.ng-scope > ui-view > div > md-content > div > div > div:nth-child(18) > div > h3:nth-child(3) > p > span > a")).click();


	 System.out.println("Test completed - Onboarding Page verifified");
	}
}
