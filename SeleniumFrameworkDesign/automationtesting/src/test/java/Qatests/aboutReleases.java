package Qatests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import resources.base;
public class aboutReleases extends base{

	public void aboutReleasesTest(){
		 //Navigate to Releases Page
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().to("https://portal.opendmc.org/release-notes.php#/");
		
		//Verify that it is on correct page
		String pageTitle = driver.getTitle();
		System.out.println("Title is " + pageTitle);
		Assert.assertTrue(pageTitle.contains("Release Notes"));
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait
		
		//Gets the information about all the releases, and checks if the current is different from previous releases Note However: 4,3,2 are the same
		String V1_8 = driver.findElement(By.xpath("//*[@id='tab-content-0']/div/md-content/div[1]/p")).getText();
		//System.out.println("V 0.1.8 " + V1_8)
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/md-content/div/div[3]/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]/span")).click();

		String V1_7 = driver.findElement(By.xpath("//*[@id='tab-content-1']/div/md-content/div[1]/p")).getText();
		//System.out.println("V 0.1.7 " + V1_7);

		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/md-content/div/div[3]/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[3]/span")).click();
		String V1_6  = driver.findElement(By.xpath("//*[@id='tab-content-2']/div/md-content/div[1]/p[1]")).getText();
		//System.out.println("V 0.1.6 " + V1_6);
		
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/md-content/div/div[3]/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[4]/span")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String V1_5  = driver.findElement(By.xpath("//*[@id='tab-content-3']/div/md-content/div[1]/p[1]")).getText();
		//System.out.println("V 0.1.5 " + V1_5);
	
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/md-cntent/div/div[3]/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span")).click();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String V1_4  = driver.findElement(By.xpath("//*[@id='tab-content-4']/div/md-content/div/span/p[1]")).getText();
		//System.out.println("V 0.1.4 " + V1_4);
		
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/md-content/div/div[3]/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[6]/span")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String V1_3  = driver.findElement(By.xpath("//*[@id='tab-content-5']/div/md-content/div/p[1]")).getText();
		//System.out.println("V 0.1.3 " + V1_3);
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/md-content/div/div[3]/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[7]/span")).click();
		String V1_2  = driver.findElement(By.xpath("//*[@id='tab-content-6']/div/md-content/div/p[1]")).getText();
		//System.out.println("V 0.1.2 " + V1_2);

		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/md-content/div/div[3]/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[8]/span")).click();
		String V1_1  = driver.findElement(By.xpath("//*[@id='tab-content-7']/div/md-content/div/div/p[1]")).getText();

		//System.out.println("V 0.1.1 BETA " + V1_1);
		driver.findElement(By.xpath("/html/body/div[2]/ui-view/div/md-content/div/div[3]/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[9]/span")).click();
		String V1_0  = driver.findElement(By.xpath("//*[@id='tab-content-8']/div/md-content/div/div[1]/p[1]")).getText();
		//System.out.println("V 0.1.0 ALPHA " + V1_0);
	
		//Check if the current release is different from the previous releases
		if(V1_8 == V1_7){
			System.out.println("Test Failed: V 0.1.8 and V 0.1.7 are the same");
		}
		if(V1_8 == V1_6){
			System.out.println("Test Failed: V 0.1.8 and V 0.1.6 are the same");
		}
		if(V1_8 == V1_5){
			System.out.println("Test Failed: V 0.1.8 and V 0.1.5 are the same");
		}
		if(V1_8 == V1_4){
			System.out.println("Test Failed: V 0.1.8 and V 0.1.4 are the same");
		}
		if(V1_8 == V1_3){
			System.out.println("Test Failed: V 0.1.8 and V 0.1.3 are the same");
		}
		if(V1_8 == V1_2){
			System.out.println("Test Failed: V 0.1.8 and V 0.1.2 are the same");
		}
		if(V1_8 == V1_1){
			System.out.println("Test Failed: V 0.1.8 and V 0.1.1 BETA are the same");
		}
		if(V1_8 == V1_0){
			System.out.println("Test Failed: V 0.1.8 and V 0.1.0 ALPHA are the same");
		}
		//If we reached here test was successful
		System.out.println("Test completed - DMC Release Notes Page verifified");
	}
}
