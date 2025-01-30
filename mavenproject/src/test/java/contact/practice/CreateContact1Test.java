package contact.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.Loginpage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationinfoPage;
import com.comcastcrm.listenerUtility.ListenerImpClass;
@Listeners(com.comcastcrm.listenerUtility.ListenerImpClass.class)
public class CreateContact1Test extends BaseClass {
	@Test(groups="SmokeTest")
	public void createContact1Test() throws InterruptedException, EncryptedDocumentException, IOException {
		
		
		//ListenerImpClass.test.log(Status.INFO, "read data from excel");
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		// read testscript data from excel file
		String lastname = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// maaximize window
		wLib.maximizeWindow(driver);

		// step 2:navigate to contact module
		//ListenerImpClass.test.log(Status.INFO, "navigate to contact page");
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact page");

		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		// step 3 :click on "create contact" Button
		//ListenerImpClass.test.log(Status.INFO, "navigate to create contact page");
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create contact page");

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreatecontactbutton().click();

		// step 4: enter all details and create new contacts
		//ListenerImpClass.test.log(Status.INFO, "create new contact page");
		UtilityClassObject.getTest().log(Status.INFO, "create new contact page");


		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createWithJustLastName(lastname);

		//ListenerImpClass.test.log(Status.INFO, lastname+ "=====create new contact page");
		UtilityClassObject.getTest().log(Status.INFO, lastname+ "=====create new contact page");

		// verify Header message expected result

		ContactInformationPage cip = new ContactInformationPage(driver);
		cip.verifyCreateContactTest(lastname);
		
//		 String actualheader=cip.getContactheader().getText();
//		 boolean b=actualheader.contains(lastname);
//		 Assert.assertEquals(b, true);
	}
	
	
	@Test(groups="RegressionTest")
	public void createContactWithOrg1Test() throws EncryptedDocumentException, IOException {
  wLib.waitForPageToLoad(driver);
	// maaximize window
	wLib.maximizeWindow(driver);
		// read testscript data from excel file

		String orgname = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String contactLastname = eLib.getDataFromExcel("contact", 7, 3);

		// step 2:navigate to organization module
		// driver.findElement(By.linkText("Organizations")).click();
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// step 3 :click on "create Organization" Button
		OrganizationPage og = new OrganizationPage(driver);
		og.getCreateorgbutton().click();

		// step 4: enter all details and create new organization

		CreatingNewOrganizationPage ng = new CreatingNewOrganizationPage(driver);
		ng.getOrgnames().sendKeys(orgname);
		ng.getSavebutton().click();
		// verify Header message expected result

		OrganizationinfoPage orginfo = new OrganizationinfoPage(driver);
		String actual = orginfo.getHeader().getText();
		if (actual.contains(orgname)) {
			System.out.println(orgname + " header verified ==== PASS");

		} else {
			System.out.println(orgname + " header verified===FAIL");

		}

		// step 5:navigate to contact module

		hp.getContactlink().click();

		// step 6 :click on "create contact" Button

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreatecontactbutton().click();

		// step 7: enter all details and create new contacts

		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.getLastnameedt().sendKeys(contactLastname);
		ccp.getAddOrg().click();

		// switch to child window

		wLib.switchToTabonTitle(driver, "module=Accounts");

		og.getOrgsearch().sendKeys(orgname);
		og.getOrgsearchbuttn().click();
		driver.findElement(By.xpath("//a[.='" + orgname + "']")).click();

		wLib.switchToTabonTitle(driver, "Contacts&action");
		ccp.getSavebutton().click();
		// verify Header message expected result

		ContactInformationPage cip = new ContactInformationPage(driver);
		cip.verifyContactLastName(contactLastname);
		cip.verifyOrgName(orgname);

	}

	
	
	@Test(groups="RegressionTest")
	public void createContactWithSupportDate1Test() throws EncryptedDocumentException, IOException {
		// maaximize window
		wLib.maximizeWindow(driver);

		// read testscript data from excel file

		String lastname = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// step 2:navigate to contact module 
		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		// step 3 :click on "create contact" Button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreatecontactbutton().click();

		// step 4: enter all details and create new contact
		String startdate = jLib.getSystemDateYYYYMMDD();
		String enddate = jLib.getRequiredDateYYYYMMDD(30);

		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContactWithSupportdate(lastname, startdate, enddate);

		// verify Header message expected result


		ContactInformationPage cip = new ContactInformationPage(driver);
		cip.verifyStartDate(startdate);
		cip.verifyEndDate(enddate);



	}
}
