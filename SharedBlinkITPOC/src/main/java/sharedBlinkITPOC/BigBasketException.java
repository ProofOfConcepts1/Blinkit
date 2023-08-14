package sharedBlinkITPOC;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BigBasketException{
	

	public void dataScrapping(int start, int end, String OutputFileName) {
		
		RemoteWebDriver driver = null;
		int rowNum = start;
		
		int ExceptionCount = 0;
		int dataCounter = start;
		
		UserUtilityBBException userUtility = new UserUtilityBBException(UserUtilityBBException.InputDataFilePathBB,"Input data", "Locators", OutputFileName);		
		while (rowNum < end) {
			try {
				newProductScrapperExcception pds = new newProductScrapperExcception();
				driver = userUtility.launchBrowser(driver, false, false, false);
				pds.BBLocationSetup(driver, "Navi Mumbai", "");
				for (int i = dataCounter; i < end; i++) {
					Row row = userUtility.InputDataSheet.getRow(rowNum);

					String SI_No = row.getCell(0).getStringCellValue().trim();
					String Location = row.getCell(1).getStringCellValue().trim();
					String Category_1 = row.getCell(2).getStringCellValue().trim();
					String Category_2 = row.getCell(3).getStringCellValue().trim();
					String Category_3 = row.getCell(4).getStringCellValue().trim();
					String CategoryURL = row.getCell(5).getStringCellValue().trim();
					String Total_product = row.getCell(6).getStringCellValue().trim();
					String URL = row.getCell(7).getStringCellValue().trim();
//					String OldName = row.getCell(7).getStringCellValue().trim();
//					String OldMRP = row.getCell(8).getStringCellValue().trim();
//					String OldSP = row.getCell(9).getStringCellValue().trim();
//					String OldUOM = row.getCell(10).getStringCellValue().trim();
//					String OldMultiplier = row.getCell(11).getStringCellValue().trim();
//					String OldAvailability = row.getCell(12).getStringCellValue().trim();
					
					try {



						if (!URL.isBlank()) {
							driver.get(URL);
							URL = driver.getCurrentUrl();
						}
					}

					catch (Exception e) {

					}
					
					
					List<String> productDetails = new ArrayList<String>();
					
					for (int i1 = 0; i1 < 9; i1++) {
						productDetails.add("NA");
					}
					
					try {
						List<WebElement> findElements = driver.findElements(By.xpath(userUtility.locatorsMap.get("BigBasket").get("PackSizeCheckList")));
						if (findElements.size() > 1) {
							for (int j = 1; j < findElements.size(); j++) {
								findElements.get(j).click();
								productDetails = pds.productDetails(driver, userUtility.locatorsMap.get("BigBasket"),
										"NA", false, URL);


								

								String NewURL = productDetails.get(0).trim();
								String NewProductCode = productDetails.get(1).trim();
								String NewName = productDetails.get(2).trim();
								String NewMRP = productDetails.get(3).trim();
								String NewSP = productDetails.get(4).trim();
								String NewUOM = productDetails.get(5).trim();
								String NewAvailability = productDetails.get(6).trim();
								String manualInterventionFlag = productDetails.get(7).trim();
								String logFile = productDetails.get(8).trim();

								

								List<String> finalList = new ArrayList<String>();

								finalList.add(SI_No);
								finalList.add(Location);
								finalList.add(Category_1);
								finalList.add(Category_2);
								finalList.add(Category_3);
								finalList.add(CategoryURL);
								finalList.add(Total_product);
								finalList.add(NewURL);
								finalList.add(NewProductCode);
								finalList.add(NewName);
								finalList.add(NewMRP);
								finalList.add(NewSP);
								finalList.add(NewUOM);
								finalList.add(NewAvailability);
								finalList.add(manualInterventionFlag);
								finalList.add(logFile);
								finalList.add(URL);
								
								System.out.println(finalList);

								if (rowNum == 1) {
									List<String> header = userUtility.header("");
									userUtility.writeIntoSheet(userUtility.OutputSheet, header);
								}

								userUtility.writeIntoSheet(userUtility.OutputSheet, finalList);

							}
							rowNum++;
						}
					} catch (Exception e) {

					}

					rowNum++;

				}
				userUtility.writeIntoExcel(userUtility.OutputWorkBook, userUtility.OutputDataFilePath);
				System.out.println("Scrapping is completed");
			} 
			
			catch (Exception e) {
				System.out.println(e.getMessage());
				userUtility.writeIntoExcel(userUtility.OutputWorkBook, userUtility.OutputDataFilePath);
				try {
					driver.quit();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				rowNum++;
				
				ExceptionCount++;
				
				if (ExceptionCount>5){
					break;
				}
			}
		}
		
		try {
			driver.quit();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
//		System.out.println(userUtility.locatorsMap.get("Myntra"));
//		System.out.println(userUtility.getExcelDataMap(userUtility.locatorsMap, "Myntra"));
//		System.out.println(userUtility.getExcelData(userUtility.locatorsMap, "Myntra", "Product Name"));
		
		
	}
	
	
	
	

}
