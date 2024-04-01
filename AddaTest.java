package SpiceMoneyApp.SMAApp;
/** manually once open adda section if it is exicuting first time**/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.AddaPage;
import pageObjects.samplePage;

/**
 * Unit test for simple App.
 */
public class AddaTest extends base {
	/**
	 * Rigorous Test :-)
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */

	@BeforeClass
	public void SetDriver() throws IOException {
		AppiumDriver<AndroidElement> Driver = capabilities();
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(Driver, 30);
		samplePage sm = new samplePage(Driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("in.spicemudra:id/tvSkip")));
		sm.SkipButton.click();
		sm.cancelButton.click();
	}

	@BeforeMethod
	public void beforeTheMethod(Method m) {
		System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");
	}
//	@BeforeTest
//	public void beforetest() {
//		service = startServer();
//	}
//
//	@AfterTest
//	public void stopTheServer() {
//		service.stop();
//	}

	@Test(priority = 0)
	public void AddaIsDisplayed() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);

		boolean addHome = ad.actionAdda.isDisplayed();
		if (addHome == true) {
			System.out.println("Adda is Available in Home Page.");
		} else {
			System.out.println("Adda is not Available in Home Page.");
		}

		Assert.assertEquals(addHome, true, "Adda is Available in Home Page.");

		System.out.println("=====================================");
	}

	@Test(priority = 1)
	public void AddaPage() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);
		ad.actionAdda.click();
		boolean addClickPage = ad.addaPage.isDisplayed();
		if (addClickPage == true) {
			System.out.println("Adda Page is Displayed.");
		} else {
			System.out.println("Adda Page is not Displayed.");
		}

		Assert.assertEquals(addClickPage, true, "Adda Page is Displayed.");

		System.out.println("=====================================");
	}

	@Test(priority = 2)
	public void AddaPageContent(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);

		boolean apnaAnubhav = ad.shareStory.isDisplayed();
		if (apnaAnubhav == true) {
			System.out.println("Apna anubhav share karein is Available in Adda Page.");
		} else {
			System.out.println("Apna anubhav share karein is not Available in Adda Page.");
		}

		Assert.assertEquals(apnaAnubhav, true, "Apna anubhav share karein is Available in Adda Page.");

		boolean storyImages = ad.viewStory.isDisplayed();
		if (storyImages == true) {
			System.out.println("View Story is Available in Adda Page.");
		} else {
			System.out.println("View Story is not Available in Adda Page.");
		}

		Assert.assertEquals(storyImages, true, "View Story is Available in Adda Page.");

		boolean greeting = ad.msgDay.isDisplayed();
		if (greeting == true) {
			System.out.println("Greetings for day is Available in Adda Page.");
		} else {
			System.out.println("Greetings for day is not Available in Adda Page.");
		}

		Assert.assertEquals(greeting, true, "Greetings for day is Available in Adda Page.");

		boolean sonuSood = ad.contactSonu.isDisplayed();
		if (sonuSood == true) {
			System.out.println("Contact Sonu Sood is Available in Adda Page.");
		} else {
			System.out.println("Contact Sonu Sood is not Available in Adda Page.");
		}

		Assert.assertEquals(sonuSood, true, "Contact Sonu Sood is Available in Adda Page.");

		boolean statusUp = ad.status.isDisplayed();
		ad.status.getText();
		if (statusUp == true) {
			System.out.println("Status is Available in Adda Page.");
		} else {
			System.out.println("Status is not Available in Adda Page.");
		}

		Assert.assertEquals(statusUp, true, "Status is Available in Adda Page.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);
		
		util.scrollToElementByID("in.spicemudra:id/textAddaPollTitle");
		

		boolean poll = ad.pollHeader.isDisplayed();
		if (poll == true) {
			System.out.println("Poll Header is Available in Adda Page.");
		} else {
			System.out.println("Poll Header is not Available in Adda Page.");
		}

		Assert.assertEquals(poll, true, "Poll Header is Available in Adda Page.");

		System.out.println("=====================================");
	}
	
	@Test(priority = 3)
	public void AddaPool(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);
		
		Utilities util = new Utilities(Driver);
		util.scrollToElementByID("in.spicemudra:id/textAddaPollTitle");
		
		String poll = ad.textAddaPollTitle.getText();
		System.out.println(poll);
		
		if (poll.equals("Poll of the day")) {
			ad.radioButtonYes.click();
		}
		else if (poll.equals("Poll Result")) {
			util.Generalscreenshot(method);
		}
		
		else {
			System.out.println("Poll Is Not Available");
		}

		System.out.println("=====================================");
	}

	@Test(priority = 4)
	public void AddaSlidingStoryContents() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);
		
		Utilities util = new Utilities(Driver);
		util.scrollToText("Happy Birthday");

		boolean addaSoch = ad.headerThought.isDisplayed();
		if (addaSoch == true) {
			System.out.println("Adda Soch is Available in Sliding Story.");
		} else {
			System.out.println("Adda Soch is Available in Sliding Story.");
		}

		Assert.assertEquals(addaSoch, true, "Adda Soch is Available in Sliding Story.");

		boolean happyBirthday = ad.smallBirthdayTitle.isDisplayed();
		if (happyBirthday == true) {
			System.out.println("Happy Birthday is Available in Sliding Story.");
		} else {
			System.out.println("Happy Birthday is not Available in Sliding Story.");
		}

		Assert.assertEquals(happyBirthday, true, "Happy Birthday is Available in Sliding Story.");

		boolean happyAnniversary = ad.textAnniverseryTitle.isDisplayed();
		if (happyAnniversary == true) {
			System.out.println("Happy Anniversary is Available in Sliding Story.");
		} else {
			System.out.println("Happy Anniversary is not Available in Sliding Story.");
		}

		Assert.assertEquals(happyAnniversary, true, "Happy Anniversary is Available in Sliding Story.");

		
		util.touchActionSlide(872, 499, 318, 504);

		boolean offerSlide = ad.offer.isDisplayed();
		if (offerSlide == true) {
			System.out.println("offers is Available in Sliding Story");
		} else {
			System.out.println("offers is not Available in Sliding Story");
		}

		Assert.assertEquals(offerSlide, true, "offers is Available in Sliding Story");
//
//		boolean BusinessStory = ad.textBusinessStory.isDisplayed();
//		if (BusinessStory == true) {
//			System.out.println("Business Insights is Available in Sliding Story");
//		} else {
//			System.out.println("Business Insights is not Available in Sliding Story");
//		}
//
//		Assert.assertEquals(BusinessStory, true, "Business Insights is Available in Sliding Story");

		System.out.println("=====================================");
	}

	@Test(priority = 5)
	public void AddaSlidingStoryAddaSoch(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);

		Utilities util = new Utilities(Driver);
		util.touchActionSlide(263, 515, 493, 515);

		ad.headerThought.click();

		util.waitAction(515, 515, 10000);

		boolean addaSochThoughtPage = ad.addaSochThought.isDisplayed();
		if (addaSochThoughtPage == true) {
			System.out.println("Adda Soch Thought Page is Available on Clicking Adda Soch.");
		} else {
			System.out.println("Adda Soch Thought Page is not Available on Clicking Adda Soch.");
		}

		Assert.assertEquals(addaSochThoughtPage, true, "Adda Soch Thought Page is Available on Clicking Adda Soch.");
		
		util.Generalscreenshot(method);

		Driver.pressKey(new KeyEvent(AndroidKey.BACK));

		System.out.println("=====================================");
	}

	@Test(priority = 6)
	public void AddaSlidingStoryHappyBirth(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);
		ad.smallBirthdayTitle.click();

		Utilities util = new Utilities(Driver);
		util.waitAction(515, 515, 10000);

		boolean birthdayTitlePage = ad.birthdayTitle.isDisplayed();
		if (birthdayTitlePage == true) {
			System.out.println("Happy Birthday page is Available on clicking Happy Birthday.");
		} else {
			System.out.println("Happy Birthday page is not Available on clicking Happy Birthday.");
		}

		Assert.assertEquals(birthdayTitlePage, true, "Happy Birthday page is Available on clicking Happy Birthday.");
		
		util.Generalscreenshot(method);


		Driver.pressKey(new KeyEvent(AndroidKey.BACK));

		System.out.println("=====================================");
	}

	@Test(priority = 7)
	public void AddaSlidingStoryHappyAnniversary(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);
		ad.textAnniverseryTitle.click();

		Utilities util = new Utilities(Driver);
		util.waitAction(515, 515, 10000);

		boolean anniverseryTitlePage = ad.anniverseryTitle.isDisplayed();
		if (anniverseryTitlePage == true) {
			System.out.println("Happy Anniversary page is Available on clicking Happy Anniversary.");
		} else {
			System.out.println("Happy Anniversary page is not Available on clicking Happy Anniversary.");
		}

		Assert.assertEquals(anniverseryTitlePage, true,
				"Happy Anniversary page is Available on clicking Happy Anniversary.");
		
		util.Generalscreenshot(method);

		Driver.pressKey(new KeyEvent(AndroidKey.BACK));

		System.out.println("=====================================");
	}

	@Test(priority = 8)
	public void AddaSlidingStoryOffers(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);

		Utilities util = new Utilities(Driver);
		util.touchActionSlide(872, 499, 318, 504);

		ad.offer.click();

		util.waitAction(515, 515, 10000);

		boolean offerImagePage = ad.offerImage.isDisplayed();
		if (offerImagePage == true) {
			System.out.println("Offers Images Page is Available on Clicking Offers Soch.");
		} else {
			System.out.println("Offers Images Page is not Available on Clicking Offers Soch.");
		}

		Assert.assertEquals(offerImagePage, true, "Offers Images Page is Available on Clicking Offers Soch.");
		
		util.Generalscreenshot(method);

		Driver.pressKey(new KeyEvent(AndroidKey.BACK));

		System.out.println("=====================================");
	}

//	@Test(priority = 9)
//	public void AddaSlidingStoryBusinessInsight() throws InterruptedException, FileNotFoundException, IOException {
//		System.out.println("=====================================");
//
//		AddaPage ad = new AddaPage(Driver);
//
//		ad.textBusinessStory.click();
//
//		Utilities util = new Utilities(Driver);
//		util.waitAction(515, 515, 10000);
//
//		boolean businessInsightPage = ad.yourBusiness.isDisplayed();
//		if (businessInsightPage == true) {
//			System.out.println("Your Business Page is Available on Clicking Business Insight.");
//		} else {
//			System.out.println("Your Business Page is not Available on Clicking Business Insight.");
//		}
//
//		Assert.assertEquals(businessInsightPage, true, "Your Business Page is Available on Clicking Business Insight.");
//
//		System.out.println("=====================================");
//	}
//
//	@Test(priority = 10)
//	public void AddaSlidingStoryBusinessInsightShowInDetailsButton()
//			throws InterruptedException, FileNotFoundException, IOException {
//		System.out.println("=====================================");
//
//		AddaPage ad = new AddaPage(Driver);
//
//		Utilities util = new Utilities(Driver);
//		util.waitAction(515, 515, 10000);
//
//		boolean showInDetailButton = ad.showInDetail.isDisplayed();
//		if (showInDetailButton == true) {
//			System.out.println("Show In Detail Button is Available in Your Business Page.");
//		} else {
//			System.out.println("Business Insight Page is not Available on Clicking Business Insight.");
//		}
//
//		Assert.assertEquals(showInDetailButton, true,"Business Insight Page is Available on Clicking Business Insight.");
//
//		System.out.println("=====================================");
//	}
//
//	@Test(priority = 11)
//	public void AddaSlidingStoryBusinessInsightEarningPage(Method method) throws InterruptedException, FileNotFoundException, IOException {
//		System.out.println("=====================================");
//
//		AddaPage ad = new AddaPage(Driver);
//		ad.showInDetail.click();
//
//		boolean earningsPage = ad.earnings.isDisplayed();
//		if (earningsPage == true) {
//			System.out.println("On Clicking Show In Details Button Earnings Page is Displayed.");
//		} else {
//			System.out.println("On Clicking Show In Details Button Earnings Page is not Displayed.");
//		}
//
//		Assert.assertEquals(earningsPage, true, "On Clicking Show In Details Button Earnings Page is Displayed.");
//		
//		Utilities util = new Utilities(Driver);
//		util.Generalscreenshot(method);
//
//		Driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		Driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		System.out.println("=====================================");
//	}
	
	@Test(priority = 12)
	public void AddaApnaAnubahv() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);
		ad.shareStory.click();
		
		boolean apnaAnubhavSpicePage = ad.apnaAnubhavSpice.isDisplayed();
		if (apnaAnubhavSpicePage == true) {
			System.out.println("Apna anubhav Spice Money Adda par kaise share karein? Page is Displayed.");
		} else {
			System.out.println("Apna anubhav Spice Money Adda par kaise share karein? Page is not Displayed.");
		}

		Assert.assertEquals(apnaAnubhavSpicePage, true, "Apna anubhav Spice Money Adda par kaise share karein? Page is Displayed.");


		System.out.println("=====================================");
	}
	
	@Test(priority = 13)
	public void AddaAbhiShareKareinButton() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);
		
		boolean abhiShareButton = ad.tvWhatsapp.isDisplayed();
		if (abhiShareButton == true) {
			System.out.println("Abhi share karein Button is Available.");
		} else {
			System.out.println("Abhi share karein Button is not Available.");
		}

		Assert.assertEquals(abhiShareButton, true, "Abhi share karein Button is Available.");


		System.out.println("=====================================");
	}
	
	@Test(priority = 14)
	public void AddaKripyaDhyanDe(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);
		ad.tvWhatsapp.click();
		boolean kripyadhyandePage = ad.kripyadhyande.isDisplayed();
		if (kripyadhyandePage == true) {
			System.out.println("Kripya dhyan de! Page is Displayed.");
		} else {
			System.out.println("Kripya dhyan de! Page is not Displayed.");
		}

		Assert.assertEquals(kripyadhyandePage, true, "Kripya dhyan de! Page is Displayed.");
		
		boolean apnaAnubhavShare = ad.tvWhatsapp.isDisplayed();
		if (apnaAnubhavShare == true) {
			System.out.println("Apna anubhav share karein! Button is Available.");
		} else {
			System.out.println("Apna anubhav share karein! Button is Available.");
		}

		Assert.assertEquals(apnaAnubhavShare, true, "Apna anubhav share karein! Button is Available.");

		System.out.println("=====================================");
	}
	
	@Test(priority = 15)
	public void AddaAbhiShareKareinButtonRedirectedToWhatsAPP(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);
		ad.tvWhatsapp.click();
		boolean whatsAppPage = ad.whatsApp.isDisplayed();
		if (whatsAppPage == true) {
			System.out.println("Clicking on Apna anubhav share karein! Button is Redirected to WhatsApp.");
		} else {
			System.out.println("Clicking on Apna anubhav share karein! Button is not Redirected to WhatsApp.");
		}

		Assert.assertEquals(whatsAppPage, true, "Clicking on Apna anubhav share karein! Button is Redirected to WhatsApp.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);
		
		Driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Driver.pressKey(new KeyEvent(AndroidKey.BACK));


		System.out.println("=====================================");
	}
	
	@Test(priority = 16)
	public void AddaSonuSoodHelpingHand() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);
		Utilities util = new Utilities(Driver);
		util.scrollToText("Sonu Sood's helping hand ");
		ad.contactSonu.click();
		boolean sonuHelpingPage = ad.sonuHeading.isDisplayed();
		if (sonuHelpingPage == true) {
			System.out.println("Sonu Sood's helping hand Page Is Displayed.");
		} else {
			System.out.println("Sonu Sood's helping hand Page Is not Displayed.");
		}

		Assert.assertEquals(sonuHelpingPage, true, "Sonu Sood's helping hand Page Is Displayed.");


		System.out.println("=====================================");
	}
	
	@Test(priority = 17)
	public void AddaSonuSoodHelpingHandContent() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);
		ad.sonuHeading.click();
		boolean personNameText = ad.personName.isDisplayed();
		if (personNameText == true) {
			System.out.println("In Sonu Sood's helping hand Page Name Text Feild Is Available.");
		} else {
			System.out.println("In Sonu Sood's helping hand Page Name Text Feild Is Not Available.");
		}

		Assert.assertEquals(personNameText, true, "In Sonu Sood's helping hand Page Name Text Feild Is Available.");
		
		boolean ageText = ad.age.isDisplayed();
		if (ageText == true) {
			System.out.println("In Sonu Sood's helping hand Page Age Text Feild Is Available.");
		} else {
			System.out.println("In Sonu Sood's helping hand Page Age Text Feild Is Not Available.");
		}

		Assert.assertEquals(ageText, true, "In Sonu Sood's helping hand Page Age Text Feild Is Available.");
		
		boolean mobileNumberText = ad.mobileNumber.isDisplayed();
		if (mobileNumberText == true) {
			System.out.println("In Sonu Sood's helping hand Page Mobile Number Text Feild Is Available.");
		} else {
			System.out.println("In Sonu Sood's helping hand Page Mobile Number Text Feild Is Not Available.");
		}

		Assert.assertEquals(mobileNumberText, true, "In Sonu Sood's helping hand Page Mobile Number Text Feild Is Available.");
		
		boolean helpSector = ad.physical.isDisplayed();
		if (helpSector == true) {
			System.out.println("In Sonu Sood's helping hand Page Help Sector Feild Is Available.");
		} else {
			System.out.println("In Sonu Sood's helping hand Page Help Sector Text Feild Is Not Available.");
		}

		Assert.assertEquals(helpSector, true, "In Sonu Sood's helping hand Page Help Sector Text Feild Is Available.");
		
		boolean issueText = ad.issue.isDisplayed();
		if (issueText == true) {
			System.out.println("In Sonu Sood's helping hand Page  Explain The Issue Text Feild Is Available.");
		} else {
			System.out.println("In Sonu Sood's helping hand Page Explain The Issue Text Feild Is Not Available.");
		}

		Assert.assertEquals(issueText, true, "In Sonu Sood's helping hand Page Explain The Issue Text Feild Is Available.");
		
		boolean login = ad.loginbutton.isDisplayed();
		if (login == true) {
			System.out.println("In Sonu Sood's helping hand Page We Bring A Better Tomorrow Button Is Available.");
		} else {
			System.out.println("In Sonu Sood's helping hand Page We Bring A Better Tomorrow Button Is Not Available.");
		}

		Assert.assertEquals(login, true, "In Sonu Sood's helping hand Page We Bring A Better Tomorrow Button Is Available.");


		System.out.println("=====================================");
	}
	
	@Test(priority = 18)
	public void AddaSonuSoodHelpingHandRequestHasBeenSubmittedSuccessfully(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);
		
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "\\src\\main\\java\\Adda.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		ad.personName.sendKeys(prop.getProperty("personName"));
		ad.age.sendKeys(prop.getProperty("age"));
		ad.mobileNumber.sendKeys(prop.getProperty("mobileNumber"));
		ad.physical.click();
		ad.financial.click();
		ad.issue.sendKeys("Testing");
		ad.loginbutton.click();
		
		boolean yourRequestPopUp = ad.yourRequest.isDisplayed();
		if (yourRequestPopUp == true) {
			System.out.println("Your request has been submitted successfully. Pop-Up Is Displayed.");
		}
		else {
			System.out.println("Your request has been submitted successfully. Pop-Up Is not Displayed.");
		}

		Assert.assertEquals(yourRequestPopUp, true, "Your request has been submitted successfully. Pop-Up Is Displayed.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);
		
		ad.buttonDefaultPositive.click();
		
		System.out.println("=====================================");
	}
	
	@Test(priority = 19)
	public void AddaGreeting() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");
		
		Utilities util  = new Utilities(Driver);
		util.scrollToElementByID("in.spicemudra:id/textMsgDay");

		AddaPage ad = new AddaPage(Driver);
		String greeting = ad.msgDay.getText();
		String[] greetingExpected = greeting.split(",");
		System.out.println(greetingExpected[0]);
		
		String greetingActual = util.greeting();
		System.out.println(greetingActual);
		
		if (greetingExpected[0].equals(greetingActual)) {
			System.out.println("Greeting of the day is Displayed Properly");
		}
		else {
			System.out.println("Greeting of the day is not Displayed Properly");
		}
		
		Assert.assertEquals(greetingExpected[0], greetingActual, "Share Page is Displayed.");
	}
	
	@Test(priority = 20)
	public void AddaStatusContent() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);
		Utilities util = new Utilities(Driver);
		util.scrollToElementByID("in.spicemudra:id/tvViews");
		
		boolean viewIcon = ad.views.isDisplayed();
		if (viewIcon == true) {
			System.out.println("In Status View is Available");
		}
		else {
			System.out.println("In Status View is not Available");
		}

		Assert.assertEquals(viewIcon, true, "In Status View is Available");
		
		boolean likesIcon = ad.likes.isDisplayed();
		if (likesIcon == true) {
			System.out.println("In Status Likes is Available");
		}
		else {
			System.out.println("In Status Likes is not Available");
		}

		Assert.assertEquals(likesIcon, true, "In Status Likes is Available");
		
		boolean commentsIcon = ad.comments.isDisplayed();
		if (commentsIcon == true) {
			System.out.println("In Status Comments is Available");
		}
		else {
			System.out.println("In Status Comments is not Available");
		}

		Assert.assertEquals(commentsIcon, true, "In Status Comments is Available");
		
		boolean shareIcon = ad.share.isDisplayed();
		if (shareIcon == true) {
			System.out.println("In Status Share is Available");
		}
		else {
			System.out.println("In Status Share is not Available");
		}

		Assert.assertEquals(shareIcon, true, "In Status Share is Available");
		
		
		System.out.println("=====================================");
	}
	
	@Test(priority = 21)
	public void AddaStatusLikeClickable(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);
		ad.likes.click();
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);
		
		ad.likes.click();

		System.out.println("=====================================");
	}
	
	@Test(priority = 22)
	public void AddaStatusWriteComment() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);
		ad.comments.click();
		boolean writeCommentSection = ad.writeComment.isDisplayed();
		if (writeCommentSection == true) {
			System.out.println("Write a comment... Is Displayed.");
		} else {
			System.out.println("Write a comment... Is Not Displayed.");
		}

		Assert.assertEquals(writeCommentSection, true, "Write a comment... Is Displayed.");


		System.out.println("=====================================");
	}
	
	@Test(priority = 23)
	public void AddaStatusWriteCommentPositiveTest(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);
		
		WebElement writeCommentSec = ad.writeComment;
		
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "\\src\\main\\java\\adda.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		writeCommentSec.sendKeys(prop.getProperty("writeCommentSec"));
		    String writeCommentSec1 = writeCommentSec.getAttribute("text");
		    System.out.println(writeCommentSec1);
		    if(writeCommentSec1.contentEquals("1")){
		    System.out.println("In Write a Comment We are able to type");
		    }
		    else{
		    System.out.println("In Write a Comment We are Not able to type");
		    }
		Assert.assertEquals(writeCommentSec1,"Automation Testing", "In Write a Comment We are able to type.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);
		
		Driver.pressKey(new KeyEvent(AndroidKey.BACK));


		System.out.println("=====================================");
	}
	
	@Test(priority = 24)
	public void AddaStatusShare(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);
		ad.share.click();
		boolean statusSharePage = ad.statusShare.isDisplayed();
		if (statusSharePage == true) {
			System.out.println("Share Page is Displayed.");
		} else {
			System.out.println("Share Page is not Displayed.");
		}

		Assert.assertEquals(statusSharePage, true, "Share Page is Displayed.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);
		
		Driver.pressKey(new KeyEvent(AndroidKey.BACK));

		System.out.println("=====================================");
	}
	
	@Test(priority = 25)
	public void AddaStatusVideoFullScreen(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);
		ad.playButton.click();
		ad.fullscreenButton.click();
		Thread.sleep(1000);
		boolean fullscreenPage = ad.fullscreen.isDisplayed();
		if (fullscreenPage == true) {
			System.out.println("Clicking on FullScreen button video has been Maximized.");
		} else {
			System.out.println("Clicking on FullScreen button video has Not been Maximized.");
		}

		Assert.assertEquals(fullscreenPage, true, "Clicking on FullScreen button video has been Maximized.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);
		
		Driver.pressKey(new KeyEvent(AndroidKey.BACK));

		System.out.println("=====================================");
	}
	
	@Test(priority = 26)
	public void AddaStatusYoutube(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		AddaPage ad = new AddaPage(Driver);
		ad.viewClick.click();
		ad.youtubeButton.click();

		boolean youtube = ad.youtube.isDisplayed();
		if (youtube == true) {
			System.out.println("Youtube Page Is Displayed.");
		} else {
			System.out.println("Youtube Page Is Not Displayed.");
		}

		Assert.assertEquals(youtube, true, "Youtube Page Is Displayed.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);
		
		Driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Driver.pressKey(new KeyEvent(AndroidKey.BACK));

		System.out.println("=====================================");
	}
	

}