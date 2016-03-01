import static org.junit.Assert.*;
import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumNewUI {


WebDriver driver = null;

@Before
public void setup() throws Exception{
String url = "http://ld2513.wdf.sap.corp:8002/sap/bc/ina/demos/epm/search.html";
//File appDir = new File("C:\\Softwares\\");
//File app = new File(appDir,"Flipkart.apk");
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
capabilities.setCapability("device","Android");
//capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
capabilities.setCapability("device ID","009325220e8a11eb");//"009325220e8a11eb");//);// "3EE2F02269B6C5EF");//"B83A8CAF0D6C9A7C");
capabilities.setCapability("platformName", "Android");
capabilities.setCapability("deviceName","Android");
capabilities.setCapability("platformVersion", "19");
capabilities.setCapability("app","Chrome");
//capabilities.setCapability("app", app.getAbsolutePath()); //app.getAbsolutePath()
// Here we mention the app's package name, to find the package name we have to convert .apk file into java class files
//capabilities.setCapability("app-package","com.flipkart.android");
capabilities.setCapability("app-package","com.android.chrome");
capabilities.setCapability("app-activity","Main");
//Here we mention the activity name, which is invoked initially as app's first page.
//capabilities.setCapability("app-activity","LoginActivity");
//capabilities.setCapability("app-wait-activity","LoginActivity,NewAccountActivity");
driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
driver.navigate().to(url);

}

@Test
public void loginTest() throws Exception 
{ 
System.out.println("Inside Test Function");
WebDriverWait wait = new WebDriverWait(driver,80);
	
//Assert.assertEquals("fail","",driver.findElement(By.cssSelector("#Emai")).toString().);
try{
	WebDriverWait wait2 = new WebDriverWait(driver,5000);
	driver.findElement(By.cssSelector("#xs_username-inner")).sendKeys("system");
	driver.findElement(By.cssSelector("#xs_password-inner")).sendKeys("iMwt2011");
	driver.findElement(By.cssSelector("#__label0")).click();
	driver.findElement(By.cssSelector("#logon_button")).click();
	
	driver.findElement(By.cssSelector(".sap-inainternalfilterbox-input>input")).sendKeys("EUR");
	WebDriverWait wait1 = new WebDriverWait(driver,10000);
	driver.findElement(By.cssSelector(".sap-inainternalfilterbox-input>input")).sendKeys(Keys.RETURN);
	//driver.findElement(By.cssSelector("#Passwd")).sendKeys("DialMe@10");
	//driver.findElement(By.cssSelector("#signIn")).click();
	//
	Thread.sleep(10000);

	System.out.println("Test passed");
}
catch(Exception e){
	System.out.println("Test Failed");
}
}


@After
public void tearDown() 
{
WebDriverWait wait = new WebDriverWait(driver,10000);
driver.quit();
}

}

//capabilities.setCapability(CapabilityType.VERSION, "5.0.1");
//capabilities.setCapability;(CapabilityType.PLATFORM, "WINDOWS");