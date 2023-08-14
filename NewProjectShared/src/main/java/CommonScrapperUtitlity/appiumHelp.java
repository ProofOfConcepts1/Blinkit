package CommonScrapperUtitlity;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class appiumHelp {

	static String fileLocationBBDelhi = "input-data/BB Delhi.xlsx";
	static String fileLocationBBIndore = "input-data/BB Indore.xlsx";
	static String fileLocationBBMumbai = "input-data/BB Mumbai.xlsx";
	static String fileLocationBBBengaluru = "input-data/BB Bengaluru.xlsx";

	static String fileLocationSwiggyDelhi = "input-data/Swiggy Delhi.xlsx";
	static String fileLocationSwiggyIndore = "input-data/Swiggy Indore.xlsx";
	static String fileLocationSwiggyMumbai = "input-data/Swiggy Mumbai.xlsx";
	static String fileLocationSwiggyBengaluru = "input-data/Swiggy Bengaluru.xlsx";

	static String fileLocationZeptoDelhi = "input-data/Zepto Delhi.xlsx";
	static String fileLocationZeptoMumbai = "input-data/Zepto Mumbai.xlsx";
	static String fileLocationZeptoBengaluru = "input-data/Zepto Bengaluru.xlsx";

	static String fileLocationBBDelhiNoCode = "input-data/BB Delhi - No product code.xlsx";
	static String fileLocationBBIndoreNoCode = "input-data/BB Indore - No product code.xlsx";

	static String fileLocationSwiggyDelhiNoCode = "input-data/Swiggy Delhi - No product code.xlsx";
	static String fileLocationSwiggyIndoreNoCode = "input-data/Swiggy Indore - No product code.xlsx";

	static String fileLocationZeptoDelhiNoCode = "input-data/Zepto Delhi - No product code.xlsx";

	static String fileLocationBlinkitDelhi = "input-data/Blinkit Delhi.xlsx";
	static String fileLocationBlinkitIndore = "input-data/Blinkit Indore.xlsx";

	String dunzoApp = "C:\\\\Users\\\\vimal.2358\\\\Desktop\\\\APK's\\\\bbdaily_ Online Milk _ Grocery_7.3.2_Apkpure.apk";
	String zeptoApp = "C:\\\\Users\\\\vimal.2358\\\\Desktop\\\\APK's\\\\bbdaily_ Online Milk _ Grocery_7.3.2_Apkpure.apk";

	static String appPackageSwiggy = "in.swiggy.android";
	static String appActivitySwiggy = "in.swiggy.android.activities.HomeActivity";

	static String appPackageBigBasket = "com.raincan.android.hybrid";
	static String appActivityBigBasket = "com.raincan.app.v2.splash.activity.SplashActivity";

	static File swiggy = new File("./Swiggy" + appiumHelp.dateTime() + ".xlsx");
	static File zepto = new File("./Zepto" + appiumHelp.dateTime() + ".xlsx");
	static File BB = new File("./BigBasket" + appiumHelp.dateTime() + ".xlsx");
	static File Blinkit = new File("./Blinkit" + appiumHelp.dateTime() + ".xlsx");

	static File swiggyTime = new File("./SwiggyTime" + appiumHelp.dateTime() + ".xlsx");
	static File zeptoTime = new File("./zeptoTime" + appiumHelp.dateTime() + ".xlsx");
	static File BBTime = new File("./BBTime" + appiumHelp.dateTime() + ".xlsx");

	static void remoteWebDriver(String nodeurl) throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setBrowserName("chrome");
		caps.setPlatform(Platform.WIN10);

		URL Nodeurl = new URL("http://10.10.0.226:4444");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vimal.2358\\eclipse-workspace\\vimal-workspaces\\Practice\\src\\main\\resources\\chromedriver.exe");

		RemoteWebDriver driver = new RemoteWebDriver(Nodeurl, caps);

//		AndroidDriver driver = new AndroidDriver(Nodeurl, capabilities);
		System.out.println("Driver Launched!");

		System.out.println("The interaction will start in s");
		System.out.println("The interaction is started");

		driver.get("https://developer.android.com/studio/run/emulator-commandline");

	}

	static AndroidDriver driverLaunch(String appPackage, String appActivity, long waitTime)
			throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AOSP on IA Emulator");
		capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver driver = new AndroidDriver(url, capabilities);
		System.out.println("Driver Launched!");

		System.out.println("The interaction will start in " + waitTime + " s");
		Thread.sleep(waitTime);
		System.out.println("The interaction is started");
		return driver;
	}

	static AndroidDriver driverLaunchParallel(String UDID, String appPackage, String appActivity, long waitTime,
			String port) throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AOSP on IA Emulator");
		capabilities.setCapability(MobileCapabilityType.UDID, "emulator-" + UDID);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
		capabilities.setCapability("systemPort", port);

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver driver = new AndroidDriver(url, capabilities);
		System.out.println("Driver Launched!");

		System.out.println("The interaction will start in " + waitTime + " s");
		Thread.sleep(waitTime);
		System.out.println("The interaction is started");
		return driver;
	}

	static void remoteDriverLaunch() throws MalformedURLException, InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
//		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
//		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
//		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "AOSP on IA Emulator");
//		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
//		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

		URL Nodeurl = new URL("http://10.10.0.226:4444/wd/hub");

		RemoteWebDriver remoteDriver = new RemoteWebDriver(Nodeurl, caps);
		System.out.println("Connected");

	}

	static void remoteDriver1(String UDID, String appPackage, String appActivity, String Appiumurl, long waitTime)
			throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AOSP on IA Emulator");
		capabilities.setCapability(MobileCapabilityType.UDID, "emulator-" + UDID);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

		URL Nodeurl = new URL("http://10.10.0.226:4444/wd/hub/");

		RemoteWebDriver driver = new RemoteWebDriver(Nodeurl, capabilities);

		System.out.println("Driver Launched!");

		System.out.println("The interaction will start in " + waitTime + " s");
		Thread.sleep(waitTime);
		System.out.println("The interaction is started");
	}

	static RemoteWebDriver remoteDriver(String UDID, String appPackage, String appActivity, String Appiumurl,
			long waitTime) throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AOSP on IA Emulator");
		capabilities.setCapability(MobileCapabilityType.UDID, "emulator-" + UDID);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

		URL Nodeurl = new URL("http://10.10.0.226:4444/wd/hub/");

		RemoteWebDriver driver = new RemoteWebDriver(Nodeurl, capabilities);
		System.out.println("Connected");

//		AndroidDriver driver = new AndroidDriver(Nodeurl, capabilities);
		System.out.println("Driver Launched!");

		System.out.println("The interaction will start in " + waitTime + " s");
		Thread.sleep(waitTime);
		System.out.println("The interaction is started");
		return driver;
	}

//	static String inputData() {
//		return fileLocation;
//	}

	static void uiHangCheck(WebDriver driver) {

		try {
			driver.findElement(By.xpath("//*[@resource-id='android:id/aerr_wait']")).click();
			System.out.println("Android UI is hanging!!");
		}

		catch (Exception e) {
			System.out.println("Android UI is Fine!!");
		}
	}

	static void screenshot(WebDriver driver, String i) throws IOException {

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("./appium-screenshot/image" + i + ".png");
		FileUtils.copyFile(SrcFile, DestFile);

	}

	static void socketHangup() throws IOException, InterruptedException {
		File file = new File("C:\\\\Users\\\\vimal.2358\\\\Desktop\\\\bat files\\\\socket hangup.bat");
		Desktop.getDesktop().open(file);
		Thread.sleep(10000);
	}

	static void restartServer() throws IOException, InterruptedException {
		File file = new File("C:\\\\Users\\\\vimal.2358\\\\Desktop\\\\bat files\\\\restart-server.bat");
		Desktop.getDesktop().open(file);
		Thread.sleep(10000);
	}

	static void appium() throws IOException, InterruptedException {
		File file = new File("C:\\\\Users\\\\vimal.2358\\\\Desktop\\\\bat files\\\\appium.bat");
		Desktop.getDesktop().open(file);
		Thread.sleep(30000);
	}

	static void VD1(Duration time) throws IOException, InterruptedException {
		File file = new File("C:\\\\Users\\\\vimal.2358\\\\Desktop\\\\bat files\\\\Virtual device 1.bat");
		Desktop.getDesktop().open(file);
		Thread.sleep(30000);
	}

	static void headlessVD1() throws IOException, InterruptedException {
		File file = new File("C:\\\\Users\\\\vimal.2358\\\\Desktop\\\\bat files\\\\Headless Virtual device 1.bat");
		Desktop.getDesktop().open(file);
		Thread.sleep(30000);
	}

	static String dateTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		return "" + dtf.format(now) + "";
	}

	static void popUp() {

		JFrame f;
		f = new JFrame();
		JOptionPane.showMessageDialog(f, "Hello, Exception is raised in the script.");

	}

	static void writeInExcel(String fileName, XSSFWorkbook workbook) throws IOException {

		File file = new File("C:\\Users\\vimal.2358\\Desktop\\" + fileName + appiumHelp.dateTime() + ".xlsx");

		FileOutputStream outstream = new FileOutputStream(file);

		workbook.write(outstream);
		workbook.close();
		outstream.close();
		System.out.println("File generated successfully!");
	}

	static void writeInExcelExistingSwiggy(String fileName, XSSFWorkbook workbook) throws IOException {

		FileOutputStream outstream = new FileOutputStream(swiggy);

		workbook.write(outstream);

		outstream.close();
		System.out.println("File generated successfully!");
	}

	static void writeInExcelExistingZepto(String fileName, XSSFWorkbook workbook) throws IOException {

		FileOutputStream outstream = new FileOutputStream(zepto);

		workbook.write(outstream);

		outstream.close();
		System.out.println("File generated successfully!");
	}
	
	static void writeInExcelExisting(File file, XSSFWorkbook workbook) throws IOException {

		FileOutputStream outstream = new FileOutputStream(file);

		workbook.write(outstream);

		outstream.close();
		System.out.println("File generated successfully!");
	}

	static void writeInExcelExistingBB(String fileName, XSSFWorkbook workbook) throws IOException {

		FileOutputStream outstream = new FileOutputStream(BB);

		workbook.write(outstream);

		outstream.close();
		System.out.println("File generated successfully!");
	}

	static void writeInExcelExistingBlinkit(String fileName, XSSFWorkbook workbook) throws IOException {

		FileOutputStream outstream = new FileOutputStream(Blinkit);

		workbook.write(outstream);

		outstream.close();
		System.out.println("File generated successfully!");
	}

	static void writeInExcelExistingSwiggyTime(XSSFWorkbook workbook) throws IOException {

		FileOutputStream outstream = new FileOutputStream(swiggyTime);

		workbook.write(outstream);

		outstream.close();
		System.out.println("File generated successfully!");
	}

	static void writeInExcelExistingZeptoTime(XSSFWorkbook workbook) throws IOException {

		FileOutputStream outstream = new FileOutputStream(zeptoTime);

		workbook.write(outstream);

		outstream.close();
		System.out.println("File generated successfully!");
	}

	static void writeInExcelExistingBBTime(XSSFWorkbook workbook) throws IOException {

		FileOutputStream outstream = new FileOutputStream(BBTime);

		workbook.write(outstream);

		outstream.close();
		System.out.println("File generated successfully!");
	}

	static int getRowNumber(String filelocation) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook(filelocation);
		XSSFSheet sheetname = book.getSheetAt(0);
		int physicalNumberOfRows = sheetname.getPhysicalNumberOfRows();
//		System.out.println("No of items in the data: "+physicalNumberOfRows);
		book.close();
		return physicalNumberOfRows;
	}

	static XSSFSheet getSheetName(String filelocation) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook(filelocation);
		XSSFSheet sheetname = book.getSheetAt(0);
		int physicalNumberOfRows = sheetname.getPhysicalNumberOfRows();
//		System.out.println("No of items in the data: "+physicalNumberOfRows);
		book.close();
		return sheetname;
	}

	static int getRowNumberIndore(String filelocation) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook(filelocation);
		XSSFSheet sheetname = book.getSheetAt(0);
		int physicalNumberOfRows = sheetname.getPhysicalNumberOfRows();
//		System.out.println("No of items in the data: "+physicalNumberOfRows);
		book.close();
		return physicalNumberOfRows;
	}

	static XSSFSheet getSheetNameIndore(String filelocation) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook(filelocation);
		XSSFSheet sheetname = book.getSheetAt(0);
		int physicalNumberOfRows = sheetname.getPhysicalNumberOfRows();
//		System.out.println("No of items in the data: "+physicalNumberOfRows);
		book.close();
		return sheetname;
	}

	public static List<String> productDetails(RemoteWebDriver driver, String path) {

		String wholeText = driver.findElement(By.xpath(path)).getText();

//		System.out.println(wholeText);

		String[] split = wholeText.split("[\r\n]+");

		List<String> listWhole = new ArrayList();

		for (String string : split) {
			listWhole.add(string);
		}

		List<String> spandMrp = new ArrayList();

//		System.out.println(listWhole);

		List<String> Mrp = new ArrayList();
		List<String> sp = new ArrayList();
		List<String> price = new ArrayList();

		String sp1 = null;
		String Mrp1 = null;

		for (String string : listWhole) {

			if (string.contains("MRP")) {
				String[] split2 = string.split("MRP:");

				for (String string2 : split2) {
					Mrp.add(string2);
				}

				spandMrp.add(Mrp.get(1));
			}

			if (string.contains("Price")) {
				String[] split2 = string.split("Price:");

				for (String string2 : split2) {
					sp.add(string2);
				}

				spandMrp.add(sp.get(1));
			}
		}

		try {
			if (spandMrp.size() > 1) {
				Mrp1 = spandMrp.get(0);
				sp1 = spandMrp.get(1);
			}

			else {
				Mrp1 = spandMrp.get(0);
				sp1 = spandMrp.get(0);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Mrp1 = null;
			sp1 = null;
		}

		price.add(Mrp1);
		price.add(sp1);

		return price;

	}

	public static String SwiggyQty(String text) {

		String[] split = text.split(":");

		List<String> splitList = new ArrayList<String>();

		for (String string : split) {
			splitList.add(string);
		}

		String qty = splitList.get(1);

		String[] qty1 = qty.split(" ");

		List<String> splitList1 = new ArrayList<String>();

		for (String string : qty1) {
			splitList1.add(string);
		}
//		System.out.println(splitList1);
//
//		System.out.println(splitList1.get(1));
//		System.out.println(splitList1.get(2));
//		System.out.println(splitList1.get(3));

		String symbol = splitList1.get(2).replace("to", "-");

		String actualQty = splitList1.get(1) + symbol + splitList1.get(3);

//		System.out.println(actualQty);
		return actualQty;
	}

	public static String removeRupeeSymbol(String data) {

		
		if (data.contains("₹")) {
			data =data.replace("₹", "");
		}
		
		else if (data.contains("Rs ")) {
			data =data.replace("Rs ", "");
		}
		
		try {
			String[] split = data.split("\\(");
			List<String> list = new ArrayList<String>();
			for (String string : split) {
				list.add(string);
				data = list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}

//	Runtime.getRuntime().exec("cmd.exe /c cd \""+"C:\\Users\\vimal.2358\\AppData\\Local\\Android\\Sdk\\emulator"+"\" & start emulator -avd 1 -no-boot-anim -no-window &");
//	Runtime.getRuntime().exec("cmd.exe /c cd \""+"C:\\Users\\vimal.2358\\AppData\\Local\\Android\\Sdk\\emulator"+"\" & start emulator -avd 1");
//	Runtime.getRuntime().exec("cmd.exe /c cd \""+"C:\\Users\\vimal.2358\\AppData\\Roaming\\npm"+"\" & start appium");
//	Thread.sleep(Duration.ofSeconds(500));	

}
