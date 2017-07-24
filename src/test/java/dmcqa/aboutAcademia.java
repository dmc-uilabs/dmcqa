package dmcqa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import resources.base;

public class aboutAcademia extends base {
	public void aboutAcademiaTest(){
		//Declare any Variables
				int before = 0;
				int after  = 0;
				
				//Navigate to DMC Academia Page
		        driver.navigate().refresh();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.navigate().to("https://portal.opendmc.org/academia.php#/");

				
				//Verify that it is on correct page
				String pageTitle = driver.getTitle();
				System.out.println("Title is " + pageTitle);
				Assert.assertTrue(pageTitle.contains("DMC Academia"));
				
				//Verify that Before clicking content should be hidden
				System.out.println("Before clicking on VIEW ACADEMIC CONTENT");
				System.out.println(driver.findElement(By.xpath("//*[@id='uniContent']/section[1]/div/div[2]/h1")).isDisplayed());

				//Verify Before clicking content should be hidden
				System.out.println("Before clicking on VIEW COURSERA CERTIFICATION");
				System.out.println(driver.findElement(By.xpath("//*[@id='courseraContent']/section[2]/div/div/h2")).isDisplayed());

				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait

				//Check if the content is hidden 
				if((driver.findElement(By.xpath("//*[@id='uniContent']/section[1]/div/div[2]/h1")).isDisplayed()) == false && (driver.findElement(By.xpath("//*[@id='courseraContent']/section[2]/div/div/h2")).isDisplayed()) == false){
					before = 1;
				}
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait
				
				driver.findElement(By.xpath("//*[@id='hideshowUni']")).click(); //Click on link

				//Verify that After clicking content should be visible
				System.out.println("After clicking on VIEW ACADEMIC CONTENT");
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

				System.out.println(driver.findElement(By.xpath("//*[@id='uniContent']/section[1]/div/div[2]/h1")).isDisplayed());

				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait

				driver.findElement(By.xpath("//*[@id='hideshowCou']")).click(); //Click on link

				//Verify that After clicking content should be visible
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

				System.out.println("After clicking on VIEW COURSERA CERTIFICATION");
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				System.out.println(driver.findElement(By.xpath("//*[@id='courseraContent']/section[2]/div/div/h2")).isDisplayed());

				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait
		
				//Check if the content is visible
				if((driver.findElement(By.xpath("//*[@id='uniContent']/section[1]/div/div[2]/h1")).isDisplayed()) == true && (driver.findElement(By.xpath("//*[@id='courseraContent']/section[2]/div/div/h2")).isDisplayed()) == true){
					after = 1;
				}
				//Check if the test passed or failed
				if(before == 0 && after == 0){
					System.out.println("Test FAILED");
				}
				else{
					System.out.println("Test completed - DMC Academia Page verifified");
				}
	}
}
