package Nykaa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;

import CommonScrapper.CommonUserUtilityScrapper;
import CommonScrapper.fileLocations;

public class nykaaScrapper {
	
	public void dataScrapping(String InputFileName, String InputLocation, String City, int startRowNum, int endRowNum, String OutputFileName) {

		RemoteWebDriver driver = null;
		int rowNum = startRowNum;
		
		int ExceptionCount = 0;
		int noOfIteration = 2;
		
		CommonUserUtilityScrapper CommonUserUtilityScrapper = new CommonUserUtilityScrapper(InputFileName,fileLocations.inputDataSheetName, fileLocations.inputLocatorsSheetName, OutputFileName);		
		
			List<String> header = CommonUserUtilityScrapper.header("");
			CommonUserUtilityScrapper.writeIntoSheet(CommonUserUtilityScrapper.OutputSheet, header);
		
		while (rowNum < endRowNum) {
			try {
				ProductDetailsScrapping2 pds = new ProductDetailsScrapping2();
				driver = CommonUserUtilityScrapper.launchBrowser(driver, false, false, false);
				driver.get("https://www.nykaa.com/");
				Thread.sleep(5000);
				for (int i = rowNum; i < endRowNum; i++) {
					Row row = CommonUserUtilityScrapper.InputDataSheet.getRow(rowNum);

					String InputPid = row.getCell(0).getStringCellValue().trim();
					String InputTitle = row.getCell(1).getStringCellValue().trim();
					String InputBrandName = row.getCell(2).getStringCellValue().trim();
					String InputSize = row.getCell(3).getStringCellValue().trim();
					String InputCity = row.getCell(4).getStringCellValue().trim();
					
					String searchXpath = CommonUserUtilityScrapper.locatorsMap.get("Nykaa").get("SearchBar");
					System.out.println(searchXpath);
					String searchItemSelectXpath = CommonUserUtilityScrapper.locatorsMap.get("Nykaa").get("SelectFromSearchResults");
//					System.out.println(searchItemSelectXpath);
					CommonScrapper.CommonUserUtilityScrapper.waitHelper(driver, searchXpath);
					driver.findElement(By.xpath(searchXpath)).click();
					driver.findElement(By.xpath(searchXpath)).clear();
					driver.findElement(By.xpath(searchXpath)).sendKeys(InputTitle, Keys.ENTER);
					
					for (int j = 1; j < noOfIteration +1; j++) {
						try {
							
							CommonScrapper.CommonUserUtilityScrapper.waitHelper(driver, searchItemSelectXpath);
//							System.out.println(searchItemSelectXpath+"["+j+"]");
							driver.findElement(By.xpath(searchItemSelectXpath+"["+j+"]")).click();
							Set<String> windowHandles = driver.getWindowHandles();
							@SuppressWarnings("unchecked")
							ArrayList tabs = new ArrayList(windowHandles);
							driver.switchTo().window((String) tabs.get(1));
									
							List<String> productDetails = pds.productDetails(driver, CommonUserUtilityScrapper.locatorsMap.get("Nykaa"));
							

							String NewProductCode = productDetails.get(0).trim();
							String NewURL = productDetails.get(1).trim();
							String NewName = productDetails.get(2).trim();
							String NewMRP = productDetails.get(3).trim();
							String NewSP = productDetails.get(4).trim();
							String NewUOM = productDetails.get(5).trim();
							String NewMultiplier = productDetails.get(6).trim();
							String NewAvailability = productDetails.get(7).trim();
							String NewManualInterventionFlag = productDetails.get(8).trim();
							String LogFile = productDetails.get(9).trim();


							List<String> finalList = new ArrayList<String>();

							finalList.add(InputPid);
							finalList.add(InputTitle);
							finalList.add(InputBrandName);
							finalList.add(InputSize);
							finalList.add(InputCity);
							finalList.add(NewURL);
							finalList.add(NewProductCode);
							finalList.add(NewName);
							finalList.add(NewMRP);
							finalList.add(NewSP);
							finalList.add(NewUOM);
							finalList.add(NewMultiplier);
							finalList.add(NewAvailability);
							finalList.add(NewManualInterventionFlag);
							finalList.add(LogFile);
							
//							System.out.println(finalList);

							CommonUserUtilityScrapper.writeIntoSheet(CommonUserUtilityScrapper.OutputSheet, finalList);

							driver.close();
							driver.switchTo().window((String) tabs.get(0));
						}
						
						catch (Exception e) {
							e.printStackTrace();
							System.out.println("No more search result is available");
						}

					}
					rowNum++;

					
				}
				CommonUserUtilityScrapper.writeIntoExcel(CommonUserUtilityScrapper.OutputWorkBook, CommonUserUtilityScrapper.OutputDataFilePath);
				System.out.println("Scrapping is completed");
			} 
			
			catch (Exception e) {
				System.out.println(e.getMessage());
				CommonUserUtilityScrapper.writeIntoExcel(CommonUserUtilityScrapper.OutputWorkBook, CommonUserUtilityScrapper.OutputDataFilePath);
				try {
					driver.quit();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				ExceptionCount++;
				rowNum++;
				
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
		
		
		
	}
}
