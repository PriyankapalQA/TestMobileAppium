package mobile;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class TestRealDevice {

	AndroidDriver<WebElement> driver;

	@BeforeClass
	public void Setup() throws MalformedURLException {
		try{
			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability("deviceName", "Galaxy J8");
			caps.setCapability("udid", "5b90e09e");          //Give Device ID of your connected mobile phone by command 'adb devices' from cmd
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "8.0.0");
			caps.setCapability("appPackage", "io.selendroid.testapp");
			caps.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
			caps.setCapability("noReset", "true");


			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

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
