package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProjectWorkspace {
	public WebDriver driver;

	By documentsTab  = By.xpath("/html/body/div[2]/ui-view/workspace-header/div/div/a[2]");
	By uploadIcon = By.cssSelector("body > div.ng-scope > ui-view > div > div > md-content > ui-widget-work-space > div.page-header > md-toolbar > div > div > button:nth-child(8) > ng-md-icon");
	By dropFileHere = By.id("documentDropZone");
	By upload = By.id("dialog_6");
	By checkbox = By.xpath("/html/body/div[2]/ui-view/div/div/md-content/ui-widget-work-space/div[2]/md-data-table-container/table/tbody/tr/td[1]/md-checkbox/div[1]");
	
	By trashcanIcon = By.cssSelector("body > div.ng-scope > ui-view > div > div > md-content > ui-widget-work-space > div.page-header > md-toolbar > div > div > button:nth-child(3) > ng-md-icon > svg > path:nth-child(4)");
	By penIcon = By.xpath("/html/body/div[2]/ui-view/div/div/md-content/ui-widget-work-space/div[2]/md-data-table-container/table/tbody/tr/td[8]/button[1]/ng-md-icon/svg");
	By shareIcon = By.cssSelector("body > div.ng-scope > ui-view > div > div > md-content > ui-widget-work-space > div.documents-folder.flex > md-data-table-container > table > tbody > tr > td:nth-child(8) > button:nth-child(2) > ng-md-icon > svg");
	
	
	By shareWith = By.cssSelector("#select_32");
	By shareDMCWorkspace = By.id("select_option_55");
	By shareWithWorkspace = By.cssSelector("#ul-79 > li");
	By shareButton = By.id("dialog_66");
	By shareConfirm = By.cssSelector("#dialog_66 > md-content > section > button:nth-child(12) > span");
	
	By deleteOK = By.xpath("/html/body/div[4]/md-dialog/div/button[2]");
	By saveDoc = By.xpath("//*[@id='dialog_75']/div/div/button[1]/span");
	
	By docRename = By.xpath("//*[@id='input_76']");
	
	By edit = By.cssSelector("body > div.ng-scope > ui-view > workspace-header > div > md-toolbar > div.layout.layout-row.layout-align-end-end > a.link-button.uppercase.edit-button.margin-left20.ng-scope");
	By deleteWorkspace = By.cssSelector("body > div.ng-scope > ui-view > div > div > div > div.content-panel-header > md-toolbar > div > button");
	By yesDeleteWorkspace = By.cssSelector("body > div.md-dialog-container.ng-scope > md-dialog > div > button:nth-child(2) > span");
	
	
	public ProjectWorkspace(WebDriver driver) {
		//Auto-generated constructor stub
		this.driver=driver;
	}
	
	public WebElement getYesDeleteWorkspace(){
		return driver.findElement(yesDeleteWorkspace);
	}
	public WebElement getDeleteWorkspaceButton(){
		return driver.findElement(deleteWorkspace);
	}
	
	
	public WebElement getEditButton(){
		return driver.findElement(edit);
	}
	
	public WebElement getShareIcon()
	{
		return driver.findElement(shareIcon);
	}
	public WebElement getShareWith()
	{
		return driver.findElement(shareWith);
	}
	public WebElement getShareDMCWorkspace()
	{
		return driver.findElement(shareDMCWorkspace);
	}
	public WebElement getShareWithWorkspace()
	{
		return driver.findElement(shareWithWorkspace);
	}
	public WebElement getShareButton()
	{
		return driver.findElement(shareButton);
	}
	public WebElement getShareConfirm(){
		return driver.findElement(shareConfirm);
	}
	
	

	public WebElement getDocumentsTab()
	{
		return driver.findElement(documentsTab);
	}
	public WebElement getUploadIcon()
	{
		return driver.findElement(uploadIcon);
	}
	public WebElement getDropFileHere()
	{
		return driver.findElement(dropFileHere);
	}
	public WebElement getUpload()
	{
		return driver.findElement(upload);
	}
	public WebElement getCheckbox()
	{
		return driver.findElement(checkbox);
	}
	public WebElement getTrashCanIcon()
	{
		return driver.findElement(trashcanIcon);
	}
	public WebElement getDeleteOk()
	{
		return driver.findElement(deleteOK);
	}
	public WebElement getSaveDoc()
	{
		return driver.findElement(saveDoc);
	}
	public WebElement getDocRename()
	{
		return driver.findElement(docRename);
	}
	
}
