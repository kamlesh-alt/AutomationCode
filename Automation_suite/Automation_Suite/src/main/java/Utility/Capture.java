package Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Capture {

	private final static String filepath =".\\Report\\Screenshot";
	
	public static String takeScreenShot(String methodName, WebDriver driver) throws IOException {
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File src =ts.getScreenshotAs(OutputType.FILE);
		//String dest =  System.getProperty("user.home") + File.separator +filepath+File.separator + methodName +".png";
		//String dest =  filepath + File.separator+ methodName +".png";
		String dest =  filepath + File.separator+ methodName +".png";
		String sub = ".\\"+ dest.substring(dest.indexOf("Screenshot"));
   	    File destination = new File(dest);
        try {
		FileUtils.copyFile(src, destination);
		} 
        catch (IOException e) {
		e.getMessage();}    
		return sub;            
    }
	
	/*public static String FullPageScreenshot(String methodName,WebDriver driver) throws IOException{ 
		AShot ashot = new AShot();
		String dest = System.getProperty("user.dir") + File.separator +filepath+ "fullpagescreenshot" +".png";
   	    File destination = new File(dest);
		Screenshot shot = ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(shot.getImage(),"PNG",destination);
		return dest;
	}*/
	
	public static String WebElementscreenshot(String name, WebElement ele,WebDriver driver) throws IOException{ 
		Point point = ele.getLocation();
		int a = point.getX();
		int b = point.getY();
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();
		AShot ashot = new AShot();
		//String dest =  System.getProperty("user.home") + File.separator +filepath+File.separator + name +".png";
		//String dest = System.getProperty("user.dir") + File.separator +filepath+ name +".png";
		String dest =  filepath + File.separator+ name +".png";
		String sub = ".\\"+ dest.substring(dest.indexOf("Screenshot"));
   	    File destination = new File(dest);
		Screenshot shot = ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(shot.getImage().getSubimage(a, b, eleWidth, eleHeight),"PNG",destination);
		return sub;
	}
	
	
}
