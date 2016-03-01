 
import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class Appium {
	
	static WebDriver driver;
	@BeforeClass
	
	//@Test
	public void setUp() throws MalformedURLException, InterruptedException{
		String url = "https://www.google.co.in";
		//File app = new File("C:\\Softwares\\WhatsApp.apk");//System.getProperty("user.dir"));
		//File appDir = new File(classpathRoot, "");
		//File app = new File(appDir, "WhatsApp.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName","Android");
		//capabilities.setCapability("app", "Chrome");
		 //Name of mobile web browser to automate. Should be an empty string if automating an app instead.
		//capabilities.setCapability(CapabilityType.VERSION, "4.1.1");
		capabilities.setCapability("platformVersion", "4.1.1");
		//capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
		//capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("app-package", "com.android.chrome"); //Replace with your app's package
		capabilities.setCapability("app-activity","Main");// "APP PACKAGE.ANDROID ACTIVITY"); //Replace with app's Activity
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.navigate().to(url);
	}
	
	@Test
	public void Cal(){
		//driver.findElement(By.name("Weather")).click();
		//driver.findElement(By.id("gbqfba")).click();
		System.out.println("Opened whatsapp");
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
 
}