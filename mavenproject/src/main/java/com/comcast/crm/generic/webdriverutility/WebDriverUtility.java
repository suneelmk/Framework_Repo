package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	//implicit wait
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	//explicit wait
	public void waitForElementPresent(WebDriver driver, WebElement element)
	{
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));	
	 wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForAllElements(WebDriver driver,List<WebElement> elements)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	public void waitForUrlContains(WebDriver driver, String str)
	{
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));	
	 wait.until(ExpectedConditions.urlContains(str));
	}
	public void waitForUrlToBe(WebDriver driver, String str)
	{
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));	
	 wait.until(ExpectedConditions.urlToBe(str));
	}
	public void waitForFrameToBeAvailableAndSwitchToIt(WebDriver driver, int index)
	{
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));	
	 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));	
	 wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForElementToBeClickable(WebDriver driver,WebElement element,String str)
	{
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));	
	 wait.until(ExpectedConditions.textToBePresentInElement(element, str));
	}
	public void waitForTitleContains(WebDriver driver, String title)
	{
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));	
	 wait.until(ExpectedConditions.titleContains(title));
	}
	public void switchToTabonURL(WebDriver driver, String partialUrl)
	{
		 Set<String> set = driver.getWindowHandles();
         Iterator<String> it=set.iterator();
         while(it.hasNext())
         {
      	   String windowID=it.next();
      	   driver.switchTo().window(windowID);
      	   String actUrl=driver.getCurrentUrl();
      	   if(actUrl.contains(partialUrl))
      	   {
      		   break;
      	   }
         }
	}
	
	
	
	public void switchToTabonTitle(WebDriver driver, String partialTitle)
	{
		 Set<String> set = driver.getWindowHandles();
         Iterator<String> it=set.iterator();
         while(it.hasNext())
         {
      	   String windowID=it.next();
      	   driver.switchTo().window(windowID);
      	   String actUrl=driver.getTitle();
      	   if(actUrl.contains(partialTitle))
      	   {
      		   break;
      	   }
         }
	}
	//frames
	//parent to child
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String nameID)
	{
		driver.switchTo().frame(nameID);
	}
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	//child to parent
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	//child to mainframe
	public void switchToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	
	//alert popup
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void switchToAlertAndGetText(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	public void switchToAlertAndSendkeys(WebDriver driver,String str)
	{
		driver.switchTo().alert().sendKeys(str);
	}
//	public void select(WebElement element, String text)
//	{
//		Select s=new Select(element);
//		s.selectByVisibleText(text);
//	}
//	public void select(WebElement element, int index)
//	{
//		Select s=new Select(element);
//		s.selectByIndex(index);
	//}
	//Actions class
	public void mousemoveonElement(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();;
	}
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	public void r(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.click(element).perform();
	}
	//maximize
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	//minimize
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	//dropdown
	public void selectByValue(WebElement element,String value )
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	public void selectByIndex(WebElement element,int index )
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	public void selectByVisibleText(WebElement element,String text )
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	//takesscreenshot
	public void takeScreenShot(WebDriver driver,String testName) throws IOException
	{
		Date d=new Date();
		String s=d.toString();
		String s1=s.replaceAll(":", "-");
		String photo="./photos/";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(photo+s1+testName+".jpeg");
		FileHandler.copy(src, dst);
	}
	//javascriptexecutor
	public void scrollToElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int x=element.getLocation().getX();
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	
	
	
	
}

