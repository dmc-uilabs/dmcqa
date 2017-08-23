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

import pageObjects.AcademiaStaticPage;
import pageObjects.Home;
import resources.base;

public class aboutAcademia extends base {
	public static Logger Log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		login(driver);
	}
	
	@Test
	public void aboutAcademiaStaticPageTest()
	{
		//Declare any Variables
		int before = 0;
		int after  = 0;
		
		//Navigate to DMC Academia Page
		Home h = new Home(driver);
		AcademiaStaticPage academia = new AcademiaStaticPage(driver);
		
		//h.getAboutFromNavBar().click();
		//h.getAcademiaTab().click();
        driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().to("https://dev-web2.opendmc.org/academia.php#/");
	
		//Verify that it is on correct page
		String pageTitle = driver.getTitle();
		Log.info("Academia Static Page Title is " + pageTitle);
		Assert.assertTrue(pageTitle.contains("DMC Academia"));
		
		//Verify that Before clicking content should be hidden
		Log.info("Before clicking on VIEW ACADEMIC CONTENT: " + academia.getViewAcademiaContent().isDisplayed());
	
		//Verify Before clicking content should be hidden
		Log.info("Before clicking on VIEW COURSERA CERTIFICATION: " + academia.getViewCourseraContent().isDisplayed());
	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait

		//Check if the content is hidden 
		if((driver.findElement(By.xpath("//*[@id='uniContent']/section[1]/div/div[2]/h1")).isDisplayed()) == false && (driver.findElement(By.xpath("//*[@id='courseraContent']/section[2]/div/div/h2")).isDisplayed()) == false){
			before = 1;
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait
		
		driver.findElement(By.xpath("//*[@id='hideshowUni']")).click(); //Click on link

		//Verify that After clicking content should be visible
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Log.info("After clicking on VIEW ACADEMIC CONTENT: " + driver.findElement(By.xpath("//*[@id='uniContent']/section[1]/div/div[2]/h1")).isDisplayed());


		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait
		driver.findElement(By.xpath("//*[@id='hideshowCou']")).click(); //Click on link

		//Verify that After clicking content should be visible
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		Log.info("After clicking on VIEW COURSERA CERTIFICATION: " + driver.findElement(By.xpath("//*[@id='courseraContent']/section[2]/div/div/h2")).isDisplayed());


		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait

		//Check if the content is visible
		if((driver.findElement(By.xpath("//*[@id='uniContent']/section[1]/div/div[2]/h1")).isDisplayed()) == true && (driver.findElement(By.xpath("//*[@id='courseraContent']/section[2]/div/div/h2")).isDisplayed()) == true){
			after = 1;
		}
		//Check if the test passed or failed
		if(before == 0 && after == 0){
			Log.info("Test Failed ");
		}
		else{
			Log.info("Test completed - DMC Academia Page verifified");
		}
}
	
	@AfterTest
	public void teardown(){
		driver.close();
		driver = null;
	}
}
