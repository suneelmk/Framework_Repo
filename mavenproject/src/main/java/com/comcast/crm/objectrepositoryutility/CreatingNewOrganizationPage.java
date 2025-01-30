package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatingNewOrganizationPage extends WebDriverUtility{

	@FindBy(name="accountname")
	private WebElement orgnames;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industrydd;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement industryelement;
	
	
	
	@FindBy(id="phone")
	private WebElement phonenum;
	
	
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getPhonenum() {
		return phonenum;
	}

	public WebElement getOrgnames() {
		return orgnames;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}


	public WebElement getIndustrydd() {
		return industrydd;
	}


	public WebElement getIndustryelement() {
		return industryelement;
	}


	public void createOrgWithIndustry(String orgname,String industry,String type)
	{
		orgnames.sendKeys(orgname);
		 selectByVisibleText(industrydd,industry);
		 selectByVisibleText(industryelement,type);
		 savebutton.click();
		 
	}
	
  public void createOrgWithPhone(String orgname,String phonenumber)
  {
	  orgnames.sendKeys(orgname);
	  phonenum.sendKeys(phonenumber);
	  savebutton.click();
  }
	
}
