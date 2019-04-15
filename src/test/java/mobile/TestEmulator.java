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

public class TestEmulator {

	AndroidDriver<WebElement> driver;

	@BeforeClass
	public void Setup() throws MalformedURLException {
		try{
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
			cap.setCapability("APP_PACKAGE","io.selendroid.testapp");
			cap.setCapability("avd", "Test");
			cap.setCapability("APP_ACTIVITY", "io.selendroid.testapp.HomeScreenActivity");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			
			//  cap.setCapability("browserName"," ");  // blank as it is native app
			//  cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Selendroid");
			//	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "2.3");
			//	cap.setCapability(MobileCapabilityType.APP, myApp);

			cap.setCapability("app","C:/Users/Jaydeep/AppData/Local/Android/Sdk/platform-tools/selendroid-test-app.apk");

			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
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
