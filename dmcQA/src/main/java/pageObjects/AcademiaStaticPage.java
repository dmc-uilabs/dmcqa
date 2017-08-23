package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AcademiaStaticPage {
	public WebDriver driver;
	
	By viewAcademia = By.xpath("//*[@id='uniContent']/section[1]/div/div[2]/h1");
	By coursera = By.xpath("//*[@id='courseraContent']/section[2]/div/div/h2");

	public AcademiaStaticPage(WebDriver driver) {
		//Auto-generated constructor stub
		this.driver=driver;
	}

	
	public WebElement getViewAcademiaContent()
	{
		return driver.findElement(viewAcademia);
	}
	public WebElement getViewCourseraContent()
	{
		return driver.findElement(coursera);
	}
	
}
