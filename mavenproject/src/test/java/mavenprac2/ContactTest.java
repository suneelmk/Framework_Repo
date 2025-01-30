package mavenprac2;

import org.testng.annotations.Test;

public class ContactTest { //as per the rule classname should end with Test otherwise maven wont execute

		@Test
		public void createContactTest()
		{
			String URL=System.getProperty("url");
			String BROWSER=System.getProperty("browser");
			String USERNAME=System.getProperty("username");
			String PASSWORD=System.getProperty("password");
			
			
			System.out.println(URL);
			System.out.println(BROWSER);
			System.out.println(USERNAME);
			System.out.println(PASSWORD);      
			System.out.println("execute createContactTest");
		}
		
		
		@Test
		public void modifyContacttest()
		{
		
			System.out.println("execute modifyContacttest");

		}
	
}
