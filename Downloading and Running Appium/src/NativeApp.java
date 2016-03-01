import static org.junit.Assert.assertEquals;
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
import org.openqa.selenium.support.ui.WebDriverWait;


public class NativeApp {

	WebDriver driver = null;

	@Before
	public void setUp() throws MalformedURLException{

		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "C:\\Softwares\\");
		File app = new File(appDir,"OlaCabs_3.3.05.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability(CapabilityType.BROWSER_NAME, ""); //Name of mobile web browser to automate. Should be an empty string if automating an app instead.
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(CapabilityType.VERSION, "4.4");
		capabilities.setCapability("deviceName","009325220e8a11eb");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.olacabs.customer");
		capabilities.setCapability("appActivity", "Main");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		}
	

	@Test
	public void loginTest() throws Exception 
	{ 
	System.out.println("Inside Test Function");
	WebDriverWait wait = new WebDriverWait(driver,80);
		
	/*//Assert.assertEquals("fail","",driver.findElement(By.cssSelector("#Emai")).toString().);
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
	}*/
	}


	@After
	public void tearDown() 
	{
	WebDriverWait wait = new WebDriverWait(driver,100);
	driver.quit();
	}

}
