package Utility;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class MultipleWindowHandling {

	@Test
	public  void multiplewindow() throws IOException, InterruptedException{
		//System.setProperty("Webdriver.Chrome.driver","./Regression_Suite/driver/chromedriver.exe");
		 System.setProperty("webdriver.chrome.driver","C:\\selenium\\Regression_Suite\\driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fe-11-15b869db488a74d0a69afa4933567547-60fa08bccd35a9f675070f0fc0f0fb473b4165f3&flowName=GlifWebSignIn&flowEntry=SignUp");
		Thread.sleep(3000);
		
	String mainWindow=driver.getWindowHandle();
	driver.findElement(By.xpath("//*[@id='initialView']/footer/ul/li[3]/a")).click();
	Set<String> set=driver.getWindowHandles();
	
	Iterator<String> itr= set.iterator();
	while(itr.hasNext()){
		String childwindow=itr.next();
		if(!mainWindow.equalsIgnoreCase(childwindow)){
			driver.switchTo().window(childwindow);
			Thread.sleep(5000);
			driver.close();
			}
		driver.switchTo().window(mainWindow);
		
	}
	
	driver.switchTo().window(mainWindow);

	}

	


}
