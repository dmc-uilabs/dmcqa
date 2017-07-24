package qaTestByArsalan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class testBatchOneUpdate {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //Create any variables 
String Selenium_User1 = "dmctest.uilabs@gmail.com";
String Selenium_Pass1 = "ilvqQ.;%Q*Ce=U6X4?4$";
String Selenium_Pass2 = "dmctest.uilabs1";
        
        //Site to test
String sitePrefix = "portal";
String siteURL = ".opendmc.org";
String sitePreAndURL = "https://" + sitePrefix + siteURL;  

for(int i = 0; i < 1; i++){
	
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
        
        //Login Google
        loginGoogle(driver, Selenium_User1, Selenium_Pass2, wait);
        
        //Login UI LABS Guest
        loginGuest(driver, Selenium_User1, Selenium_Pass1, wait);
        
         driver.close();
        System.out.println("successfully exited browser");
        
}//end of for-loop
        
        System.out.println("Execution Done");

}//end of main()

/*  For Login Using UI LABS Guest */
public static void loginGuest(WebDriver driver, String Selenium_User1, String Selenium_Pass1, WebDriverWait wait){
        
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
        
        //Logging out
        driver.findElement(By.cssSelector(".user-button")).click();
        sleepThreadWait();
        driver.findElement(By.xpath("/html/body/div[4]/md-menu-content/md-menu-item[3]")).click();
        sleepThreadWait();
        driver.navigate().refresh();
        sleepThreadWait();
        System.out.println("successfully logged out Guest");

}//end of loginGuest()

/*  For Login Using Google */
public static void loginGoogle(WebDriver driver, String Selenium_User1, String Selenium_Pass2, WebDriverWait wait){
        
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