package qaTestByArsalan;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class batchThreeDiscussion 
{
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
	        
	        //Adding a discussion
	        driver.findElement(By.cssSelector("button[class='add-button-square md-button ng-scope md-default-theme']")).click();
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("input[ng-model='NewDiscussion.subject']")).clear();
	        driver.findElement(By.cssSelector("input[ng-model='NewDiscussion.subject']")).sendKeys("Discussion" +" - "+"Test" + " - " + RandomStringUtils.randomAlphabetic(3) + RandomStringUtils.randomNumeric(3));
	        driver.findElement(By.xpath("//*[@id='richdiv']")).clear();
	        driver.findElement(By.xpath("//*[@id='richdiv']")).sendKeys("Adding Discussion-" + RandomStringUtils.randomAlphabetic(3) + RandomStringUtils.randomNumeric(3));
	        driver.findElement(By.xpath("//*[@id='dialog_7']/div/div[2]/button[2]")).click();
	        sleepThreadWait();
	        
	        //Checking visibility of user profile picture
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[ng-src='https://dmcupfinal.s3.amazonaws.com/USER/cuid-d3d4270e-7eab-4e60-a3c3-81bd8317a959%40uilabs.idp.cirrusidentity.com/Documents/1500308257-943363-sanitized-download.png?AWSAccessKeyId=AKIAIZPP46XXRK6PBF6A&Expires=1502986659&Signature=CeZFbFLwUqckBpHYjIhKYj4qT98%3D']")));
	        System.out.println("Profile picture is visible in discussion");
	        
	        //Creating a task
	        driver.findElement(By.cssSelector("a[ng-href='https://portal.opendmc.org/project.php#/248/home']")).click();
	        System.out.println("Back to Project- creating task");
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("a[class='add-button-square md-button ng-scope md-default-theme']")).click();
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("textarea[ng-model='task.title']")).clear();
	        driver.findElement(By.cssSelector("textarea[ng-model='task.title']")).sendKeys("New" +" - "+"Task" + " - " + RandomStringUtils.randomAlphabetic(3) + RandomStringUtils.randomNumeric(3));
	        driver.findElement(By.xpath("//*[@id='richdiv']")).clear();
	        driver.findElement(By.xpath("//*[@id='richdiv']")).sendKeys("Adding Task-" + RandomStringUtils.randomAlphabetic(3) + RandomStringUtils.randomNumeric(3));
	        driver.findElement(By.xpath("/html/body/div[2]/div/form/div[2]/div/div[2]/md-content/div/md-datepicker/div/button")).click();
	        sleepThreadWait();
	        driver.findElement(By.xpath("//*[@id='md-0-2017-7-30']/span")).click();
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("md-select[ng-model='task.priority']")).click();
	        driver.findElement(By.cssSelector("md-option[ng-repeat='p in priorities']")).click();
	        driver.findElement(By.cssSelector("md-select[ng-model='task.assigneeId']")).click();
	        driver.findElement(By.cssSelector("md-option[value='248-593-593']")).click();
	        sleepThreadWait();
	        driver.findElement(By.xpath("/html/body/div[2]/div/div/button[2]")).click();
	        sleepThreadWait();
	        System.out.println("New Task Created");
	        
	        //Completing and Checking Task Completion
	        driver.findElement(By.cssSelector("button[class='md-raised dmc-button md-button md-default-theme']")).click();
	        System.out.println("Task Completed");
	        sleepThreadWait();
	        System.out.println("Checking for Task Completion");
	        
	        int exists = driver.findElements(By.xpath("/html/body/div[2]/ui-view/div/md-content/div[2]/div[2]/div/md-content/ul/li[1]")).size();
	        
	        if(exists == 0){
	    		System.out.println("Test Failed: Task Completion Not Evident");
	    	}
	    	
	        else if(exists != 0){
	    		System.out.println("Test Passed: Task Completion Evident on Task Page");
	    	}
	        
	        driver.findElement(By.cssSelector("a[href='/project.php#/248/home']")).click();
	        sleepThreadWait();
	        System.out.println("On Home Page- checking task completion");
	        
	        int existsTwo = driver.findElements(By.cssSelector("strike[ng-bind-html='item.formatedDueDate[1]']")).size();
	        
	        if(existsTwo == 0){
	    		System.out.println("Test Failed: Task Completion Not Evident");
	    	}
	    	
	        else if(existsTwo != 0){
	    		System.out.println("Test Passed: Task Completion Evident on Home Page");
	    	}
	        
	        driver.findElement(By.xpath("/html/body/div[2]/ui-view/workspace-header/div/div/a[6]")).click();
	        sleepThreadWait();
	        System.out.println("On Task Page- checking task completion");
	      
	        int existsThree = driver.findElements(By.cssSelector("strike[ng-bind-html='item.formatedDueDate[1]']")).size();
	        
	        if(existsThree == 0){
	    		System.out.println("Test Failed: Task Completion Not Evident");
	    	}
	    	
	        else if(existsThree != 0){
	    		System.out.println("Test Passed: Task Completion Evident on Tasks Page");
	    	}
	        
	        if(exists != 0 && existsTwo != 0 && existsThree != 0){
	    		System.out.println("All Tests Passed: Task Completion Evident on All Pages");
	    	}
	        
	        else {
	        	System.out.println("Test Failed: Task Completion Not Evident on One or More Pages");
	        }
	        
	        //Updating Workspace Name, Tags, and Description
	        driver.findElement(By.id("workspaces")).click();
	        System.out.println("In workspaces section");
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("a[ng-href='project.php#/248/home']")).click();
	        sleepThreadWait();
	        System.out.println("Back to Workspace- Updating Workspace Information");
	        driver.findElement(By.cssSelector("a[ng-href='/project.php#/248/edit']")).click();
	        sleepThreadWait();
	        
	        //Declaring randomized updates
	        String projectTitle = "Title" + " - " + RandomStringUtils.randomAlphabetic(3) + RandomStringUtils.randomNumeric(3);
	        String projectDescription = "Description" + " - " + RandomStringUtils.randomAlphabetic(3) + RandomStringUtils.randomNumeric(3);
	        String projectTag = "Tag" + RandomStringUtils.randomAlphabetic(3) + RandomStringUtils.randomNumeric(3);
	        
	        //Inserting updates
	        driver.findElement(By.cssSelector("input[ng-model='projectDetails.title']")).clear();
	        driver.findElement(By.cssSelector("input[ng-model='projectDetails.title']")).sendKeys(projectTitle);
	        System.out.println("Updated Workspace Title Name");
	        driver.findElement(By.xpath("//*[@id='richdiv']")).clear();
	        driver.findElement(By.xpath("//*[@id='richdiv']")).sendKeys(projectDescription);
	        System.out.println("Updated Workspace Description");
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("input[ng-model='newTag']")).sendKeys(projectTag);
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("button[ng-disabled='!newTag']")).click();
	        sleepThreadWait();
	        System.out.println("Added New Tag");
	        driver.findElement(By.cssSelector("button[ng-disabled='!form.$valid']")).click();
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("button[ng-click='submitProjectDetails(invitees)']")).click();
	        System.out.println("Successfully Updated Changes in Workspace");
	        
	        //Checking Changes 
	        driver.findElement(By.id("workspaces")).click();
	        sleepThreadWait();
	        driver.navigate().refresh();
	        sleepThreadWait();
	        System.out.println("Back to Workspace- Checking Updated Changes");
	        
	        //Storing variables to confirm changes
	        WebElement elTitle = driver.findElement(By.cssSelector("a[ng-href='project.php#/248/home']"));
	        String verifyTitle = elTitle.getText();
	        System.out.println("Title Name: " + verifyTitle);
	        
	        WebElement elDesc = driver.findElement(By.cssSelector("div[markdown-to-html='item.description']"));
	        String verifyDesc = elDesc.getText();
	        System.out.println("Description Name: " + verifyDesc);
	        
	       
	        WebElement elTag = driver.findElement(By.xpath("//*[@id='myProjectsList']/section/section/div[1]/div[7]/div/div/div[4]"));
	        String verifyTag = elTag.getText();
	        System.out.println("Tag Name: " + verifyTag);
	        
	        //Checking for noted updated changes 
	        if (projectTitle.equals(verifyTitle)){
	    		System.out.println("Test Passed: Title Change Stored Successfully");
	    	}
	    	
	        else {
	    		System.out.println("Test Failed: Title Change Not Stored");
	    	}
	        
	        if (projectDescription.equals(verifyDesc)){
	    		System.out.println("Test Passed: Description Change Stored Successfully");
	    	}
	    	
	        else {
	    		System.out.println("Test Failed: Description Change Not Stored");
	    	}
	        
	        if (projectTag.equals(verifyTag)){
	    		System.out.println("Test Passed: Additional Tag Stored Successfully");
	    	}
	    	
	        else {
	    		System.out.println("Test Failed: Additional Tag Not Stored");
	    	}
	        
	        //Replying to discussion
	        System.out.println("Attempting to reply to discussion");
	        driver.findElement(By.cssSelector("a[ng-href='project.php#/248/home']")).click();
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("a[href='/individual-discussion.php#/108']")).click();
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("a[ng-if='$first']")).click();
	        driver.findElement(By.id("richdiv")).click();
	        sleepThreadWait();
	        driver.findElement(By.id("richdiv")).sendKeys("Replying to discussion- " + RandomStringUtils.randomAlphabetic(5) + RandomStringUtils.randomNumeric(5));
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("button[ng-disabled='!NewReview.Comment']")).click();
	        System.out.println("Attempt Successful: Replied to discussion");
	        
	        //Preparing Account for Next Test
	        System.out.println("Preparing account for retest");
	        driver.findElement(By.id("workspaces")).click();
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("a[ng-href='project.php#/248/home']")).click();
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("a[ng-href='/project.php#/248/edit']")).click();
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("button[ng-click='deleteTag($index,tag)']")).click();
	        sleepThreadWait();
	        System.out.println("Deleted New Tag");
	        driver.findElement(By.cssSelector("button[ng-disabled='!form.$valid']")).click();
	        sleepThreadWait();
	        driver.findElement(By.cssSelector("button[ng-click='submitProjectDetails(invitees)']")).click();
	        driver.navigate().refresh();
	        System.out.println("Account prepared for new trial");
	        
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
	
	
}