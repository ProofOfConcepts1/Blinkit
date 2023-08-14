package BigBasket;

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


public class BBCommonScrapper {
	
	public void dataScrapping(String InputFileName, String InputLocation, String City, int startRowNum, int endRowNum,boolean SingleRun,Integer[] ListOfRowNumbers, String OutputFileName) {

		RemoteWebDriver driver = null;
		int rowNum = 1;
		int counter = startRowNum;

		CommonUserUtilityScrapper userUtility = new CommonUserUtilityScrapper(InputFileName,fileLocations.inputDataSheetName, fileLocations.inputLocatorsSheetName, OutputFileName);
		
		if (rowNum == 1) {
			List<String> header = userUtility.headerBB("");
			userUtility.writeIntoSheet(userUtility.OutputSheet, header);
		}
		
		if (SingleRun) {
			counter = ListOfRowNumbers[0];
			endRowNum = ListOfRowNumbers[ListOfRowNumbers.length-1];
		}
		
		while (counter <= endRowNum) {		

			for (int i = counter; i < endRowNum + 1; i++) {
				
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
				String Category_3 = row.getCell(4).getStringCellValue().trim();
				String URL = row.getCell(5).getStringCellValue().trim();
				String Total_product = row.getCell(6).getStringCellValue().trim();
//				int Count = Integer.valueOf(Total_product);
				
				BigBasketCommonUtility bb = new BigBasketCommonUtility();


				try {
					
					if (URL.equals("NA")) {
						counter++;
						continue;
					}

					try {
						driver.get(URL);
					} catch (Exception e) {
						driver = userUtility.launchBrowser(driver, false, false, false);
						bb.BBLocationSetup(driver, InputLocation, City);
					}
					try {
						userUtility.screenshot(driver, InputLocation);
					} catch (Exception e) {
						e.printStackTrace();
					}
					driver.get(URL);

					Thread.sleep(5000);
					
					
					

					int innerCount = 1;
					int Exception = 0;
					int checklist = 0;
					JavascriptExecutor js = (JavascriptExecutor) driver;

					while (true) {
						
						Thread.sleep(5000);
						
						String noOfWebElements = "(//section)[2]//section//ul//li";
						
						CommonUserUtilityScrapper.waitHelper(driver,noOfWebElements );
						
						List<WebElement> listOfAvailableElements = driver.findElements(By.xpath(noOfWebElements));
								
						if (checklist == listOfAvailableElements.size()) {
							
							break;
						}
						else {
							checklist = listOfAvailableElements.size();
						}
						
						
						for (int ItemCount = innerCount; ItemCount < checklist + 1; ItemCount++) {




							try {


								
								String availability = "1";
								String VarianceAvailability = "NA";
								
								String URLXapth = "(((//section)[2]//section//ul//li)["+ItemCount+"]//a)[1]";
								String BrandNameXpath = "(((//section)[2]//section//ul//li)["+ItemCount+"]//a)[2]//span";
								String BrandTitleXapth = "(((//section)[2]//section//ul//li)["+ItemCount+"]//a)[2]";
								String SPXpath = "((//section)[2]//section//ul//li)["+ItemCount+"]//div[@class='Pricing___StyledDiv-sc-pldi2d-0 bUnUzR']//span";
								String MRPXpath = "(((//section)[2]//section//ul//li)["+ItemCount+"]//div[@class='Pricing___StyledDiv-sc-pldi2d-0 bUnUzR']//span)[2]";
								String NormalQty = "((//section)[2]//section//ul//li)["+ItemCount+"]//div[@class='py-1.5 xl:py-1']//span";
								String stockAvailabilityXpath = "(((//section)[2]//section//ul//li)["+ItemCount+"]//a)//*[contains(text(),'Stock')]";
								String VarianceAvailabilityXpath = "((//section)[2]//section//ul//li)["+ItemCount+"]//div[contains(@id,'headlessui')]//button[@color='silverSurfer'][@pattern='filled']//span";
								String VarianceList = "//div[contains(@class,'PackChanger___')]";
								String ImageURLforVariance = "(((//section)[2]//section//ul//li)["+ItemCount+"]//a)//img";
								String varianceListSelect = "//li[@aria-selected='false']";
								
								CommonUserUtilityScrapper.waitHelper(driver, URLXapth);
								js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath(URLXapth)));
								
								List<String> finalList = new ArrayList<String>();
								String productCodeURL;
								String ProductCode;
								String Title;
								String SellingPrice;
								String Qty;
								String MRP;
								WebElement imageElement;
								String BrandName;
//										
									
									CommonUserUtilityScrapper.waitHelper(driver, URLXapth);
									imageElement = driver.findElement(By.xpath(URLXapth));
									productCodeURL = imageElement.getAttribute("href");
									ProductCode = bb.productCodeSplit(productCodeURL);
									Title = driver.findElement(By.xpath(BrandTitleXapth)).getText();
									SellingPrice = driver.findElement(By.xpath(SPXpath)).getText();
									SellingPrice = CommonUserUtilityScrapper.rupeesSplit(SellingPrice);
									Qty = driver.findElement(By.xpath(NormalQty)).getText();

									
									try {
										MRP = driver.findElement(By.xpath(MRPXpath)).getText();
										MRP = CommonUserUtilityScrapper.rupeesSplit(MRP);
									} catch (Exception e1) {
										MRP = SellingPrice;
									}
									

									
									try {
										driver.findElement(By.xpath(stockAvailabilityXpath));
										availability = "0";
									} 
									catch (Exception e1) {
									}
									
									try {
										BrandName = driver.findElement(By.xpath(BrandNameXpath)).getText();
									} catch (Exception e) {
										BrandName = "NA";
									}


									finalList.clear();
									finalList.add(SI_No);
									finalList.add(Location);
									finalList.add(Category_1);
									finalList.add(Category_2);
									finalList.add(Category_3);
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
									finalList.add(BrandName);



									userUtility.writeIntoSheet(userUtility.OutputSheet, finalList);
									
									WebElement Variance = null;
									try {
										Variance = driver.findElement(By.xpath(VarianceAvailabilityXpath));
										VarianceAvailability = "YES";
									} catch (Exception e) {
									}
									
									if (VarianceAvailability.equals("YES")) {
										
										CommonUserUtilityScrapper.waitHelper(driver, Variance);
										Variance.click();
										CommonUserUtilityScrapper.waitHelper(driver, varianceListSelect);
										driver.findElement(By.xpath(varianceListSelect)).click();
										
										CommonUserUtilityScrapper.waitHelper(driver, ImageURLforVariance);
										imageElement = driver.findElement(By.xpath(ImageURLforVariance));
										productCodeURL = imageElement.getAttribute("srcset");
										ProductCode = BigBasketCommonUtility.productCodeReturn(productCodeURL, "p/m/", "_");
										Title = driver.findElement(By.xpath(BrandTitleXapth)).getText();
										SellingPrice = driver.findElement(By.xpath(SPXpath)).getText();
										SellingPrice = CommonUserUtilityScrapper.rupeesSplit(SellingPrice);
										Qty = driver.findElement(By.xpath(NormalQty)).getText();

										
										try {
											MRP = driver.findElement(By.xpath(MRPXpath)).getText();
											MRP = CommonUserUtilityScrapper.rupeesSplit(MRP);
										} catch (Exception e1) {
											MRP = SellingPrice;
										}
										

										
										try {
											driver.findElement(By.xpath(stockAvailabilityXpath));
											availability = "0";
										} 
										catch (Exception e1) {
										}
										
										try {
											BrandName = driver.findElement(By.xpath(BrandNameXpath)).getText();
										} catch (Exception e) {
											BrandName = "NA";
										}
										
										productCodeURL = "https://www.bigbasket.com/pd/"+ProductCode;

										finalList.clear();
										finalList.add(SI_No);
										finalList.add(Location);
										finalList.add(Category_1);
										finalList.add(Category_2);
										finalList.add(Category_3);
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
										finalList.add(BrandName);

										userUtility.writeIntoSheet(userUtility.OutputSheet, finalList);
										
										
									}
									
									
								


							} catch (Exception e) {
								e.printStackTrace();
								Exception++;
								
								if (Exception > 10) {
									break;
								}
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
			
			try {
				driver.quit();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		try {
			driver.quit();
		} catch (Exception e1) {
//			e1.printStackTrace();
		}

	}

}
