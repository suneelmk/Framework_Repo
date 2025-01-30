package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrganizationinfoPage {

	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement header;
	
	
	@FindBy(id="dtlview_Industry")
	private WebElement actualindustry;
	
	@FindBy(id="dtlview_Type")
	private WebElement actualtexts;
	
	
	@FindBy(id="dtlview_Phone")
	private WebElement actualphone;
	
	
	public OrganizationinfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeader() {
		return header;
	}

	public WebElement getActualindustry() {
		return actualindustry;
	}

	public WebElement getActualtexts() {
		return actualtexts;
	}

	public WebElement getActualphone() {
		return actualphone;
	}
	
	//verify  
	
	public void verifyCreateOrgTest(String orgname)
	{
		 String actual=getHeader().getText();
		 boolean b=actual.contains(orgname);
		 Assert.assertEquals(b, true);
//         if(actual.contains(orgname))
//		        {
//		        	System.out.println(orgname+" header verified ==== PASS");
//		        	
//		        }
//		        else
//		        {			    
//		        	System.out.println(orgname +" header verified===FAIL");
//	           
//		        }
	}
	
	public void verifyIndustry(String industry)
	{
		String actuaindustry=getActualindustry().getText();
		Assert.assertEquals(actuaindustry, industry);

//	       if(actuaindustry.equals(industry))
//	       {
//	    	   System.out.println(industry+" information is verified===PASS");
//	       }else
//	       {
//	    	   System.out.println(industry+" information is not verified===FAIL");
//	       }
	}
	public void verifytext(String type)
	{
		 String actualtxt=getActualtexts().getText();
		 Assert.assertEquals(actualtxt, type);
//	       if(actualtxt.equals(type))
//	       {
//	    	   System.out.println(type+" information is verified===PASS");
//	       }else
//	       {
//	    	   System.out.println(type+" information is not verified===FAIL");
//	       } 
	}
	
	public void verifyPhoneNumber(String phonenumber )
	{
		String actualPhones= getActualphone().getText();
		Assert.assertEquals(actualPhones, phonenumber);
//	       if(actualPhones.equals(phonenumber))
//	        {
//	        	System.out.println(phonenumber+" information is created==PASS");
//	        }
//	        else
//	        {
//	        	System.out.println(phonenumber+" information is not created==PASS");
//	        }
	}
	
	public void verifyDeleteOrgHeader(String orgname )
	{
		 String actual=getHeader().getText();
		 boolean b=actual.contains(orgname);
		 Assert.assertEquals(b, true);
//         if(actual.contains(orgname))
//		        {
//		        	System.out.println(orgname+" header verified ==== PASS");
//		        	
//		        }
//		        else
//		        {			    
//		        	System.out.println(orgname +" header verified===FAIL");
//	           
//		        }
	}
}
