package dmcqa;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Home;
import pageObjects.ProjectWorkspace;
import pageObjects.Workspaces;
import resources.base;

public class workspaceDocTest extends base {
	
	String document = "/home/arsalan/Desktop/test2/quick/dmcqa/documentUploads/office.jpg";
	
	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		login(driver);
	}
	
	
	@Test
	public void uploadDocumentToWorkspace()
	{
		Home h = new Home(driver);
		Workspaces w = new Workspaces(driver);
		ProjectWorkspace p = new ProjectWorkspace(driver);
		
		h.getWorkspacesTab().click();
		w.getCreatedWorkspace().click();
		
		p.getDocumentsTab().click(); //Documents Tab
		
		p.getUploadIcon().click(); //File upload icon
		sleepThreadWait2(); //wait
		p.getDropFileHere().click(); //Drop File Here Menu
		
		fileLocationUpload(document);
		
		sleepThreadWait(); //wait
		
		p.getUpload().click(); //Upload File Button	
	}
	
	@Test
	public void shareDocument(){
		Home h = new Home(driver);
		Workspaces w = new Workspaces(driver);
		ProjectWorkspace p = new ProjectWorkspace(driver);
		
		h.getWorkspacesTab().click();
		w.getCreatedWorkspace().click();
		
		p.getDocumentsTab().click(); //Documents Tab
		
		p.getShareIcon().click();
		p.getShareWith().click();
		p.getShareDMCWorkspace().click();
		
		p.getShareWithWorkspace().click();
		p.getShareConfirm().click();
	}
	
	@Test
	public void deleteDocument(){
		Home h = new Home(driver);
		Workspaces w = new Workspaces(driver);
		ProjectWorkspace p = new ProjectWorkspace(driver);
		
		h.getWorkspacesTab().click();
		w.getCreatedWorkspace().click();
		
		p.getDocumentsTab().click(); //Documents Tab
		
		p.getCheckbox().click(); //click checkbox
		p.getTrashCanIcon().click(); //trash icon
		p.getDeleteOk().click(); //delete doc
	}
	
	
	@Test
	public void deleteWorkspace(){
		Home h = new Home(driver);
		Workspaces w = new Workspaces(driver);
		ProjectWorkspace p = new ProjectWorkspace(driver);
		
		h.getWorkspacesTab().click();
		w.getCreatedWorkspace().click();
		
		p.getEditButton().click();
		p.getDeleteWorkspaceButton().click();
		p.getYesDeleteWorkspace().click();
		
	}
	
	@AfterTest
	public void teardown(){
		driver.close();
		driver = null;
	}
	
	
	
	
}
