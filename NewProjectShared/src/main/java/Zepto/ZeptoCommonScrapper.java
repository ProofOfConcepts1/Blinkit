package Zepto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import CommonScrapperUtitlity.CommonUserUtilityScrapper;
import CommonScrapperUtitlity.fileLocations;

public class ZeptoCommonScrapper {

	public void dataScrapping(String InputFileName, String InputLocation, String City, int startRowNum, int endRowNum,boolean SingleRun,Integer[] ListOfRowNumbers, String OutputFileName) {

		RemoteWebDriver driver = null;
		int rowNum = 1;
		int counter = startRowNum;

		CommonUserUtilityScrapper userUtility = new CommonUserUtilityScrapper(InputFileName,fileLocations.inputDataSheetName, fileLocations.inputLocatorsSheetName, OutputFileName);
	
		if (rowNum == 1) {
			List<String> header = userUtility.header("");
			userUtility.writeIntoSheet(userUtility.OutputSheet, header);
		}
		
		if (SingleRun) {
			counter = ListOfRowNumbers[0];
			endRowNum = ListOfRowNumbers[ListOfRowNumbers.length-1];
		}
		
		while (counter <= endRowNum) {		

			for (int i = startRowNum; i < endRowNum + 1; i++) {
				
				if (SingleRun) {
					 boolean test = false;
					 for (int n : ListOfRowNumbers) {
					      if (n == i) {
					    	  test = true;
					        break;
					      }
					    }
					 if (!test) {
						 counter++;
						continue;
					}
				}

				Row row = userUtility.InputDataSheet.getRow(i);
				String SI_No = row.getCell(0).getStringCellValue().trim();
				String Location = row.getCell(1).getStringCellValue().trim();
				String Category_1 = row.getCell(2).getStringCellValue().trim();
				String Category_2 = row.getCell(3).getStringCellValue().trim();
				String URL = row.getCell(4).getStringCellValue().trim();
				String Total_product = row.getCell(5).getStringCellValue().trim();
//				int Count = Integer.valueOf(Total_product);
				
				ZeptoCommonUtility Zepto = new ZeptoCommonUtility();


				try {

					if (driver == null) {
						driver = userUtility.launchBrowser(driver, false, false, false);
						Zepto.ZeptoLocationSetup(driver, InputLocation);
					}
					else {
						try {
							driver.get(URL);
						} catch (Exception e) {
							driver = userUtility.launchBrowser(driver, false, false, false);
							Zepto.ZeptoLocationSetup(driver, InputLocation);
						}
					}
					
					try {
						userUtility.screenshot(driver, InputLocation);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					driver.get(URL);

					Thread.sleep(5000);
					
					if (URL.equals("NA")) {
						counter++;
						startRowNum++;
						break;
					}
					
					CommonUserUtilityScrapper.waitHelper(driver, "(//div[@class='IS72w1  pb-24 no-scrollbar']//*[contains(@id,'store-product')])");

					int innerCount = 1;
					int checklist = 0;

					while (true) {
						
						Thread.sleep(5000);
						
						List<WebElement> listOfAvailableElements = driver
								.findElements(By.xpath("(//div[@class='IS72w1  pb-24 no-scrollbar']//*[contains(@id,'store-product')])"));
						if (checklist == listOfAvailableElements.size()) {
							break;
						}
						else {
							checklist = listOfAvailableElements.size();
						}
						
						
						for (int ItemCount = innerCount; ItemCount < listOfAvailableElements.size() + 1; ItemCount++) {



							int lookupCount = ItemCount;

							try {
								String availability = "1";
								String VarianceAvailability = "NA";
								
								String URLXapth = "(//div[@class='IS72w1  pb-24 no-scrollbar']//*[contains(@id,'store-product')])["+ItemCount+"]";
								String BrandTitleXapth = "((//div[@class='IS72w1  pb-24 no-scrollbar']//*[contains(@id,'store-product')])["+ItemCount+"]//h4)[1]";
								String SPXpath = "((//div[@class='IS72w1  pb-24 no-scrollbar']//*[contains(@id,'store-product')])["+ItemCount+"]//h4)[3]";
								String MRPXpath = "(//div[@class='IS72w1  pb-24 no-scrollbar']//*[contains(@id,'store-product')])["+ItemCount+"]//p";
								String NormalQty = "((//div[@class='IS72w1  pb-24 no-scrollbar']//*[contains(@id,'store-product')])["+ItemCount+"]//h4)[2]";
								String stockAvailabilityXpath = "(//div[@class='IS72w1  pb-24 no-scrollbar']//*[contains(@id,'store-product')])["+ItemCount+"]//*[contains(text(),'Out of Stock')]";
								
								CommonUserUtilityScrapper.waitHelper(driver, URLXapth);
								
								JavascriptExecutor js = (JavascriptExecutor) driver;
								js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(URLXapth)));
								
								WebElement imageElement = driver.findElement(By.xpath(URLXapth));
								
								String productCodeURL = imageElement.getAttribute("id");
								String ProductCode = Zepto.productCodeSplit(productCodeURL);
								String Title = driver.findElement(By.xpath(BrandTitleXapth)).getText();
								String SellingPrice = driver.findElement(By.xpath(SPXpath)).getText();
								SellingPrice = CommonUserUtilityScrapper.rupeesSplit(SellingPrice);
								String MRP;
								
								
								try {
									MRP = driver.findElement(By.xpath(MRPXpath)).getText();
									MRP = CommonUserUtilityScrapper.rupeesSplit(MRP);
								} catch (Exception e) {
									MRP = SellingPrice;
								}
								String Qty = driver.findElement(By.xpath(NormalQty)).getText();
								
								try {
									driver.findElement(By.xpath(stockAvailabilityXpath));
									availability = "0";
								} 
								catch (Exception e) {
								}
								
								
//								System.out.println(productCodeURL);
//								System.out.println(ProductCode);
//								System.out.println(Title);
//								System.out.println(SellingPrice);
//								System.out.println(MRP);
//								System.out.println(Qty);
//								System.out.println(availability);
//								System.out.println("-----------------------------");
								
								List<String> finalList = new ArrayList<String>();
								finalList.add(SI_No);
								finalList.add(Location);
								finalList.add(Category_1);
								finalList.add(Category_2);
								finalList.add(URL);
								finalList.add(Total_product);
								finalList.add(productCodeURL);
								finalList.add(ProductCode);
								finalList.add(Title);
								finalList.add(MRP);
								finalList.add(SellingPrice);
								finalList.add(Qty);
								finalList.add(availability);
								finalList.add(VarianceAvailability);

								userUtility.writeIntoSheet(userUtility.OutputSheet, finalList);

								rowNum++;
								
							} catch (Exception e) {
								e.printStackTrace();
							}

							innerCount++;
							

						}
					}
					userUtility.writeIntoExcel(userUtility.OutputWorkBook, userUtility.OutputDataFilePath);
					System.out.println("Scrapping is completed");
					counter++;

				} catch (Exception e) {
					System.out.println(e.getMessage());
					userUtility.writeIntoExcel(userUtility.OutputWorkBook, userUtility.OutputDataFilePath);

					try {
						driver.quit();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

				counter++;
			}
			counter++;
		}
		
		try {
			driver.quit();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
