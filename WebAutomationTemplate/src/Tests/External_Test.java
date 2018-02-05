package Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Helper.External;


public class External_Test extends External
{
	@Test
	public void Test1 () throws InterruptedException  

	{		
		Reporter.log("Executing External Test Case");
		Reporter.log(driver.getTitle());
		Assert.assertTrue(true);		
		 
	}
	 
}  
