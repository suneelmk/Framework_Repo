package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createcontactbutton;
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	//getters
	
	public WebElement getCreatecontactbutton() {
		return createcontactbutton;
	}
	
	
		
	
}
