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

public class TestBrowserStack2
{
	static AndroidDriver<WebElement> driver;
	public static String userName = "priyankapal2";
	public static String accessKey = "Lv4PBijFJkMARJVQynsF";



	public static void main(String args[]) throws MalformedURLException
	{
		Setup();
		testRegistration();
		testWaitingProgressBar();
		testDisplayText();
		testLabel();
		testToast();
	}

	public static void Setup() throws MalformedURLException 
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
			caps.setCapability("app", "bs://3175c5eee356a60ce320830bb9556586f88c58b4");
			caps.setCapability("browserstack.debug","TRUE");


			driver = new AndroidDriver<WebElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

	}


	public static void testRegistration()
	{
		try{

			TimeUnit.SECONDS.sleep(7);

			if ( driver.findElement(By.id("input_adds_check_box")).isSelected() )
			{
				driver.findElement(By.id("input_adds_check_box")).click();
			}
			//		driver.findElement(By.id("startUserRegistration")).click();
			//		registration();
		}
		catch(Exception e)
		{
			System.out.println("method testRegistration "+e.getMessage());
		}

	}  


	public static void testWaitingProgressBar() {
		try{

			String a = driver.findElement(By.id("waitingButtonTest")).getText();
			driver.findElement(By.id("io.selendroid.testapp:id/waitingButtonTest")).click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("scrollView"))));

			registration();
		}
		catch(Exception e)
		{

			System.out.println("method f "+e.getMessage());
		}
	}


	public static void registration()
	{
		try{
			driver.findElement(By.id("inputUsername")).sendKeys("Hello1");
			driver.findElement(By.id("inputEmail")).sendKeys("Hello@gmail.com");
			driver.findElement(By.id("inputPassword")).sendKeys("Hello");

			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+"I accept adds"+"\").instance(0))").click();

			driver.findElement(By.id("inputName")).clear();
			driver.findElement(By.id("inputName")).sendKeys("Ms.Priyanka");

			driver.findElement(By.id("input_preferedProgrammingLanguage")).click();

			//  driver.findElement(By.xpath("//*[contains(text(),'Python')]")).click();

			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+"Python"+"\")").click();

			System.out.println("Button in Registration selected: "+driver.findElement(By.id("input_adds")).isSelected());

			if ( !driver.findElement(By.id("input_adds")).isSelected() )
			{
				driver.findElement(By.id("input_adds")).click();
			}

			driver.findElement(By.id("btnRegisterUser")).click();

			driver.findElement(By.id("buttonRegisterUser")).click();

			String name = driver.findElement(By.id("label_name_data")).getText();
			String progLang = driver.findElement(By.id("label_preferedProgrammingLanguage_data")).getText();
			String acceptAd = driver.findElement(By.id("label_acceptAdds_data")).getText();

			if (name.equalsIgnoreCase("Ms.Priyanka")&& progLang.equalsIgnoreCase("Python")&& acceptAd.equalsIgnoreCase("true"))	  
				System.out.println("All entered data correct: "+ name+ ","+progLang+","+acceptAd);
			else
				System.out.println("All entered data not correct: "+ name+ ","+progLang+","+acceptAd);

			driver.findElement(By.id("buttonRegisterUser")).click();
		}
		catch(Exception e)
		{

			System.out.println("method registration "+e.getMessage());
		}

	}


	public static void testDisplayText()
	{
		try
		{
			driver.findElement(By.id("my_text_field")).sendKeys("Hello");
			driver.findElement(By.id("visibleButtonTest")).click();
			//String b=  driver.findElement(By.id("visibleTextView")).getText(); 

			Assert.assertEquals(displayText("visibleTextView"), "Text is sometimes displayed"); 
		}
		catch(Exception e)
		{
			System.out.println("method testDisplayText "+e.getMessage());
		}
	}  

	public static String displayText(String identifier)
	{
		return driver.findElement(By.id(identifier)).getText();
	} 


	public static void testLabel()
	{
		try{
			System.out.println("The displayed text is: "+ displayText("encodingTextview"));
		}
		catch(Exception e)
		{
			System.out.println("method testLabel "+e.getMessage());
		}
	}


	public static void testToast()
	{
		try{

		}
		catch(Exception e)
		{
			System.out.println("method testToast "+e.getMessage());
		}
	}

}
