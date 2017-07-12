package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testingBatchFour {
	 public static void main(String[] args) {
	        // TODO Auto-generated method stub

	        //Create any variables 
	String Selenium_User1 = "dmctest.uilabs@gmail.com";
	String Selenium_Pass1 = "ilvqQ.;%Q*Ce=U6X4?4$";
	String Selenium_Pass2 = "dmctest.uilabs1";
	StringBuilder verifyCode = new StringBuilder("");
	        
	        //Site to test
	String sitePrefix = "portal";
	String siteURL = ".opendmc.org";
	String sitePreAndURL = "https://" + sitePrefix + siteURL;  

	for(int i = 0; i < 1; i++){
		
			System.setProperty("webdriver.chrome.driver", "/home/ali/Downloads/chromedriver");
			//Chrome browser
			WebDriver driver= new ChromeDriver();
	        
			
/*			//For incognito
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("incognito");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			System.setProperty("webdriver.chrome.driver", "/home/ali/Downloads/chromedriver");
			WebDriver driver = new ChromeDriver(capabilities);
*/
	      
			//Wait created
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        
	        //Maximize browser
	        driver.manage().window().maximize(); 
	         
	        //Open portal DMC home page
	        driver.get(sitePreAndURL + "/#/");
	        driver.get(sitePreAndURL + "/#/");
	        System.out.println("DMC Portal Opened");
	        
	        //Google
	        requestVerification(driver, Selenium_User1, Selenium_Pass2, wait);
	        
	        //DMC QA admin
	        adminVerify(driver, Selenium_User1, Selenium_Pass1, verifyCode, wait);
	        
	        //self verifying account
	        selfVerify(driver, Selenium_User1, Selenium_Pass2, verifyCode, wait);
	        
	        driver.close();
	        System.out.println("successfully exited browser");
	        
	}//end of for-loop
	        
	        System.out.println("Execution Done");

	}//end of main()

	/*  For verifying an organization member */
	public static void adminVerify(WebDriver driver, String Selenium_User1, String Selenium_Pass1, StringBuilder verifyCode, WebDriverWait wait){
	        
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
	        
	        //Go to verification request
	        driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div/div[2]/md-menu[1]")).click();
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("body > div.md-open-menu-container.md-whiteframe-z2.md-default-theme.md-active.md-clickable > md-menu-content > md-menu-item:nth-child(2)")).click();
	        sleepThreadWait();
	        
	        //Verify user
	        driver.findElement(By.xpath("/html/body/div[2]/div/md-content/div[4]/div[2]/div/div/div[3]/div[2]/a")).click();
	        sleepThreadWait();
	        driver.findElement(By.xpath("/html/body/div[2]/div/md-content/div[4]/div[2]/div/div/div[4]/div[2]/button[3]")).click();
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("#dialog_24 > md-content > div.button-aria.layout.layout-row.layout-align-center-center > button:nth-child(1)")).click();
	        System.out.println("verification code sent");
	        sleepThreadWait();
	        
	        //Store verification code into variable
	        WebElement el = driver.findElement(By.xpath("//*[@id='dialog_24']/md-content/div[1]/h4"));
	        verifyCode.append(el.getText());
	        System.out.println(verifyCode);
	        System.out.println("saved verification code");
	        driver.findElement(By.cssSelector("#dialog_24 > md-content > div.button-aria.layout.layout-row.layout-align-center-center > button:nth-child(3)")).click();
	        sleepThreadWait();
	        System.out.println("verification code confirmed");
	        
	        //Logging out
	        driver.findElement(By.cssSelector(".user-button")).click();
	        sleepThreadWait();
	        driver.findElement(By.xpath("/html/body/div[4]/md-menu-content/md-menu-item[3]")).click();
	        sleepThreadWait();
	        driver.navigate().refresh();
	        sleepThreadWait();
	        System.out.println("successfully logged out Admin");

	}//end of loginGuest()

	/*  For Google Account Requesting Verification */
	public static void requestVerification(WebDriver driver, String Selenium_User1, String Selenium_Pass2, WebDriverWait wait){
	        
	        //Find login button and click
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.login-button")));           
	        driver.findElement(By.cssSelector("a.login-button")).click();
	        
	        //Search for institution 
	        driver.findElement(By.id("idp-search")).clear();
	        driver.findElement(By.id("idp-search")).sendKeys("Google");
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("#idp-list > li:nth-child(5)")).click(); //Login using Google
	        
	        //Provide User Name and password
	        driver.findElement(By.id("identifierId")).sendKeys(Selenium_User1);
	        driver.findElement(By.id("identifierNext")).click();
	        sleepThreadWait();
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input"))); 
	        driver.findElement(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")).sendKeys(Selenium_Pass2);
	        sleepThreadWait();
	        driver.findElement(By.id("passwordNext")).click();
	        sleepThreadWait();
	        
	        //Going to My Accounts
	        driver.findElement(By.cssSelector(".user-button")).click();
	        sleepThreadWait();
	        driver.findElement(By.xpath("/html/body/div[4]/md-menu-content/md-menu-item[1]/a")).click();
	        sleepThreadWait();
	        
	        //Search for organization 
	        driver.findElement(By.id("fl-input-4")).clear();
	        driver.findElement(By.id("fl-input-4")).sendKeys("DMC QA Organization");
	        sleepThreadWait();
	        driver.findElement(By.id("ul-4")).click(); //Choose organization
	        
	        //Request Verification from admin
	        driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/div[2]/div/div/md-content/div[4]/div[2]/button")).click();
	        System.out.println("requested verification");
	        sleepThreadWait();
	        
	        //Logging out
	        driver.findElement(By.cssSelector(".user-button")).click();
	        sleepThreadWait();
	        driver.findElement(By.xpath("/html/body/div[4]/md-menu-content/md-menu-item[3]")).click();
	        sleepThreadWait();
	        driver.navigate().refresh();
	        sleepThreadWait();
	        System.out.println("successfully logged out Google"); 

	}//end of requestVerification()
	
	/*  Account Verifying Itself */
	public static void selfVerify(WebDriver driver, String Selenium_User1, String Selenium_Pass2, StringBuilder verifyCode, WebDriverWait wait){
	        
	        //Find login button and click
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.login-button")));           
	        driver.findElement(By.cssSelector("a.login-button")).click();
	        
	        //Search for institution 
	        driver.findElement(By.id("idp-search")).clear();
	        driver.findElement(By.id("idp-search")).sendKeys("Google");
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("#idp-list > li:nth-child(5)")).click(); //Login using Google
	        System.out.println("Google successfully logged in");
	        
/*	        //Provide User Name and password
	        driver.findElement(By.id("identifierId")).sendKeys(Selenium_User1);
	        driver.findElement(By.id("identifierNext")).click();
	        sleepThreadWait();
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input"))); 
	        driver.findElement(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")).sendKeys(Selenium_Pass2);
	        sleepThreadWait();
	        driver.findElement(By.id("passwordNext")).click();
	        sleepThreadWait();  
*/
	  
	        //Going to My Accounts
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/header/div[1]/div/div/div[3]/md-menu/button")));
	        driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div/div[3]/md-menu/button")).click();
	        System.out.println("Accessed user button properly");
	        sleepThreadWait();
	        driver.findElement(By.xpath("/html/body/div[4]/md-menu-content/md-menu-item[1]/a")).click();
	        System.out.println("Accessed 'My Accounts' button properly");
	        sleepThreadWait();
	        
	        //Search for organization 
	        driver.findElement(By.id("fl-input-4")).clear();
	        driver.findElement(By.id("fl-input-4")).sendKeys("DMC QA Organization");
	        sleepThreadWait();
	        driver.findElement(By.id("ul-4")).click(); //Choose organization
	        
	        //Self verifying account 
	        driver.findElement(By.id("input_5")).click();
	        //driver.findElement(By.id("input_5")).clear();
	        driver.findElement(By.id("input_5")).sendKeys(verifyCode);
	        //System.out.println(driver.findElement(By.id("input_5")).sendKeys(verifyCode));
	        System.out.println("Entered verification code");
	        sleepThreadWait();
	        driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/div[2]/div/div/md-content/div[5]/div[2]/button")).click(); //Login using Google
	        sleepThreadWait();
	        System.out.println("Account successfully verified");
	        
	        //Logging out
	        driver.findElement(By.cssSelector(".user-button")).click();
	        sleepThreadWait();
	        driver.findElement(By.xpath("/html/body/div[4]/md-menu-content/md-menu-item[3]")).click();
	        sleepThreadWait();
	        driver.navigate().refresh();
	        sleepThreadWait();
	        System.out.println("successfully logged out Google");

	}//end of loginGuest()

	public static void sleepThreadWait(){
	        try {
	                        Thread.sleep(6000);
	                        
	        }catch(InterruptedException e){
	                        
	                        e.printStackTrace();
	        }

	}
	}//end of class
