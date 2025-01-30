package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	
	@FindBy(linkText="Organizations")
	private WebElement orglink;
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutlink;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement logoutbutn;
	 
	//contacts
	@FindBy(linkText="Contacts")
	private WebElement contactlink;
	
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getOrglink() {
		return orglink;
	}


	public WebElement getLogoutlink() {
		return logoutlink;
	}
	
	
	
	public WebElement getLogoutbutn() {
		return logoutbutn;
	}


	public WebElement getContactlink() {
		return contactlink;
	}
	


	public void logout(WebDriver driver) throws InterruptedException
	{
		 
		mousemoveonElement(driver, logoutlink);
		 logoutbutn.click();
//		 
//		
//		Actions a=new Actions(driver);
//		a.moveToElement(logoutlink).perform();
//		Thread.sleep(5000);
//		logoutbutn.click();
		
		
		
//		Actions a=new Actions(driver);
//		a.moveToElement(logoutlink).perform();
//		logoutbutn.click();
		
	}
}
