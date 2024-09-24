package Pagefactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Property_data;

public class LoginPage {

	/*
	 * The @FindBy annotation is used in Page Objects in Selenium tests to
	 * specify the object location strategy for a WebElement or a list of
	 * WebElements. Using the PageFactory, these WebElements are usually
	 * initialized when a Page Object is created.
	 */
	WebDriver driver;
	@FindBy(xpath="//input[@type='email']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//div[@id='submissionArea']//span[@id='submitButton']")
	WebElement login; 
	
	@FindBy(xpath="//span[starts-with(text(), 'site')]")
	WebElement Site_login;
	
	public LoginPage(WebDriver driver){
		
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	public void setusername(String usrname) throws InterruptedException{
		highlight(driver,username);
		username.click();
		username.clear();
		username.sendKeys(usrname);
	}
	
	public void setpass(String pass) throws InterruptedException{
		highlight(driver,password);
		password.click();
		password.clear();
		password.sendKeys(pass);
	}
	
	public void click() throws InterruptedException{
		highlight(driver,login);
		login.click();
	}
	
	public void site_login(){
		Site_login.click();
	}
	
	public String gettitle(){
		
		return driver.getTitle();
	}
	public void loginguru(String usrname, String pass) throws InterruptedException{
		this.setusername(usrname);
		this.setpass(pass);
		this.click();
	}
	public static void highlight(WebDriver driver, WebElement element) throws InterruptedException
	{
	JavascriptExecutor js=(JavascriptExecutor)driver; 

    js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",element);
    
	try 
	{
	
	} 
	catch (Exception e) {

	System.out.println(e.getMessage());
	} 

	js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 

	}
	
	
	}

