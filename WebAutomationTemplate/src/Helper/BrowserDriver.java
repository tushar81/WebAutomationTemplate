package Helper;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.awt.Robot;
import java.io.File;
import java.io.IOException; 
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import Helper.Constants;


public class BrowserDriver extends TestListenerAdapter
{ 
	public static WebDriverWait wait;
	public static WebDriver driver;
	public static ITestContext ctx;
	public static Robot rb;
	 
	@BeforeSuite
	public static void setUp() 
	{
		//@SuppressWarnings("resource")		
		/*AS ONLY IE Browser is supported today disable asking for browser
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Please enter the browser to run the Automation on ");
		 browsername = reader.next();	*/		
		String browsername = "IE";
		
		switch (browsername) 
		{         
        case "IE":
        	System.setProperty("webdriver.ie.driver", Constants.IEDriverPath);
    		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
    		cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);    	
    		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);		
    		driver  = new InternetExplorerDriver(cap);    		
            break;            
        case "CHROME":
        	System.setProperty("webdriver.chrome.driver", "C://Users//ukccs1tsa//Downloads//Tushar CC//Tools//Selenium//ChromeDriver//chromedriver.exe");		
    		driver=new ChromeDriver();    		
            break;       
        default :
        	System.out.println("Tests to be Run in Phantom Browser with no UI");      
    		File file = new File("C:/Users/ukccs1tsa/Downloads/Tushar CC/Tools/Selenium/PhantomJS/phantomjs-2.1.1-windows/bin/phantomjs.exe");				
            System.setProperty("phantomjs.binary.path", file.getAbsolutePath());		
            driver = new PhantomJSDriver();
            break;
			}		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Constants.TimeOut, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, Constants.TimeOut);
		Constants.browsername = browsername;
		Reporter.log("*****************************-_ Automation of - Executed on browser - "+ browsername + "_-*****************************");	
		} 
		
		@AfterSuite
	public void tearDown() 
	{
		Reporter.log("************************************************************************************");
		driver.close();
	}
	 		
	@AfterMethod  
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException
	{ 
		//Take screenshot on failure		
		long millis = (testResult.getEndMillis()-testResult.getStartMillis());
				
		if (testResult.getStatus() != ITestResult.SUCCESS) 
			{ 
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
				FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + ".jpg"));
			}
		Reporter.log("Execution Time for Test "+testResult.getName().substring(0,(testResult.getName().length()-48) )+" is =  "+String.format("%d min, %d sec",TimeUnit.MILLISECONDS.toMinutes(millis),TimeUnit.MILLISECONDS.toSeconds(millis)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))));		
		Reporter.log("------------------------------------------------------------------------------");
		
	}
		
	 
}

