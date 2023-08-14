package BigBasket;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import CommonScrapperUtitlity.CommonUserUtilityScrapper;
import CommonScrapperUtitlity.fileLocations;
import CommonScrapperUtitlity.newProductScrapperExcception;

public class BBCommonScrapperDehradunNew {
	
	public void dataScrapping(String InputFileName, String InputLocation, String City, int startRowNum, int endRowNum,boolean SingleRun,Integer[] ListOfRowNumbers, String OutputFileName) {

		RemoteWebDriver driver = null;
		int rowNum = 1;
		int counter = startRowNum;

		Set<String> duplicateChecker = new HashSet<String>();
		CommonUserUtilityScrapper userUtility = new CommonUserUtilityScrapper(InputFileName,fileLocations.inputDataSheetName, fileLocations.inputLocatorsSheetName, OutputFileName);
		newProductScrapperExcception pds = new newProductScrapperExcception();
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
						driver = userUtility.launchBrowser(driver, false, false, true);
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
						
						String noOfWebElements = "//div[@qa='product_name']//a";
						
						String showMoreBtn = "//button[text()='Show More']";
						
						CommonUserUtilityScrapper.waitHelper(driver,noOfWebElements );
						
						List<WebElement> listOfAvailableElements = driver.findElements(By.xpath(noOfWebElements));
								
						if (checklist == listOfAvailableElements.size()) {
							
							try {
								driver.findElement(By.xpath(showMoreBtn)).click();
								Thread.sleep(10000);
								listOfAvailableElements = driver.findElements(By.xpath(noOfWebElements));
								checklist = listOfAvailableElements.size();
								
							}
							
							catch (Exception e) {
								break;

							}
							
							
						}
						else {
							
							checklist = listOfAvailableElements.size();
							
						}
						
						
						for (int ItemCount = innerCount; ItemCount < checklist + 1; ItemCount++) {




							try {
								
								String URLXapth = "(//div[@qa='product_name']//a)["+ItemCount+"]";
								CommonUserUtilityScrapper.waitHelper(driver, URLXapth);
								js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath(URLXapth)));
								
								String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
								driver.findElement(By.xpath(URLXapth)).sendKeys(selectLinkOpeninNewTab);
								
								Set<String> windowHandles = driver.getWindowHandles();
								@SuppressWarnings("unchecked")
								ArrayList tabs = new ArrayList(windowHandles);
								driver.switchTo().window((String) tabs.get(1));
								
									
									List<String> productDetails = new ArrayList<String>();
									productDetails = pds.productDetails(driver,
											userUtility.locatorsMap.get("BigBasket"), "NA", false, URL);
									
									List<String> finalList = new ArrayList<String>();
									String productCodeURL;
									String ProductCode;
									String Title;
									String SellingPrice;
									String Qty;
									String MRP;
									WebElement imageElement;
									String BrandName;
										
									productCodeURL = productDetails.get(0).trim();
									ProductCode = productDetails.get(1).trim();
									Title = productDetails.get(2).trim();
									MRP = productDetails.get(3).trim();
									SellingPrice = productDetails.get(4).trim();
									Qty = productDetails.get(5).trim();
									BrandName = productDetails.get(6).trim();
									String availability = productDetails.get(7).trim();
									String about = productDetails.get(8).trim();
									String manualInterventionFlag = productDetails.get(9).trim();
									String logFile = productDetails.get(10).trim();



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
										finalList.add(BrandName);
										finalList.add(availability);
										finalList.add(about);
										finalList.add(manualInterventionFlag);
										finalList.add(logFile);



										userUtility.writeIntoSheet(userUtility.OutputSheet, finalList);
										
										int packSize = 0;
									
									String packSizeXpath;
									try {
										packSizeXpath = "//section[@class='irDHq']//div[@class='_1LiCn']//div[contains(@class,'rippleEffect')]";
										packSize = 1;
										
										if (packSize > 0) {
											List<WebElement> findElements = driver.findElements(By.xpath(packSizeXpath));
											
											for (int j = 2; j < findElements.size()+1; j++) {
												
												driver.findElement(By.xpath(packSizeXpath+"["+j+"]")).click();
												
												productDetails = pds.productDetails(driver,
														userUtility.locatorsMap.get("BigBasket"), "NA", false, URL);
												
												finalList.clear();
													
												productCodeURL = productDetails.get(0).trim();
												ProductCode = productDetails.get(1).trim();
												Title = productDetails.get(2).trim();
												MRP = productDetails.get(3).trim();
												SellingPrice = productDetails.get(4).trim();
												Qty = productDetails.get(5).trim();
												BrandName = productDetails.get(6).trim();
												availability = productDetails.get(7).trim();
												about = productDetails.get(8).trim();
												manualInterventionFlag = productDetails.get(9).trim();
												logFile = productDetails.get(10).trim();



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
													finalList.add(BrandName);
													finalList.add(availability);
													finalList.add(about);
													finalList.add(manualInterventionFlag);
													finalList.add(logFile);



													userUtility.writeIntoSheet(userUtility.OutputSheet, finalList);
										}
										
										
											
										}
										
									} catch (Exception e) {
										e.printStackTrace();
									}
									
									
									
									driver.close();
									driver.switchTo().window((String) tabs.get(0));
									
								


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
