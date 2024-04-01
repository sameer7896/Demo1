package SpiceMoneyApp.SMAApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

/**
 * Unit test for simple App.
 */
public class Grahak_base{
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> Driver;
	
	public AppiumDriverLocalService startServer() {
		boolean flag = checkIfServerIsRunning(4723);
		if(!flag) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}
	
	public static boolean checkIfServerIsRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket();
			serverSocket.close();
		}catch(IOException e) {
			isServerRunning=true;
		}finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static AndroidDriver<AndroidElement> capabilities() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\global1.properties");
		Properties prop = new Properties();
		prop.load(fis);
		// WebDriver driver;
		// Created object of DesiredCapabilities class.
		DesiredCapabilities capabilities = new DesiredCapabilities();
		String device = System.getProperty("deviceName");
		// Set android deviceName desired capability. Set your device name.
		// capabilities.setCapability("deviceName", "d15cc436");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		capabilities.setCapability(CapabilityType.VERSION, "9.0");

		// Set BROWSER_NAME desired capability. It's Android in our case here.
		// capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

		// Set android VERSION desired capability. Set your mobile device's OS
		// version.
		// capabilities.setCapability("platformVersion", "11");

		// Set android platformName desired capability. It's Android in our case
		// here.
		capabilities.setCapability("platformName", prop.getProperty("platformName"));

		// Set android appPackage desired capability.
		capabilities.setCapability("appPackage", prop.getProperty("appPackage"));

		// Set android appActivity desired capability.
		capabilities.setCapability("appActivity", prop.getProperty("appActivity"));

		capabilities.setCapability("fullReset", prop.getProperty("fullReset"));

		capabilities.setCapability("noReset", prop.getProperty("noReset"));

		// Created object of RemoteWebDriver with all set capabilities.
		// Set appium server address and port number in URL string.
		 Driver = new AndroidDriver<AndroidElement>(new URL(prop.getProperty("URL")), capabilities);
		 Driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 
		 capabilities.setCapability("Username", prop.getProperty("Username"));
//		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL(prop.getProperty("URL")), capabilities);
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// driver.findElement(By.id("in.spicemudra:id/loginid")).sendKeys("sdl1116549");
		// driver.findElement(By.id("in.spicemudra:id/passtext")).sendKeys("Sdl@2023");
		// driver.findElement(By.id("in.spicemudra:id/loginbutton")).click();

		// assertTrue( true );
		// Assert.assertEquals(true, true);
		// in.spicemudra:id/passtext
		return Driver;
	}

	public static void getScreenshot(String classN,String testN,String type) throws IOException {
		try {
			System.out.println("============I am inside the getScreenshot try block==========================");
		
			File scrfile = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "\\Screenshot\\"+type+"\\"+classN+"\\" + testN+".png"));
		} catch (Exception e) {
			System.out.println("============I am inside the getScreenshot catch block==========================");
			e.printStackTrace();
		}

	}
}
