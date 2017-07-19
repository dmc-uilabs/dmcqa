package Qatests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class restCompanies extends base{
	
	
	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();		
		driver.get(prop.getProperty("url"));
		login(driver);
	}
	
	@Test
	public void restCompaniesTest(){
			//URL is entered to visit ~.opendmc.org/rest/companies
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait
		    	driver.get("https://portal.opendmc.org/rest/companies");
		    	
		    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait
		    	int exists = driver.findElements(By.xpath("/html/body/pre") ).size();
		    	
		    	/* 
		    	 * Check if page returns a Blank, Whitelabel Error Page, or {"message":"REST Internal Error"} Page
		    	 * If so the test failed 
		    	 */
		    	if(exists == 0){
		    		System.out.println("Test Failed: Blank Page");
		    	}
		    	
		    	if(exists != 0){
		    		//System.out.println(exists);
		    		if(driver.getPageSource().contains("Whitelabel Error Page")){
		    			System.out.println("Test Failed: Whitelabel Error Page");
		    		}
		    		if(driver.getPageSource().contains("REST Internal Error")){
		    			System.out.println("Test Failed: REST Internal Error");
		    		}
		    	}
		    	//driver.getPageSource().contains("General Electric")
		    	long startTime = System.currentTimeMillis(); //fetch starting time

		    	while(false||(System.currentTimeMillis()-startTime)<10000){
		        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > pre")));
		    		//Check if the element is returned to the screen
		    		if(!driver.findElements(By.cssSelector("body > pre")).isEmpty()){
		                System.out.println("Rest/Comapnies can be reached");
		                break;
		        	}
		        	else{
		                System.out.println("Rest/Comapnies can not be reached");
		                break;
		        	}	
		    	}
		    	System.out.println("Out of Loop - Test Completed");
	}
	
}
