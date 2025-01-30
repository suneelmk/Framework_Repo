package org.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationinfoPage;
@Listeners(com.comcastcrm.listenerUtility.ListenerImpClass.class)
public class CreateOrg1Test extends BaseClass {

	@Test(groups = "SmokeTest")
	public void createOrg1Test() throws EncryptedDocumentException, IOException {
		wLib.waitForPageToLoad(driver);
		// maximize window
		wLib.maximizeWindow(driver);
		// read test script data from excel file
		System.out.println("start");
		String orgname = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
		System.out.println("start-stop");
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
		orginfo.verifyCreateOrgTest(orgname);

	}

	@Test(groups = "RegressionTest")
	public void createOrgwithindustries1Test() throws EncryptedDocumentException, IOException {
		wLib.waitForPageToLoad(driver);
		// maximize window
		wLib.maximizeWindow(driver);

		// read test script data from excel file

		String orgname = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);

		// step 2:navigate to organization module
		// driver.findElement(By.linkText("Organizations")).click();
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// step 3 :click on "create Organization" Button
		// driver.findElement(By.xpath("//img[@title='Create
		// Organization...']")).click();
		OrganizationPage org = new OrganizationPage(driver);
		org.getCreateorgbutton().click();

		// step 4: enter all details and create new organization

		CreatingNewOrganizationPage cog = new CreatingNewOrganizationPage(driver);
		cog.createOrgWithIndustry(orgname, industry, type);

		// verify industry and type info

		OrganizationinfoPage oinfo = new OrganizationinfoPage(driver);
		oinfo.verifyIndustry(industry);
		oinfo.verifytext(type);

	}

	@Test(groups = "RegressionTest")
	public void createOrgWithPhoneNumber1Test() throws EncryptedDocumentException, IOException {
		wLib.waitForPageToLoad(driver);
		// maaximize window
		wLib.maximizeWindow(driver);

		// read testscript data from excel file

		String orgname = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String phonenumber = eLib.getDataFromExcel("org", 7, 3);

		// step 2:navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// step 3 :click on "create Organization" Button
		OrganizationPage og = new OrganizationPage(driver);
		og.getCreateorgbutton().click();

		// step 4: enter all details and create new organization

		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.createOrgWithPhone(orgname, phonenumber);

		// verify phonenumber expected result

		OrganizationinfoPage oinfo = new OrganizationinfoPage(driver);
		oinfo.verifyPhoneNumber(phonenumber);

	}

}
