package BigBasket;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BigBasketThane {

	public void dataScrapping(int startRowNum, int endRowNum, String OutputFileName) {

		RemoteWebDriver driver = null;
		int rowNum = 1;
		int counter = startRowNum;

		UserUtilityNewPOC userUtility1 = new UserUtilityNewPOC(UserUtilityNewPOC.InputDataFilePath2,"Input data", "Locators", OutputFileName);
		System.out.println(userUtility1.InputDataFilePath2);
		
		while (counter <= endRowNum) {		

			for (int i = startRowNum; i < endRowNum + 1; i++) {

				Row row = userUtility1.InputDataSheet.getRow(i);
				String SI_No = row.getCell(0).getStringCellValue().trim();
				String Location = row.getCell(1).getStringCellValue().trim();
				String Category_1 = row.getCell(2).getStringCellValue().trim();
				String Category_2 = row.getCell(3).getStringCellValue().trim();
				String Category_3 = row.getCell(4).getStringCellValue().trim();
				String URL = row.getCell(5).getStringCellValue().trim();
				String Total_product = row.getCell(6).getStringCellValue().trim();
//				int Count = Integer.valueOf(Total_product);
				
				BigBasketUtility bb = new BigBasketUtility();


				try {

					if (driver == null) {
						driver = userUtility1.launchBrowser(driver, false, false, false);
						bb.BBLocationSetup(driver, "Mumbai", "thane west");
					}
					else {
						try {
							driver.get(URL);
						} catch (Exception e) {
							driver = userUtility1.launchBrowser(driver, false, false, false);
							bb.BBLocationSetup(driver, "Mumbai", "thane west");
						}
					}
					
					driver.get(URL);

					Thread.sleep(5000);
					
					if (URL.equals("NA")) {
						counter++;
						startRowNum++;
						break;
					}
					
					

					int innerCount = 1;
					int checklist = 0;

					while (true) {
						
						Thread.sleep(5000);
						
						userUtility1.waitHelper(driver, "(//section)[2]//section//ul//li");
						
						List<WebElement> listOfAvailableElements = driver
								.findElements(By.xpath("(//section)[2]//section//ul//li"));
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
								
								String URLXapth = "(((//section)[2]//section//ul//li)["+ItemCount+"]//a)[1]";
								String BrandTitleXapth = "(((//section)[2]//section//ul//li)["+ItemCount+"]//a)[2]";
								String SPXpath = "((//section)[2]//section//ul//li)["+ItemCount+"]//div[@class='Pricing___StyledDiv-sc-pldi2d-0 bUnUzR']//span";
								String MRPXpath = "(((//section)[2]//section//ul//li)["+ItemCount+"]//div[@class='Pricing___StyledDiv-sc-pldi2d-0 bUnUzR']//span)[2]";
								String NormalQty = "((//section)[2]//section//ul//li)["+ItemCount+"]//div[@class='py-1.5 xl:py-1']//span";
								String stockAvailabilityXpath = "(((//section)[2]//section//ul//li)["+ItemCount+"]//a)//*[contains(text(),'Stock')]";
								
								
								JavascriptExecutor js = (JavascriptExecutor) driver;
								userUtility1.waitHelper(driver, URLXapth);
								js.executeScript("arguments[0].scrollIntoView();",
										driver.findElement(By.xpath(URLXapth)));

//								userUtility1.waitHelper(driver, URLXapth);
//								driver.findElement(By.xpath(URLXapth)).click();
								
								WebElement imageElement = driver.findElement(By.xpath(URLXapth));
								userUtility1.waitHelper(driver, URLXapth);
								String productCodeURL = imageElement.getAttribute("href");
								String ProductCode = bb.productCodeSplit(productCodeURL);
								String Title = driver.findElement(By.xpath(BrandTitleXapth)).getText();
								String SellingPrice = driver.findElement(By.xpath(SPXpath)).getText();
								SellingPrice = userUtility1.rupeesSplit(SellingPrice);
								String MRP;
								
								try {
									driver.findElement(By.xpath("((//section)[2]//section//ul//li)["+ItemCount+"]//button[@color='silverSurfer'][@pattern='filled']"));
									VarianceAvailability = "YES";
								} catch (Exception e) {
								}
								
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
								
								


								List<String> finalList = new ArrayList<String>();
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
