package SpiceMoneyApp.SMAApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.io.IOException;
import java.lang.reflect.Method;


public class Utilities {

	AndroidDriver<AndroidElement> Driver;
	
	public Utilities(AppiumDriver<AndroidElement>  Driver){
		this.Driver = (AndroidDriver<AndroidElement>) Driver;
		
	}
	
	public void scrollToText(String text) {
		String uiSelector = "new UiSelector().textMatches(\"" + text
			      + "\")";

			String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
			      + uiSelector + ");";

			Driver.findElementByAndroidUIAutomator(command); 
		
	}
	public void Generalscreenshot(Method method)
	{
		// TODO Auto-generated method stub
		//screenshot 
		String pass = "OnGeneral";
		String testName=method.getName();
		//String className =arg0.getInstanceName();
		String className =method.getDeclaringClass().getSimpleName();
		try {
			System.out.println("========Take Screenshot=================");
			SpiceMoneyApp.SMAApp.base.getScreenshot(className,testName,pass);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

		
	}



