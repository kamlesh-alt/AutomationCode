/* This class consists of the common functionalities that is require for every suite
 for eg : We need to invoke the driver and also get the application url before we execute test cases */


package test;
import Utility.Property_data; 

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeSuite;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;


public class BaseTest {
	
public static ExtentHtmlReporter htmlReporter;
public static ExtentReports extent;
public static ExtentTest test;
public static WebDriver driver;
Property_data p = new Property_data();


public void Login() throws IOException, InterruptedException
{    
htmlReporter = new ExtentHtmlReporter(".\\Report\\Regression_report.html");
htmlReporter.config().setTheme(Theme.DARK);
extent = new ExtentReports();
extent.attachReporter(htmlReporter);
p.read_Data_from_propertyfile();
if(p.getbrowser().equalsIgnoreCase("firefox"))
{
	  FirefoxOptions options = new FirefoxOptions();
	  //options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); 
	  options.setCapability("marionette", true);
	  /*DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	  capabilities.setCapability("moz:firefoxOptions", options);*/
	  System.setProperty("webdriver.gecko.driver", p.getDriverPath_firefox());
    driver =new FirefoxDriver(options);
   
    if(p.getenvironment().equalsIgnoreCase("build")){
        driver.get(p.getApplicationUrl1());}
        else if(p.getenvironment().equalsIgnoreCase("pi")){
        driver.get(p.getApplicationUrl());}
   
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    
}
else if(p.getbrowser().equalsIgnoreCase("Chrome"))
{
	  ChromeOptions option = new ChromeOptions();
	  option.addArguments("--disable-infobars","--start-maximized"); // disable the controlled text and maximizes the page 
	  option.addArguments("--disable-notifications");

	  System.setProperty("webdriver.chrome.driver", p.getDriverPath());
    driver = new ChromeDriver(option);
    if(p.getenvironment().equalsIgnoreCase("build")){
    driver.get(p.getApplicationUrl1());}
    
    
    else if(p.getenvironment().equalsIgnoreCase("pi")){
    driver.get(p.getApplicationUrl());}
    
    driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);	
}
else
{
	  InternetExplorerOptions options =new InternetExplorerOptions();
	  options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
	  System.setProperty("webdriver.ie.driver", p.getDriverPath_ie());
    driver =new InternetExplorerDriver(options);
    if(p.getenvironment().equalsIgnoreCase("build")){
    driver.get(p.getApplicationUrl1());}
    
    else if(p.getenvironment().equalsIgnoreCase("pi")){
    driver.get(p.getApplicationUrl());}

    driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
    //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
}
}
  
 @AfterSuite
	public void quit() throws InterruptedException{
	    extent.flush();
	    extent.close();
		Reporter.log("************BROWSER CLOSED SUCCESSFULLY*************");
		Thread.sleep(10000);
		driver.quit();
	}
}
