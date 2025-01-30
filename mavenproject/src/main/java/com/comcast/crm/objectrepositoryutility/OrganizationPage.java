package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
 
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createorgbutton;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement searchdropdown;
	
	@FindBy(name="submit")
	private WebElement searchNowbutton;
	
	//popup org
	@FindBy(name="search_text")
	private WebElement orgsearch;
	
	@FindBy(name="search")
	private WebElement orgsearchbuttn;
	
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//getters

	
	
	public WebElement getCreateorgbutton() {
		return createorgbutton;
	}

	public WebElement getOrgsearch() {
		return orgsearch;
	}

	public WebElement getOrgsearchbuttn() {
		return orgsearchbuttn;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchdropdown() {
		return searchdropdown;
	}

	public WebElement getSearchNowbutton() {
		return searchNowbutton;
	}
	
	
	
}
