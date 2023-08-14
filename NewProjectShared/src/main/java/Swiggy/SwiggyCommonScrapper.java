package Swiggy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import CommonScrapperUtitlity.CommonUserUtilityScrapper;
import CommonScrapperUtitlity.fileLocations;

public class SwiggyCommonScrapper {

	public void dataScrapping(String InputFileName, String InputLocation, String City, int startRowNum, int endRowNum,boolean SingleRun,Integer[] ListOfRowNumbers,String OutputFileName) {

		RemoteWebDriver driver = null;
		int rowNum = 1;
		int counter = startRowNum;
		
		

		CommonUserUtilityScrapper userUtility = new CommonUserUtilityScrapper(InputFileName,fileLocations.inputDataSheetName, fileLocations.inputLocatorsSheetName, OutputFileName);
		
		if (rowNum == 1) {
			List<String> header = userUtility.headerSwiggy("");
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
				String URL = row.getCell(4).getStringCellValue().trim();
				String Total_product = row.getCell(5).getStringCellValue().trim();
//				int Count = Integer.valueOf(Total_product);
				
				SwiggyCommonUtility Swiggy = new SwiggyCommonUtility();


				try {

					try {
						driver.get(URL);
					} catch (Exception e) {
						driver = userUtility.launchBrowser(driver, true, false, false);
						Swiggy.SwiggyLocationSetup(driver, InputLocation);
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
					
					try {
						driver.findElement(By.xpath("//a[contains(text(),'Go Back')]"));
						startRowNum++;
						counter++;
						break;
					} catch (Exception e) {
					}
					
					CommonUserUtilityScrapper.waitHelper(driver, "(//div[@data-testid='ItemWidgetContainer'])");

					int innerCount = 1;
					int checklist = 0;
					
					boolean IsDuplicate = true;
					int duplicateCounter = 0;
					
					Set<String> duplicateChecker = new HashSet<String>();

					while (true) {
						List<WebElement> listOfAvailableElements = driver
								.findElements(By.xpath("(//div[@data-testid='ItemWidgetContainer'])"));
						if (checklist == listOfAvailableElements.size()) {
							break;
						}
						else {
							checklist = listOfAvailableElements.size();
						}
						

						
						for (int ItemCount = innerCount; ItemCount < listOfAvailableElements.size() + 1; ItemCount++) {



							int lookupCount = ItemCount;

							try {

								JavascriptExecutor js = (JavascriptExecutor) driver;
								try {
									CommonUserUtilityScrapper.waitHelper(driver, "(//div[@data-testid='ItemWidgetContainer'])["
											+ lookupCount + "]//button//img");
								} catch (Exception e) {
									
									CommonUserUtilityScrapper.waitHelper(driver, "//button[@data-testid='simpleheader-back']",20);
									driver.findElement(By.xpath("//button[@data-testid='simpleheader-back']")).click();
									
									CommonUserUtilityScrapper.waitHelper(driver, "(//div[@data-testid='ItemWidgetContainer'])["
											+ lookupCount + "]//button//img");
								}
								js.executeScript("arguments[0].scrollIntoView();",
										driver.findElement(By.xpath("(//div[@data-testid='ItemWidgetContainer'])["
												+ lookupCount + "]//button//img")));

								CommonUserUtilityScrapper.waitHelper(driver,
										"(//div[@data-testid='ItemWidgetContainer'])[" + ItemCount + "]//button//img");
								driver.findElement(By.xpath(
										"(//div[@data-testid='ItemWidgetContainer'])[" + ItemCount + "]//button//img"))
										.click();

								List<String> data = Swiggy.productDetailsScrapping(driver);
								String productCodeURL = data.get(0);
								String ProductCode = data.get(1);
								String Title = data.get(2);
								String MRP = data.get(3);
								String SellingPrice = data.get(4);
								String Qty = data.get(5);
								String availability = data.get(6);
								String VarianceAvailability = data.get(7);
								String BrandName = data.get(8);
								String productDescription = data.get(9);
								String ImportantInformation = data.get(10);
								
								IsDuplicate = duplicateChecker.add(ProductCode+Qty);
								
								if (!IsDuplicate) {
									duplicateCounter++;
								}
								
								if (duplicateCounter > 10) {
									break;
								}


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
								finalList.add(BrandName);
								finalList.add(productDescription);
								finalList.add(ImportantInformation);

								userUtility.writeIntoSheet(userUtility.OutputSheet, finalList);

								rowNum++;
								
								CommonUserUtilityScrapper.waitHelper(driver, "//button[@data-testid='simpleheader-back']",20);
								driver.findElement(By.xpath("//button[@data-testid='simpleheader-back']")).click();

							} catch (Exception e) {
								e.printStackTrace();
								counter++;
								break;
							}

							innerCount++;

						}
						
						if (duplicateCounter > 10) {
							break;
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
