package SpiceMoneyApp.SMAApp;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Calendar;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Utilities {

	AndroidDriver<AndroidElement> Driver;

	public Utilities(AppiumDriver<AndroidElement> Driver) {
		this.Driver = (AndroidDriver<AndroidElement>) Driver;

	}

	public void scrollToText(String text) {
		String uiSelector = "new UiSelector().text(\"" + text + "\")";

		String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector+ ");";

		Driver.findElementByAndroidUIAutomator(command);

	}
	
	public void scrollTest(String text) {
		String uiSelector = "new UiSelector().text(\"" + text + "\")";

		String command = "new UiScrollable(new UiSelector().scrollable(true).instance(1)).scrollIntoView(" + uiSelector+ ");";

		Driver.findElementByAndroidUIAutomator(command);

	}

	public void touchActionSlide(int startX, int startY, int endX, int endY) {
		new TouchAction(Driver).press(point(startX, startY)).waitAction(waitOptions(ofMillis(1000)))
				.moveTo(point(endX, endY)).release().perform();
	}

	public void waitAction(int startX, int startY, int second) {
		new TouchAction(Driver).press(point(startX, startY)).waitAction(waitOptions(ofMillis(second))).perform();
		
	}

	public void scrollToElementByID(String ID) {
		WebElement element1 = Driver
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
						+ ".scrollIntoView(new UiSelector().resourceIdMatches(\"" + ID + "\"))"));

	}

	public Utilities clearNotification() throws InterruptedException {
		Driver.openNotifications();
		System.out.println("---------- Opened Notifications ----------");
		try {
			AndroidElement notif = Driver.findElementById("com.android.systemui:id/dismiss_text");
			if (notif.isDisplayed()) {
				notif.click();
				System.out.println("---- Clicked on clear all button ----");
				return new Utilities(Driver);
			} else if (!notif.isEnabled()) {
				System.out.println("No notifications to clear, going back");
				Driver.pressKey(new KeyEvent(AndroidKey.BACK));
				return new Utilities(Driver);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("No notifications to clear, going back");
			Driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		return new Utilities(Driver);
	}

//	public Utilities Notification() throws InterruptedException {
//		Driver.openNotifications();
//		System.out.println("---------- Opened Notifications ----------");
//		
//		return new Utilities(Driver);
//		}

	public String FecthOTP() {
		Driver.openNotifications();
		System.out.println("---------- Opened Notifications ----------");

		try {
			String OTP1 = Driver.findElementById("com.truecaller:id/textOtp").getText();
			String trimOTP = OTP1.replaceAll("(?<=\\d) +(?=\\d)", "");
			if (trimOTP.length() == 6) {
				System.out.println("Correct OTP Fetched.");
				Driver.pressKey(new KeyEvent(AndroidKey.BACK));
				return trimOTP;
			} else if (trimOTP.length() < 6 || trimOTP.length() > 6) {
				System.out.println("Wrong OTP Fetched.");
				Driver.pressKey(new KeyEvent(AndroidKey.BACK));
				return null;
			}

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("No OTP to fetch Please Install True Caller, going back");
			Driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		return null;
	}

	public String greeting() {
		try {
			int timeOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			System.out.println(timeOfDay);
			String greetingActual = "";
			if (timeOfDay >= 5 && timeOfDay < 12) {
				greetingActual = "Good morning";
				return greetingActual;
			} else if (timeOfDay >= 12 && timeOfDay < 16) {
				greetingActual = "Good afternoon";
				return greetingActual;
			} else if (timeOfDay >= 16 && timeOfDay < 20) {
				greetingActual = "Good evening";
				return greetingActual;
			} else {
				greetingActual = "Good night";
				return greetingActual;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void Generalscreenshot(Method method)
	{
		//screenshot 
		String pass = "OnGeneral";
		String testName=method.getName();
		//String className =arg0.getInstanceName();
		String className =method.getDeclaringClass().getSimpleName();
		try {
			System.out.println("========Take Screenshot=================");
			SpiceMoneyApp.SMAApp.base.getScreenshot(className,testName,pass);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
