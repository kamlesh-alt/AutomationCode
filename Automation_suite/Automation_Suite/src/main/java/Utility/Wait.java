package Utility;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Wait {
	 public boolean isClickable(WebElement webe,WebDriver driver){
	 try
	 { 
		     WebDriverWait wait = new WebDriverWait(driver, 20);
		     wait.until(ExpectedConditions.elementToBeClickable(webe));
		     return true;
	 }
	  catch (Exception e)
	 {
		     return false;
    }
	 
	 }
	 
	 public boolean isPresent(WebElement webe,WebDriver driver,String text){
		 try
		 {
			     WebDriverWait wait = new WebDriverWait(driver, 20);
			     wait.until(ExpectedConditions.textToBePresentInElement(webe, text));
			     return true;
		 }
		  catch (Exception e)
		 {
			     return false;
	     }
		 }
	 
	 public boolean isvisible(WebElement webe,WebDriver driver){
		 try
		 { 
			     WebDriverWait wait = new WebDriverWait(driver,20);
			     wait.until(ExpectedConditions.visibilityOf(webe));
			     return true;
		 }
		  catch (Exception e)
		 {
			     return false;
	     }
	 }
	 
	 public boolean isvisible_dropdown(WebElement webe,WebDriver driver){
		 try
		 { 
			     WebDriverWait wait = new WebDriverWait(driver, 20);
			     wait.until(ExpectedConditions.visibilityOf(webe));
			     return true;
		 }
		  catch (Exception e)
		 {
			     return false;
	     }
	 }
	 
	 public boolean invisible(WebElement webe,WebDriver driver){
		 try
		 { 
			     WebDriverWait wait = new WebDriverWait(driver, 20);
			     wait.until(ExpectedConditions.invisibilityOf(webe));
			     return true;
		 }
		  catch (Exception e)
		 {
			     return false;
	     }
	 }
	 
	 public boolean popupisvisible(WebElement webe,WebDriver driver){
		 try
		 { 
			     WebDriverWait wait = new WebDriverWait(driver, 20);
			     wait.until(ExpectedConditions.visibilityOf(webe));
			     return true;
		 }
		  catch (Exception e)
		 {
			     return false;
	     }
	 }
	 
	 public boolean isenabled(WebElement ele){
		 boolean status;
		 try {
		     boolean status1 = ele.isEnabled();
		     if(status1){
		    	 status=true;
		     }
		     else{
		    	 status=false;
		     }
		     return status;
		     
		  }
		  catch (Exception e ) {
		    return false;
		  }
	 }
	 
	 public boolean isdisabled(WebElement ele){
		 boolean status;
		 try {
		     boolean status1 = ele.isEnabled();
		     if(status1==false){
		    	 status=true;
		     }
		     else{
		    	 status=false;
		     }
		     return status;
		     
		  }
		  catch (Exception e ) {
		    return false;
		  }
		 }
	 
	public boolean is_displayed(WebElement ele)
	{
		 
		boolean status;
		 try {
		     boolean status1 = ele.isDisplayed();
		     if(status1){
		    	 status=true;
		     }
		     else{
		    	 status=false;
		     }
		     return status;
		     
		  }
		  catch (Exception e ) {
		    return false;
		  }
		 
	 }
	
	public void click_on_element(WebDriver driver,WebElement ele)
	{try{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	}
	
	public void click_on_element_Action(WebDriver driver,WebElement ele) throws Exception
	{try{
		
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		highlight(driver,ele);
		ele.click();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	}
	
	public void highlight(WebDriver driver, WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		Thread.sleep(1000);
		try {
			Thread.sleep(500);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}
	
	
	public void scrollup(WebDriver driver){
		try{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollTo(0,0)", "");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
		public void customize_click(WebDriver driver, WebElement element)
		{
			try{
				element.click();
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		
		}
		public void Handle_Feedback_pop_up(WebDriver driver) throws InterruptedException{
			WebElement menuHoverLink = null;
			try
			{
			    menuHoverLink = driver.findElement(By.cssSelector("#wrapper > div > app-learning-area > div > app-learning-area-header > app-edit-focus-area > app-feedback-modal > app-bootstrap-modal:nth-child(5) > div > div > div > div > div > div.fb-inner-box > span > button > span"));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			if (menuHoverLink != null)
			{
				Actions action= new Actions(driver);
				action.moveToElement(menuHoverLink).perform();
			    Thread.sleep(2000);
			    menuHoverLink.click();
			}
		}

		public void blackpopup(WebDriver driver){
			List<WebElement> element=driver.findElements(By.xpath("//*[@class='close-icon-toaster']"));
			System.out.println(element.size());
			for (WebElement elements : element){
				try{
					elements.click();
				break;
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
			}
		}}


 

	
	


