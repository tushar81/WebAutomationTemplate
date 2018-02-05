package Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import Helper.BrowserDriver;

public class External extends BrowserDriver 
{
	 
	@BeforeTest
	public void initbrowser()   
	{
		driver.get("https://uk.test.clearchannel.io/login/login");
		WebElement Uname = wait.until(ExpectedConditions.elementToBeClickable(By.id("MainContent_Login1_UserName")));
		WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(By.id("MainContent_Login1_Password")));
		WebElement LogIn = wait.until(ExpectedConditions.elementToBeClickable(By.id("MainContent_Login1_LoginButton")));
		
		Uname.sendKeys("tushar.sathaye@clearchannel.co.uk");
		pass.sendKeys("3£Unitest");
		LogIn.click();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnLogout")));		 
		 
	}	
	
	 

}
