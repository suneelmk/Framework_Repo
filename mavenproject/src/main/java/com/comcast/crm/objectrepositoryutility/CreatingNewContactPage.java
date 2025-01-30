package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {

	
	@FindBy(name="lastname")
	private  WebElement lastnameedt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	//create contact with support date
	
	@FindBy(name="support_start_date")
	private WebElement startdate;
	
	@FindBy(name="support_end_date")
	private WebElement enddate;
	
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement addOrg;
	
	public CreatingNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

//getters
	
	public WebElement getLastnameedt() {
		return lastnameedt;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	         
	public WebElement getStartdate() {
		return startdate;
	}
	

	public WebElement getAddOrg() {
		return addOrg;
	}

	public WebElement getEnddate() {
		return enddate;
	}

	//business methods 
	public void createWithJustLastName(String lastname)
	{
		lastnameedt.sendKeys(lastname);
		savebutton.click();
	}
	
	public void createContactWithSupportdate(String lastname , String startsdate,String endsdate)
	{
		lastnameedt.sendKeys(lastname);
		startdate.clear();
		startdate.sendKeys(startsdate);
		enddate.clear();
		enddate.sendKeys(endsdate);
		savebutton.click();
	}
}
