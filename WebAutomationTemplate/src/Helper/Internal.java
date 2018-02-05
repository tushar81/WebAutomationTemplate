package Helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;

import Helper.BrowserDriver;

public class Internal extends BrowserDriver
{

	@BeforeTest
	public void init() throws InterruptedException, AWTException 
	{		
		driver.get(Constants.launchingURL);
		if(Constants.browsername.equalsIgnoreCase("IE"))
			{					
			Thread.sleep(1500);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());     
			alert.authenticateUsing(new UserAndPassword(Constants.username, Constants.password));
			}		
		else
			{						
			Thread.sleep(1500);
			driver.switchTo().activeElement();
			Robot rb = new Robot();			
			rb.keyPress(KeyEvent.VK_U);
			rb.keyRelease(KeyEvent.VK_U);
			rb.keyPress(KeyEvent.VK_K);
			rb.keyRelease(KeyEvent.VK_K);
			rb.keyPress(KeyEvent.VK_C);
			rb.keyRelease(KeyEvent.VK_C);
			rb.keyPress(KeyEvent.VK_C);
			rb.keyRelease(KeyEvent.VK_C);
			rb.keyPress(KeyEvent.VK_S);
			rb.keyRelease(KeyEvent.VK_S);
			rb.keyPress(KeyEvent.VK_1);
			rb.keyRelease(KeyEvent.VK_1);
			rb.keyPress(KeyEvent.VK_T);
			rb.keyRelease(KeyEvent.VK_T);
			rb.keyPress(KeyEvent.VK_S);
			rb.keyRelease(KeyEvent.VK_S);
			rb.keyPress(KeyEvent.VK_A);
			rb.keyRelease(KeyEvent.VK_A);
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			
			rb.keyPress(KeyEvent.VK_3);
			rb.keyRelease(KeyEvent.VK_3);
			rb.keyPress(KeyEvent.VK_SHIFT); 
			rb.keyPress(KeyEvent.VK_3); 
			rb.keyRelease(KeyEvent.VK_3);
			rb.keyPress(KeyEvent.VK_U); 
			rb.keyRelease(KeyEvent.VK_U);
			rb.keyRelease(KeyEvent.VK_SHIFT);
			rb.keyPress(KeyEvent.VK_N); 
			rb.keyRelease(KeyEvent.VK_N);
			rb.keyPress(KeyEvent.VK_I); 
			rb.keyRelease(KeyEvent.VK_I);
			rb.keyPress(KeyEvent.VK_T); 
			rb.keyRelease(KeyEvent.VK_T);
			rb.keyPress(KeyEvent.VK_E); 
			rb.keyRelease(KeyEvent.VK_E);
			rb.keyPress(KeyEvent.VK_S); 
			rb.keyRelease(KeyEvent.VK_S);
			rb.keyPress(KeyEvent.VK_T); 
			rb.keyRelease(KeyEvent.VK_T);
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);			
			}
		Thread.sleep(2500); 
	}	

	 
}

