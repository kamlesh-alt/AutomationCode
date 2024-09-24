package Pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utility.Wait;


public class HomePage extends Wait {
	
	WebDriver driver; // intitialising the webdriver
	
	// ************************** LOCATORS STARTS HERE ********************************************************
	@FindBy(xpath="//*[@id='navbarSupportedContent']/ul[1]/li[1]/a")
	WebElement myplan_section;
	
	@FindBy(xpath="//*[@id='navbarSupportedContent']/ul[2]/li[5]/a/span")
	WebElement admin_icon;
	
	
	WebElement top_picks;
	
	@FindBy(xpath="//*[@id='collapseThree']/div/div[2]/div[2]/div[3]/a/img")
	
	
	
	
	
	
	

	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	// **************Methods to perform click actions on webelements STARTS here*********************************	

	public void Close_popup_hi_click() {
		//click_on_element(driver, Close_popup_hi);
		  try {
		       WebDriverWait wait=new WebDriverWait(driver, 100);

		       wait.until(ExpectedConditions.visibilityOfElementLocated(
		            By.xpath("//*[@id='encTrainingModal']/div/div/span/button"))
		       ).click();

		    }
		    catch(Throwable t){
		        System.out.println("The execption is: " + t);
		    }
	}

	public void tutorial_popup_click() {
		click_on_element(driver,Close_tutorial);
	}
	
	public void click_on_MyPlan()
	{
		myplan_section.click();
	}
	
	
		click_on_element_Action(driver,top_picks);
	}
	

	


	