	package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Pagefactory.HomePage;
import Pagefactory.LoginPage;
import Utility.Capture;
import Utility.Property_data;
import net.bytebuddy.implementation.bind.annotation.Super;


public class HomePageTest extends BaseTest {

	SoftAssert s;
	Property_data p;
	HomePage home;

	@BeforeMethod
	public void get_object() {
		home = new HomePage(driver);
		s = new SoftAssert();
		p = new Property_data();
	}
	@Test(priority =1)
	public void entering_credentials() throws IOException, InterruptedException {
		p.read_Data_from_propertyfile();
		LoginPage login = new LoginPage(driver);
		//test = extent.createTest("Login into Falcon Application", "In this Test Case , User will enter the valid credentials to verify the login functionality");
		login.site_login();
		login.loginguru(p.getusername_prop(), p.getpassword_prop());
		test.log(Status.PASS, "USER ENTERS THE CREDENTIALS");
	}

	
	
	@AfterMethod
	public void after(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS,
					MarkupHelper.createLabel(result.getName().toUpperCase() + "-Test Case Passed ", ExtentColor.GREEN));
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName().toUpperCase() + " -Test Case Failed ", ExtentColor.RED));
			test.fail(result.getThrowable().getMessage());
		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName().toUpperCase() + " -Test Case Skipped ",
					ExtentColor.YELLOW));
			test.skip(result.getThrowable().getMessage());
		}
	}
	

}
