package Shopping;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.remote.RemoteWebDriver;

import CommonUtility.UserUtility;

public class deemno {

	public static void main(String[] args) {
	
//		UserUtility userUtility = new UserUtility(UserUtility.InputDataFilePath,"Websites", "Websites");
//		
//		int counter = 0;
//		RemoteWebDriver driver = null;
//		driver = userUtility.launchBrowser(driver, false, false, false);
//		
//		for (int i = 1; i < userUtility.getNoOfRows(userUtility.InputDataSheet); i++) {
//			Row row = userUtility.InputDataSheet.getRow(i);
//			String url = row.getCell(0).getStringCellValue().trim();
//
//			driver.get(url);
//			String currentTitle = driver.getTitle();
//			System.out.println(url + ": "+ currentTitle);
//			
//			if (currentTitle.contains("Blocked")) {
//				System.out.println("blocked");
//				counter++;
//			}
//		}
//		
//		driver.quit();
//		System.out.println("No of Blocked websites: "+ counter);
		
		String s1 = "Revlon Colorsilk Hair Color - Deep Burgundy 3DB\r\n"
				+ "(91.8 ml)";
		String s2 = "Revlon Colorsilk Hair Color - Deep Burgundy 3DB\r\n"
				+ "(91.8 ml)";
		
		System.out.println(s1.equals(s2));
	}
}