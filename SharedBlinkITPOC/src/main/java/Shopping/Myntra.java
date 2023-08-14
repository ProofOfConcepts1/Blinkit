package Shopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.remote.RemoteWebDriver;

import CommonUtility.ProductDetailsScrapping;
import CommonUtility.UserUtility;

public class Myntra{
	

	public static void main(String[] args) {
		
		RemoteWebDriver driver = null;
		int rowNum = 1;
		
		int ExceptionCount = 0;
		
		UserUtility userUtility = new UserUtility(UserUtility.InputDataFilePath,"Input data", "Locators");		
		while (rowNum < userUtility.getNoOfRows(userUtility.InputDataSheet)) {
			try {
				ProductDetailsScrapping pds = new ProductDetailsScrapping();
				driver = userUtility.launchBrowser(driver, false, false, false);
				for (int i = 1; i < userUtility.getNoOfRows(userUtility.InputDataSheet); i++) {
					Row row = userUtility.InputDataSheet.getRow(rowNum);

					String InputBrandName = row.getCell(0).getStringCellValue().trim();
					String InputPid = row.getCell(1).getStringCellValue().trim();
					String InputCity = row.getCell(2).getStringCellValue().trim();
					String InputTitle = row.getCell(3).getStringCellValue().trim();
					String InputSize = row.getCell(4).getStringCellValue().trim();
					String OldProductCode = row.getCell(5).getStringCellValue().trim();
					String OldURL = row.getCell(6).getStringCellValue().trim();
					String OldName = row.getCell(7).getStringCellValue().trim();
					String OldMRP = row.getCell(8).getStringCellValue().trim();
					String OldSP = row.getCell(9).getStringCellValue().trim();
					String OldUOM = row.getCell(10).getStringCellValue().trim();
					String OldMultiplier = row.getCell(11).getStringCellValue().trim();
					String OldAvailability = row.getCell(12).getStringCellValue().trim();

					List<String> productDetails = pds.productDetails(driver, userUtility.locatorsMap.get(InputBrandName),
							"NA", false, OldURL);
					

					String NewProductCode = productDetails.get(0);
					String NewURL = productDetails.get(1);
					String NewName = productDetails.get(2);
					String NewMRP = productDetails.get(3);
					String NewSP = productDetails.get(4);
					String NewUOM = productDetails.get(5);
					String NewMultiplier = productDetails.get(6);;
					String NewAvailability = productDetails.get(7);
					String NewManualInterventionFlag = productDetails.get(8);
					String LogFile = productDetails.get(9);

					String MRPPriceValidation = "NA";
					String sellingPriceValidation = "NA";
					String ProductCodeValidation = "NA";

					try {
						if (!OldProductCode.equals("NA")) {
							
							if (NewURL.contains(OldProductCode)) {
								NewProductCode = OldProductCode;
								ProductCodeValidation = "OK";
							}
							
//							if (!(NewSP.equals(" ") || NewSP.equals("") || NewSP.equals("NA"))) {
//								if (userUtility.checkDifferenceBTWNumbers(OldSP, NewSP, 10)) {
//									NewSP = "Need to check";
//									sellingPriceValidation = "OK";
//								}
//								
//								if (userUtility.checkDifferenceBTWNumbers(OldMRP, NewMRP, 3)) {
//									NewMRP = "Need to check";
//									MRPPriceValidation = "OK";
//								} 
//							}

						}
					} catch (Exception e) {
						e.printStackTrace();
					}

					if ((OldName.equals(NewName)) && (OldMRP.equals(NewMRP))) {
						NewUOM = OldUOM;
						NewMultiplier = OldMultiplier;
						NewAvailability = OldAvailability;
					}

					else {
						NewManualInterventionFlag = "YES";
					}

					List<String> finalList = new ArrayList<String>();

					finalList.add(InputPid);
					finalList.add(InputBrandName);
					finalList.add(InputTitle);
					finalList.add(InputSize);
					finalList.add(NewProductCode);
					finalList.add(NewURL);
					finalList.add(NewName);
					finalList.add(NewMRP);
					finalList.add(NewSP);
					finalList.add(NewUOM);
					finalList.add(NewMultiplier);
					finalList.add(NewAvailability);
					finalList.add(NewManualInterventionFlag);
					finalList.add(LogFile);
					finalList.add(MRPPriceValidation);
					finalList.add(sellingPriceValidation);
					finalList.add(ProductCodeValidation);
					
					System.out.println(finalList);

					if (rowNum == 1) {
						List<String> header = userUtility.header("");
						userUtility.writeIntoSheet(userUtility.OutputSheet, header);
					}

					userUtility.writeIntoSheet(userUtility.OutputSheet, finalList);

					rowNum++;
				}
				userUtility.writeIntoExcel(userUtility.OutputWorkBook, userUtility.OutputDataFilePath);
				driver.quit();
				System.out.println("Scrapping is completed");
			} 
			
			catch (Exception e) {
				userUtility.writeIntoExcel(userUtility.OutputWorkBook, userUtility.OutputDataFilePath);
				try {
					driver.quit();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				ExceptionCount++;
				
				if (ExceptionCount>5){
					break;
				}
			}
		}
		
//		System.out.println(userUtility.locatorsMap.get("Myntra"));
//		System.out.println(userUtility.getExcelDataMap(userUtility.locatorsMap, "Myntra"));
//		System.out.println(userUtility.getExcelData(userUtility.locatorsMap, "Myntra", "Product Name"));
		
		
	}
	
	
	
	

}
