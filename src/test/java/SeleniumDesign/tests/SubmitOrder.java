package SeleniumDesign.tests;



import java.io.IOException;

import org.testng.annotations.Test;

import SeleniumDesign.PageObjects.LoginPage;
import SeleniumDesign.TestComponents.BaseTest;

public class SubmitOrder extends BaseTest{

	
	@Test
	public void SubmitOrder () throws IOException, InterruptedException
	{
		launchApplication();
	LoginPage landingpage=	 new LoginPage(driver);
	landingpage.gotoDemoBlazeURL();
	Thread.sleep(3000);
	landingpage.login("pavanol", "test@123");
	}
}
