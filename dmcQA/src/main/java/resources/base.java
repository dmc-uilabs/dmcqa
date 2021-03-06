package resources;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.SelectYourInstitution; 


public class base {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	
	public WebDriver initializeDriver() throws IOException{	
		prop = new Properties();
		FileInputStream fileInput = new FileInputStream("src/main/java/resources/data.properties");
	
		prop.load(fileInput);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("chrome")){
			// Using Chrome Driver Manager depencency 
			ChromeDriverManager.getInstance().setup(); 
			
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 30);
			
			//Maximize browser
			driver.manage().window().maximize();


		}
		else if(browserName.equals("firefox")){
			//add firefox capability
			
		}
		else if(browserName.equals("IE")){
			//add IE capability
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
	//DMC Login
	public static void login(WebDriver driver){
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		
		SelectYourInstitution i = new SelectYourInstitution(driver);
		i.getUILabsGuest().click(); 
		
		LoginPage lp = new LoginPage(driver);
		
	
		lp.getEmailUILabsGuest().sendKeys(System.getenv("Selenium_User1"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		lp.getpwUILabsGuest().sendKeys(System.getenv("Selenium_Pass1"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		lp.getSubmitUIGuest().click();
		
		
	}
	//Function to upload a file / photo
		public static void fileLocationUpload(String documentLocation){
			//Go to search bar
			try{
				Robot robot1 = new Robot();
				robot1.delay(1000);

				for(int i = 0; i < 3; i++){
					robot1.keyPress(KeyEvent.VK_TAB);
					robot1.keyRelease(KeyEvent.VK_TAB);	
					robot1.delay(1000);

				}
				robot1.delay(1000);

			}catch(Exception e){
				e.printStackTrace();
			}
		
			//Go to location of file
				try{
					StringSelection stringSelection = new StringSelection(documentLocation);

					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(stringSelection, stringSelection);

					Robot robot2 = new Robot();
					robot2.keyPress(KeyEvent.VK_CONTROL);
					robot2.keyPress(KeyEvent.VK_V);
					robot2.keyRelease(KeyEvent.VK_V);
					robot2.keyRelease(KeyEvent.VK_CONTROL);
					
				}catch(Exception e){
					System.out.println(e);
				}
			//Enter
			try{
				Robot robot3 = new Robot();
				robot3.keyPress(KeyEvent.VK_ENTER);
				robot3.keyRelease(KeyEvent.VK_ENTER);
				robot3.delay(1000);
				
			}catch(Exception e){
				System.out.println(e);
			}
		}//end of fileLocationUpload
		
		
		//Wait for the mentioned seconds (6)
		public static void sleepThreadWait(){
				try {
					Thread.sleep(6000);

				}catch(InterruptedException e){
					e.printStackTrace();

				}
			}//end of sleepThreadWait()

			
		//Wait for the mentioned seconds (3)
		public static void sleepThreadWait2(){
				try {
					Thread.sleep(3000);
					
				}catch(InterruptedException e){
					e.printStackTrace();
					
				}
			}//end of sleepThreadWait2()

		//Method to Screenshot at failure
		public void getScreenshot(String result) throws IOException
		{
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("/home/arsalan/Desktop/test3/dmcqa/dmcQA/screenshots/" + result + "screenshot.png"));
		}
}
