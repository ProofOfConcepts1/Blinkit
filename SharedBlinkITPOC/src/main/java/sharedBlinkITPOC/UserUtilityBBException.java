package sharedBlinkITPOC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UserUtilityBBException {

	public static String currentDate() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm");
		LocalDateTime currentDate = LocalDateTime.now();
		String date = dtf.format(currentDate);
		return " " + date + "";
	}

	public static String InputDataFilePath = ".\\input-data\\Input Data.xlsx"; // TODO: load from config file
	public static String InputDataFilePath2 = ".\\input-data\\Input Data2.xlsx"; // TODO: load from config file
	public static String InputDataFilePath3 = ".\\input-data\\Input Data33.xlsx"; // TODO: load from config file
	public static String InputDataFilePathBB = ".\\input-data\\BBNew.xlsx"; // TODO: load from config file
	public String OutputDataFilePath = "Blinkit_Output" + currentDate() + ".xlsx"; // TODO: load from config file

//	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

	public Workbook InputWorkbook;
	public Sheet InputDataSheet;
	public Sheet InputLocatorsSheet;
	public XSSFWorkbook OutputWorkBook;
	public XSSFSheet OutputSheet;
	public String gridHost = "http://10.10.6.69:4444";
	public String driverPath = ".\\Drivers1\\chromedriver.exe";
	public static int waitTime = 10;

	public HashMap<String, HashMap<String, String>> inputDataMap = new HashMap<String, HashMap<String, String>>();
	public HashMap<String, HashMap<String, String>> locatorsMap = new HashMap<String, HashMap<String, String>>();

	public UserUtilityBBException(String FilePath, String InputDataSheet, String InputLocatorsSheet, String OutputFileName) {

		this.InputWorkbook = dataInputFromFile(FilePath);
		this.InputDataSheet = InputWorkbook.getSheet(InputDataSheet);
		this.locatorsMap = getExcelDataUserUtility(FilePath, locatorsMap, "Locators");
		this.OutputWorkBook = createWorkbook();
		this.OutputSheet = createSheet(OutputWorkBook);
		this.OutputDataFilePath = OutputFileName + currentDate() + ".xlsx"; // TODO: load from config file

	}

	public HashMap<String, HashMap<String, String>> getExcelDataUserUtility(String FilePath,
			HashMap<String, HashMap<String, String>> map, String sheetName) {

		File file = null;

		try {
			file = new File(FilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}

		XSSFWorkbook dataBook = null;
		try {
			try {
				dataBook = new XSSFWorkbook(file);
			} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
				e.printStackTrace();
			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		XSSFSheet dataSheet = dataBook.getSheet(sheetName);

		int noOfRows = dataSheet.getPhysicalNumberOfRows();
		int noOfCols = dataSheet.getRow(0).getLastCellNum();
		for (int i = 1; i < noOfRows; i++) {

			XSSFRow row = dataSheet.getRow(i);

			Cell titleCell = row.getCell(0);
			DataFormatter formatter = new DataFormatter();
			String titleHeader = formatter.formatCellValue(titleCell);
			HashMap<String, String> map1 = new HashMap<String, String>();

			for (int j = 1; j < noOfCols; j++) {

				XSSFRow headerRow = dataSheet.getRow(0);
				XSSFCell headerCell = headerRow.getCell(j);
				String headerValue = formatter.formatCellValue(headerCell);

				Cell cell = row.getCell(j);
				String value = formatter.formatCellValue(cell);

				map1.put(headerValue, value);
			}

			map.put(titleHeader, map1);

//			System.out.println(map);

			try {
				try {
					dataBook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		System.out.println(map);
		return map;

	}

	/***
	 * 
	 * @param 1. HashMap<String, HashMap<String, String>>
	 * @param 2. testCaseID
	 * @return It returns a HashMap with HashMap<String, String>
	 */

	public HashMap<String, String> getExcelDataMap(HashMap<String, HashMap<String, String>> map, String testCaseID) {

		HashMap<String, String> value = map.get(testCaseID);
//		System.out.println(value);
		return value;

	}

	/***
	 * 
	 * @param HashMap<String,    String>
	 * @param testCaseID
	 * @param requiredColumnName
	 * @return It returns a value for the given row and column name
	 */

	public String getExcelData(HashMap<String, HashMap<String, String>> map, String testCaseID,
			String requiredColumnName) {

		String value = map.get(testCaseID).get(requiredColumnName);
//		System.out.println(value);
		return value;

	}

	public List<String> header(String BrandName) {

		List<String> headerList = new ArrayList<String>();

		headerList.add("SI_No");
		headerList.add("Location");
		headerList.add("Category_1");
		headerList.add("Category_2");
		headerList.add("Category_3");
		headerList.add("URL");
		headerList.add("Total_product");
		headerList.add(BrandName + " URL");
		headerList.add("NewProductCode");
		headerList.add(BrandName + " Name");
		headerList.add(BrandName + " MRP");
		headerList.add(BrandName + " SP");
		headerList.add(BrandName + " UOM");
//		headerList.add(BrandName + " Multiplier");
		headerList.add(BrandName + " Availability");
		headerList.add(BrandName + " ManualInterventionFlag");
		headerList.add(BrandName + " LogFile");

		return headerList;

	}

	public Workbook dataInputFromFile(String filePath) {

		File file = new File(filePath);
		FileInputStream inStream = null;
		Workbook dataBook = null;

		try {
			inStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			dataBook = WorkbookFactory.create(inStream);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dataBook;
	}

	public int getNoOfRows(Sheet data) {
		int lastRowNum = data.getPhysicalNumberOfRows();
		return lastRowNum;
	}

	public int getNoOfColumns(Sheet data) {
		int lastColumnNum = data.getRow(0).getLastCellNum();
		return lastColumnNum;
	}

	/***
	 * 
	 * @param driver     WebDriver object
	 * @param mobileView boolean
	 * @param grid       boolean
	 * @param headless   boolean
	 * @return It returns the driver object
	 */

	public RemoteWebDriver launchBrowser(RemoteWebDriver driver, boolean mobileView, boolean grid, boolean headless) {

		if (mobileView && grid) {
			return MobileChromeLaunch(driver, grid, headless);

		}

		else if (mobileView) {
			return MobileChromeLaunch(driver, grid, headless);
		}

		else if (grid) {
			return chromeLaunch(driver, grid, headless);
		}

		else {
			return chromeLaunch(driver, grid, headless);
		}

	}

	public RemoteWebDriver chromeLaunch(RemoteWebDriver driver, boolean grid, boolean headless) {
		System.setProperty("webdriver.chrome.driver", driverPath); // TODO: Set Location
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--remote-allow-origins=*");
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);

		if (headless) {
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--start-maximized");
			options.addArguments("--headless=new");
		}

		URL url = null;

		try {
			url = new URL(gridHost);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		if (!grid) {
			driver = new ChromeDriver(options);
		}

		else {
			driver = new RemoteWebDriver(url, options);
		}
		System.out.println(driver);
		System.out.println("Driver is launched");
		driver.manage().window().maximize();
		return driver;

	}

	public RemoteWebDriver MobileChromeLaunch(RemoteWebDriver driver, boolean grid, boolean headless) {
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "iPhone SE");
		System.setProperty("webdriver.chrome.driver", driverPath); // TODO: Set Location
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("mobileEmulation", mobileEmulation);
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--remote-allow-origins=*");
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);

		if (headless) {
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--start-maximized");
			options.addArguments("--headless=new");
		}

		URL url = null;

		try {
			url = new URL(gridHost);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		if (!grid) {
			driver = new ChromeDriver(options);
		}

		else {
			driver = new RemoteWebDriver(url, options);
		}
		System.out.println(driver);
		System.out.println("Driver is launched");
		driver.manage().window().maximize();
		return driver;

	}

	public static String qtySplitFromName(String name, String separator1, String separator2, boolean useSeparator2) {

		String qty;
		String[] split = name.split(separator1);
		List<String> qtySplitList = new ArrayList<String>();
		List<String> qtySplitList2 = new ArrayList<String>();

		for (String string : split) {
			qtySplitList.add(string);
		}

		qty = qtySplitList.get(qtySplitList.size() - 1);

		if (useSeparator2) {
			String[] split2 = qty.split(separator2);
			for (String string : split2) {
				qtySplitList2.add(string);
			}
			qty = qtySplitList2.get(qtySplitList2.size() - 1);
		}

		return qty;
	}

	public String brandNameSplit(String name) {

		String brandName;
		String[] split = name.split(" ");
		List<String> qtySplitList = new ArrayList<String>();

		for (String string : split) {
			qtySplitList.add(string);
		}

		brandName = qtySplitList.get(0);

		return brandName;

	}

	public XSSFSheet writeIntoSheet(XSSFSheet sheet, List<String> productData) {

		int rowNum = sheet.getPhysicalNumberOfRows();

		System.out.println("Non-Header: " + rowNum);

		Row r1 = sheet.createRow(rowNum);

		for (int j = 0; j < productData.size(); j++) {

			Cell col = r1.createCell(j);
			col.setCellValue(productData.get(j));
			rowNum++;
		}

		return sheet;
	}

	public XSSFWorkbook createWorkbook() {
		XSSFWorkbook book = new XSSFWorkbook();
		return book;

	}

	public XSSFSheet createSheet(Workbook book) {
		XSSFSheet sheet = (XSSFSheet) book.createSheet("Output");
		return sheet;
	}

	public void writeIntoExcel(Workbook workbook, String OutputDataFilePath) {

		File file;
		try {
			file = new File(OutputDataFilePath);
		} catch (Exception e) {
			file = new File("Blinkit_Output" + currentDate() + ".xlsx");
		}
		FileOutputStream outstream = null;

		try {
			outstream = new FileOutputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
			file = new File("Blinkit_Output" + currentDate() + ".xlsx");
			try {
				outstream = new FileOutputStream(file);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		try {
			workbook.write(outstream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			outstream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

//		try {
//			workbook.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public static String rupeesSplit(String inputvalue) {

		String str = inputvalue;
		String value = "";
		for (int i = 0; i < str.length(); i++) {
			Boolean flag = Character.isDigit(str.charAt(i));

			if (flag) {
//				System.out.println("'" + str.charAt(i) + "' is a number");
				value = value + str.charAt(i);
			}

			else {
				int compare = Character.compare(str.charAt(i), '.');
				if (compare == 0) {
					value = value + str.charAt(i);
				}
//				System.out.println("'" + str.charAt(i) + "' is a letter");

			}
		}

//		System.out.println(value);

		if (value.contains(".")) {

			String newValue = value.trim();

			int compare = Character.compare(newValue.charAt(0), '.');

			if (compare == 0) {
				newValue = newValue.substring(1);
			}

//			System.out.println(newValue);

			value = "";

			String[] split = newValue.split("\\.");
//			System.out.println(split.length);

			if (split.length == 3) {
				value = split[1];
			} else if (split.length == 2) {
				value = split[0];
			} else if (split.length == 1) {
				value = split[0];
			}

		}

//		System.out.println(value);

		return value;

	}

	public boolean checkDifferenceBTWNumbers(String xvalue, String yvalue, int checkDifference) {

		String x = xvalue;
		String y = yvalue;
		double difference = Math.abs(Double.parseDouble(y) - Double.parseDouble(x));
		double average = (Double.parseDouble(y) + Double.parseDouble(x)) / 2;

		double percentage = (difference / average) * 100;

		if (percentage > checkDifference) {
			
			return true;
		}
		
		return false;
	}

	public double differenceBTWNumbers(String xvalue, String yvalue) {

		String x = xvalue;
		String y = yvalue;
		double difference = Math.abs(Double.parseDouble(y) - Double.parseDouble(x));
		double average = (Double.parseDouble(y) + Double.parseDouble(x)) / 2;

		double percentage = (difference / average) * 100;

		return percentage;
	}

}
