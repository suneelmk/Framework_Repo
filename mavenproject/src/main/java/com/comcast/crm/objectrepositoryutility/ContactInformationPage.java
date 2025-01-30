package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContactInformationPage {

	
	@FindBy(id="dtlview_Last Name")
	private WebElement contactheader;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement actualStartDate;
	
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement actualEndDate;
	
	@FindBy(id="mouseArea_Last Name")
	private WebElement contactlastname;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement verifyorgname;
	
	
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	public WebElement getContactheader() {
		return contactheader;
	}

	public WebElement getActualStartDate() {
		return actualStartDate;
	}

	public WebElement getActualEndDate() {
		return actualEndDate;
	}
	
	public WebElement getContactlastname() {
		return contactlastname;
	}

	public WebElement getVerifyorgname() {
		return verifyorgname;
	}
	
	//verify
	
	
	public void verifyContactLastName(String contactLastname )
	{
		String actuallast=contactlastname.getText();
		boolean b=actuallast.contains(contactLastname);
		Assert.assertEquals(b, true);
//		if(actuallast.equals(contactLastname))
//        {
//        	System.out.println(contactLastname+" information verified ==== PASS");
//        	
//        }
//        else
//        {
//        	System.out.println(contactLastname +" information is not  verified===FAIL");
//        }
	}
	
	
	public void verifyOrgName(String orgname )
	{
		String actOrgname=verifyorgname.getText();
		boolean b=actOrgname.contains(orgname);
		Assert.assertEquals(b, true);
		
//		if(actOrgname.trim().contains(orgname))
//        {
//        	System.out.println(orgname+" information verified ==== PASS");
//        	
//        }
//        else
//        {
//        	System.out.println(orgname +" information is not  verified===FAIL");
//        }
	}

	public void verifyCreateContactTest(String lastname)
	{
		 String actualheader=getContactheader().getText();
		 boolean b=actualheader.contains(lastname);
		 Assert.assertEquals(b, true);
		
	        
//	        if(actualheader.contains(lastname))
//	        {
//	        	System.out.println(lastname+" information verified ==== PASS");
//	        	
//	        }
//	        else
//	        {
//	        	System.out.println(lastname +" information is not  verified===FAIL");
//	        }
		 
	}
	
	
	public void verifyStartDate(String startdate )
	{
		 String actualstart=getActualStartDate().getText();
		 Assert.assertEquals(actualstart, startdate);
	        
//	        if(actualstart.equals(startdate))
//		        {
//		        	System.out.println(startdate+" information verified ==== PASS");
//		        	
//		        }
//		        else
//		        {
//		        	System.out.println(startdate +" information is not  verified===FAIL");
//		        }
	}
	
	
	public void verifyEndDate(String enddate)
	{
		String actualend= getActualEndDate().getText();
		Assert.assertEquals(actualend, enddate);
	       
//	       if(actualend.equals(enddate))
//	        {
//	        	System.out.println(enddate+" information verified ==== PASS");
//	        	
//	        }
//	        else
//	        {
//	        	System.out.println(enddate +" information is not  verified===FAIL");
//	        }
	}
	
}
