package Swiggy;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SwiggyThane {

	public void dataScrapping(int startRowNum, int endRowNum, String OutputFileName) {

		RemoteWebDriver driver = null;
		int rowNum = 1;
		int counter = startRowNum;

		UserUtilitySwiggy userUtility1 = new UserUtilitySwiggy(UserUtilitySwiggy.InputDataFilePath2, "Input data",
				"Locators", OutputFileName);

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
				
				SwiggyUtility Swiggy = new SwiggyUtility();


				try {

					if (driver == null) {
						driver = userUtility1.launchBrowser(driver, true, false, false);
						Swiggy.SwiggyLocationSetup(driver, "Thane");
					}
					else {
						try {
							driver.get(URL);
						} catch (Exception e) {
							driver = userUtility1.launchBrowser(driver, true, false, false);
							Swiggy.SwiggyLocationSetup(driver, "Thane");
						}
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
					
					userUtility1.waitHelper(driver, "(//div[@data-testid='ItemWidgetContainer'])");

					int innerCount = 1;
					int checklist = 0;

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
								userUtility1.waitHelper(driver, "(//div[@data-testid='ItemWidgetContainer'])["
										+ lookupCount + "]//button//img");
								js.executeScript("arguments[0].scrollIntoView();",
										driver.findElement(By.xpath("(//div[@data-testid='ItemWidgetContainer'])["
												+ lookupCount + "]//button//img")));

								userUtility1.waitHelper(driver,
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
								
								userUtility1.waitHelper(driver, "//button[@data-testid='simpleheader-back']");
								driver.findElement(By.xpath("//button[@data-testid='simpleheader-back']")).click();

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
