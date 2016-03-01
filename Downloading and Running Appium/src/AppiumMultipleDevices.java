
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

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

public class AppiumMultipleDevices {


AppiumDriver driver = null;
AppiumDriver driver1 = null;

String url = "https://accounts.google.com";
DesiredCapabilities capabilities = new DesiredCapabilities();
DesiredCapabilities capabilities1 = new DesiredCapabilities();

@Before
public void setup() throws Exception{
	
}

@Test
public void loginTest1() throws Exception 
{ 
	
	capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	capabilities.setCapability("device","Android");
	capabilities.setCapability("udid", "009325220e8a11eb");//"3EE2F02269B6C5EF");//"B83A8CAF0D6C9A7C");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("deviceName","Android");
	capabilities.setCapability("platformVersion", "21");
	capabilities.setCapability("app","Chrome");
	capabilities.setCapability("app-package","com.android.chrome");
	capabilities.setCapability("app-activity","Main");
	//capabilities.setCapability("devicePort", "8080");
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	driver.navigate().to(url);
	System.out.println("Inside Test Function");

}

@Test
public void loginTest2() throws Exception
{
	capabilities1.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	capabilities1.setCapability("device","Android");
	capabilities1.setCapability("udid", "ZX1B3398HG");//"TA993015LB");//"3EE2F02269B6C5EF");
	capabilities1.setCapability("platformName", "Android");
	capabilities1.setCapability("deviceName","Android");
	capabilities1.setCapability("platformVersion", "19");
	capabilities1.setCapability("app","Chrome");
	capabilities1.setCapability("app-package","com.android.chrome");
	capabilities1.setCapability("app-activity","Main");
	//capabilities1.setCapability("devicePort", "8080");
	driver1 = new AndroidDriver(new URL("http://127.0.0.2:4725/wd/hub"), capabilities1);
	driver1.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	driver1.navigate().to(url);
	System.out.println("Inside Test Function 2");
}

@After
public void tearDown() 
{
	//WebDriverWait wait = new WebDriverWait(driver,100);
driver.quit();
driver1.quit();
}

}
