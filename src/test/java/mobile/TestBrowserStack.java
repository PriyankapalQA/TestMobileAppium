package mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBrowserStack
{
	AndroidDriver<WebElement> driver;
	public static String userName = "priyankapal2";
	public static String accessKey = "Lv4PBijFJkMARJVQynsF";

	@BeforeClass
	public void Setup() throws MalformedURLException 
	{
		try
		{
			DesiredCapabilities caps = new DesiredCapabilities();

			//		caps.setCapability("device", "Google Pixel");
			//	caps.setCapability("app", "bs://3175c5eee356a60ce320830bb9556586f88c58b4");
			//	caps.setCapability("app", "io.selendroid.testapp");
			//	 caps.setCapability("os_version", "11");
			//	caps.setCapability("APP_PACKAGE","selendroid-test-app.apk");

			caps.setCapability("device", "Google Nexus 6");
			caps.setCapability("os_version", "6.0");
			caps.setCapability("app", "bs://3175c5eee356a60ce320830bb9556586f88c58b4");   //use curl command to upload and get this bs value
			caps.setCapability("browserstack.debug","TRUE");


			driver = new AndroidDriver<WebElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

	}
	@AfterClass
	public void close() 
	{
		driver.quit();
	}

}
