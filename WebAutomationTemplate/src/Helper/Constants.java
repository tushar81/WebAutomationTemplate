package Helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants 
{
	public static String browsername = "IE";	
	public static long TimeOut =240;
	public static String today = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
	
	//Credentials
	public static String username = "";
	public static String password = "";
	
	
	//IE Driver Path
	public static String IEDriverPath = "C://Users//ukccs1tsa//Downloads//Tushar CC//Tools//Selenium//IEDriver//IEDriverServer.exe";
	
	public static String launchingURL = "https://uat.playiq.co.uk/Default";
	public static String ExternalLaunchingURL = "https://uk.test.clearchannel.io/login/login";
	 
}
