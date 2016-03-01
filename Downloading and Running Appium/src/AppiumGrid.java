import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AppiumGrid {


WebDriver driver = null;

@Before
public void setup() throws Exception{

//File appDir = new File("C:\\Softwares\\");
//File app = new File(appDir,"Fiori.apk");


}

@Test
public void loginTest() throws Exception 
{ 
	String url = "https://accounts.google.com";
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	capabilities.setCapability("device","Android");
	//capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
	capabilities.setCapability("device ID", "3EE2F02269B6C5EF");//"B83A8CAF0D6C9A7C");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("deviceName","Android");
	capabilities.setCapability("platformVersion", "19");
	//capabilities.setCapability("browserName", "Opera");
	capabilities.setCapability("app","Chrome");
	//capabilities.setCapability("app", app.getAbsolutePath()); //app.getAbsolutePath()
	// Here we mention the app's package name, to find the package name we have to convert .apk file into java class files
	//capabilities.setCapability("app-package","com.flipkart.android");
	capabilities.setCapability("app-package","com.android.chrome");
	//capabilities.setCapability("app-activity","Main");
	//Here we mention the activity name, which is invoked initially as app's first page.
	//capabilities.setCapability("app-activity","LoginActivity");
	//capabilities.setCapability("app-wait-activity","LoginActivity,NewAccountActivity");
	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	driver.navigate().to(url);
	System.out.println("Inside Test Function");

}

@After
public void tearDown() 
{
driver.quit();
}

}
