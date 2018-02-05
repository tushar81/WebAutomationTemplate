package Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Helper.Internal;


public class Internal_Test extends Internal
{
	@Test
	public void Test1 () throws InterruptedException  

	{		
		Reporter.log("Executing Internal Test Case");
		Reporter.log(driver.getTitle());
		Assert.assertTrue(true);		
		 
	}
	 
}
