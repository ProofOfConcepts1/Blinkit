package Zepto;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import BigBasket.BigBasketUtility;
import BigBasket.UserUtilityNewPOC;

public class ZeptoMainMethod {

	public void dataScrapping(int startRowNum, int endRowNum, String OutputFileName) {
		
		
		
		RemoteWebDriver driver = null;
		int rowNum = 1;
		int counter = startRowNum;

		UserUtilityZepto userUtility1 = new UserUtilityZepto(UserUtilityZepto.InputDataFilePath,"Input data", "Locators", OutputFileName);
		
		while (counter <= endRowNum) {
			ZeptoUtility Zepto = new ZeptoUtility();
			
			driver = userUtility1.launchBrowser(driver, false, false, true);
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			
//			                                    Load the URL and Set the location
			Zepto.ZeptoLocationSetup(driver, "Mumbai Central");
			
//			                                  Load the category URL one by one
			
			for (int i = startRowNum; i < endRowNum+1; i++) {
				
				Row row = userUtility1.InputDataSheet.getRow(i); 
				String SI_No = row.getCell(0).getStringCellValue().trim();
				String Location = row.getCell(1).getStringCellValue().trim();
				String Category_1 = row.getCell(2).getStringCellValue().trim();
				String Category_2 = row.getCell(3).getStringCellValue().trim();
				String URL = row.getCell(4).getStringCellValue().trim();
				String Total_product = row.getCell(5).getStringCellValue().trim();
				int Count = Integer.valueOf(Total_product);
				
				try {
					
					
					driver.get(URL);
					
					Thread.sleep(5000);
					
					for (int i1 = 1; i1 < Count+1; i1++) {
						
						if (URL.equals("NA")) {
							break;
						}
						
						
						try {
							String availability = "1";
							String VarianceAvailability = "NA";
							
							String URLXapth = "(//div[@class='IS72w1  pb-24 no-scrollbar']//*[contains(@id,'store-product')])["+i1+"]";
							String BrandTitleXapth = "((//div[@class='IS72w1  pb-24 no-scrollbar']//*[contains(@id,'store-product')])["+i1+"]//h4)[1]";
							String SPXpath = "((//div[@class='IS72w1  pb-24 no-scrollbar']//*[contains(@id,'store-product')])["+i1+"]//h4)[3]";
							String MRPXpath = "(//div[@class='IS72w1  pb-24 no-scrollbar']//*[contains(@id,'store-product')])["+i1+"]//p";
							String NormalQty = "((//div[@class='IS72w1  pb-24 no-scrollbar']//*[contains(@id,'store-product')])["+i1+"]//h4)[2]";
							String stockAvailabilityXpath = "(//div[@class='IS72w1  pb-24 no-scrollbar']//*[contains(@id,'store-product')])["+i1+"]//*[contains(text(),'Out of Stock')]";
							
							
							JavascriptExecutor js = (JavascriptExecutor) driver;
							js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(URLXapth)));
							
							WebElement imageElement = driver.findElement(By.xpath(URLXapth));
							userUtility1.waitHelper(driver, URLXapth);
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
							
							
//							System.out.println(productCodeURL);
//							System.out.println(ProductCode);
//							System.out.println(Title);
//							System.out.println(SellingPrice);
//							System.out.println(MRP);
//							System.out.println(Qty);
//							System.out.println(availability);
//							System.out.println("-----------------------------");
							
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
							
							if (i1 % 10 == 0) {
								userUtility1.pressDownArrow(driver, 4);
								Thread.sleep(2000);
							}
						} catch (Exception e) {
							e.printStackTrace();
							userUtility1.pressDownArrow(driver, 4);
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
