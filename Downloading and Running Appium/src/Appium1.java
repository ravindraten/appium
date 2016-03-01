import static org.junit.Assert.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Appium1 {


WebDriver driver = null;

@Before
public void setup() throws Exception{
String url = "https://mail.google.com";
//File appDir = new File("C:\\Softwares\\");
//File app = new File(appDir,"Flipkart.apk");
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
capabilities.setCapability("device","Android");
//capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
capabilities.setCapability("device ID","009325220e8a11eb");//"ZX1B3398HG");// "3EE2F02269B6C5EF");//"B83A8CAF0D6C9A7C");
capabilities.setCapability("platformName", "Android");
capabilities.setCapability("deviceName","Android");
capabilities.setCapability("platformVersion", "18");
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
	String val = driver.findElement(By.cssSelector("#Email")).getAttribute("name");
	System.out.println(val);
	assertEquals("Email",val);
	driver.findElement(By.cssSelector("#Email")).sendKeys("demoappium");
	driver.findElement(By.cssSelector("#Passwd")).sendKeys("DialMe@10");
	driver.findElement(By.cssSelector("#signIn")).click();
	//WebDriverWait wait1 = new WebDriverWait(driver,4000);
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
WebDriverWait wait = new WebDriverWait(driver,100);
driver.quit();
}

}

//capabilities.setCapability(CapabilityType.VERSION, "5.0.1");
//capabilities.setCapability;(CapabilityType.PLATFORM, "WINDOWS");