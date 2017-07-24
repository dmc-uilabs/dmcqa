package qaTestByArsalan;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class batchThreeApplication {
	
	public static void main(String[] args) 
	{
        // TODO Auto-generated method stub

        //Create any variables 
		String Selenium_User1 = "dmctest.uilabs@gmail.com";
		String Selenium_Pass1 = "ilvqQ.;%Q*Ce=U6X4?4$";
	
        //Site to test
		String sitePrefix = "portal";
		String siteURL = ".opendmc.org";
		String sitePreAndURL = "https://" + sitePrefix + siteURL;  

	for(int i = 0; i < 1; i++)
	{
		
		System.setProperty("webdriver.chrome.driver", "/home/ali/Downloads/chromedriver");
		//Chrome browser
	    WebDriver driver= new ChromeDriver();
	        
	    //Wait created
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	        
	    //Maximize browser
	    driver.manage().window().maximize(); 
	         
	    //Open portal DMC home page
	    driver.get(sitePreAndURL + "/#/");
	    driver.get(sitePreAndURL + "/#/");
	    System.out.println("DMC Portal Opened");
	    
	    //Login UI LABS Guest
        loginGuest(driver, Selenium_User1, Selenium_Pass1, wait);
        
        driver.close();
        System.out.println("successfully exited browser");
        
	}//end of for-loop
        
        System.out.println("Execution Done");

	}//end of main()
	
	/*  For Login Using UI LABS Guest */
	public static void loginGuest(WebDriver driver, String Selenium_User1, String Selenium_Pass1, WebDriverWait wait)
	{
	        
	        //Find login button and click
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.login-button")));           
	        driver.findElement(By.cssSelector("a.login-button")).click();
	        
	        //Search for institution 
	        driver.findElement(By.id("idp-search")).clear();
	        driver.findElement(By.id("idp-search")).sendKeys("UI Labs Guest Account");
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("#idp-list > li:nth-child(17) > a")).click(); //Login using UI LABS Guest
	        
	        //Provide User Name and password
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username"))); 
	        driver.findElement(By.cssSelector("#username")).sendKeys(Selenium_User1);
	        sleepThreadWait();
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password"))); 
	        driver.findElement(By.cssSelector("#password")).sendKeys(Selenium_Pass1);
	        sleepThreadWait();
	        
	        //Hit the sign in button
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn"))); 
	        driver.findElement(By.cssSelector(".btn")).click();
	        System.out.println("successfully logged in Guest");
	        sleepThreadWait();
	        
	        /*
	        //Create a workspace
	        driver.findElement(By.xpath("//*[@id='my-projects-page']/div[2]/main/section/div[2]/div[3]/div/a")).click();
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("input[ng-model='projectDetails.title']")).sendKeys("Test Workspace");
	        driver.findElement(By.xpath("//*[@id='richdiv']")).clear();
	        driver.findElement(By.xpath("//*[@id='richdiv']")).sendKeys("Testing discussion in workspace for batch three.");
	        sleepThreadWait();
	        driver.findElement(By.xpath("//*[@id='tab-content-0']/div/md-content/ap-tab-one/div/div[1]/div[1]/div/div[2]/md-content[1]/form/div/md-input-container[1]/md-datepicker/button/md-icon")).click();
	        sleepThreadWait();
	        driver.findElement(By.xpath("//*[@id='md-0-2017-7-30']/span")).click();
	        System.out.println("Due date for task completion");
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("md-select[ng-model='projectDetails.type']")).click();
	        driver.findElement(By.cssSelector("md-option[value='public']")).click();
	        driver.findElement(By.cssSelector("input[ng-model='newTag']")).sendKeys("Testing");
	        sleepThreadWait();
	        driver.findElement(By.xpath("//*[@id='tab-content-0']/div/md-content/ap-tab-one/div/div[1]/div[1]/div/div[2]/md-content[2]/div/form/button")).click();
	        driver.findElement(By.cssSelector("input[ng-model='newTag']")).sendKeys("Batch Three");
	        sleepThreadWait();
	        driver.findElement(By.xpath("//*[@id='tab-content-0']/div/md-content/ap-tab-one/div/div[1]/div[1]/div/div[2]/md-content[2]/div/form/button")).click();
	        driver.findElement(By.xpath("//*[@id='tab-content-0']/div/md-content/ap-tab-one/div/div[2]/button")).click();
	        System.out.println("Workspace created.");
	        */
	        
	        //Going to Workspace
	        driver.findElement(By.id("workspaces")).click();
	        sleepThreadWait();
	        
	        //Entering a workspace
	        System.out.println("Entering workspace");
	        sleepThreadWait();
	        //insert while loop to refresh until workspace found
	        driver.navigate().refresh();
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("a[ng-href='project.php#/248/home']")).click();
	        sleepThreadWait();
	        System.out.println("Entered workspace");
	        
	        //Entering services
	        System.out.println("Entering services");
	        driver.findElement(By.cssSelector("a[href='#/248/services']")).click();
	        sleepThreadWait();
	        System.out.println("Entered services");
	        driver.findElement(By.cssSelector("a[href='marketplace.php']")).click();
	        sleepThreadWait();
	        
	        //driver.findElement(By.cssSelector("button[ng-click='nextSlide()']")).click();
	        //sleepThreadWait();
	        //FIX THIS 
	        /*driver.findElement(By.id("tab-content-6")).click();
	        sleepThreadWait();
	        System.out.println("clicked app");
	        
	        String marketplaceApp_1 = "ng-href='/service-marketplace.php#/309'";
	        String marketplaceApp_2 = "ng-href='/service-marketplace.php#/297'";
	        String marketplaceApp_3 = "ng-href='/service-marketplace.php#/315'";
	        String marketplaceApp_4 = "ng-href='/service-marketplace.php#/318'";
	        String marketplaceApp_5 = "ng-href='/service-marketplace.php#/303'";
	        String marketplaceApp_6 = "ng-href='/service-marketplace.php#/288'";
	        String marketplaceApp_7 = "ng-href='/service-marketplace.php#/300'";
	        String marketplaceApp_8 = "ng-href='/service-marketplace.php#/291'";
	        String marketplaceApp_9 = "ng-href='/service-marketplace.php#/312'";
	        String marketplaceApp_10 = "ng-href='/service-marketplace.php#/294'";
	        String marketplaceApp_11 = "ng-href='/service-marketplace.php#/306'";
	        String marketplaceApp_12 = "ng-href='/service-marketplace.php#/409'";
	        String marketplaceApp_13 = "ng-href='/service-marketplace.php#/412'";
	        String marketplaceApp_14 = "ng-href='/service-marketplace.php#/406'";
	        */
	        
	        String xpathFracOne = "/html/body/div[2]/div/div/dmc-products-card/div/div[2]/md-content/div[3]/div[2]/div[";
	        String xpathFracTwo = "]/div/div[1]/a";
	        
	        for(int i = 1; i < 12; i++)
			{
	        	driver.findElement(By.xpath(xpathFracOne + i + xpathFracTwo)).click();
	        	sleepThreadWait();
	        	driver.findElement(By.cssSelector("button[ng-click='addToProject()']")).click();
	        	driver.findElement(By.cssSelector("input[ng-required='$mdAutocompleteCtrl.isRequired']")).click();
	        	driver.findElement(By.cssSelector("input[ng-required='$mdAutocompleteCtrl.isRequired']")).sendKeys("Title - ");
	        	driver.findElement(By.cssSelector("li[ng-click='$mdAutocompleteCtrl.select($index)']")).click();
	        	driver.findElement(By.cssSelector("button[ng-disabled='!projectModel']")).click();
	        	sleepThreadWait();
	        	if (driver.getPageSource().contains("Added to Title - "))
	        	{
	        		System.out.println("Added Fracture Mechanics App " + i);
	        	}
	        	else
	        	{
	        		System.out.println("App add check Fracture Mechanics App " + i + "failed");
	        	}
	        	driver.navigate().back();
	        	sleepThreadWait();
			}
	        
	        String xpathPhysOne = "/html/body/div[2]/div/div/dmc-products-card/div/div[2]/md-content/div[4]/div[2]/div[";
	        String xpathPhysTwo = "]/div/div[1]/a";
	        
	        for(int i = 1; i < 4; i++)
			{
	        	driver.findElement(By.xpath(xpathPhysOne + i + xpathPhysTwo)).click();
	        	sleepThreadWait();
	        	driver.findElement(By.cssSelector("button[ng-click='addToProject()']")).click();
	        	driver.findElement(By.cssSelector("input[ng-required='$mdAutocompleteCtrl.isRequired']")).click();
	        	driver.findElement(By.cssSelector("input[ng-required='$mdAutocompleteCtrl.isRequired']")).sendKeys("Title");
	        	driver.findElement(By.cssSelector("li[ng-click='$mdAutocompleteCtrl.select($index)']")).click();
	        	driver.findElement(By.cssSelector("button[ng-disabled='!projectModel']")).click();
	        	sleepThreadWait();
	        	if (driver.getPageSource().contains("Added to Title - "))
	        	{
	        		System.out.println("Added Physics App " + i);
	        	}
	        	else
	        	{
	        		System.out.println("App add check Physics App " + i + "failed");
	        	}
	        	driver.navigate().back();
	        	sleepThreadWait();
			}
	        
	        
	        
	        //Logging out
	        driver.findElement(By.cssSelector(".user-button")).click();
	        sleepThreadWait();
	        driver.findElement(By.xpath("/html/body/div[4]/md-menu-content/md-menu-item[3]")).click();
	        sleepThreadWait();
	        driver.navigate().refresh();
	        sleepThreadWait();
	        System.out.println("successfully logged out Guest");

	}//end of loginGuest()
	
	//randomizing for letters
	public String generateRandomString(int length)
	{
	    return RandomStringUtils.randomAlphabetic(length);
	} 

	//randomizing for numbers
	public String generateRandomNumber(int length)
	{
	    return RandomStringUtils.randomNumeric(length);
	}  
	
	public static void sleepThreadWait()
	{
        try 
        {
                        Thread.sleep(6000);
                        
        }catch(InterruptedException e)
        {
                        
                        e.printStackTrace();
        }

	}
	
	/*
	//Function to add Marketplace apps in workspace
	public static void addMarketplaceApps()
	{
		System.setProperty("webdriver.chrome.driver", "/home/ali/Downloads/chromedriver");
		//Chrome browser
	    WebDriver driver= new ChromeDriver();
	    
		//Add all marketplace apps
		try
		{
			Robot robot1 = new Robot();
			robot1.delay(1000);
				
			for(int i = 1; i < 282; i++)
			{
				if (i < 171)
				{
					robot1.keyPress(KeyEvent.VK_TAB);
					robot1.keyRelease(KeyEvent.VK_TAB);	
					robot1.delay(1000);
				}
				
				if (i >= 171)
				{
					robot1.keyPress(KeyEvent.VK_TAB);
					robot1.keyRelease(KeyEvent.VK_TAB);	
					robot1.delay(1000);
					
					if ((i % 10 == 1) || (i % 10 == 6))
					{
						robot1.keyPress(KeyEvent.VK_ENTER);
						robot1.keyRelease(KeyEvent.VK_ENTER);	
						robot1.delay(1000);
						
						driver.findElement(By.cssSelector("input[ng-if='!floatingLabel']")).click();
						driver.findElement(By.cssSelector("input[ng-if='!floatingLabel']")).sendKeys("Title");
						
						robot1.keyPress(KeyEvent.VK_DOWN);
						robot1.keyRelease(KeyEvent.VK_DOWN);
						robot1.delay(1000);
						
						robot1.keyPress(KeyEvent.VK_ENTER);
						robot1.keyRelease(KeyEvent.VK_ENTER);	
						robot1.delay(1000);
						
						robot1.keyPress(KeyEvent.VK_TAB);
						robot1.keyRelease(KeyEvent.VK_TAB);	
						robot1.delay(1000);
						
						robot1.keyPress(KeyEvent.VK_ENTER);
						robot1.keyRelease(KeyEvent.VK_ENTER);	
						robot1.delay(1000);
					}
				}

			}
				
		}catch(Exception e)
		{
				e.printStackTrace();
		}
	}
	*/
	
}
