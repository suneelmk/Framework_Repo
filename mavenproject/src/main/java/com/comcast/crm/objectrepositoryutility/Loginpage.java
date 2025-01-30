package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	//Rule 1 create a separate java class
	//Rule 2 Object Creation

	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginbutton;

	
	          
	//Rule 3 Object Initialization(it has to be done in test script and not in pomscript)
	
	
	//Rule 4 Object Encapsulation
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	
	//Rule 5 if required  Provide action(Business method----this method can be used for specific to application)
	public void logintoApp(String username,String password)
	{
		
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginbutton.click();
		
		
	}
	//initializing by constuctor
	
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

}
