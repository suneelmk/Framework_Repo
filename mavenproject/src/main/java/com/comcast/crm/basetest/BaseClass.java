package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.Loginpage;

public class BaseClass {

	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite(groups = { "SmokeTest", "RegressionTest" })
	public void configBS() throws SQLException {
		System.out.println("===connect to db, report config===");
		dbLib.getDbconnection();

	}

	@BeforeClass(groups = { "SmokeTest", "RegressionTest" })
	public void configBC() throws IOException {
		System.out.println("launch browser");

		//String BROWSER = fLib.getDataFromPropertiesFile("browser");
          String BROWSER=System.getProperty("browser",fLib.getDataFromPropertiesFile("browser"));
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();

		}
		sdriver = driver;
		UtilityClassObject.setdriver(driver);
		
	}

//     @Parameters("BROWSER")
// 	@BeforeClass(groups= {"SmokeTest","RegressionTest"})
// 	public void configBC(String browser) throws IOException {
// 		System.out.println("launch browser");
// 		
// 		String BROWSER=browser;                                                  //fLib.getDataFromPropertiesFile("browser");
// 		 
// 	        if(BROWSER.equals("chrome"))
// 	        {
// 	        	driver=new ChromeDriver();     
// 	        }	
// 	        else if(BROWSER.equals("firefox"))
// 	        {
// 	        	driver=new FirefoxDriver();
// 	        }
// 	        else if(BROWSER.equals("edge"))
// 	        {
// 	        	driver=new EdgeDriver();
// 	        }
// 	        else
// 	        {
// 	        	driver=new ChromeDriver();
//
// 	        }
	//sdriver = driver;
	//UtilityClassObject.setdriver(driver);

// 	}

	@BeforeMethod(groups = { "SmokeTest", "RegressionTest" })
	public void configBM() throws IOException {
		System.out.println("login to app");
		//String URL = fLib.getDataFromPropertiesFile("url");
		//String USERNAME = fLib.getDataFromPropertiesFile("username");
		//String PASSWORD = fLib.getDataFromPropertiesFile("password");
        String URL=System.getProperty("url",fLib.getDataFromPropertiesFile("url"));
        String USERNAME=System.getProperty("username",fLib.getDataFromPropertiesFile("username"));
        String PASSWORD=System.getProperty("password",fLib.getDataFromPropertiesFile("password"));

        
        
        //if values are not present in propertyfiles then hardcode the values
        
        //String URL=System.getProperty("url","http://49.249.28.218:8888/");
        //String USERNAME=System.getProperty("username","admin");
        //String PASSWORD=System.getProperty("password","admin");
		
		driver.get(URL);
		Loginpage lp = new Loginpage(driver);
		lp.logintoApp(USERNAME, PASSWORD);

	}

	@AfterMethod(groups = { "SmokeTest", "RegressionTest" })
	public void configAM() throws InterruptedException {
		System.out.println("logout to app");
		HomePage hp = new HomePage(driver);
		hp.logout(driver);

	}

	@AfterClass(groups = { "SmokeTest", "RegressionTest" })
	public void configAC() throws SQLException {
		System.out.println("close browser");
		driver.quit();
	}

	@AfterSuite(groups = { "SmokeTest", "RegressionTest" })
	public void configAS() throws SQLException {
		System.out.println("====close db, report backup====");
		dbLib.closeConnection();

	}

}
