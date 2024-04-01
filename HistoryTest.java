package SpiceMoneyApp.SMAApp;

/*
 * Prerequ
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.HistoryPage;
import pageObjects.samplePage;

import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

/**
 * Unit test for simple App.
 */
public class HistoryTest extends base {

	/**
	 * Rigorous Test :-)
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
//	@BeforeTest
//	public void beforetest() {
//		service=startServer();
//	}
//	@AfterTest
//	public void stopTheServer() {
//	     service.stop();
//	}

	@BeforeClass
	public void SetDriver() throws IOException {
		AppiumDriver<AndroidElement> Driver = capabilities();
		Driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
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

	@Test(priority = 0)
	public void HistoryAllPage() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);

		his.history.click();
		Thread.sleep(1500);
		boolean hist = his.historyTrans.isDisplayed();

		if (hist == true) {
			System.out.println("History page is Displayed.");
		}

		else {
			System.out.println("History page is not Displayed.");
		}

		Assert.assertEquals(hist, true, "History page is Displayed.");

		System.out.println("=====================================");
	}

	@Test(priority = 1)
	public void HistoryBBPS() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);

		his.bbps.click();
		Thread.sleep(1500);
		boolean date1 = his.date.isDisplayed();
		if (date1 == true) {
			System.out.println("In History page of BBPS section Date is Displayed");
		} else {
			System.out.println("In History page of BBPS section Date is  not Displayed");
		}

		Assert.assertEquals(date1, true, "In History page of BBPS section Date is Displayed");

		boolean ref1 = his.refID.isDisplayed();
		if (ref1 == true) {
			System.out.println("In History page of BBPS section Ref ID is Displayed.");
		} else {
			System.out.println("In History page of BBPS section Ref ID is not Displayed.");
		}

		Assert.assertEquals(ref1, true, "In History page of BBPS section Ref ID is Displayed.");

		boolean status1 = his.status.isDisplayed();
		if (status1 == true) {
			System.out.println("In History page of BBPS section Status is Displayed");
		} else {
			System.out.println("In History page of BBPS section Status is not Displayed");
		}

		Assert.assertEquals(status1, true, "In History page of BBPS section Status is Displayed");

		boolean num1 = his.mobileNumber.isDisplayed();
		if (num1 == true) {
			System.out.println("In History page of BBPS Mobile Number Ref ID is Displayed.");
		} else {
			System.out.println("In History page of BBPS Mobile Number Status is not Displayed");
		}

		Assert.assertEquals(num1, true, "In History page of BBPS Mobile Number Ref ID is Displayed.");

		System.out.println("=====================================");
	}

	@Test(priority = 2)
	public void HistoryBBPSDate() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		Thread.sleep(1500);
		his.date.click();
		boolean filter1 = his.filterBy.isDisplayed();

		if (filter1 == true) {
			System.out.println("Filter by Date Page is Displayed.");
		}

		else {
			System.out.println("Filter by Date Page is not Displayed.");
		}

		Assert.assertEquals(filter1, true, "Filter by Date Page is Displayed.");

		System.out.println("=====================================");
	}

	@Test(priority = 3)
	public void HistoryBBPSTransactionDate(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		Thread.sleep(1500);
		his.fromeDate.click();
		his.monthDate.click();
		his.okDate.click();
		his.toDate.click();
		his.monthDate1.click();
		his.okDate.click();
		his.btnApply.click();
		Thread.sleep(500);
		boolean bbpsD = his.filterClose.isDisplayed();
		if (bbpsD == true) {
			System.out.println("Transaction of selected date is displayed if Available.");
		} else {
			System.out.println("Transaction of selected date is not Available.");
		}

		Assert.assertEquals(bbpsD, true, "Transaction of selected date is displayed if Available.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);
		
		his.filterClose.click();

		System.out.println("=====================================");
	}

	@Test(priority = 4)
	public void HistoryBBPSRefIDPage() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		Thread.sleep(1500);
		his.refID.click();
		boolean filterBy = his.refPage.isDisplayed();
		if (filterBy == true) {
			System.out.println("Filter by Ref ID Page is Displayed.");
		} else {
			System.out.println("Filter by Ref ID Page is not Displayed.");
		}

		Assert.assertEquals(filterBy, true, "Filter by Ref ID Page is Displayed.");

		System.out.println("=====================================");
	}

	@Test(priority = 5)
	public void HistoryBBPSRefIDPageTransaction(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		Thread.sleep(1500);
		
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "\\src\\main\\java\\History.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		his.refCustomField.sendKeys(prop.getProperty("BBPSRefID"));
		his.btnApply.click();

		boolean ref = his.refindex.isDisplayed();
		if (ref == true) {
			System.out.println("Transaction of Ref ID is Displayed.");
		}

		else {
			System.out.println("Transaction of Ref ID is not Displayed.");
		}

		Assert.assertEquals(ref, true, "Transaction of Ref ID is Displayed.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);

		his.filterClose.click();

		System.out.println("=====================================");
	}

	@Test(priority = 6)
	public void HistoryBBPSStatus() throws InterruptedException, FileNotFoundException, IOException {

		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		Thread.sleep(1500);
		his.satusPage.click();
		boolean status = his.filterBy.isDisplayed();
		if (status == true) {
			System.out.println("Filter By Status Page is Displayed.");
		}

		else {
			System.out.println("Filter By Status Page is not Displayed.");
		}

		Assert.assertEquals(status, true, "Filter By Status Page is Displayed.");

		boolean succ = his.succces.isDisplayed();
		if (succ == true) {
			System.out.println("In Filter By Status Page Success is Displayed.");
		} else {
			System.out.println("In Filter By Status Page Success is not Displayed.");
		}

		Assert.assertEquals(succ, true, "In Filter By Status Page Success is Displayed.");

		boolean fail = his.failure.isDisplayed();
		if (fail == true) {
			System.out.println("In Filter By Status Page Failure is Displayed.");
		} else {
			System.out.println("In Filter By Status Page Failure is not Displayed.");
		}

		Assert.assertEquals(fail, true, "In Filter By Status Page Failure is Displayed.");

		boolean pend = his.pending.isDisplayed();
		if (pend == true) {
			System.out.println("In Filter By Status Page Pending is Displayed.");
		} else {
			System.out.println("In Filter By Status Page Pending is not Displayed.");
		}

		Assert.assertEquals(pend, true, "In Filter By Status Page Pending is Displayed.");

		boolean refun = his.refunded.isDisplayed();
		if (refun == true) {
			System.out.println("In Filter By Status Page Refunded is Displayed.");
		} else {
			System.out.println("In Filter By Status Page Refunded is not Displayed.");
		}

		Assert.assertEquals(refun, true, "In Filter By Status Page Refunded is Displayed.");

		System.out.println("=====================================");
	}

	@Test(priority = 7)
	public void HistoryBBPSSuccessStatus() throws InterruptedException, FileNotFoundException, IOException {

		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		Thread.sleep(1500);
		his.succces.click();
		his.btnApply.click();
		boolean succ1 = his.statusSuccess.isDisplayed();
		if (succ1 == true) {
			System.out.println("Success Status of BBPS Transaction is Displayed.");
		}

		else {
			System.out.println("Success Status of BBPS Transaction is not Displayed.");
		}

		Assert.assertEquals(succ1, true, "Success Status of BBPS Transaction is Displayed.");

		System.out.println("=====================================");

	}

	@Test(priority = 8)
	public void HistoryBBPSHelp(Method method) throws InterruptedException, FileNotFoundException, IOException {

		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		his.tvHelpSection.click();
		boolean selfCarePage = his.selfCare.isDisplayed();
		if (selfCarePage == true) {
			System.out.println("Self Care Page Is Displayed.");
		}

		else {
			System.out.println("Self Care Page Is Not Displayed.");
		}

		Assert.assertEquals(selfCarePage, true, "Self Care Page Is Displayed.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);

		his.backArrow.click();
		his.statusSuccess.click();

		System.out.println("=====================================");

	}

	@Test(priority = 9)
	public void HistoryBBPSFailureStatus(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		Thread.sleep(1500);
		his.status.click();
		his.failure.click();
		his.btnApply.click();

		boolean fail1 = his.statusFailure.isDisplayed();
		if (fail1 == true) {
			System.out.println("Failure Status of BBPS Transaction is Displayed.");
		}

		else {
			System.out.println("Failure Status of BBPS Transaction is not Displayed.");
		}

		Assert.assertEquals(fail1, true, "Failure Status of BBPS Transaction is Displayed.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);

		his.statusFailure.click();

		System.out.println("=====================================");

	}

	@Test(priority = 10)
	public void HistoryBBPSPendingStatus(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		Thread.sleep(1500);
		his.status.click();
		his.pending.click();
		his.btnApply.click();
		boolean pend1 = his.statusPending.isDisplayed();
		if (pend1 == true) {
			System.out.println("Pending Status of BBPS Transaction is Displayed.");
		}

		else {
			System.out.println("Pending Status of BBPS Transaction is not Displayed.");
		}

		Assert.assertEquals(pend1, true, "Pending Status of BBPS Transaction is Displayed.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);

		his.statusPending.click();

		System.out.println("=====================================");
	}

	@Test(priority = 11)
	public void HistoryBBPSRefundedStatus(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		Thread.sleep(1500);
		his.status.click();
		his.refunded.click();
		his.btnApply.click();
		boolean refun1 = his.statusRefunded.isDisplayed();
		if (refun1 == true) {
			System.out.println("Refunded Status of BBPS Transaction is Displayed.");
		}

		else {
			System.out.println("Refunded Status of BBPS Transaction is not Displayed.");
		}

		Assert.assertEquals(refun1, true, "Pending Status of BBPS Transaction is Displayed.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);

		his.statusRefunded.click();

		System.out.println("=====================================");
	}

	@Test(priority = 12)
	public void HistoryBBPSMobileNumbers() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);

		his.mobileNumber.click();
		Thread.sleep(1500);
		boolean mob = his.refPage.isDisplayed();
		if (mob == true) {
			System.out.println("Filter by Mobile Number Page is Displayed.");
		} else {
			System.out.println("Filter by Mobile Number Page is NOT Displayed.");
		}
		Assert.assertEquals(mob, true, "Filter by Mobile Number Page is Displayed.");

		System.out.println("=====================================");
	}

	@Test(priority = 13)
	public void HistoryBBPSTransMobileNumbers(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		Thread.sleep(1500);

		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "\\src\\main\\java\\History.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		his.refCustomField.sendKeys(prop.getProperty("BBPSMobileNumber"));
		his.btnApply.click();

		boolean num = his.enterMobileNumber.isDisplayed();
		if (num == true) {
			System.out.println("Transaction of Enter mobile number is Displayed.");
		} else {
			System.out.println("Transaction of Enter mobile number is not Displayed.");
		}

		Assert.assertEquals(num, true, "Transaction of Enter mobile number is Displayed.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);

		his.filterClose.click();

		System.out.println("=====================================");
	}

	@Test(priority = 14)
	public void HistoryWallet() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		Thread.sleep(1500);
		his.dmt.click();
		his.wallet.click();

		boolean wallet = his.wallet.isDisplayed();
		if (wallet == true) {
			System.out.println("In History page, Wallet Section is Displayed.");
		} else {
			System.out.println("In History page, Wallet Section is Displayed.");
		}

		Assert.assertEquals(wallet, true, "In History page, Wallet Section is Displayed.");

		boolean date2 = his.date.isDisplayed();
		if (date2 == true) {
			System.out.println("In History page of Wallet Section date is Available.");
		} else {
			System.out.println("In History page of Wallet Section date is Available.");
		}

		Assert.assertEquals(date2, true, "In History page of Wallet Section date is Available.");

		boolean download = his.downloadStatement.isDisplayed();
		if (download == true) {
			System.out.println("In History page of Wallet Section Download Statement is Available.");
		}

		else {
			System.out.println("In History page of Wallet Section Download Statement is Available.");
		}

		Assert.assertEquals(download, true, "In History page of Wallet Section Download Statement is Available.");

		boolean summ = his.summary.isDisplayed();
		if (summ == true) {
			System.out.println("In History page of Wallet Section Summary is Available.");
		} else {
			System.out.println("In History page of Wallet Section Summary is Available.");
		}

		Assert.assertEquals(summ, true, "In History page of Wallet Section Summary is Available.");

		System.out.println("=====================================");

	}

	@Test(priority = 15)
	public void HistoryWalletDownlaodStatement() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		his.downloadStatement.click();

		boolean walletStatementPage = his.walletStatement.isDisplayed();
		if (walletStatementPage == true) {
			System.out.println("Wallet Statement Page is Displayed.");
		} else {
			System.out.println("Wallet Statement Page is not Displayed.");
		}

		Assert.assertEquals(walletStatementPage, true, "Wallet Statement Page is Displayed.");

		System.out.println("=====================================");
	}

	@Test(priority = 16)
	public void HistoryWalletDownlaodStatementContent()
			throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);

		boolean datewall = his.date.isDisplayed();
		if (datewall == true) {
			System.out.println("Date is Available in Wallet Statement Page.");
		} else {
			System.out.println("Date is Not Available in Wallet Statement Page.");
		}

		Assert.assertEquals(datewall, true, "Date is Available in Wallet Statement Page.");

		boolean excelwall = his.excel.isDisplayed();
		if (excelwall == true) {
			System.out.println("Excel is Available in Wallet Statement Page.");
		} else {
			System.out.println("Excel is Not Available in Wallet Statement Page.");
		}

		Assert.assertEquals(excelwall, true, "Excel is Available in Wallet Statement Page.");

		boolean csvwall = his.csv.isDisplayed();
		if (csvwall == true) {
			System.out.println("CSV is Available in Wallet Statement Page.");
		} else {
			System.out.println("CSV is Not Available in Wallet Statement Page.");
		}

		Assert.assertEquals(csvwall, true, "CSV is Available in Wallet Statement Page.");

		boolean downloadNowwall = his.downloadNow.isDisplayed();
		if (downloadNowwall == true) {
			System.out.println("Download Now is Available in Wallet Statement Page.");
		} else {
			System.out.println("Download Now is Not Available in Wallet Statement Page.");
		}

		Assert.assertEquals(downloadNowwall, true, "Download Now is Available in Wallet Statement Page.");

		System.out.println("=====================================");
	}

	@Test(priority = 17)
	public void HistoryWalletDownlaodStatementPage(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		his.date.click();
		his.fromeDate.click();
		his.monthDate.click();
		his.okDate.click();
		his.toDate.click();
		his.monthDate1.click();
		his.okDate.click();
		his.btnApply.click();
		his.downloadNow.click();

		boolean viewProgress = his.textViewProgress.isDisplayed();
		if (viewProgress == true) {
			System.out.println("Download in progress is Displayed.");
		} else {
			System.out.println("Download in progress is Not Displayed.");
		}

		Assert.assertEquals(viewProgress, true, "Download in progress is Displayed.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);

		Driver.pressKey(new KeyEvent(AndroidKey.BACK));

		System.out.println("=====================================");
	}

	@Test(priority = 18)
	public void HistoryWalletSummaryPage(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		Thread.sleep(1500);
		his.summary.click();

		boolean wll_sum = his.summaryPage.isDisplayed();
		if (wll_sum == true) {
			System.out.println("Wallet Summary Page is Displayed.");
		} else {
			System.out.println("Wallet Summary Page is not Displayed.");
		}

		Assert.assertEquals(wll_sum, true, "Wallet Summary Page is Displayed.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);

		his.backArrow.click();

		System.out.println("=====================================");
	}

	@Test(priority = 19)
	public void HistoryRechrge() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		Thread.sleep(1500);
		his.recharge.click();
		boolean date3 = his.date.isDisplayed();
		if (date3 == true) {
			System.out.println("In History page of Recharge section Date is Displayed");
		} else {
			System.out.println("In History page of Recharge section Date is  not Displayed");
		}

		Assert.assertEquals(date3, true, "In History page of Recharge section Date is Displayed");

		boolean dth = his.mobileDTH.isDisplayed();
		if (dth == true) {
			System.out.println("In History page of Recharge section Mobile/DTH No. is Displayed");
		} else {
			System.out.println("In History page of Recharge section Mobile/DTH No. is  not Displayed");
		}

		Assert.assertEquals(dth, true, "In History page of Recharge section Mobile/DTH No. is Displayed");

		System.out.println("=====================================");
	}
	
	@Test(priority = 20)
	public void HistoryRechrgeHelp(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		his.mobileDTH.click();
		
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "\\src\\main\\java\\History.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		his.refCustomField.sendKeys(prop.getProperty("RechargeNumber"));
		his.btnApply.click();
		his.tvHelpSection.click();
		boolean selfCarePage = his.selfCare.isDisplayed();
		if (selfCarePage == true) {
			System.out.println("Self Care Page Is Displayed.");
		}

		else {
			System.out.println("Self Care Page Is Not Displayed.");
		}

		Assert.assertEquals(selfCarePage, true, "Self Care Page Is Displayed.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);

		Driver.pressKey(new KeyEvent(AndroidKey.BACK));

		System.out.println("=====================================");
	}
	
	@Test(priority = 21)
	public void HistoryRechrgeShareAndPrint(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		his.ivArrow.click();

		boolean ShareReceipt = his.tvShareReceipt.isDisplayed();
		if (ShareReceipt == true) {
			System.out.println("Share Customer Receipt Is Available.");
		} else {
			System.out.println("Share Customer Receipt Is Not Available.");
		}

		Assert.assertEquals(ShareReceipt, true, "Share Customer Receipt Is Available.");

		boolean printReceipt = his.tvPrintReceipt.isDisplayed();
		if (printReceipt == true) {
			System.out.println("Print Customer Receipt Is Available.");
		} else {
			System.out.println("Print Customer Receipt Is Not Available.");
		}

		Assert.assertEquals(printReceipt, true, "Print Customer Receipt Is Available.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);
		
		Driver.pressKey(new KeyEvent(AndroidKey.BACK));

		System.out.println("=====================================");
	}

	@Test(priority = 22)
	public void HistoryAEPS() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		Thread.sleep(1500);
		his.aeps.click();
		boolean status2 = his.satusPage.isDisplayed();
		if (status2 == true) {
			System.out.println("In History page of AEPS section Status is Displayed");
		} else {
			System.out.println("In History page of AEPS section Status is  not Displayed");
		}

		Assert.assertEquals(status2, true, "In History page of AEPS section Status is Displayed");

		boolean aadhar = his.adhaar.isDisplayed();
		if (aadhar == true) {
			System.out.println("In History page of AEPS section Aadhaar is Displayed");
		} else {
			System.out.println("In History page of AEPS section Aadhaar is  not Displayed");
		}

		Assert.assertEquals(aadhar, true, "In History page of AEPS section Aadhaar is Displayed");

		boolean date4 = his.date.isDisplayed();
		if (date4 == true) {
			System.out.println("In History page of AEPS section Date is Displayed");
		} else {
			System.out.println("In History page of AEPS section Date is  not Displayed");
		}

		Assert.assertEquals(date4, true, "In History page of AEPS section Date is Displayed");

		boolean trans = his.transID.isDisplayed();
		if (trans == true) {
			System.out.println("In History page of AEPS section Trans ID is Displayed");
		} else {
			System.out.println("In History page of AEPS section Trans ID is  not Displayed");
		}

		Assert.assertEquals(aadhar, true, "In History page of AEPS section Trans ID is Displayed.");

		new TouchAction(Driver).press(point(844, 515)).waitAction(waitOptions(ofMillis(1000))).moveTo(point(263, 504))
				.release().perform();

		boolean num2 = his.mobileNumber.isDisplayed();
		if (num2 == true) {
			System.out.println("In History page of AEPS section Mobile Number is Displayed");
		} else {
			System.out.println("In History page of AEPS section Mobile Number is  not Displayed");
		}

		Assert.assertEquals(num2, true, "In History page of AEPS section Mobile Number is Displayed");

		System.out.println("=====================================");
	}

	@Test(priority = 23)
	public void HistoryDMT() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		Thread.sleep(1500);
		his.dmt.click();
		boolean trans1 = his.transID.isDisplayed();
		if (trans1 == true) {
			System.out.println("In History page of DMT section Trans ID is Displayed");
		} else {
			System.out.println("In History page of DMT section Trans ID is  not Displayed");
		}

		Assert.assertEquals(trans1, true, "In History page of DMT section Trans ID is Displayed");

		boolean date5 = his.date.isDisplayed();
		if (date5 == true) {
			System.out.println("In History page of DMT section Date is Displayed");
		} else {
			System.out.println("In History page of DMT section Date is  not Displayed");
		}

		Assert.assertEquals(date5, true, "In History page of DMT section Date is Displayed");

		boolean sender = his.senderMobile.isDisplayed();
		if (sender == true) {
			System.out.println("In History page of DMT section Sender Mobile No. is Displayed");
		} else {
			System.out.println("In History page of DMT section Sender Mobile No. is  not Displayed");
		}

		Assert.assertEquals(sender, true, "In History page of DMT section Sender Mobile No. is Displayed");

		boolean account = his.beneAccount.isDisplayed();
		if (account == true) {
			System.out.println("In History page of DMT section Bene Account No. is Displayed");
		} else {
			System.out.println("In History page of DMT section Bene Account No. is  not Displayed");
		}

		Assert.assertEquals(account, true, "In History page of DMT section Bene Account No. is Displayed");

		System.out.println("=====================================");
	}

	@Test(priority = 24)
	public void HistoryDMTShare(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		his.senderMobile.click();
		
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "\\src\\main\\java\\History.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		his.refCustomField.sendKeys(prop.getProperty("DMTMobNumber"));
		his.btnApply.click();
		his.ivArrow.click();
		his.tvShareReceipt.click();

		boolean statusSharePage = his.statusShare.isDisplayed();
		if (statusSharePage == true) {
			System.out.println("Share Page Is Displayed.");
		} else {
			System.out.println("Share Page Is Not Displayed.");
		}

		Assert.assertEquals(statusSharePage, true, "Share Page Is Displayed.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);

		Driver.pressKey(new KeyEvent(AndroidKey.BACK));

		System.out.println("=====================================");
	}

	@Test(priority = 25)
	public void HistoryDMTPrint(Method method) throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		his.tvPrintReceipt.click();

		boolean bluetoothPop = his.bluetooth.isDisplayed();
		if (bluetoothPop == true) {
			System.out.println("Spice Money wants to turn on Bluetooth Is Displayed.");
		} else {
			System.out.println("Spice Money wants to turn on Bluetooth Is Not Displayed.");
		}

		Assert.assertEquals(bluetoothPop, true, "Spice Money wants to turn on Bluetooth Is Displayed.");
		
		Utilities util = new Utilities(Driver);
		util.Generalscreenshot(method);

		Driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Driver.pressKey(new KeyEvent(AndroidKey.BACK));

		System.out.println("=====================================");
	}

	@Test(priority = 26)
	public void HistoryMATM() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);

		his.bbps.click();
		his.matm.click();
		Thread.sleep(1500);
		boolean date6 = his.date.isDisplayed();
		if (date6 == true) {
			System.out.println("In History page of MATM section Date is Displayed");
		} else {
			System.out.println("In History page of MATM section Date is  not Displayed");
		}

		Assert.assertEquals(date6, true, "In History page of MATM section Date is Displayed");

		boolean trans2 = his.transID.isDisplayed();
		if (trans2 == true) {
			System.out.println("In History page of MATM section Trans ID is Displayed");
		} else {
			System.out.println("In History page of MATM section Trans ID is  not Displayed");
		}

		Assert.assertEquals(trans2, true, "In History page of MATM section Trans ID is Displayed");

		boolean status3 = his.status.isDisplayed();
		if (status3 == true) {
			System.out.println("In History page of MATM section Status is Displayed");
		} else {
			System.out.println("In History page of MATM section Status is not Displayed");
		}

		Assert.assertEquals(status3, true, "In History page of MATM section Status is Displayed");

		boolean num3 = his.mobileNumber.isDisplayed();
		if (num3 == true) {
			System.out.println("In History page of MATM section Mobile Number is Displayed");
		} else {
			System.out.println("In History page of MATM section Mobile Number is  not Displayed");
		}
		Assert.assertEquals(num3, true, "In History page of MATM section Mobile Number is Displayed");

		System.out.println("=====================================");
	}

	@Test(priority = 27)
	public void HistoryMPOS() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		his.mpos.click();
		Thread.sleep(1500);
		boolean date7 = his.date.isDisplayed();
		if (date7 == true) {
			System.out.println("In History page of MPOS section Date is Displayed");
		} else {
			System.out.println("In History page of MPOS section Date is  not Displayed");
		}

		Assert.assertEquals(date7, true, "In History page of MPOS section Date is Displayed");

		boolean trans3 = his.transID.isDisplayed();
		if (trans3 == true) {
			System.out.println("In History page of MPOS section Trans ID is Displayed");
		} else {
			System.out.println("In History page of MPOS section Trans ID is  not Displayed");
		}

		Assert.assertEquals(trans3, true, "In History page of MPOS section Trans ID is Displayed");

		boolean status4 = his.status.isDisplayed();
		if (status4 == true) {
			System.out.println("In History page of MPOS section Status is Displayed");
		} else {
			System.out.println("In History page of MPOS section Status is not Displayed");
		}

		Assert.assertEquals(status4, true, "In History page of MPOS section Status is Displayed");

		System.out.println("=====================================");
	}

	@Test(priority = 28)
	public void HistoryMoveToBank() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		Thread.sleep(1500);
		his.moveToBank.click();

		boolean date8 = his.date.isDisplayed();
		if (date8 == true) {
			System.out.println("In History page of Move To Bank section Date is Displayed");
		} else {
			System.out.println("In History page of Move To Bank section Date is  not Displayed");
		}

		Assert.assertEquals(date8, true, "In History page of Move To Bank section Date is Displayed");

		boolean trans4 = his.transID.isDisplayed();
		if (trans4 == true) {
			System.out.println("In History page of Move To Bank section Trans ID is Displayed");
		} else {
			System.out.println("In History page of Move To Bank section Trans ID is  not Displayed");
		}

		Assert.assertEquals(trans4, true, "In History page of Move To Bank section Trans ID is Displayed");

		boolean status5 = his.status.isDisplayed();
		if (status5 == true) {
			System.out.println("In History page of Move To Bank section Status is Displayed");
		} else {
			System.out.println("In History page of Move To Bank section Status is not Displayed");
		}

		Assert.assertEquals(status5, true, "In History page of Move To Bank section Status is Displayed");

		System.out.println("=====================================");
	}

	@Test(priority = 29)
	public void HistoryCAREINSURANCE() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		Thread.sleep(1500);
		his.careInsurance.click();
		boolean date9 = his.date.isDisplayed();
		if (date9 == true) {
			System.out.println("In History page of CARE INSURANCE section Date is Displayed");
		} else {
			System.out.println("In History page of CARE INSURANCE section Date is  not Displayed");
		}

		Assert.assertEquals(date9, true, "In History page of CARE INSURANCE section Date is Displayed");

		boolean trans5 = his.transID.isDisplayed();
		if (trans5 == true) {
			System.out.println("In History page of CARE INSURANCE section Trans ID is Displayed");
		} else {
			System.out.println("In History page of CARE INSURANCE section Trans ID is  not Displayed");
		}

		Assert.assertEquals(trans5, true, "In History page of CARE INSURANCE section Trans ID is Displayed");

		boolean num4 = his.mobileNumber.isDisplayed();
		if (num4 == true) {
			System.out.println("In History page of CARE INSURANCE section Mobile Number is Displayed");
		} else {
			System.out.println("In History page of CARE INSURANCE section Mobile Number is not Displayed");
		}

		Assert.assertEquals(num4, true, "In History page of CARE INSURANCE section Mobile Number is Displayed");

		System.out.println("=====================================");
	}

	@Test(priority = 30)
	public void HistoryGRAHAKLOAN() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		Thread.sleep(1500);
		his.grahakLoan.click();
		boolean date10 = his.date.isDisplayed();
		if (date10 == true) {
			System.out.println("In History page of GRAHAK LOAN section Date is Displayed");
		} else {
			System.out.println("In History page of GRAHAK LOAN section Date is  not Displayed");
		}

		Assert.assertEquals(date10, true, "In History page of GRAHAK LOAN section Date is Displayed");

		boolean num5 = his.mobileNumber.isDisplayed();
		if (num5 == true) {
			System.out.println("In History page of GRAHAK LOAN section Mobile Number is Displayed");
		} else {
			System.out.println("In History page of GRAHAK LOAN section Mobile Number is not Displayed");
		}

		Assert.assertEquals(num5, true, "In History page of GRAHAK LOAN section Mobile Number is Displayed");

		System.out.println("=====================================");
	}

	@Test(priority = 31)
	public void HistoryAADHAARPAY() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);
		Thread.sleep(1500);
		his.aadhaarPay.click();
		boolean status6 = his.status.isDisplayed();
		if (status6 == true) {
			System.out.println("In History page of AADHAAR PAY section Status is Displayed");
		} else {
			System.out.println("In History page of AADHAAR PAY section Status is not Displayed");
		}

		Assert.assertEquals(status6, true, "In History page of AADHAAR PAY section Status is Displayed");

		boolean aadhar1 = his.adhaar.isDisplayed();
		if (aadhar1 == true) {
			System.out.println("In History page of AADHAAR PAY section Aadhaar is Displayed");
		} else {
			System.out.println("In History page of AADHAAR PAY section Aadhaar is  not Displayed");
		}

		Assert.assertEquals(aadhar1, true, "In History page of AADHAAR PAY section Aadhaar is Displayed");

		boolean date11 = his.date.isDisplayed();
		if (date11 == true) {
			System.out.println("In History page of AADHAAR PAY section Date is Displayed");
		} else {
			System.out.println("In History page of AADHAAR PAY section Date is  not Displayed");
		}

		Assert.assertEquals(date11, true, "In History page of AADHAAR PAY section Date is Displayed");

		boolean trans6 = his.transID.isDisplayed();
		if (trans6 == true) {
			System.out.println("In History page of AADHAAR PAY section Trans ID is Displayed");
		} else {
			System.out.println("In History page of AADHAAR PAY section Trans ID is  not Displayed");
		}

		Assert.assertEquals(trans6, true, "In History page of AADHAAR PAY section Trans ID is Displayed");

		new TouchAction(Driver).press(point(844, 526)).waitAction(waitOptions(ofMillis(1000))).moveTo(point(329, 515))
				.release().perform();

		boolean num6 = his.mobileNumber.isDisplayed();// manually
		if (num6 == true) {
			System.out.println("In History page of AADHAAR PAY Mobile Number Ref ID is Displayed.");
		} else {
			System.out.println("In History page of AADHAAR PAY Mobile Number Status is not Displayed");
		}

		Assert.assertEquals(num6, true, "In History page of AADHAAR PAY Mobile Number Ref ID is Displayed.");

		System.out.println("=====================================");
	}

	@Test(priority = 32)
	public void HistoryWALLETUPLOAD() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("=====================================");

		HistoryPage his = new HistoryPage(Driver);

		his.walletUpload.click();
		Thread.sleep(1500);
		boolean date12 = his.date.isDisplayed();
		if (date12 == true) {
			System.out.println("In History page of WALLET UPLOAD section Date is Displayed");
		} else {
			System.out.println("In History page of WALLET UPLOAD section Date is  not Displayed");
		}

		Assert.assertEquals(date12, true, "In History page of WALLET UPLOAD section Date is Displayed");

		boolean trans7 = his.transactionID.isDisplayed();
		if (trans7 == true) {
			System.out.println("In History page of WALLET UPLOAD section Transaction ID is Displayed");
		} else {
			System.out.println("In History page of WALLET UPLOAD section Transaction ID is  not Displayed");
		}

		Assert.assertEquals(trans7, true, "In History page of WALLET UPLOAD section Transaction ID is Displayed");

		boolean mode = his.mode.isDisplayed();
		if (mode == true) {
			System.out.println("In History page of WALLET UPLOAD section Mode is Displayed");
		} else {
			System.out.println("In History page of WALLET UPLOAD section Mode is not Displayed");
		}

		Assert.assertEquals(mode, true, "In History page of WALLET UPLOAD section Mode is Displayed");

		boolean status7 = his.status.isDisplayed();
		if (status7 == true) {
			System.out.println("In History page of WALLET UPLOAD section Status is Displayed");
		} else {
			System.out.println("In History page of WALLET UPLOAD section Status is not Displayed");
		}

		Assert.assertEquals(status7, true, "In History page of WALLET UPLOAD section Status is Displayed");

		System.out.println("=====================================");
	}

}
