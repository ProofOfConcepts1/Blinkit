package Zepto;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ZeptoNaviMumbai {

	public void dataScrapping(int startRowNum, int endRowNum, String OutputFileName) {

		RemoteWebDriver driver = null;
		int rowNum = 1;
		int counter = startRowNum;

		UserUtilityZepto userUtility1 = new UserUtilityZepto(UserUtilityZepto.InputDataFilePath1,"Input data", "Locators", OutputFileName);
		System.out.println(userUtility1);
		
		while (counter <= endRowNum) {		

			for (int i = startRowNum; i < endRowNum + 1; i++) {

				Row row = userUtility1.InputDataSheet.getRow(i);
				String SI_No = row.getCell(0).getStringCellValue().trim();
				String Location = row.getCell(1).getStringCellValue().trim();
				String Category_1 = row.getCell(2).getStringCellValue().trim();
				String Category_2 = row.getCell(3).getStringCellValue().trim();
				String URL = row.getCell(4).getStringCellValue().trim();
				String Total_product = row.getCell(5).getStringCellValue().trim();
//				int Count = Integer.valueOf(Total_product);
				
				ZeptoUtility Zepto = new ZeptoUtility();


				try {

					if (driver == null) {
						driver = userUtility1.launchBrowser(driver, false, false, false);
						Zepto.ZeptoLocationSetup(driver, "Navi Mumbai");
					}
					else {
						try {
							driver.get(URL);
						} catch (Exception e) {
							driver = userUtility1.launchBrowser(driver, false, false, false);
							Zepto.ZeptoLocationSetup(driver, "Navi Mumbai");
						}
					}
					
					driver.get(URL);

					Thread.sleep(5000);
					
					if (URL.equals("NA")) {
						counter++;
						startRowNum++;
						break;
					}
					
					userUtility1.waitHelper(driver, "(//div[@class='IS72w1  pb-24 no-scrollbar']//*[contains(@id,'store-product')])");

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
								
								userUtility1.waitHelper(driver, URLXapth);
								
								JavascriptExecutor js = (JavascriptExecutor) driver;
								js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(URLXapth)));
								
								WebElement imageElement = driver.findElement(By.xpath(URLXapth));
								
								String productCodeURL = imageElement.getAttribute("id");
								String ProductCode = Zepto.productCodeSplit(productCodeURL);
								String Title = driver.findElement(By.xpath(BrandTitleXapth)).getText();
								String SellingPrice = driver.findElement(By.xpath(SPXpath)).getText();
								SellingPrice = userUtility1.rupeesSplit(SellingPrice);
								String MRP;
								
								
								try {
									MRP = driver.findElement(By.xpath(MRPXpath)).getText();
									MRP = userUtility1.rupeesSplit(MRP);
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
								
								if (rowNum == 1) {
									List<String> header = userUtility1.header("");
									userUtility1.writeIntoSheet(userUtility1.OutputSheet, header);
								}

								userUtility1.writeIntoSheet(userUtility1.OutputSheet, finalList);

								rowNum++;
								
							} catch (Exception e) {
								e.printStackTrace();
							}

							innerCount++;
							

						}
					}
					userUtility1.writeIntoExcel(userUtility1.OutputWorkBook, userUtility1.OutputDataFilePath);
					System.out.println("Scrapping is completed");
					counter++;

				} catch (Exception e) {
					System.out.println(e.getMessage());
					userUtility1.writeIntoExcel(userUtility1.OutputWorkBook, userUtility1.OutputDataFilePath);

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

	}

}
