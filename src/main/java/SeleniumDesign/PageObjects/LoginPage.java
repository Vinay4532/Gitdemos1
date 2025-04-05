package SeleniumDesign.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumDesign.AbstractComponents.Abstractcomponents;

public class LoginPage extends Abstractcomponents{
	WebDriver driver;
	//intialization
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Declaration
	@FindBy(xpath="//a[@id='login2']")
	WebElement loginlink;
	
	@FindBy(xpath="//input[@id='loginusername']")
	WebElement userNameInput;
	@FindBy(xpath="//input[@id='loginpassword']")
	WebElement passwordInput;
	@FindBy(xpath="(//button[normalize-space()='Log in'])[1]")
	WebElement loginButton;
	//utilization 
	
	public void gotoDemoBlazeURL()
	{
		driver.get("https://www.demoblaze.com/index.html");
	}
	public void login(String username, String password) throws InterruptedException
	{
		loginlink.click();
		
		userNameInput.sendKeys(username);
		Thread.sleep(3000);
		passwordInput.sendKeys(password);
		Thread.sleep(3000);
		loginButton.click();
		Thread.sleep(3000);
	}
	

}
